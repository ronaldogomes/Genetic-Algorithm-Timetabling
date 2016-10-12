package entr_saida;

import emc.*;
import genetic.*;

public class CrossOver {

	public Cromossomo child1, child2;

	CrossOver(Cromossomo parent1, Cromossomo parent2) {
		for (int i = 0; i < parent1.getCromossomoHash().size() / 2; i++) {

		}

	}

	public Cromossomo retornaFilho1() {
		return child1;
	}

	public Cromossomo retornaFilho2() {
		return child2;
	}
}
