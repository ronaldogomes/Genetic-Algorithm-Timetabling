package genetic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import emc.*;
import entr_saida.Arquivo;

/**
 * Class gene
 */
public class Cromossomo {

	//
	// Fields
	//
	private Hashtable<Integer, ArrayList<Gene>> cromossomoHash;
	private Random aleatorio = new Random();
	public ArrayList<Disciplina> disciplinasTemp;
	public int controlCargHor[][];
	// index aleatório dos arrays
	// private
	//
	// Constructor
	//

	public Cromossomo() {
		this.cromossomoHash = new Hashtable<Integer, ArrayList<Gene>>();
		// array de alunos aleatório
		ArrayList<Estudante> alunos;
		disciplinasTemp = copyArrayListDisc(Arquivo.disciplinasEMC);
		int i = 0;
		boolean manterLupDisc;
		// carregando cromossomo
		int indexProf, indexSala, indexDisc, indexCurso;
		int indexTSlot;
		int controlCargaHorariaDisc[][];
		do {
			int posicaoControl = 0;
			indexDisc = geraIndexDisc();
			int cargaHorariaTeorica = disciplinasTemp.get(indexDisc).getCargaHorariaTeorica();
			int cargaHorariaPratica = disciplinasTemp.get(indexDisc).getCargaHorariaPratica();
			int qtdLinhas = cargaHorariaPratica + cargaHorariaTeorica;
			controlCargaHorariaDisc = new int[qtdLinhas][4];
			// PREENCHER TODA CARGA HORARIA DA DISCIPLINA
			do {
				indexTSlot = geraIndexTimeSlot();
				manterLupDisc = true;
				indexCurso = disciplinasTemp.get(indexDisc).getCodigoCurso() - 1;
				indexProf = geraIndexProfessor(indexTSlot, indexDisc);
				indexSala = geraIndexSala(indexTSlot, indexDisc);
				if (indexProf == -1 || isDiscMemsmoPeriodo(indexDisc, indexTSlot)) {
					// resetar CHT e CHP
					break;
				}
				if ((disciplinasTemp.get(indexDisc).getTipoSalaTeoria() == Arquivo.salasEMC.get(indexSala).getTipoSala()
						.getCodigo()) && (disciplinasTemp.get(indexDisc).getCargaHorariaTeorica() > 0)) {
					decrementaCargaHoraria(disciplinasTemp.get(indexDisc), 1);
					controlCargaHorariaDisc[posicaoControl][0] = indexTSlot;
					controlCargaHorariaDisc[posicaoControl][1] = indexProf;
					controlCargaHorariaDisc[posicaoControl][2] = indexSala;
					posicaoControl++;
				} else if (disciplinasTemp.get(indexDisc).getTipoSalaPratica() == Arquivo.salasEMC.get(indexSala)
						.getTipoSala().getCodigo() && disciplinasTemp.get(indexDisc).getCargaHorariaPratica() > 0) {
					// decrementa CHP
					decrementaCargaHoraria(disciplinasTemp.get(indexDisc), 2);
					controlCargaHorariaDisc[posicaoControl][0] = indexTSlot;
					controlCargaHorariaDisc[posicaoControl][1] = indexProf;
					controlCargaHorariaDisc[posicaoControl][2] = indexSala;
					posicaoControl++;
				}
				if (disciplinasTemp.get(indexDisc).getCargaHorariaTeorica() == 0
						&& disciplinasTemp.get(indexDisc).getCargaHorariaPratica() == 0)
					manterLupDisc = false;

			} while (manterLupDisc);

			if (disciplinasTemp.get(indexDisc).getCargaHorariaTeorica() == 0
					&& disciplinasTemp.get(indexDisc).getCargaHorariaPratica() == 0) {

				// gerar ArrayList de Estudante
				alunos = new ArrayList<>();
				// resetar CHT e CHP
				disciplinasTemp.get(indexDisc).setCargaHorariaTeorica(cargaHorariaTeorica);
				disciplinasTemp.get(indexDisc).setCargaHorariaPratica(cargaHorariaPratica);
				// Inserir Disciplina no cromossomo
				System.out.println(" "+disciplinasTemp.get(indexDisc).getDescricao()+" "+controlCargaHorariaDisc[controlCargaHorariaDisc.length-1][1]);
				for (int j = 0; j < controlCargaHorariaDisc.length; j++) {
					insereGeneInCromossomo(
							new Gene(Arquivo.professoresEMC.get(controlCargaHorariaDisc[j][1]),
									Arquivo.salasEMC.get(controlCargaHorariaDisc[j][3]), disciplinasTemp.get(indexDisc),
									alunos, Arquivo.listaTimeSlots.get(controlCargaHorariaDisc[j][0]),
									Arquivo.cursosEMC.get(indexCurso)),
							Arquivo.listaTimeSlots.get(controlCargaHorariaDisc[j][0]).getCodigo());
				}
				// remover disciplina de displinasTemp
				disciplinasTemp.remove(indexDisc);

			}else{
				disciplinasTemp.get(indexDisc).setCargaHorariaTeorica(cargaHorariaTeorica);
				disciplinasTemp.get(indexDisc).setCargaHorariaPratica(cargaHorariaPratica);
			}
			i++;

		} while (disciplinasTemp.size() > 0 && i < 500);
		// verdadeiro verdadeiro = falso
	}

