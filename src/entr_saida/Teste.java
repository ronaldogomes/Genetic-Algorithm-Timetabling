package entr_saida;


import java.util.ArrayList;


import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TipoSala;
import genetic.Cromossomo;




public class Teste {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Arquivo.informacoesAg();
		Arquivo.restricoesAg();
		Cromossomo cromo1 = new Cromossomo();
//		for (int i = 1; i < 169; i++) {
//			System.out.print(i + " ");
//			if (cromo1.getCromossomoHash().get(i) != null) {
//				for (int j = 0; j < cromo1.getCromossomoHash().get(i).size(); j++) {
//					System.out.print(
//							"[" + cromo1.getCromossomoHash().get(i).get(j).getDisciplina().getDescricao() + "   ");
//					System.out.print(" > " + cromo1.getCromossomoHash().get(i).get(j).getProfessor().getNome() + "] {");
//					for (int j2 = 0; j2 < cromo1.getCromossomoHash().get(i).get(j).getAlunos().size(); j2++) {
//						System.out.print(cromo1.getCromossomoHash().get(i).get(j).getAlunos().get(j2).getNome() + ", "+cromo1.getCromossomoHash().get(i).get(j2).getDisciplina().getCargaHorariaTeorica());
//					}
//					System.out.print("}");
//				}
//			}
//			System.out.println("");
//		}
		Arquivo.salvaXLS(cromo1);
				
		System.out.println("salvo xls");
	}

	// 
	//METODOS
	//
		
	public static void validaCromossomo(Cromossomo cromossomo){
		boolean cromossomoValido = true;
		if(cromossomoValido){
			/**
			 * Insere na populacao. Ver qual estrutura usar para populacao(hash, vector, list).
			 * */
		}
		else{
			/**
			 * Descarta
			 * */
			
		}
	}
	
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
