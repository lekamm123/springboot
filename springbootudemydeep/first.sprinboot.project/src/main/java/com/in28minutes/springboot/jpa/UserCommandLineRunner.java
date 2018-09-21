package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CommandLineRunner");
		repository.save(new User1("Ranga","Admin"));
		repository.save(new User1("Ravi","user"));
		repository.save(new User1("Satish","Admin"));
		repository.save(new User1("Raghu","user"));
		 		
   
	for (User1 user : repository.findAll())
	{
		 log.info(user.toString());
	}

}
}