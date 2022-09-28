package br.com.entra21.emr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

//	@Autowired
//	private DBServices dbService;
//	@Value("${spring.jpa.hibernate.ddl-auto}");
//	private String ddl;
//	
//	public boolean intanceDB() {
//		if(ddl.equals("create")) {
//			this.dbService.instanceDB();
//		}
//		
//		return false;
//	}
}
