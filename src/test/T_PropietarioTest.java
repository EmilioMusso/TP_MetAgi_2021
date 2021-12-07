package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xp.db.T_propietario;
import xp.model.Propietario;

public class T_PropietarioTest {

	T_propietario tp;
	Propietario propietario;
	
	@Before
	public void setUp() throws Exception {
		tp = new T_propietario();
	}

	@Test
	public void test() {
		propietario = tp.buscarPorId(345);
		Boolean cond1 = (propietario.getTipoDoc()=="LE");
		Boolean cond2 = (propietario.getNumDoc()=="30433539");
		
		assertTrue((cond1 && cond2));
	}

}
