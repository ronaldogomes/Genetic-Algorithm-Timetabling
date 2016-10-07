package genetic;



public class Populacao {
	
	private int sizePopulation;
	Cromossomo cromossomo[];
	
	Populacao(int sizePopulation){
		
		this.setSizePopulation(sizePopulation);
		for (int i =0;i<sizePopulation;i++){
			//cromossomo[i] = new Cromossomo();	
		}
		
	}

	public int getSizePopulation() {
		return sizePopulation;
	}

	public void setSizePopulation(int sizePopulation) {
		this.sizePopulation = sizePopulation;
	}

}
	


