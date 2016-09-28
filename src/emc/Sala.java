package emc;

import java.util.ArrayList;

/**
 * Class Sala
 */
public class Sala {

	//
	// Fields
	//

	/**
	 * um numero natural maior que zero – que identifica de maneira ´ unica uma
	 * sala de aula. Portanto nao há duas salas de aula com o mesmo codigo; 
	 */
	private int codigo;
	/**
	 * identifica a capacidade, em numero de estudantes, da sala.  
	 */
	private int capacidade;
	private ArrayList<TimeSlots> horariosDisponiveis;
	/**
	 * identifica as especiais caracterısticas (fısicas e/ou funcionais) da
	 * sala. Veja a sec¸ao referente ao Tipo de Sala 
	 */
	private String tipoSala;

	//
	// Constructors
	//
	public Sala(int condigo, int capacidade, String tipoSala) {
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.tipoSala = tipoSala;
		// iniciar o ArrayList horariosDisponiveis com todos os horarios livres
		// por default
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of codigo um numero natural maior que zero – que identifica
	 * de maneira ´ unica uma sala de aula. Portanto nao há duas salas de aula
	 * com o mesmo codigo; 
	 * 
	 * @param newVar
	 *            the new value of codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Get the value of codigo um numero natural maior que zero – que identifica
	 * de maneira ´ unica uma sala de aula. Portanto nao há duas salas de aula
	 * com o mesmo codigo; 
	 * 
	 * @return the value of codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Set the value of capacidade identifica a capacidade, em numero de
	 * estudantes, da sala.  
	 * 
	 * @param newVar
	 *            the new value of capacidade
	 */
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	/**
	 * Get the value of capacidade identifica a capacidade, em numero de
	 * estudantes, da sala.  
	 * 
	 * @return the value of capacidade
	 */
	public int getCapacidade() {
		return capacidade;
	}

	/**
	 * Set the value of horariosDisponiveis
	 * 
	 * @param newVar
	 *            the new value of horariosDisponiveis
	 */
	public void setHorariosDisponiveis(ArrayList<TimeSlots> horariosDisponiveis) {
		this.horariosDisponiveis = horariosDisponiveis;
	}

	/**
	 * Get the value of horariosDisponiveis
	 * 
	 * @return the value of horariosDisponiveis
	 */
	public ArrayList<TimeSlots> getHorariosDisponiveis() {
		return horariosDisponiveis;
	}

	/**
	 * Set the value of tipoSala identifica as especiais caracterısticas
	 * (fısicas e/ou funcionais) da sala. Veja a sec¸ao referente ao Tipo de
	 * Sala 
	 * 
	 * @param newVar
	 *            the new value of tipoSala
	 */
	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	/**
	 * Get the value of tipoSala identifica as especiais caracterısticas
	 * (fısicas e/ou funcionais) da sala. Veja a sec¸ao referente ao Tipo de
	 * Sala 
	 * 
	 * @return the value of tipoSala
	 */
	public String getTipoSala() {
		return tipoSala;
	}

	//
	// Other methods
	//

	/**
	 * @return verdadeiro se o timeslot está disponivel
	 * @return Boolean
	 * @param timeSlot
	 *            timeslot para verificar se está disponivel no quadro de
	 *            horario da sala
	 */
	public Boolean isTimeSlotAvailable(String timeSlot) {
		return null;
	}

}
