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
		
//		IMPRIME OS ARRAYS DOS OBJETOS CARREGADOS DO ARQUIVO ag-informacoes.csv		
//		imprimeArrayAlunos(alunosEMC);
//		imprimeArrayCursos(cursosEMC);
//		imprimeArrayDisciplinas(DisciplinasEMC);
		imprimeArrayProfessores(professoresEMC);
//		imprimeArraySalas(salasEMC);
//		imprimeArrayTimesSlots(tipoSalaEMC);
//		imprimeArrayTipoSala(tipoSalaEMC);

	}

	// metodos
	public static void imprimeArrayCursos(ArrayList<Curso> cursos) {
		for (int i = 0; i < cursos.size(); i++) {
			System.out.println(cursos.get(i).getCodigo() + ", "
					+ cursos.get(i).getNome() + ","
					+ cursos.get(i).getNumPeriodo() + ","
					+ cursos.get(i).getTurno());

		}

	}

	public static void imprimeArrayDisciplinas(ArrayList<Disciplina> disciplinas) {
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.println(disciplinas.get(i).getCodigo() + ","
					+ disciplinas.get(i).getCodigoCurso() + ","
					+ disciplinas.get(i).getCodigPeriodo() + ","
					+ disciplinas.get(i).getDescricao() + ","
					+ disciplinas.get(i).getCargaHorariaTeorica() + ","
					+ disciplinas.get(i).getTipoSalaTeoria() + ","
					+ disciplinas.get(i).getCargaHorariaPratica() + ","
					+ disciplinas.get(i).getTipoSalaPratica());
		}
		

	}

	public static void imprimeArrayAlunos(ArrayList<Estudante> alunos) {
		for (int i = 0; i < alunos.size(); i++) {
			System.out.print(alunos.get(i).getCodigo()+","+alunos.get(i).getNome());
			for (int j = 0; j < alunos.get(i).getDisciplinasCursar().size(); j++) {
				System.out.print(","+alunos.get(i).getDisciplinasCursar().get(j).getCodigo());
			}
			System.out.println("");
		}

	}

	public static void imprimeArrayProfessores(ArrayList<Professor> professores) {
		for (int i = 0; i < professores.size(); i++) {
			System.out.print(professores.get(i).getCodigo()+","+professores.get(i).getNome());
			for (int j = 0; j < professores.get(i).getDisciplinasMinist().size(); j++) {
				System.out.print(","+professores.get(i).getDisciplinasMinist().get(j).getCodigo());
			}
			System.out.println("");
		}

	}

	public static void imprimeArraySalas(ArrayList<Sala> salas) {
		for (int i = 0; i < salas.size(); i++) {
			System.out.println(salas.get(i).getCodigo()+","+salas.get(i).getDescricao()+","+salas.get(i).getTipoSala().getCodigo()+","+salas.get(i).getCapacidade());
		}
	}

	public static void imprimeArrayTimesSlots(ArrayList<TipoSala> timeSlots) {
		for (int i = 0; i < timeSlots.size(); i++) {
			System.out.println(timeSlots.get(i).getCodigo()+","+timeSlots.get(i).getDescricao()+","+timeSlots.get(i)+" configurar horairo de inicio e fim");
		}
	}

	public static void imprimeArrayTipoSala(ArrayList<TipoSala> tipoSalas) {
		for (int i = 0; i < tipoSalas.size(); i++) {
			System.out.println(tipoSalas.get(i).getCodigo()+","+tipoSalas.get(i).getDescricao());
		}
	}

}
