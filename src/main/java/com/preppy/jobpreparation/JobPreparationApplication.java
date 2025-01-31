package com.preppy.jobpreparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JobPreparationApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobPreparationApplication.class, args);
	}

}
