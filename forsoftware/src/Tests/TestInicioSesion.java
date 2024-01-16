package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import forsoftware.ventanas.VentanaInicioSesion;

public class TestInicioSesion {

	private VentanaInicioSesion ventana;

	@Before
	public void setUp() {
		ventana = new VentanaInicioSesion();
	}

	@Test
	public void testGetMapa() {
		// que el mapa no sea nulo
		assertNotNull(ventana.getMapa());


		// que el mapa tenga mas de 8 trabajadores
		int n = 8;
		assertTrue("El mapa debería tener más de " + n + " trabajadores", ventana.getMapa().size() > n);


		// obtener listas de claves y valores desde el mapa
		List<String> claves = new ArrayList<>(ventana.getMapa().keySet());
		List<String> valores = new ArrayList<>(ventana.getMapa().values());

		// que la primera posición de la lista de claves sea rosalia.flores@forsoftware.es
		String correoEsperado = "rosalia.flores@forsoftware.es"; 
		assertEquals(correoEsperado, claves.get(0));

		// que la primera posición de la lista de valores sea Rosalia
		String contrasenyaEsperado = "Rosalia"; 
		assertEquals(contrasenyaEsperado, valores.get(0));

	}
}