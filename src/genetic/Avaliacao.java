package genetic;

import emc.*;

public class Avaliacao {
	
	
	public void avaliableProfessor(Cromossomo cromossomo, Professor professor){
		boolean  isProfValido=true;
		for (int i = 0; i < cromossomo.getCromossomoHash().size(); i++) {
			if(cromossomo.getCromossomoHash().get(i)!=null){			
				for (int j = 0; j < cromossomo.getCromossomoHash().get(i).size(); j++) {
					if(cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getCodigo()==professor.getCodigo()){
						isProfValido=false;
						break;
					}
					
				}							
			}
		}
	}
	
	
	
	
	

}
