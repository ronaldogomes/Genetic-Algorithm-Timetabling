package genetic;

import java.util.ArrayList;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;

public class Gene {
	private Professor professor;
	private Sala sala;
	private Disciplina disciplina;
	private ArrayList<Estudante> alunos;
	private TimeSlots timeslots;
	private Curso curso;

	//
	//CONSTRUTORES
	//
	public Gene(Professor professor, Sala sala, Disciplina disciplina, ArrayList<Estudante> alunos, TimeSlots timeslots,
			Curso curso) {
		this.setProfessor(professor);
		this.setSala(sala);
		this.setDisciplina(disciplina);
		this.setAlunos(alunos);
		this.setTimeslots(timeslots);
		this.setCurso(curso);
	}


	public void setCurso(Curso curso) {
		this.curso=curso;
		
	}
	public Curso getCurso() {
		return this.curso;
		
	}


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


	public TimeSlots getTimeslots() {
		return timeslots;
	}


	public void setTimeslots(TimeSlots timeslots) {
		this.timeslots = timeslots;
	}




}
