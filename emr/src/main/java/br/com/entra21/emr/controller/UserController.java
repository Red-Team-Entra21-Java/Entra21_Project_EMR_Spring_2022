package br.com.entra21.emr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.entra21.emr.model.ItemNivel3;
import br.com.entra21.emr.model.User;
import br.com.entra21.emr.repository.IUserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private IUserRepository userRepository;
	
	
    //	LIST ALL
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<User> list() {
		
		List<User> response = userRepository.findAll();
		response.forEach(user ->{
			setMaturidadeNivel3(user);
		});
		
		return response;
	}
	
	
	// LIST FOR ID
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<User> search(@PathVariable("id") int param) {

		List<User> response = userRepository.findById(param).stream().toList();

		return response;
	}
	
	// CREATE
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User add(@RequestBody User newUser) {

		return userRepository.save(newUser);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Optional<User> atualizar(@PathVariable("id") int param,
			@RequestBody User newDataUser) {

		User current = userRepository.findById(param).get();
		current.setName(newDataUser.getName());
		current.setLogin(newDataUser.getLogin());
		current.setEmail(newDataUser.getEmail());
		current.setPassword(newDataUser.getPassword());
		
		userRepository.save(current);

		return userRepository.findById(param);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		userRepository.deleteById(id);

		return !userRepository.existsById(id);
	}
	
	private void setMaturidadeNivel3(User user) {

		final String PATH = "localhost:8080/user";

		ArrayList<String> headers = new ArrayList<String>();

		headers.add("Accept : application/json");

		headers.add("Content-type : application/json");

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);

		try {

			User clone = mapper.readValue(mapper.writeValueAsString(user), User.class);

			clone.setLinks(null);

			String name = clone.getName();
			String login = clone.getLogin();
			String email = clone.getEmail();
			String password = clone.getPassword();
			
			clone.setName("Different name");
			clone.setLogin("Different login");
			clone.setEmail("Different email");
			clone.setPassword("Different password");
			
			String jsonUpdate = mapper.writeValueAsString(clone);

			clone.setName(name);
			clone.setLogin(login);
			clone.setEmail(email);
			clone.setPassword(password);
			
			clone.setId(null);

			String jsonCreate = mapper.writeValueAsString(clone);

			user.setLinks(new ArrayList<>());

			user.getLinks().add(new ItemNivel3("GET", PATH, null, null));

			user.getLinks().add(new ItemNivel3("GET", PATH + "/" + user.getId(), null, null));

			user.getLinks().add(new ItemNivel3("POST", PATH, headers, jsonCreate));

			user.getLinks().add(new ItemNivel3("PUT", PATH + "/" + user.getId(), headers, jsonUpdate));

		} catch (JsonProcessingException e) {

			e.printStackTrace();

		}

	}
}
