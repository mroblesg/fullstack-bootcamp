package es.avante.fullstackbootcamp.spring.core.springbean.naming.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.avante.fullstackbootcamp.spring.core.springbean.naming.component.Cat;
import es.avante.fullstackbootcamp.spring.core.springbean.naming.component.Dog;

@Configuration
public class BeanNamingConfig {

	@Bean("cat")
	public Cat cat() {
		return new Cat();
	}
	
	@Bean("dog")
	public Dog dog() {
		return new Dog();
	}
	
	@Bean("petShow")
	public PetShow petShow() {
		return new PetShow();
	}
	
}