	private boolean isDiscMemsmoPeriodo(int indexDisc, int indexTSlot) {
		for (int i = 0; i < 169; i++) {
			if(cromossomoHash.get(i)!=null){
				for (int j = 0; j < cromossomoHash.get(i).size(); j++) {
					if(cromossomoHash.get(i).get(j).getDisciplina().getCodigo()==disciplinasTemp.get(indexDisc).getCodigo()){
						return true;
					}
				}
			}
		}
		return false;
	}

	private ArrayList<Estudante> geraArrayAlunos(int indexTSlot, int indexDisc) {
		// criar um arrayList de alunos garantindo as hard
		ArrayList<Estudante> alunos = new ArrayList<>();
		return alunos;
	}

	//
	// Accessor methods
	//
	/**
	 * 
	 * @return
	 */
	public Hashtable<Integer, ArrayList<Gene>> getCromossomoHash() {
		return cromossomoHash;
	}

	public void setCromossomo(Integer timeSlot, ArrayList<Gene> gene) {
		this.cromossomoHash.put(timeSlot, gene);
	}

	/**
	 * 
	 * @param gene
	 * @param codigoTimeSlot
	 *            <h2>Descrição</h2>
	 *            <p>
	 *            Metodo que insere um gene no cromossomo em um timeSlot passado
	 *            por parametro)
	 *            </p>
	 */

	public boolean insereGeneInCromossomo(Gene gene, Integer codigoTimeSlot) {
		ArrayList<Gene> geneArray = new ArrayList<>();
		if (cromossomoHash.get(codigoTimeSlot) == null) {
			geneArray.add(gene);
			this.cromossomoHash.put(codigoTimeSlot, geneArray);
			return true;
		} else {
			geneArray = cromossomoHash.get(codigoTimeSlot);
			geneArray.add(gene);
			cromossomoHash.put(codigoTimeSlot, geneArray);
			return true;
		}
	}

	public void decrementaCargaHoraria(Disciplina disciplina, int ch) {
		switch (ch) {
		case 1:
			disciplina.setCargaHorariaTeorica(disciplina.getCargaHorariaTeorica() - 1);
			break;
		case 2:
			disciplina.setCargaHorariaPratica(disciplina.getCargaHorariaPratica() - 1);
			break;
		}

	}

	/**
	 * 
	 * @param indexTSlot
	 *            - código do timeslot a ser consultado
	 * @return boolean - true se timeslot válido
	 *         <h2>Descrição</h2>
	 *         <p>
	 *         Método que verifica se um timeslot é válido quanto ao horário de
	 *         funcionamento da instituição
	 *         </p>
	 */
	public static boolean validaTS(int indexTSlot) {
		boolean valida = false;

		for (int ds = 0; ds < 5; ds++) {
			if (indexTSlot + 1 >= 32 + 24 * ds && indexTSlot + 1 <= 36 + 24 * ds)
				valida = true;
			else if (indexTSlot + 1 >= 38 + 24 * ds && indexTSlot + 1 <= 42 + 24 * ds)
				valida = true;
			else if (indexTSlot + 1 >= 43 + 24 * ds && indexTSlot + 1 <= 46 + 24 * ds)
				valida = true;
			if (indexTSlot + 1 >= 32 + 24 * 5 && indexTSlot + 1 <= 36 + 24 * 5)
				valida = true;
		}
		return valida;
	}

