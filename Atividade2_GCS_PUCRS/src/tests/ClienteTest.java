package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import business.Cliente;

class ClienteTest {

	private Cliente cli;
	private String nome = "nome";
	private String CPF = "1234567890";
	private char genero = 'M';
	private int idade = 42;
	private boolean status = false;



	@Test
	void testNome() {
		cli = new Cliente(nome, CPF, genero, idade);
		assertEquals(nome, cli.getNome());
	}

	@Test
	void testCPF() {
		cli = new Cliente(nome, CPF, genero, idade);
		assertEquals(CPF, cli.getCpf());
	}

	@Test
	void testGenero() {
		cli = new Cliente(nome, CPF, genero, idade);
		assertEquals(genero, cli.getGenero());
	}

	@Test
	void testIdade() {
		cli = new Cliente(nome, CPF, genero, idade);
		assertEquals(idade, cli.getIdade());
	}

	@Test
	void testStatus() {
		cli = new Cliente(nome, CPF, genero, idade);
		cli.setStatus(status);
		assertEquals(status, cli.getStatus());
	}

}
