package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import business.Cliente;
import business.ClienteSocio;

class ClienteSocioTest {
	private ClienteSocio cli;
	private String nome = "nome";
	private String CPF = "1234567890";
	private char genero = 'M';
	private int idade = 42;
	private boolean status = false;
	private int numero = 568;
	private double milhagens = 22;



	@Test
	void testNome() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);
		assertEquals(nome, cli.getNome());
	}

	@Test
	void testCPF() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);
		assertEquals(CPF, cli.getCpf());
	}

	@Test
	void testGenero() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);
		assertEquals(genero, cli.getGenero());
	}

	@Test
	void testIdade() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);
		assertEquals(idade, cli.getIdade());
	}

	@Test
	void testStatus() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);
		cli.setStatus(status);
		assertEquals(status, cli.getStatus());
	}

	@Test
	void testMilhagem() {
		cli = new ClienteSocio(nome, CPF, genero, idade, numero, milhagens);		
		assertEquals(milhagens, cli.getMilhagens());
	}

}
