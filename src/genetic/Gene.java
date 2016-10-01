package genetic;
import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;



/**
 * Class gene
 */
public class Gene {

  //
  // Fields
  //
  private Curso curso;
  private Disciplina disciplina;
  private Estudante estudante;
  private Professor professor;
  private Sala sala;
  private TimeSlots timeslots;
  private String geneEncoded = "";
 
  //
  // Constructors
  //
  public Gene(Sala sala, Disciplina disciplina,Estudante estudante,Professor professor,Curso curso,TimeSlots timeslots) {
	  this.setSala(sala);
	  this.setDisciplina(disciplina);
	  this.setEstudante(estudante);
	  this.setProfessor(professor);
	  this.setCurso(curso);
	  this.setTimeslots(timeslots);  
  };
  public Gene(){	  
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of sala
   * @param newVar the new value of sala
   */
  public void setSala (Sala sala) {
    this.sala = sala;
  }

  /**
   * Get the value of sala
   * @return the value of sala
   */
  public Sala getSala () {
    return sala;
  }

  /**
   * Set the value of disciplina
   * @param newVar the new value of disciplina
   */
  public void setDisciplina (Disciplina disciplina) {
    this.disciplina = disciplina;
  }

  /**
   * Get the value of disciplina
   * @return the value of disciplina
   */
 public Disciplina getDisciplina () {
    return disciplina;
  }
public Curso getCurso() {
	return curso;
}
public void setCurso(Curso curso) {
	this.curso = curso;
}
public Estudante getEstudante() {
	return estudante;
}
public void setEstudante(Estudante estudante) {
	this.estudante = estudante;
}
public Professor getProfessor() {
	return professor;
}
public void setProfessor(Professor professor) {
	this.professor = professor;
}
public TimeSlots getTimeslots() {
	return timeslots;
}
public void setTimeslots(TimeSlots timeslots) {
	this.timeslots = timeslots;
}

  //
  // Other methods
  //

}
