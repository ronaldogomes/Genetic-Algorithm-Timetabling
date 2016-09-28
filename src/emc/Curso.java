package emc;

import java.util.ArrayList;

/**
 * Class Curso
 */
public class Curso {

	//
	// Fields
	//
	
	private int numPeriodo = 10;
	/**
	 * 
	 * Turno: e um codigo que identifica qual o turno de oferta do curso. Pode
	 * ser um dos seguintes valores: 1) matutino; 2) vespertino; 3) noturno; 4)
	 * matutino e vespertino; 5) matutino e noturno; 6) vespertino e noturno; 7)
	 * matutino, vespertino e noturno. 
	 */

	private String turno;
	private ArrayList<Disciplina> disciplinas;
	/**
	 * – um numero natural maior que zero – que identifica de maneira ´ unica um
	 * curso (veja a lista ´ anterior); 
	 */
	private int codigo;
	private String nome;

	//
	// Constructors
	//
	public Curso() {
	};

	public Curso(String nome, String turno, int codigo) {
		this.codigo = codigo;
		this.turno = turno;
		this.nome = nome;
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of numPeriodo
	 * 
	 * @param newVar
	 *            the new value of numPeriodo
	 */
	public void setNumPeriodo(int numPeriodo) {
		this.numPeriodo = numPeriodo;
	}

	/**
	 * Get the value of numPeriodo
	 * 
	 * @return the value of numPeriodo
	 */
	public int getNumPeriodo() {
		return numPeriodo;
	}

	/**
	 * Set the value of turno Turno: e um codigo que identifica qual o turno de
	 * oferta do curso. Pode ser um dos seguintes valores: 1) matutino; 2)
	 * vespertino; 3) noturno; 4) matutino e vespertino; 5) matutino e noturno;
	 * 6) vespertino e noturno; 7) matutino, vespertino e noturno. 
	 * 
	 * @param newVar
	 *            the new value of turno
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

	/**
	 * Get the value of turno Turno: e um codigo que identifica qual o turno de
	 * oferta do curso. Pode ser um dos seguintes valores: 1) matutino; 2)
	 * vespertino; 3) noturno; 4) matutino e vespertino; 5) matutino e noturno;
	 * 6) vespertino e noturno; 7) matutino, vespertino e noturno. 
	 * 
	 * @return the value of turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * Set the value of disciplinas
	 * 
	 * @param newVar
	 *            the new value of disciplinas
	 */
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * Get the value of disciplinas
	 * 
	 * @return the value of disciplinas
	 */
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Set the value of codigo – um numero natural maior que zero – que
	 * identifica de maneira ´ unica um curso (veja a lista ´ anterior); 
	 * 
	 * @param newVar
	 *            the new value of codigo
	 */
	public void setCodigo(int newVar) {
		codigo = newVar;
	}

	/**
	 * Get the value of codigo – um numero natural maior que zero – que
	 * identifica de maneira ´ unica um curso (veja a lista anterior); 
	 * 
	 * @return the value of codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Set the value of nome
	 * 
	 * @param newVar
	 *            the new value of nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get the value of nome
	 * 
	 * @return the value of nome
	 */
	public String getNome() {
		return nome;
	}

	//
	// Other methods
	//

}
