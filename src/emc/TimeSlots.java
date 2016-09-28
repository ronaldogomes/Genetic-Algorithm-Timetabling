package emc;



/**
 * Class TimeSlots
 */
public class TimeSlots {

  //
  // Fields
  //

  /**
   * Um numero natural maior que zero que indentifica de forma unica timeslot. 7) das 7h as 7h59min, 8) das 8h as 8h59min
   */
  private int codigo;
  /**
   * 1-domingo, 2-segunda, 3-terça, 4-quarta, 5-quinta e 6-sexta
   */
  private int codDiaSemana;
  
  //
  // Constructors
  //
  public TimeSlots () { };
  public TimeSlots (int codigo, int codDiaSemana) { 
	  this.codigo=codigo;
	  this.codDiaSemana=codDiaSemana;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of codigo
   * Um numero natural maior que zero que indentifica de forma unica timeslot. 7) das
   * 7h as 7h59min, 8) das 8h as 8h59min
   * @param newVar the new value of codigo
   */
  private void setCodigo (int codigo) {
    this.codigo = codigo;
  }

  /**
   * Get the value of codigo
   * Um numero natural maior que zero que indentifica de forma unica timeslot. 7) das
   * 7h as 7h59min, 8) das 8h as 8h59min
   * @return the value of codigo
   */
  private int getCodigo () {
    return codigo;
  }

  /**
   * Set the value of codDiaSemana
   * 1-domingo, 2-segunda, 3-terça, 4-quarta, 5-quinta e 6-sexta
   * @param newVar the new value of codDiaSemana
   */
  private void setCodDiaSemana (int codDiaSemana) {
    this.codDiaSemana = codDiaSemana;
  }

  /**
   * Get the value of codDiaSemana
   * 1-domingo, 2-segunda, 3-terça, 4-quarta, 5-quinta e 6-sexta
   * @return the value of codDiaSemana
   */
  private int getCodDiaSemana () {
    return codDiaSemana;
  }

  //
  // Other methods
  //

}
