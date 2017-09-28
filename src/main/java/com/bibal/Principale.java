package com.bibal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principale implements CommandLineRunner
{

	/*
	 * @Autowired private IUsagerRepository iUsagerRepository;
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(Principale.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception
	{
	}
}
