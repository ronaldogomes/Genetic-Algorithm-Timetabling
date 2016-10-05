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

/**
 * Class gene
 */
public class Cromossomo {

	//
	// Fields
	//
	private Hashtable<Integer, ArrayList<Gene>> cromossomoHash;;

	//
	// Constructor
	//
	public Cromossomo() {
		this.cromossomoHash =  new Hashtable<Integer, ArrayList<Gene>>();
	}

	public Cromossomo(ArrayList<Disciplina> disc) {
		Random aleatorio = new Random();
		this.cromossomoHash =  new Hashtable<Integer, ArrayList<Gene>>();
		ArrayList<Gene> genes = new ArrayList<>();
		for (int i = 0; i <disc.size(); i++) {
			
			
			//cromossomoHash.put(arg0, arg1)
			
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
	
	
	
	/**
	 * 
	 * @param gene
	 * @param codigoTimeSlot
	 * <h2>Descrição</h2>
	 * <p>Metodo que insere um gene no cromossomo em um timeSlot passado por paramentro)</p>
	 */

	public void insereGene(Gene gene, Integer codigoTimeSlot){
		ArrayList<Gene> geneArray = new ArrayList<>();
		
		if (cromossomoHash.get(codigoTimeSlot)==null) {
			geneArray.add(gene);
			this.cromossomoHash.put(codigoTimeSlot, geneArray);
		}else{
			geneArray=cromossomoHash.get(codigoTimeSlot);
			geneArray.add(gene);
			cromossomoHash.put(codigoTimeSlot, geneArray);
		}	
		
	}
	



}
