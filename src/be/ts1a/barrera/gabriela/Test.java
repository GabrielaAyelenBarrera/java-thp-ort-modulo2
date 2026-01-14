package be.ts1a.barrera.gabriela;

public class Test {

	public static void main(String[] args) {

		Refugio refugio = new Refugio("Huellitas");

		System.out.println("=== SET DE PRUEBAS: Refugio ===");
		refugio.generarDatosParaTestear();

		// 1) Datos base
		System.out.println("\n[1] Informe inicial (después de generar datos):");
		refugio.mostrarInformeOcupacionPorTipo();

		// 2) Intento de registrar cuidador duplicado
		System.out.println("\n[2] Intento de registrar cuidador duplicado (esperado: 'Ya existe ese cuidador...'):");
		refugio.registrarCuidador("Ana Huellitas", TipoAnimal.PERRO);

		// 3) Altas de animales para verificar balanceo por tipo PERRO
		System.out.println("\n[3] Registro de nuevos PERROS (ver salidas de asignación al cuidador con menor carga):");
		refugio.registrarAnimal("Firulais", TipoAnimal.PERRO);
		refugio.registrarAnimal("Canela", TipoAnimal.PERRO);

		System.out.println("\n[3.1] Informe luego de nuevas altas de PERRO:");
		refugio.mostrarInformeOcupacionPorTipo();

		// 4) Caso sin cuidadores para un tipo: nuevo refugio con un solo tipo de
		// cuidador
		System.out.println("\n[4] Caso 'sin cuidadores' para un tipo:");
		Refugio otro = new Refugio("Patitas");
		otro.registrarCuidador("Lucho Conejos", TipoAnimal.CONEJO);

		// Debería informar que NO hay cuidadores de GATO
		otro.registrarAnimal("Michi Nuevo", TipoAnimal.GATO);

		// Sí debería asignar al cuidador de CONEJO
		otro.registrarAnimal("Tamborcito", TipoAnimal.CONEJO);

		System.out.println("\n[4.1] Informe de 'Patitas':");
		otro.mostrarInformeOcupacionPorTipo();

		// 5) Agregar un tercer cuidador de GATO y cargar más gatos para ver la
		// distribución
		System.out.println("\n[5] Agrego nuevo cuidador de GATO y doy de alta más gatos:");
		refugio.registrarCuidador("Sofi Miau", TipoAnimal.GATO);
		refugio.registrarAnimal("Zuri", TipoAnimal.GATO);
		refugio.registrarAnimal("Tiza", TipoAnimal.GATO);
		refugio.registrarAnimal("Ámbar", TipoAnimal.GATO);

		System.out.println("\n[5.1] Informe final (con tercer cuidador de GATO):");
		refugio.mostrarInformeOcupacionPorTipo();

		// 6) Verificar chapitas correlativas en un refugio chico
		System.out.println("\n[6] Prueba de chapitas correlativas:");
		Refugio refugioChapitas = new Refugio("ChapitasTest");
		refugioChapitas.registrarCuidador("Tester", TipoAnimal.PERRO);
		refugioChapitas.registrarAnimal("Perro1", TipoAnimal.PERRO);
		refugioChapitas.registrarAnimal("Perro2", TipoAnimal.PERRO);
		refugioChapitas.registrarAnimal("Perro3", TipoAnimal.PERRO);

		// 7) Pruebas de adopción
		System.out.println("\n[7] Prueba de adopción exitosa (chapita existente):");
		Animal adoptado;
		adoptado = refugio.adoptar(1);
		if (adoptado != null) {
			System.out.println("Desde Test: Se adoptó a " + adoptado.getNombre() + " (chapita "
					+ adoptado.getNumeroChapita() + ")");
		}

		System.out.println("\n[7.1] Prueba de adopción con chapita inexistente:");
		Animal adoptadoInexistente;
		adoptadoInexistente = refugio.adoptar(9999);
		if (adoptadoInexistente == null) {
			System.out.println("Desde Test: No se encontró animal con chapita 9999 (como se esperaba).");
		}
		System.out.println("\n[7.2] Animales por cuidador luego de la adopción:");
		refugio.mostrarAnimalesPorCuidador();

		System.out.println("\n=== FIN DE PRUEBAS ===");
	}
}
