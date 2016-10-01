package genetic;
import java.util.ArrayList;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;



/**
 * Class gene
 */
public class Cromossomo {

  //
  // Fields
  //
  private ArrayList<Curso> cursoArray;
  private ArrayList<Disciplina> disciplinaArray;
  private ArrayList<Estudante> estudanteArray;
  private ArrayList<Professor> professorArray;
  private ArrayList<Sala> salaArray;
  private ArrayList<TimeSlots> timeslotsArray;
  private int index = 0 ;
 
  //
  // Constructors
  //
  public Cromossomo(Sala sala, Disciplina disciplina,Estudante estudante,Professor professor,Curso curso,TimeSlots timeslots) {
	  cursoArray.add(index,curso);
	  disciplinaArray.add(index,disciplina);
	  estudanteArray.add(index,estudante);
	  professorArray.add(index,professor);
	  salaArray.add(index,sala);
	  timeslotsArray.add(index,timeslots);
	  index++;
  };
  public Cromossomo(){	  
  }
  
  //
  // Methods
  //

  //
  // Accessor methods
  //

}

  //
  // Other methods
  //


