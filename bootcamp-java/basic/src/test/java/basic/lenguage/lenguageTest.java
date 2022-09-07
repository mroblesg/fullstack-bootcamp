package basic.lenguage;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class lenguageTest {

	@Test
	public void checkVarIsString() {
		var message = "test";
		assertTrue(message instanceof String);
	}
	
}