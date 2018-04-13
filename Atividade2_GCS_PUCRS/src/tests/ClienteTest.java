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
	private boolean status = true;

	@Before
	public void setUp() {cli = new Cliente(nome, CPF, genero, idade);}

	@Test
	void testNome() {assertEquals(nome, cli.getNome());}

	@Test
	void testCPF() {assertEquals(CPF, cli.getCpf());}
	
	@Test
	void testGenero() {assertEquals(genero, cli.getGenero());}
	
	@Test
	void testIdade() {assertEquals(idade, cli.getIdade());}
	
	@Test
	void testStatus() {cli.setStatus(status); assertEquals(status, cli.getStatus());}

}
