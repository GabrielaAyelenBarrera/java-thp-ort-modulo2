package be.ts1a.barrera.gabriela;

import java.util.ArrayList;

public class Refugio {
	private String nombre;
	private ArrayList<Cuidador> cuidadores;
	private int ultimoNumeroChapita;

	public Refugio(String nombre) {
		this.nombre = nombre;
		this.cuidadores = new ArrayList<>();
		this.ultimoNumeroChapita = 0;
	}

	public void registrarCuidador(String nombre, TipoAnimal tipo) {
		if (this.buscarCuidador(nombre) == null) {
			this.cuidadores.add(new Cuidador(nombre, tipo));
		} else {
			System.out.println("Ya existe ese cuidador en el sistema!");
		}
	}

	private Cuidador buscarCuidador(String nombre) {
		Cuidador cuidador = null;
		int i = 0;

		while (i < this.cuidadores.size() && !this.cuidadores.get(i).mismoNombre(nombre)) {
			i++;
		}
		if (i < this.cuidadores.size()) {
			cuidador = this.cuidadores.get(i);
		}
		return cuidador;
	}

	private int generarProximoNumeroChapita() {
		this.ultimoNumeroChapita++;
		return this.ultimoNumeroChapita;
	}

	private Animal crearAnimal(String nombreAnimal, TipoAnimal tipo) {
		int numeroChapita = generarProximoNumeroChapita();
		return new Animal(nombreAnimal, tipo, numeroChapita);
	}

	public void registrarAnimal(String nombreAnimal, TipoAnimal tipo) {
		Cuidador cuidador;
		Animal animal;

		cuidador = this.buscarCuidadorPorTipo(tipo);

		if (cuidador != null) {
			animal = crearAnimal(nombreAnimal, tipo);
			cuidador.asignarAnimal(animal);
			System.out.println(nombreAnimal + " (chapita " + animal.getNumeroChapita() + ") es cuidado por: "
					+ cuidador.getNombre());
		} else {
			System.out.println("No hay cuidadores para : " + tipo);
		}
	}

	public Animal adoptar(int numeroChapita) {
		Animal animalEncontrado = null;
		Cuidador cuidadorResponsable = null;
		int i = 0;
		Cuidador cuidadorActual;

		while (i < this.cuidadores.size() && animalEncontrado == null) {
			cuidadorActual = this.cuidadores.get(i);
			animalEncontrado = cuidadorActual.buscarAnimalPorChapita(numeroChapita);
			if (animalEncontrado != null) {
				cuidadorResponsable = cuidadorActual;
			} else {
				i++;
			}
		}

		if (animalEncontrado == null) {
			System.out.println("No existe ningún animal con chapita " + numeroChapita);
		} else {
			cuidadorResponsable.removerAnimal(animalEncontrado);
			System.out.println("Animal " + animalEncontrado.getNumeroChapita() + " fue adoptado con éxito.");
		}

		return animalEncontrado;
	}

	private Cuidador buscarCuidadorPorTipo(TipoAnimal tipo) {
		Cuidador cuidadorElegido = null;
		int minAnimales = Integer.MAX_VALUE;
		int cantAnimales;

		for (Cuidador cuidador : this.cuidadores) {
			cantAnimales = cuidador.obtenerCantidadAnimales();
			if (cuidador.estaCuidando(tipo) && cantAnimales < minAnimales) {
				cuidadorElegido = cuidador;
				minAnimales = cantAnimales;
			}
		}

		return cuidadorElegido;
	}

	private ArrayList<InfoTipoAnimal> generarInformeOcupacionPorTipo() {
		ArrayList<InfoTipoAnimal> informe = new ArrayList<>();

		for (TipoAnimal tipo : TipoAnimal.values()) {
			this.completarRegistroPorTipo(informe, tipo);
		}

		return informe;
	}

	private void completarRegistroPorTipo(ArrayList<InfoTipoAnimal> informe, TipoAnimal tipo) {
		int cantidadAnimales = 0;
		int cantidadCuidadores = 0;

		for (Cuidador cuidador : this.cuidadores) {
			if (cuidador.tieneAnimalesACargo() && cuidador.estaCuidando(tipo)) {
				cantidadAnimales += cuidador.obtenerCantidadAnimales();
				cantidadCuidadores++;
			}
		}

		informe.add(new InfoTipoAnimal(cantidadAnimales, cantidadCuidadores, tipo));
	}

