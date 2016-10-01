package genetic;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;

public class Populacao {
	
	private int sizePopulation;
	private int fitness;
	Gene gene[];
	
	Populacao(int sizePopulation){
		
		this.setSizePopulation(sizePopulation);
		for (int i =0;i<sizePopulation;i++){
			gene[i] = new Gene();	
		}
		
	}

	public int getSizePopulation() {
		return sizePopulation;
	}

	public void setSizePopulation(int sizePopulation) {
		this.sizePopulation = sizePopulation;
	}

	public int getFitness(Populacao populacao){
			for(int i=0;i<populacao.gene.length;i++){
			}
		return fitness;
	}

}
