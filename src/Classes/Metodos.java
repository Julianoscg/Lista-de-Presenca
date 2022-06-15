package Classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Metodos {
	List<Aluno> dados = new ArrayList<Aluno>();
	List<Aluno> turma1 = new ArrayList<Aluno>(); //Apocalipse
	List<Aluno> turma2 = new ArrayList<Aluno>(); //Maranata
	List<Aluno> turma3 = new ArrayList<Aluno>(); ///Berçario
	
	
	Scanner scan = new Scanner(System.in);
	int id = 1;
	public void menu() {
		String opcao;
		boolean executar = true;
		while (executar) {
			escrever("\n" + "-----  Bem vido ao cadastro de Alunos -----");
			System.out.println("O que deseja fazer? (escolha a opção)");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Consultar Aluno");
			System.out.println("3 - Mostrar Lista de Alunos");
			System.out.println("4 - Sair");
			System.out.print("Digite aqui: ");
			opcao = scan.next();
			if (opcao.length() > 1) {
				System.out.println("Opção inválida");
			} else {
				int opc = Integer.parseInt(opcao);

				 if (opc == 1) {
					cadastrarAluno();
				} else if (opc == 2) {
					consultarAluno();
				} else if (opc == 3) {
					escrever("Escolha uma opção");
					escrever("1 - Listar todos os alunos");
					escrever("2 escolher a turma");
					int opt = scan.nextInt();
					if(opt ==1) {
						ListarAlunos();
					}else {
						ListarTurmas();
					}
					
				} else if (opc == 4) {
					System.out.print("Até mais");
					executar = false;
					System.exit(0);
				} else {
					escrever("Opção Inválida");
					menu();
				}
			}
		}

	}

	public void cadastrarAluno() {
		
		boolean cadastrandoAluno = true;
		while (cadastrandoAluno) {
			
			Aluno aluno = new Aluno();
			System.out.println("\n--- Novo Aluno ---\n");
			
			System.out.print("Informe o nome do aluno: ");
			aluno.setNome(scan.next());

			System.out.print("Nascimento: ");
			aluno.setDataNascimento(scan.next());

			System.out.print("Turma: ");
			aluno.setTurma(scan.next());

			System.out.print("Professor(a): ");
			aluno.setProfessor(scan.next());

			System.out.print("\nFinalizar cadastro [S/N]? ");
			String cadastro = scan.next();
			
			if (cadastro.equalsIgnoreCase("s")) {
				dados.add(aluno);
				aluno.setId(dados.size());
				if(aluno.getTurma().equals("Apocalipse")){
					turma1.add(aluno);
				} else if(aluno.getTurma().equals("Maranata")) {
					turma2.add(aluno);
				} else{
					turma3.add(aluno);
				}
				dados.add(aluno);
				aluno.setId(dados.size());
				aluno.MostrarCadastro();
			}
			System.out.print("\nCadastrar outro aluno? [S/N]");
			String novoAluno = scan.next();
			if (novoAluno.equalsIgnoreCase("N")) {
				cadastrandoAluno = false;
				menu();
			} else if (novoAluno.equalsIgnoreCase("S")) {
				

			}
		}
	}
	
	public void consultarAluno() {
		int tentativas = 0;
		boolean consultar = true;
		while (consultar) {
			if (dados.size() == 0) {
				System.out.println("Nenhum Aluno cadastrado");
				menu();	
			} else {
				escrever("Informe o ID ou o nome do aluno");
				String info = scan.next();
				 int tamanhoText = info.length();
				 if (tamanhoText < 3) {
					int ID = Integer.parseInt(info);
						try {
							Aluno d = dados.get((ID-1));
							System.out.println("--- Informações ---");
							System.out.println("Id: "+ d.getId());
							System.out.println("Nome: " + d.getNome());
							System.out.println("Nascimento: " + d.getDataNascimento());
							System.out.println("Professor: " + d.getProfessor());
							System.out.println("Turma: " + d.getTurma());
							System.out.println("-----------------\n");
							consultar = false;
							menu();
						} catch (Exception e) {
							
							escrever("Aluno inexistente");
								tentativas++;
								if(tentativas >=3) {
									escrever("multiplas tentativas");
									menu();
								}
						} 
				}else { 
					for (int i=0;i<dados.size();i++) {
						if (dados.get(i).getNome().contains(info)) {
							System.out.print(dados.get(i));
							Aluno a = dados.get(i);
							escrever("Nome: " + a.getNome());
							escrever("Nascimento: " + a.getDataNascimento());
							escrever("Professor: " + a.getProfessor());
							escrever("Turma: " + a.getTurma());
					}
						menu();
					}
				}
			}
		}
	}	
	public void ListarTurmas() {
		if(turma1.size() == 0 && turma2.size() == 0 && turma3.size() == 0) {
			System.out.println("Não existem turmas cadastradas");
			menu();
		} else {
			escrever("--- Escolhe a turma ---");
			escrever("1 - Apocalipse");
			escrever("2 - Maranata");
			escrever("3 - Berçario");
			escrever("4 sair");
			int opcao = scan.nextInt();
			if(opcao ==1) {
				for(int i=0;i<turma1.size();i++) {
					Aluno a = turma1.get(i);
					escrever("--- Alunos turma Apocalipse ---");
					escrever("Id:" + a.getId());
					System.out.println("Nome: " + a.getNome());
					System.out.println("Nascimento: " + a.getDataNascimento());
					System.out.println("Professor: " + a.getProfessor());
					System.out.println("-----------------\n");
				}
				System.out.println("Fim da lista");
				menu();
			} else if(opcao ==2) {
				for(int i=0;i<turma2.size();i++) {
					Aluno a = turma2.get(i);
					escrever("--- Alunos turma Maranata ---");
					escrever("Id:" + a.getId());
					System.out.println("Nome: " + a.getNome());
					System.out.println("Nascimento: " + a.getDataNascimento());
					System.out.println("Professor: " + a.getProfessor());
					System.out.println("-----------------\n");
				}
				System.out.println("Fim da lista");
				menu();
			}else {
				for(int i=0;i<turma3.size();i++) {
					Aluno a = turma3.get(i);
					escrever("--- Alunos turma Berçario ---");
					escrever("Id:" + a.getId());
					System.out.println("Nome: " + a.getNome());
					System.out.println("Nascimento: " + a.getDataNascimento());
					System.out.println("Professor: " + a.getProfessor());
					System.out.println("-----------------\n");
				}
				System.out.println("Fim da lista");
				menu();
			}
		}
		
	}
	public void ListarAlunos() {
		
		if (dados.size() == 0) {
			System.out.println("Não existem alunos cadastrado");
			menu();
		} else {
			for (int i = 0; i < dados.size(); i++) {
				Aluno a = dados.get(i);
				escrever("--- Informações ---");
				escrever("Id:" + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Nascimento: " + a.getDataNascimento());
				System.out.println("Turma: " + a.getTurma());
				System.out.println("Professor: " + a.getProfessor());
				System.out.println("-----------------\n");
			}
			System.out.println("Fim da lista");
			menu();
		}
	}

	public String escrever(String text) {
		System.out.println(text);
		return text;
	}
	
}