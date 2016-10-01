package entr_saida;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;
import genetic.Cromossomo;



public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String nome = "/home/ronaldo/workspace/Genetic-Algorithm-Timetabling/files/ag-informacoes.csv";

		ArrayList<Curso> cursosEMC = new ArrayList<>();
		ArrayList<Disciplina> DisciplinasEMC = new ArrayList<>();
		ArrayList<Estudante> alunosEMC = new ArrayList<>();
		ArrayList<Professor> professoresEMC = new ArrayList<>();
		ArrayList<Sala> salasEMC = new ArrayList<>();
		ArrayList<TimeSlots> listaTimeSlots = new ArrayList<>();
		ArrayList<TipoSala> tipoSalaEMC = new ArrayList<>();

		Arquivo arquivo = new Arquivo();
		ArrayList<String> linhaPorLinha = arquivo.lerArquivo(nome);

		arquivo.informacoesAg(linhaPorLinha, cursosEMC, DisciplinasEMC,
				alunosEMC, professoresEMC, salasEMC, listaTimeSlots,
				tipoSalaEMC);
		for (int i = 0; i < salasEMC.size(); i++) {
			System.out.println("SALA " + 1 + i);
			System.out.println("codigo: " + salasEMC.get(i).getCodigo()
					+ "\ntipo de sala : "
					+ salasEMC.get(i).getTipoSala().getDescricao()
					+ "\ncapacidade da sala: "
					+ salasEMC.get(i).getCapacidade()
					+ "\nhorarios disponiveis : "
					+ salasEMC.get(i).getHorariosDisponiveis() + "\n\n");
		}

		// ArrayList<Disciplina> disc = new ArrayList<Disciplina>();
		// disc.add(new Disciplina(01, 01, "Desc", 64, 0, 0, 0));
		// Estudante aluno = new Estudante(01, "Chaib", disc);
		//
		// String nome =
		// "/home/ronaldo/workspace/Genetic-Algorithm-Timetabling/files/ag-informacoes.csv";
		// Arquivo arquivo = new Arquivo();
		// ArrayList<String> linhaPorLinha = arquivo.lerArquivo(nome);
		// for (int i = 0; i < linhaPorLinha.size(); i++) {
		// // System.out.println(linhaPorLinha.get(i));
		// }
		// ArrayList<TimeSlots> timeSlots =
		// arquivo.informacoesAg(linhaPorLinha);
		// for (int i = 0; i < timeSlots.size(); i++) {
		// //
		// System.out.println("Codigo TimeSlot: "+timeSlots.get(i).getCodigo()+"|  codigoDiaSemana :"+timeSlots.get(i).getCodDiaSemana());
		//
		// }
	}

}
