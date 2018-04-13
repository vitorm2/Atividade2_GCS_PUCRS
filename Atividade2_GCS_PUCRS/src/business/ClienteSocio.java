package business;

import java.io.Serializable;

public class ClienteSocio extends Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	private int numero;
	private double milhagens;

	public ClienteSocio(String nome, String cpf, char genero, int idade, int numero, double milhagens){
		super(nome, cpf, genero, idade);
		this.numero = numero;
		this.milhagens = milhagens;
	}

	public void adicionarMilhagens(double quantidade) {
		milhagens= milhagens + quantidade;
	}

	public double getMilhagens() {
		return this.milhagens;
	}

	public int getNumero(){
		return this.numero;
	}

	@Override
	public String toString() {
		return super.toString() + numero + ", milhagens=" + milhagens + "]";
	}

}
