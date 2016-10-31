package entr_saida;

import java.util.ArrayList;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;
import genetic.Avaliacao;
import genetic.Cromossomo;

public class Teste {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Arquivo.informacoesAg();
		Arquivo.restricoesAg();
		System.out.println(Arquivo.disciplinasEMC.size());
		System.out.println("criando cromossomo...");
		Cromossomo cromo1 = new Cromossomo();
		System.out.println(Avaliacao.isCromossomoValido(cromo1));
		Arquivo.salvaXLS(cromo1);
		System.out.println(" cromossomo criado");
		System.out.println(cromo1.disciplinasTemp.size() + " DISCIPLINAS NÃO ALOCADAS");
//		for (int i = 0; i < 169; i++) {
//			if (cromo1.getCromossomoHash().get(i) != null) {
//				for (int j = 0; j < cromo1.getCromossomoHash().get(i).size(); j++) {
//
//					System.out.println(cromo1.getCromossomoHash().get(i).get(j).getDisciplina().getDescricao() + " TS: "
//							+ i + " Periodo:  "
//							+ cromo1.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + " Curso: "
//							+ cromo1.getCromossomoHash().get(i).get(j).getDisciplina().getCodigoCurso()+" prof: "+cromo1.getCromossomoHash().get(i).get(j).getProfessor().getNome());
//
//				}
//			}
//		}

	}

	//
	// METODOS
	//

	public static void validaCromossomo(Cromossomo cromossomo) {
		boolean cromossomoValido = true;
		if (cromossomoValido) {
			/**
			 * Insere na populacao. Ver qual estrutura usar para populacao(hash,
			 * vector, list).
			 */
		} else {
			/**
			 * Descarta
			 */

		}
	}

	public static void imprimeArrayCursos(ArrayList<Curso> cursos) {
		for (int i = 0; i < cursos.size(); i++) {
			System.out.println(cursos.get(i).getCodigo() + ", " + cursos.get(i).getNome() + ","
					+ cursos.get(i).getNumPeriodo() + "," + cursos.get(i).getTurno());

		}

	}

	public static void imprimeArrayDisciplinas(ArrayList<Disciplina> disciplinas) {
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.println(disciplinas.get(i).getCodigo() + "," + disciplinas.get(i).getCodigoCurso() + ","
					+ disciplinas.get(i).getCodigPeriodo() + "," + disciplinas.get(i).getDescricao() + ",CHT:"
					+ disciplinas.get(i).getCargaHorariaTeorica()
					+ "," /* + disciplinas.get(i).getTipoSalaTeoria() */ + ",CHP: "
					+ disciplinas.get(i).getCargaHorariaPratica()
					+ ", " /* + disciplinas.get(i).getTipoSalaPratica() */);
		}

	}

	public static void imprimeArrayAlunos(ArrayList<Estudante> alunos) {
		for (int i = 0; i < alunos.size(); i++) {
			System.out.print(alunos.get(i).getCodigo() + "," + alunos.get(i).getNome());
			for (int j = 0; j < alunos.get(i).getDisciplinasCursar().size(); j++) {
				System.out.print("," + alunos.get(i).getDisciplinasCursar().get(j).getCodigo());
			}
			System.out.println("");
		}

	}

	public static void imprimeArrayProfessores(ArrayList<Professor> professores) {
		for (int i = 0; i < professores.size(); i++) {
			System.out.print(professores.get(i).getCodigo() + "," + professores.get(i).getNome());
			for (int j = 0; j < professores.get(i).getDisciplinasMinistrar().size(); j++) {
				System.out.print("," + professores.get(i).getDisciplinasMinistrar().get(j).getCodigo());
			}
			System.out.println("");
		}

	}

	public static void imprimeArraySalas(ArrayList<Sala> salas) {
		for (int i = 0; i < salas.size(); i++) {
			System.out.println(salas.get(i).getCodigo() + "," + salas.get(i).getDescricao() + ","
					+ salas.get(i).getTipoSala().getCodigo() + "," + salas.get(i).getCapacidade());
		}
	}

	public static void imprimeArrayTimesSlots(ArrayList<TimeSlots> timeSlots) {
		for (int i = 0; i < timeSlots.size(); i++) {
			System.out.println("indice " + i + "  " + timeSlots.get(i).getCodigo() );
		}
	}

	public static void imprimeArrayTipoSala(ArrayList<TipoSala> tipoSalas) {
		for (int i = 0; i < tipoSalas.size(); i++) {
			System.out.println(tipoSalas.get(i).getCodigo() + "," + tipoSalas.get(i).getDescricao());
		}
	}

}
