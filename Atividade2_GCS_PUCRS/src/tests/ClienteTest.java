package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import business.Cliente;

class ClienteTest {
	
	private Cliente cli;

	@Before
	public void setUp() {
	cli = new Cliente("nome", "cpf02859", 'M', 77);
	
	}
	
	@Test
	void testNome() {
		String nome = cli.getNome();
		System.out.println(nome);
		if(nome == null || nome == "")
			fail("Erro: Nome");
	}
	
	@Test
	void testCPF() {
		String CPF = cli.getCpf();
		if(CPF == null || CPF == "" || !verificaSeEhInteiro(CPF))
			fail("Erro: CPF");
	}
	
	public static boolean verificaSeEhInteiro(String s) {
		boolean resposta = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) { // Verifica caractere por caractere se � um d�gito
				resposta = false;
				break;
			}
		}
		return resposta;
	}

}
