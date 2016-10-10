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
		int indexSala, indexTSlot;
		// array de alunos aleatório
		ArrayList<Estudante> alunos;
		
		
		// carregando cromossomo 
		for (int i = 0; i < disciplinasEMC.size(); i++) {
			indexSala = aleatorio.nextInt(salasEMC.size());
			
			indexTSlot = TimeSlots.timeSlotAleatorioValido();//= aleatorio.nextInt(listaTimeSlots.size());
			
			alunos= new ArrayList<>();
			for (int a = 0; a < salasEMC.get(indexSala).getCapacidade(); a++) {
				int indexAl = aleatorio.nextInt(alunosEMC.size()-1);
				alunos.add(alunosEMC.get(indexAl));
				
			}
			
			insereGeneInCromossomo(
					new Gene(professoresEMC.get(aleatorio.nextInt(professoresEMC.size())), salasEMC.get(indexSala),
					disciplinasEMC.get(aleatorio.nextInt(disciplinasEMC.size())), alunos,
					listaTimeSlots.get(indexTSlot), cursosEMC.get(aleatorio.nextInt(cursosEMC.size()))), listaTimeSlots.get(indexTSlot).getCodigo());
			
			
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
