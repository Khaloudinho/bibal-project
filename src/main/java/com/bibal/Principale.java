package com.bibal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Principale extends SpringBootServletInitializer
{

	/*
	 * @Autowired private IUsagerRepository iUsagerRepository;
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(Principale.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass).web(false);
	}

	private static Class<Principale> applicationClass = Principale.class;
}
