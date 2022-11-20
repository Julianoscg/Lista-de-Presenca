package ListaTelefonica;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

	Scanner scan = new Scanner(System.in);

	ArrayList<Contato> contatos = new ArrayList<>();

	// Menu principal
	void menu() {

		escreva("    --- MENU ---");
		escreva("1 -> Adicionar Novo Contato");
		escreva("2 -> Consultar Contato");
		escreva("3 -> Listar Contatos");
		escreva("4 -> Sair");

		// Validar opções do MENU
		boolean validacaoOpcao = false;
		while (!validacaoOpcao) {
			System.out.print("Escolha uma opção. Digite aqui: ");
			String opc = scan.nextLine();

			if (opc.matches("[1-4]*")) {
				if (opc.equalsIgnoreCase("4")) {
					escreva("Até mais :)");
					System.exit(0);
				} else if (opc.equalsIgnoreCase("1")) {
					adicionarAluno();
				} else if (opc.equalsIgnoreCase("2")) {
					consultarAluno();
				} else if (opc.equalsIgnoreCase("3")) {
					listarAluno();
				}
				validacaoOpcao = true;
			} else {
				escreva("opção inválida");

			}
		}
	}

	int matricula = 0;

	// Metodo para adicionar Aluno

	void adicionarAluno() {
		Contato aluno = new Contato();
		boolean adicionar = false;
		while (!adicionar) {

			escreva("\n---- Adicionar Aluno ----");
			System.out.print("Informe um nome: ");
			aluno.setNome(scan.nextLine());

			System.out.print("Informe um telefone: ");
			aluno.setTelefone(scan.nextLine());

			System.out.print("Informe um e-mail: ");
			aluno.setEmail(scan.nextLine());

			escreva("_____________________");
			escreva("Confira seus dados:");
			escreva(aluno.toString());
			escreva("_____________________");

			// Validação para finalizar o cadastro
			boolean validarContato = false;
			while (!validarContato) {
				escreva("-------------------------------");
				escreva("Tudo correto? 1 - Sim | 2 - Não");
				System.out.print("Digite aqui: ");
				String opc = scan.nextLine();

				boolean validarOpc = opc.matches("[1-2]*");
				if (validarOpc == true) {
					if (opc.equalsIgnoreCase("1")) {
						contatos.add(aluno);
						escreva("Contato adicionado!");
						validarContato = true;
					} else {
						adicionarAluno();
					}
				} else {
					escreva("Opção inválida");
				}
			}

			// Validação para adicionar outro aluno
			boolean adcOutro = false;
			while (!adcOutro) {
				escreva("-------------------------------");
				escreva("Adicionar outro contato? 1 - Sim 2 - Não");
				System.out.print("Digite aqui: ");
				String Opc = scan.nextLine();

				boolean validaNumero = Opc.matches("[1-2]*");

				if (validaNumero == true) {
					if (Opc.equalsIgnoreCase("1")) {

						adicionarAluno();

					} else {
						adcOutro = true;
						menu();
					}

				} else {
					escreva("Opção inválida");
				}
			}
		}
	}

	// Metodo para Listar os alunos adicionados
	void listarAluno() {

		if (contatos.size() == 0) {
			escreva("Não existem alunos cadastrados");
			menu();
		} else {
			escreva("\n    --- Lista de Contatos ---");
			for (int i = 0; i < contatos.size(); i++) {
				escreva("__________________________________");
				System.out.println(contatos.get(i));

			}
			escreva("__________________________________");
			menu();
		}
		scan.close();
	}

	// Metodo de consulta de Contato
	void consultarAluno() {
		if (contatos.size() == 0) {
			escreva("Não existem contatos cadastrados");
			menu();
		} else {
			escreva("__________________________________");
			escreva("Consulta de Contato");
			escreva("Digite o nome ou número: ");
			String entrada = scan.nextLine();
		
			boolean validaEntrada = entrada.matches("[0-9]*");
			
			if(validaEntrada == true) {
				for (int i = 0; i < contatos.size(); i++) {
					Contato c = contatos.get(i);
					if (c.getTelefone().equalsIgnoreCase(entrada)) {
						System.out.println(contatos.get(i));
						break;
					} 
					else {
						System.out.println("Contato não encontrado!");
						consultarAluno();
					}
				}
			} else {
				for (int i = 0; i < contatos.size(); i++) {
					Contato c = contatos.get(i);
					if (c.getNome().equalsIgnoreCase(entrada)) {
						System.out.println(contatos.get(i));
						break;
					} 
					else {
						System.out.println("Contato não encontrado!");
						consultarAluno();
					}
				}
			}
			
			
			escreva("__________________________________");
				menu();
		}
	}

	void escreva(String texto) {
		String s = texto;
		System.out.println(s);
	}
}
