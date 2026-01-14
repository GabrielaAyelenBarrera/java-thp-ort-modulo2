package be.ts1a.barrera.gabriela;

public class InfoTipoAnimal {

	private int cantidadAnimales;
	private int cantidadCuidadores;
	private TipoAnimal tipo;

	public InfoTipoAnimal(int cantidadAnimales, int cantidadCuidadores, TipoAnimal tipo) {
		this.cantidadAnimales = cantidadAnimales;
		this.cantidadCuidadores = cantidadCuidadores;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		String resultado = "";

		resultado = " Tipo de animal: " + this.tipo + ". ";
		resultado += " Cantidad de animales cuidados: " + this.cantidadAnimales + ". ";
		resultado += " Cantidad de cuidadores asignados: " + this.cantidadCuidadores + ". ";

		return resultado;

	}

}
