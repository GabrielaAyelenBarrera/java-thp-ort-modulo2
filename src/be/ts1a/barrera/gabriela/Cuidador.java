package be.ts1a.barrera.gabriela;

import java.util.ArrayList;

public class Cuidador {
	private String nombre;
	private TipoAnimal tipo;
	private ArrayList<Animal> animalesACargo;

	public Cuidador(String nombre, TipoAnimal tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.animalesACargo = new ArrayList<>();
	}

	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}

	public boolean estaCuidando(TipoAnimal tipo) {
		return this.tipo == tipo;
	}

	public int obtenerCantidadAnimales() {
		return this.animalesACargo.size();
	}

	public void asignarAnimal(Animal animal) {
		this.animalesACargo.add(animal);
	}

	public boolean tieneAnimalesACargo() {
		return this.obtenerCantidadAnimales() > 0;
	}

	public Animal buscarAnimalPorChapita(int numeroChapita) {
		Animal encontrado = null;
		Animal actual;
		int i = 0;

		while (i < this.animalesACargo.size() && encontrado == null) {
			actual = this.animalesACargo.get(i);
			if (actual.getNumeroChapita() == numeroChapita) {
				encontrado = actual;
			} else {
				i++;
			}
		}
		return encontrado;
	}

	public boolean removerAnimal(Animal animal) {
		return this.animalesACargo.remove(animal);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void mostrarAnimalesACargo() {
		System.out.println("Cuidador: " + nombre);
		int i = 0;
		while (i < this.animalesACargo.size()) {
			System.out.println("  - " + this.animalesACargo.get(i));
			i++;
		}
	}
}
