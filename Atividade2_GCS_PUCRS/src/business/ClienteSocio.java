package business;

public class ClienteSocio extends Cliente {
	
	private int numero;
	private double milhagens;

	public ClienteSocio(String nome, String cpf, char genero, int idade, int numero, double milhagens){
		super(nome, cpf, genero, numero);
		this.numero = numero;
		this.milhagens = milhagens;
	}
	
	public void adicionarMilhagens(double quantidade) {
		milhagens= milhagens + quantidade;
	}
	
	public double getMilhagens() {
		return milhagens;
	}
	
	@Override
	public String toString() {
		return super.toString() + numero + ", milhagens=" + milhagens + "]";
	}

}
