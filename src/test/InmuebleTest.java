package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xp.enums.EstadoInmueble;
import xp.enums.TipoInmueble;
import xp.model.Inmueble;

public class InmuebleTest {

	Inmueble casa, terreno, galpon, departamento;
	
	@Before
	public void setUp() throws Exception {
		casa = new Inmueble(001, "001", EstadoInmueble.DISPONIBLE, "Progreso", "Santa Fe",
				null, null, null, "342-000012", null, 10000, null, null, null, null,
				null, TipoInmueble.C, null, null, null, null, true, null, null, null, null, 
				null, null, null, null, null);
		terreno = new Inmueble(001, "001", EstadoInmueble.DISPONIBLE, "Progreso", "Santa Fe",
				null, null, null, "342-000012", null, 200000, null, null, null, 945,
				null, TipoInmueble.T, null, null, null, null, null, null, null, null, null, 
				null, null, null, null, null);
		galpon = new Inmueble(001, "001", EstadoInmueble.DISPONIBLE, "Progreso", "Santa Fe",
				null, null, null, "342-000012", null, 30000, null, null, null, null,
				null, TipoInmueble.G, null, null, null, null, null, null, null, null, null, 
				null, null, null, null, null);
		departamento = new Inmueble(001, "001", EstadoInmueble.DISPONIBLE, "Progreso", "Santa Fe",
				null, null, null, "342-000012", null, 40000, null, null, null, null,
				null, TipoInmueble.D, 3, null, null, null, null, null, null, null, null, 
				null, null, null, null, null);
	}

	@Test
	public void test() {
		System.out.println(casa.getDescripcion());
		System.out.println(terreno.getDescripcion());
		System.out.println(departamento.getDescripcion());
		
	}

}
