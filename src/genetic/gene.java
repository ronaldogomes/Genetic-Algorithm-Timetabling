package genetic;
import emc.Disciplina;
import emc.Sala;



/**
 * Class gene
 */
public class gene {

  //
  // Fields
  //

  private Sala sala;
  private Disciplina disciplina;
  
  //
  // Constructors
  //
  public gene () { };
  
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
  private void setSala (Sala sala) {
    this.sala = sala;
  }

  /**
   * Get the value of sala
   * @return the value of sala
   */
  private Sala getSala () {
    return sala;
  }

  /**
   * Set the value of disciplina
   * @param newVar the new value of disciplina
   */
  private void setDisciplina (Disciplina disciplina) {
    this.disciplina = disciplina;
  }

  /**
   * Get the value of disciplina
   * @return the value of disciplina
   */
  private Disciplina getDisciplina () {
    return disciplina;
  }

  //
  // Other methods
  //

}
