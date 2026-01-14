package be.ts1a.barrera.gabriela;

public class Animal {
	private String nombre;
	private TipoAnimal tipo;
	private int numeroChapita;

	public Animal(String nombre, TipoAnimal tipo, int numeroChapita) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.numeroChapita = numeroChapita;
		;
	}

	public int getNumeroChapita() {
		return numeroChapita;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return nombre + " (chapita " + numeroChapita + ", " + tipo + ")";
	}
}
