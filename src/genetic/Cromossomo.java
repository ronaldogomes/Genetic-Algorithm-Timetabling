package genetic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;
import entr_saida.Arquivo;

/**
 * Class gene
 */
public class Cromossomo {

	//
	// Fields
	//
	private Hashtable<Integer, ArrayList<Gene>> cromossomoHash;

	//
	// Constructor
	//
	public Cromossomo() {
		this.cromossomoHash = new Hashtable<Integer, ArrayList<Gene>>();
	}

	public Cromossomo(ArrayList<Curso> cursosEMC, ArrayList<Disciplina> disciplinasEMC, ArrayList<Estudante> alunosEMC,
			ArrayList<Professor> professoresEMC, ArrayList<Sala> salasEMC, ArrayList<TimeSlots> listaTimeSlots,
			ArrayList<TipoSala> tipoSalaEMC) {
		this.cromossomoHash = new Hashtable<Integer, ArrayList<Gene>>();
		// index aleatório dos arrays
		Random aleatorio = new Random();
		int indexProf = aleatorio.nextInt(professoresEMC.size());
		int indexSala = aleatorio.nextInt(salasEMC.size());
		int indexDisc = aleatorio.nextInt(disciplinasEMC.size());
		int indexTSlot = aleatorio.nextInt(tipoSalaEMC.size());
		int indexCurso= aleatorio.nextInt(cursosEMC.size());
		// array de alunos aleatório
		ArrayList<Estudante> alunos = new ArrayList<>();
		for (int i = 0; i < salasEMC.get(indexSala).getCapacidade(); i++) {
			int indexAl = aleatorio.nextInt(alunosEMC.size()-1);
			alunos.add(alunosEMC.get(indexAl));
			
		}
		
		// carregando cromossomo 
		for (int i = 0; i < disciplinasEMC.size(); i++) {
			insereGeneInCromossomo(
					new Gene(professoresEMC.get(indexProf), salasEMC.get(indexSala),
					disciplinasEMC.get(indexDisc), alunos,
					listaTimeSlots.get(indexTSlot), cursosEMC.get(indexCurso)), listaTimeSlots.get(indexTSlot).getCodigo());
			
			indexProf = aleatorio.nextInt(professoresEMC.size());
			indexSala = aleatorio.nextInt(salasEMC.size());
			indexDisc = aleatorio.nextInt(disciplinasEMC.size());
			indexTSlot = aleatorio.nextInt(listaTimeSlots.size());
			indexCurso= aleatorio.nextInt(cursosEMC.size());
		}

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
	public void setCromossomo(Integer timeSlot, ArrayList<Gene> gene){
		this.cromossomoHash.put(timeSlot, gene);
	}

	/**
	 * 
	 * @param gene
	 * @param codigoTimeSlot
	 *            <h2>Descrição</h2>
	 *            <p>
	 *            Metodo que insere um gene no cromossomo em um timeSlot passado
	 *            por paramentro)
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

}
