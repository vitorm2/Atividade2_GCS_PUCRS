package business;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 6732261645514576922L;
	private String nome;

	public Cliente(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public StringProperty identificadorProperty(){
		StringProperty nomeProperty = new SimpleStringProperty(this.nome);
		return nomeProperty;
	}

}
