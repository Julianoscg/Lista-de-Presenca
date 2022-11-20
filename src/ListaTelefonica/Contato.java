package ListaTelefonica;

import java.util.Objects;

public class Contato {

	String nome;
	String telefone;
	String email;
	

	/*
	 * Aluno(String nome, String turma, int matricula) { this.nome = nome;
	 * this.turma = turma; this.matricula = matricula; }
	 */


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		
		String s = "Nome      : " + this.nome + 
				"\nTelefone  : " + this.telefone + 
				"\nE-mail    : " + this.email;
		
		return s;
	}

}
