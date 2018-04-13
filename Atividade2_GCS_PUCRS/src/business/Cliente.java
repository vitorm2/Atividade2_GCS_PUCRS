package business;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 6732261645514576922L;
	private String nome;
	private String cpf;
	private char genero;
	private int idade;
	private boolean status;

	public Cliente(String nome, String cpf, char genero, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public char getGenero() {
		return genero;
	}

	public int getIdade() {
		return idade;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean Status) {
		status = Status;
	}

	public StringProperty nomeProperty(){
		StringProperty nomeProperty = new SimpleStringProperty(this.nome);
		return nomeProperty;
	}

	public StringProperty cpfProperty(){
		StringProperty cpfProperty = new SimpleStringProperty(this.cpf);
		return cpfProperty;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", genero=" + genero + ", idade=" + idade + ", status="
				+ status + "]";
	}



}
