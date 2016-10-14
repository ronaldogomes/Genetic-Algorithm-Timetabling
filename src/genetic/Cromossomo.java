package genetic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import emc.*;
import entr_saida.Arquivo;

/**
 * Class gene
 */
public class Cromossomo {

	//
	// Fields
	//
	private Hashtable<Integer, ArrayList<Gene>> cromossomoHash;
	private Random aleatorio = new Random();
	// index aleatÃ³rio dos arrays
	private int indexProf, indexSala, indexDisc, indexTSlot, indexCurso;
	//
	// Constructor
	//

	
	public Cromossomo() {
		this.cromossomoHash = new Hashtable<Integer, ArrayList<Gene>>();
		// array de alunos aleatÃ³rio
		ArrayList<Estudante> alunos;

		int i = 0;

		// carregando cromossomo
		do {
			indexProf = aleatorio.nextInt(Arquivo.professoresEMC.size());			
			indexTSlot = aleatorio.nextInt(Arquivo.listaTimeSlots.size());
			indexCurso= aleatorio.nextInt(Arquivo.cursosEMC.size());
			indexSala = aleatorio.nextInt(Arquivo.salasEMC.size());
			indexDisc = geraIndexDisc(indexSala);

			if (validaTS(indexTSlot)) {

				alunos = new ArrayList<>();
				for (int a = 0; a < Arquivo.salasEMC.get(indexSala).getCapacidade(); a++) {
					int indexAl = aleatorio.nextInt(Arquivo.alunosEMC.size() - 1);
					alunos.add(Arquivo.alunosEMC.get(indexAl));

				}

				insereGeneInCromossomo(
						new Gene(Arquivo.professoresEMC.get(indexProf), Arquivo.salasEMC.get(indexSala),
								Arquivo.disciplinasEMC.get(indexDisc), alunos,
								Arquivo.listaTimeSlots.get(indexTSlot), Arquivo.cursosEMC.get(indexCurso)), Arquivo.listaTimeSlots.get(indexTSlot).getCodigo());

				i++;
			}
			
		}while(i<Arquivo.disciplinasEMC.size());

	}


	//
	// Accessor methods
	//
	/**
	 * 
	 * @return
	 */
	public Hashtable<Integer, ArrayList<Gene>> getCromossomoHash() {
		return cromossomoHash;
	}

	public void setCromossomo(Integer timeSlot, ArrayList<Gene> gene) {
		this.cromossomoHash.put(timeSlot, gene);
	}

	/**
	 * 
	 * @param gene
	 * @param codigoTimeSlot
	 *            <h2>DescriÃ§Ã£o</h2>
	 *            <p>
	 *            Metodo que insere um gene no cromossomo em um timeSlot passado
	 *            por parametro)
	 *            </p>
	 */

	public void insereGeneInCromossomo(Gene gene, Integer codigoTimeSlot) {
		ArrayList<Gene> geneArray = new ArrayList<>();

		if (cromossomoHash.get(codigoTimeSlot) == null) {
			geneArray.add(gene);
			this.cromossomoHash.put(codigoTimeSlot, geneArray);
		} else {
			geneArray = cromossomoHash.get(codigoTimeSlot);
			geneArray.add(gene);
			cromossomoHash.put(codigoTimeSlot, geneArray);
		}

	}
    
	/**
	 * 
	 * @param indexTSlot - código do timeslot a ser consultado
	 * @return boolean -  true se timeslot válido
	 * <h2>Descrição</h2>
	 * <p>Método que verifica se um timeslot é válido quanto ao horário de funcionamento da instituição</p>
	 */
	public boolean validaTS(int indexTSlot) {
		boolean valida = false;

		for (int ds = 0; ds < 5; ds++) {
			if (indexTSlot + 1 >= 32 + 24 * ds && indexTSlot + 1 <= 36 + 24 * ds)
				valida = true;
			else if (indexTSlot + 1 >= 38 + 24 * ds && indexTSlot + 1 <= 42 + 24 * ds)
				valida = true;
			else if (indexTSlot + 1 >= 43 + 24 * ds && indexTSlot + 1 <= 46 + 24 * ds)
				valida = true;
			if (indexTSlot + 1 >= 32 + 24 * 5 && indexTSlot + 1 <= 36 + 24 * 5)
				valida = true;
		}
		return valida;
	}
	
	/**
	 * 
	 * @param indexSala - index do arraylist de salas
	 * @return int - código de sala aleatório que combina com tipo da disciplina 
	 * <h2>Descrição</h2>
	 * <p>Método que gera um index aleatório para disciplina ser alocada em uma sala garantindo que o 
	 * tipo da sala alocada é o mesmo tipo de sala em que a disciplina deve ser ministrada</p>
	 */
	public int geraIndexDisc(int indexSala){
		boolean valida = false;
		int aux;
		do {
			aux = aleatorio.nextInt(Arquivo.disciplinasEMC.size());
			
			if (Arquivo.disciplinasEMC.get(aux).getTipoSalaTeoria() == Arquivo.salasEMC.get(indexSala).getTipoSala()
					.getCodigo())
				valida = true;
			else if (Arquivo.disciplinasEMC.get(aux).getTipoSalaPratica() == Arquivo.salasEMC.get(indexSala).getTipoSala()
					.getCodigo())
				valida = true;
			else
				valida = false;
		} while (valida);
		
		return aux;
	}
}
