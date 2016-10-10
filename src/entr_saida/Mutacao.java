package entr_saida;
import java.util.ArrayList;
import java.util.Random;

import emc.*;
import genetic.*;

public class Mutacao {
	Mutacao(Gene gene){
		Random random = new Random();
	/**
	 * Case 0 = muta discipina
	 * Case 1 = muta estudante
	 * Case 2 = muta professor
	 * Case 3 = muta sala	
	 * Case 4 = muta timeSlot 
	 * */	
		int indexProf = random.nextInt(Teste.professoresEMC.size());
		int indexSala = random.nextInt(Teste.salasEMC.size());
		int indexDisc = random.nextInt(Teste.DisciplinasEMC.size());
		int indexTSlot = random.nextInt(Teste.tipoSalaEMC.size());
		
		switch(random.nextInt(5)){
		 case 0:
			 gene.setDisciplina(Teste.DisciplinasEMC.get(indexDisc));
			 break;
		 case 1:
			 ArrayList<Estudante> alunos = new ArrayList<>();
			 for(int i=0;i<gene.getSala().getCapacidade();i++){
				alunos.add(Teste.alunosEMC.get(random.nextInt(Teste.alunosEMC.size())));
			 }
			 gene.setAlunos(alunos);
			 break;
		 case 2:
			 gene.setProfessor(Teste.professoresEMC.get(indexProf));
			 break;
		 case 3:
			 gene.setSala(Teste.salasEMC.get(indexSala));
			 break;
		 case 4:
			 gene.setTimeslots(Teste.listaTimeSlots.get(indexTSlot));
			 break;

		
		}
	}
}
