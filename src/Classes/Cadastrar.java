package Classes;


import java.util.Scanner;

public class Cadastrar {

	public void cadastrarAluno() {
		
		Menu metodo = new Menu();
		//List<Aluno> dados = new ArrayList<Aluno>();
		
		Scanner scan = new Scanner(System.in);
		
		boolean cadastrandoAluno = false;
		while (!cadastrandoAluno) {

			Aluno aluno = new Aluno();
			System.out.println("\n--- Novo Aluno ---\n");

			System.out.print("Informe o nome do aluno: ");
			aluno.setNome(scan.nextLine());
			
			System.out.print("Nascimento: ");
			aluno.setDataNascimento(scan.next());

			System.out.print("Turma: ");
			aluno.setTurma(scan.nextLine());

			System.out.print("Professor(a): ");
			aluno.setProfessor(scan.nextLine());
			
			metodo.dados.add(aluno);
			aluno.setId(metodo.dados.size());
			cadastrandoAluno = false;

			/*	System.out.print("\nFinalizar cadastro [S/N]? ");
			String cadastro = scan.nextLine();
			scan.next();

			if (cadastro.equalsIgnoreCase("s")) {
				

				aluno.MostrarCadastro();
				metodo.menu();
				
			}
			System.out.print("\nCadastrar outro aluno? [S/N]");
			String novoAluno = scan.nextLine();
			
			System.out.println("");
			
			if (novoAluno.equalsIgnoreCase("N")) {
				cadastrandoAluno = false;
				metodo.menu();
			} else if (novoAluno.equalsIgnoreCase("S")) {
				cadastrarAluno();
			}*/
		}
		scan.close();
	}
}
