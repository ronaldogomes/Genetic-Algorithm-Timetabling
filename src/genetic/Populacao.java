package genetic;

import java.util.ArrayList;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;

public class Populacao {

	private int sizePopulation;
	private Cromossomo populacao[];

	public Populacao(int sizePopulation, ArrayList<Curso> cursosEMC, ArrayList<Disciplina> DisciplinasEMC,
				ArrayList<Estudante> alunosEMC, ArrayList<Professor> professoresEMC, ArrayList<Sala> salasEMC,
				ArrayList<TimeSlots> listaTimeSlots, ArrayList<TipoSala> tipoSalaEMC) {
		this.setSizePopulation(sizePopulation);
		this.populacao= new Cromossomo[sizePopulation];
		for (int i = 0; i < sizePopulation; i++) {
			populacao[i] = new Cromossomo(cursosEMC, DisciplinasEMC, alunosEMC, professoresEMC, salasEMC,
					listaTimeSlots, tipoSalaEMC);
		}

	}

	public int getSizePopulation() {
		return sizePopulation;
	}

	public void setSizePopulation(int sizePopulation) {
		this.sizePopulation = sizePopulation;
	}
	

}
