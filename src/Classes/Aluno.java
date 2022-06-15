package Classes;

public class Aluno {
    
    String nome;
    String DataNascimento;
    String turma;
    String professor;
    int id;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento() {
        return DataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}
    
    public void MostrarCadastro(){
        System.out.println("----- Informações -----");
        System.out.println("ID: "+ id);
        System.out.println("Nome: " + nome);
        System.out.println("Nascimento: " + DataNascimento);
        System.out.println("Turma: " + turma);
        System.out.println("Professor: "  + professor);
        System.out.println("----------------------");
        

    }
    

}
