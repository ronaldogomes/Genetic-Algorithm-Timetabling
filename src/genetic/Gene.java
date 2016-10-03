package genetic;

import java.util.ArrayList;

import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;

public class Gene {
	private Professor professor;
	private Sala sala;
	private Disciplina disciplina;
	private ArrayList<Estudante> alunos;
	//
	//CONSTRUTORES
	//



	//
	//SETTERS AND GETTERS
	//
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public ArrayList<Estudante> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Estudante> alunos) {
		this.alunos = alunos;
	}

}