	/**
	 * 
	 * @param indexSala
	 *            - index do arraylist de salas
	 * @return int - código de sala aleatório que combina com tipo da disciplina
	 *         <h2>Descriçãoo</h2>
	 *         <p>
	 *         Método que gera um index aleat�rio para disciplina ser alocada em
	 *         uma sala garantindo que o tipo da sala alocada é o mesmo tipo de
	 *         sala em que a disciplina deve ser ministrada
	 *         </p>
	 */
	public int geraIndexDisc() {
		int indexDisc;
		indexDisc = aleatorio.nextInt(disciplinasTemp.size());
		return indexDisc;
	}

	/**
	 * 
	 * @return
	 *         <h1>Descrição</h1>
	 *         <p>
	 *         método que gera index para um aluno do array de Estudantes
	 *         garantindo a hard constraint [um aluno não pode se matricular em
	 *         duas disciplinas no mesmo timeSlot]
	 *         </p>
	 */
	public int geraIndexAluno(int indexTimeSlot) {
		// IMPLEMENTAR AS HARD CONSTRAINTS
		// aluno não deve pegar mais de uma disciplina no mesmo timeslot
		int indexAlunoGerado;
		boolean val = false;
		do {
			indexAlunoGerado = aleatorio.nextInt(Arquivo.alunosEMC.size());
			if (!cromossomoHash.get(indexTimeSlot).isEmpty()) {
				for (int indexArGene = 0; indexArGene < cromossomoHash.get(indexTimeSlot).size(); indexArGene++) {
					for (int indexArrEst = 0; indexArrEst < cromossomoHash.get(indexTimeSlot).get(indexArGene)
							.getAlunos().size(); indexArrEst++) {
						if (cromossomoHash.get(indexTimeSlot).get(indexArGene).getAlunos().get(indexArrEst)
								.getCodigo() == Arquivo.alunosEMC.get(indexAlunoGerado).getCodigo()) {
							val = true;
						} else {
							val = false;
						}
					}
				}
			}
		} while (val);
		return indexAlunoGerado;
	}

	/**
	 * 
	 * @return
	 *         <h1>Descrição</h1>
	 *         <p>
	 *         método que gera index para um professor do array de professor
	 *         garantindo a hard constraint [um professor não pode ministrar
	 *         duas disciplinas no mesmo timeSlot e não pode ministrar em
	 *         horario indisponivel]
	 *         </p>
	 */
	public int geraIndexProfessor(int indexTimeSlot, int indexDisc) {
		ArrayList<Integer> indexProfTSDispTotal = new ArrayList<>();
		for (int i = 0; i < Arquivo.professoresEMC.size(); i++) {
			for (int j = 0; j < Arquivo.professoresEMC.get(i).getDisciplinasMinistrar().size(); j++) {
				if (Arquivo.professoresEMC.get(i).getDisciplinasMinistrar().get(j).getCodigo() == disciplinasTemp
						.get(indexDisc).getCodigo()) {
					// se a lista de horarios indisponiveis do professor não
					// está vazia
					if (Arquivo.professoresEMC.get(i).getListaTSIndFixa() != null) {
						for (int j2 = 0; j2 < Arquivo.professoresEMC.get(i).getListaTSIndFixa().size(); j2++) {
							if (Arquivo.professoresEMC.get(i).getListaTSIndFixa().get(j2)
									.getCodigo() != Arquivo.listaTimeSlots.get(indexTimeSlot).getCodigo()) {
								indexProfTSDispTotal.add(i);// A
								break;
							}
						}
					} else
						indexProfTSDispTotal.add(i);
					break; // se está vazia
				}
			}

		}
		for (int i = 0; i < 169; i++) {
			if (cromossomoHash.get(i) != null) {
				for (int j = 0; j < cromossomoHash.get(i).size(); j++) {
					for (int j2 = 0; j2 < indexProfTSDispTotal.size(); j2++) {
						if (cromossomoHash.get(i).get(j).getProfessor().getCodigo() == Arquivo.professoresEMC
								.get(indexProfTSDispTotal.get(j2)).getCodigo()) {
							indexProfTSDispTotal.remove(j2);
							break;
						}
					}

				}
			}
		}

		if (indexProfTSDispTotal.size() == 0)
			return -1;

		return indexProfTSDispTotal.get(aleatorio.nextInt(indexProfTSDispTotal.size()));
	}

