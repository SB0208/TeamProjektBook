package com.library.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service

public class BackendApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BackendApplication.class, args);
	}

}
