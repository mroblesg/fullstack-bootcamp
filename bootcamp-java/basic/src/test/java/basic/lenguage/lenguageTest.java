package basic.lenguage;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import basic.lenguage.Gato;

public class lenguageTest {

	@Test
	public void checkVarIsString() {
		Gato marcos = new Gato("Marcos");
		//var message = ;
		assertTrue(marcos instanceof String);
	}
	
}