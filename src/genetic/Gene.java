package genetic;
import emc.Disciplina;
import emc.Sala;



/**
 * Class gene
 */
public class Gene {

  //
  // Fields
  //

  private Sala sala;
  private Disciplina disciplina;
  
  //
  // Constructors
  //
  public Gene () { };
  public Gene (Sala sala, Disciplina disciplina) {
	  this.sala=sala;
	  this.disciplina=disciplina;
  };
  
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

  //
  // Other methods
  //

}
