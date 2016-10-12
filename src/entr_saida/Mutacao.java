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
		int indexProf = random.nextInt(Arquivo.professoresEMC.size());
		int indexSala = random.nextInt(Arquivo.salasEMC.size());
		int indexDisc = random.nextInt(Arquivo.disciplinasEMC.size());
		int indexTSlot = random.nextInt(Arquivo.tipoSalaEMC.size());
		
		switch(random.nextInt(5)){
		 case 0:
			 gene.setDisciplina(Arquivo.disciplinasEMC.get(indexDisc));
			 break;
		 case 1:
			 ArrayList<Estudante> alunos = new ArrayList<>();
			 for(int i=0;i<gene.getSala().getCapacidade();i++){
				alunos.add(Arquivo.alunosEMC.get(random.nextInt(Arquivo.alunosEMC.size())));
			 }
			 gene.setAlunos(alunos);
			 break;
		 case 2:
			 gene.setProfessor(Arquivo.professoresEMC.get(indexProf));
			 break;
		 case 3:
			 gene.setSala(Arquivo.salasEMC.get(indexSala));
			 break;
		 case 4:
			 gene.setTimeslots(Arquivo.listaTimeSlots.get(indexTSlot));
			 break;

		
		}
	}
}
