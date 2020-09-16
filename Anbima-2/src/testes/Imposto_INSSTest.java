package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import projeto.Imposto_INSS;

class Imposto_INSSTest {
	
	Imposto_INSS inss;
	
	@Before//Comando que indica que a classe que este está relacionado deve ser executada antes dos testes
	void setUp() throws Exception{
		inss = new Imposto_INSS(3000, 0);
	}
	

	@Test
	void testImposto_INSS() {
		Assert.assertEquals(2670, inss.setSalarioInss(3000));
		fail("Not yet implemented");
	}

}
