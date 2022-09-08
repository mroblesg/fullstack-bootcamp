package es.avante.fullstackbootcamp.spring.core.scopes;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.avante.fullstackbootcamp.spring.core.springbean.naming.services.BeanNamingConfig;

public class ScopesIntegrationTest {

	private static final String NAME = "John Smith";
	private static final String NAME_OTHER = "Anna Jones";
	private ApplicationContext applicationContext;
	
	@BeforeEach
	public void setUp() {
		applicationContext = new AnnotationConfigApplicationContext(ScopesConfig.class);
	}

	@Test
	public void givenSingletonScope_whenSetName_thenEqualNames() {

//		private AnnotationConfigApplicationContext context;
//		context = new AnnotationConfigApplicationContext(BeanNamingConfig.class);		

		final Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
		final Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

		personSingletonA.setName(NAME);
		Assert.assertEquals(NAME, personSingletonB.getName());

		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void givenPrototypeScope_whenSetNames_thenDifferentNames() {

		final Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
		final Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");

		personPrototypeA.setName(NAME);
		personPrototypeB.setName(NAME_OTHER);

		Assert.assertEquals(NAME, personPrototypeA.getName());
		Assert.assertEquals(NAME_OTHER, personPrototypeB.getName());

		((AbstractApplicationContext) applicationContext).close();
	}
}
