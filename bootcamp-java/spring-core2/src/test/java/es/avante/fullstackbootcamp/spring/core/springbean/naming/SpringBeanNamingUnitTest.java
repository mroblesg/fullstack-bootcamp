package es.avante.fullstackbootcamp.spring.core.springbean.naming;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.avante.fullstackbootcamp.spring.core.springbean.naming.component.Cat;
import es.avante.fullstackbootcamp.spring.core.springbean.naming.component.Dog;
import es.avante.fullstackbootcamp.spring.core.springbean.naming.services.BeanNamingConfig;
import es.avante.fullstackbootcamp.spring.core.springbean.naming.services.PetShow;

public class SpringBeanNamingUnitTest {
	private AnnotationConfigApplicationContext context;

	@BeforeEach
	void setUp() {
		// context = new AnnotationConfigApplicationContext();
		// context.scan("es.avante.fullstackbootcamp.spring.core.springbean.naming.*");
		// context.refresh();
		// ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfig.class);
		// AccountService accountService = context.getBean(AccountService.class);
		context = new AnnotationConfigApplicationContext(BeanNamingConfig.class);
	}

	@Test
	void givenMultipleImplementationsOfAnimal_whenFieldIsInjectedWithQualifiedName_thenTheSpecificBeanShouldGetInjected() {
		PetShow petShow = (PetShow) context.getBean("petShow");

		assertNotNull(context.getBean("cat"));
		assertNotNull(context.getBean("dog"));

//		var getCat = petShow.getCat().getClass();
//
//		assertThat(getCat.isEqualTo(Cat.class));
//		assertThat((petShow.getDog().getClass()).isEqualTo(Dog.class);
		
		assertThat(petShow.getCat().getClass()).isEqualTo(Cat.class);
		assertThat(petShow.getDog().getClass()).isEqualTo(Dog.class);
	}
}
