package entr_saida;

import emc.*;
import genetic.*;

public class CrossOver {

	public Cromossomo child1, child2;

	public CrossOver(Cromossomo parent1, Cromossomo parent2) {
		child1 = new Cromossomo();
		child2 = new Cromossomo();
		int max = parent1.getCromossomoHash().size() / 2;
		for (int i = 0; i < max; i++) {
			//
		}

	}

	public Cromossomo retornaFilho1() {
		return child1;
	}

	public Cromossomo retornaFilho2() {
		return child2;
	}
}
