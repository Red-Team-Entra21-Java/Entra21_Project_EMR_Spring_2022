package br.com.entra21.emr.controller;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public String on(Model model) {

		return "Estou ON";
	}
}
