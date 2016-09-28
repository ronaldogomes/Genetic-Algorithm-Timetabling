package testes;

import emc.Curso;
import emc.Disciplina;
import emc.Sala;
import genetic.Gene;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gene gene = new Gene(new Sala(001, 45, "Comum"), new Disciplina());
		
		Curso ec = new Curso();

	}

}
