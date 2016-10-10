package entr_saida;
import emc.*;
import genetic.*;


public class CrossOver {
	
		public Gene child1, child2;
		CrossOver(Gene parent1, Gene parent2){

				child1 = new Gene(parent2.getProfessor(), parent2.getSala(),
							parent2.getDisciplina(), parent1.getAlunos(),
							parent1.getTimeslots(), parent1.getCurso());
				 child2 = new Gene(parent1.getProfessor(), parent1.getSala(),
							parent1.getDisciplina(), parent2.getAlunos(),
							parent2.getTimeslots(), parent2.getCurso());
			}
	
		
		
		public Gene retornaFilho1(){
			return child1;
				}
		public Gene retornaFilho2(){
			return child2;
				}
}