	/**
	 * 
	 * @return int - indexTimeSlot
	 *         <h1>Descrição</h1>
	 *         <p>
	 *         método que gera index para um timeSlot do array de timeSlot
	 *         garantindo a hard constraint [um timeSlot não pode ter duas
	 *         disciplinas simultaneas]
	 *         </p>
	 */
	public int geraIndexTimeSlot() {
		int indexTSGerado;
		do {
			indexTSGerado = aleatorio.nextInt(Arquivo.listaTimeSlots.size());
		} while (!validaTS(indexTSGerado));
		return indexTSGerado;
	}

	/**
	 * 
	 * @return
	 *         <h2>Descrição</h2>
	 *         <p>
	 *         Método que gera um index aleatório para a sala respeitando as
	 *         Hard Constraints físicas da sala
	 *         </p>
	 */
	public int geraIndexSala(int indexTimeslot, int indexDisc) {
		int indexSalaGerada;
		boolean manterLupe;
		int cont = 0;
		do {
			manterLupe = true;
			indexSalaGerada = aleatorio.nextInt(Arquivo.salasEMC.size());
			// se a sala gerada não estiver ocupada naquele timeslot
			if (eSalaLivre(indexSalaGerada, indexTimeslot)) {
				if (disciplinasTemp.get(indexDisc).getTipoSalaTeoria() == Arquivo.salasEMC.get(indexSalaGerada)
						.getTipoSala().getCodigo()
						|| disciplinasTemp.get(indexDisc).getTipoSalaPratica() == Arquivo.salasEMC.get(indexSalaGerada)
								.getTipoSala().getCodigo() && disciplinasTemp.get(indexDisc).getTipoSalaPratica() > 0) {
					manterLupe = false;
				}
			}
			cont++;
		} while (manterLupe || cont < 1000);
		return indexSalaGerada;

	}

	private boolean eSalaLivre(int indexSalaGerada, int indexTimeslot) {
		if (cromossomoHash.containsKey(indexTimeslot)) {
			for (int indexArGene = 0; indexArGene < cromossomoHash.get(indexTimeslot).size(); indexArGene++) {
				if (cromossomoHash.get(indexTimeslot).get(indexArGene).getSala().getCodigo() == Arquivo.salasEMC
						.get(indexSalaGerada).getCodigo()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 *         <h2>Descrição</h2>
	 *         <p>
	 *         Método que gera um index para o curso respeitando a hard
	 *         constraints de curso
	 *         </p>
	 */


	public ArrayList<Disciplina> copyArrayListDisc(ArrayList<Disciplina> disc) {
		int codigo, codigoCurso, codigoPeriodo, cargaHorariaTeoria, tipoSalaTeoria, cargaHorariaPratica,
				tipoSalaPratica;
		String descricao;
		ArrayList<Disciplina> discRetorno = new ArrayList<>();
		for (int i = 0; i < disc.size(); i++) {
			codigo = disc.get(i).getCodigo();
			codigoCurso = disc.get(i).getCodigoCurso();
			codigoPeriodo = disc.get(i).getCodigPeriodo();
			descricao = disc.get(i).getDescricao();
			cargaHorariaTeoria = disc.get(i).getCargaHorariaTeorica();
			tipoSalaTeoria = disc.get(i).getTipoSalaTeoria();
			cargaHorariaPratica = disc.get(i).getCargaHorariaPratica();
			tipoSalaPratica = disc.get(i).getTipoSalaPratica();

			discRetorno.add(new Disciplina(codigo, codigoCurso, codigoPeriodo, descricao, cargaHorariaTeoria,
					tipoSalaTeoria, cargaHorariaPratica, tipoSalaPratica));
		}
		return discRetorno;
	}

	public int removeDisciplinaCromossomo(int codigoDisciplina) {
		int contRemocao = 0;
		for (int i = 0; i < 169; i++) {
			if (cromossomoHash.get(i) != null) {
				for (int j = 0; j < cromossomoHash.get(i).size(); j++) {
					if (cromossomoHash.get(i).get(j).getDisciplina().getCodigo() == codigoDisciplina) {
						cromossomoHash.get(i).remove(j);
						contRemocao++;
					}
				}
			}
		}
		return contRemocao;
	}
}