	public void mostrarInformeOcupacionPorTipo() {
		ArrayList<InfoTipoAnimal> informe;

		informe = this.generarInformeOcupacionPorTipo();

		for (InfoTipoAnimal reg : informe) {
			System.out.println(reg);
		}
	}

	public void mostrarAnimalesPorCuidador() {
		System.out.println("=== Animales por cuidador en " + this.nombre + " ===");
		for (Cuidador c : this.cuidadores) {
			c.mostrarAnimalesACargo();
		}
	}

	/*
	 * Desde aca son metodos que se utilizan exclusivamente para inventar
	 * informacion con la cual testear la solucion
	 */

	public void generarDatosParaTestear() {
		this.generarCuidadores();
		this.generarAnimales();
	}

	private void generarCuidadores() {
		// PERROS (3 cuidadores para mayor carga)
		this.registrarCuidador("Ana Huellitas", TipoAnimal.PERRO);
		this.registrarCuidador("Bruno Ladridos", TipoAnimal.PERRO);
		this.registrarCuidador("Sofi Canina", TipoAnimal.PERRO);

		// GATOS (2 cuidadores)
		this.registrarCuidador("Clara Bigotes", TipoAnimal.GATO);
		this.registrarCuidador("Diego Ronrón", TipoAnimal.GATO);

		// CONEJOS (2 cuidadores)
		this.registrarCuidador("Pame Pompón", TipoAnimal.CONEJO);
		this.registrarCuidador("Ramiro Zanahoria", TipoAnimal.CONEJO);

		// HAMSTERS (2 cuidadores)
		this.registrarCuidador("Hugo Ruedita", TipoAnimal.HAMSTER);
		this.registrarCuidador("Mora Semillitas", TipoAnimal.HAMSTER);
	}

	private void generarAnimales() {
		// PERROS (12)
		this.registrarAnimal("Luna", TipoAnimal.PERRO);
		this.registrarAnimal("Rocky", TipoAnimal.PERRO);
		this.registrarAnimal("Chispita", TipoAnimal.PERRO);
		this.registrarAnimal("Toby", TipoAnimal.PERRO);
		this.registrarAnimal("Kika", TipoAnimal.PERRO);
		this.registrarAnimal("Waffles", TipoAnimal.PERRO);
		this.registrarAnimal("Mora", TipoAnimal.PERRO);
		this.registrarAnimal("Rocco", TipoAnimal.PERRO);
		this.registrarAnimal("Nala", TipoAnimal.PERRO);
		this.registrarAnimal("Bowie", TipoAnimal.PERRO);
		this.registrarAnimal("Coco", TipoAnimal.PERRO);
		this.registrarAnimal("Greta", TipoAnimal.PERRO);

		// GATOS (8)
		this.registrarAnimal("Michi", TipoAnimal.GATO);
		this.registrarAnimal("Nube", TipoAnimal.GATO);
		this.registrarAnimal("Bigotes", TipoAnimal.GATO);
		this.registrarAnimal("Loki", TipoAnimal.GATO);
		this.registrarAnimal("Frida", TipoAnimal.GATO);
		this.registrarAnimal("Pixel", TipoAnimal.GATO);
		this.registrarAnimal("Zuri", TipoAnimal.GATO);
		this.registrarAnimal("Tiza", TipoAnimal.GATO);

		// CONEJOS (5)
		this.registrarAnimal("Copito", TipoAnimal.CONEJO);
		this.registrarAnimal("Tambor", TipoAnimal.CONEJO);
		this.registrarAnimal("Nieve", TipoAnimal.CONEJO);
		this.registrarAnimal("Manchitas", TipoAnimal.CONEJO);
		this.registrarAnimal("Lola", TipoAnimal.CONEJO);

		// HAMSTERS (3)
		this.registrarAnimal("Pelusa", TipoAnimal.HAMSTER);
		this.registrarAnimal("Maní", TipoAnimal.HAMSTER);
		this.registrarAnimal("Gizmo", TipoAnimal.HAMSTER);
	}
}
