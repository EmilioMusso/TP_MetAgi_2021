package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xp.db.T_vendedor;
import xp.model.Vendedor;

public class VendedorTest {
	T_vendedor vT;
	Vendedor v1, v2, v3;
	
	@Before
	public void setUp() throws Exception {
		vT = new T_vendedor();
		v1 = new Vendedor("Lionel", "Messi", "DNI", "12345600", "anto123");
	}
	
	@Test
	public void testAlmacenarVendedor() {
		Integer newId = vT.insert(v1);
		v2 = vT.buscarVendedor(newId);
		assertTrue(v1.equals(v2));
	}
}
