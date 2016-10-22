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
	public ArrayList<Disciplina> disciplinasTemp = new ArrayList<>();;
	// index aleatório dos arrays
	private int indexProf, indexSala, indexDisc, indexTSlot, indexCurso;
	//
	// Constructor
	//

	public Cromossomo() {
		this.cromossomoHash = new Hashtable<Integer, ArrayList<Gene>>();
		// array de alunos aleatório
		ArrayList<Estudante> alunos;
		disciplinasTemp.addAll(Arquivo.disciplinasEMC);

		int i = 0;

		// carregando cromossomo
		do {
			indexTSlot = geraIndexTimeSlot();//
			indexProf = geraIndexProfessor(indexTSlot);
			indexCurso = geraIndexCurso();
			indexSala = geraIndexSala(indexTSlot);
			indexDisc = geraIndexDisc(indexTSlot, indexSala);

			if (validaTS(indexTSlot)) {

				alunos = new ArrayList<>();
				for (int a = 0; a < Arquivo.salasEMC.get(indexSala).getCapacidade(); a++) {
					int indexAl = aleatorio.nextInt(Arquivo.alunosEMC.size() - 1);
					alunos.add(Arquivo.alunosEMC.get(indexAl));

				}
		
				insereGeneInCromossomo(new Gene(Arquivo.professoresEMC.get(indexProf), Arquivo.salasEMC.get(indexSala),
						disciplinasTemp.get(indexDisc), alunos, Arquivo.listaTimeSlots.get(indexTSlot),
						Arquivo.cursosEMC.get(indexCurso)), Arquivo.listaTimeSlots.get(indexTSlot).getCodigo());
				if(disciplinasTemp.get(indexDisc).getCargaHorariaPratica()==0 && disciplinasTemp.get(indexDisc).getCargaHorariaTeorica()==0){
					disciplinasTemp.remove(indexDisc);
				}
				
			}
			i++;
		} while (disciplinasTemp.size()>0 && i<1240);

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

	public void insereGeneInCromossomo(Gene gene, Integer codigoTimeSlot) {
		ArrayList<Gene> geneArray = new ArrayList<>();
		if (cromossomoHash.get(codigoTimeSlot) == null) {
			geneArray.add(gene);
			this.cromossomoHash.put(codigoTimeSlot, geneArray);
		} else {
			geneArray = cromossomoHash.get(codigoTimeSlot);
			geneArray.add(gene);
			cromossomoHash.put(codigoTimeSlot, geneArray);
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
	public int geraIndexDisc(int indexTimeSlot, int indexSala) {
		boolean valida = false;
		boolean validaChoqTS=false;
		int aux;
		do {
			aux = aleatorio.nextInt(disciplinasTemp.size());
			//verifica se há choque de horário de disciplinas do mesmo período
			if(cromossomoHash.get(indexTimeSlot)!=null){
				for (int i = 0; i < cromossomoHash.get(indexTimeSlot).size(); i++) {
					if(cromossomoHash.get(indexTimeSlot).get(i).getDisciplina().getCodigPeriodo()==disciplinasTemp.get(aux).getCodigPeriodo()){
						validaChoqTS=true;
					}
				}
			}
			//verifica 
			if (disciplinasTemp.get(aux).getTipoSalaTeoria() == Arquivo.salasEMC.get(indexSala).getTipoSala()
					.getCodigo()&& disciplinasTemp.get(aux).getCargaHorariaTeorica()>0){
				disciplinasTemp.get(aux).setCargaHorariaTeorica(disciplinasTemp.get(aux).getCargaHorariaTeorica()-1);
				valida = false;
			}else if (disciplinasTemp.get(aux).getTipoSalaPratica() == Arquivo.salasEMC.get(indexSala)
					.getTipoSala().getCodigo() && disciplinasTemp.get(aux).getCargaHorariaPratica()>0){
				disciplinasTemp.get(aux).setCargaHorariaPratica(disciplinasTemp.get(aux).getCargaHorariaPratica()-1);
				valida = false;
			}else
				valida = true;
		} while (valida && validaChoqTS);
		return aux;
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
		int indexAlunoGerado;
		boolean val = false;
		do {
			indexAlunoGerado = aleatorio.nextInt(Arquivo.alunosEMC.size());
			if (!cromossomoHash.get(indexTimeSlot).isEmpty()) {
				for (int indexArGene = 0; indexArGene < cromossomoHash.get(indexTimeSlot).size(); indexArGene++) {
					for (int indexArrEst = 0; indexArrEst < cromossomoHash.get(indexTimeSlot).get(indexArGene)
							.getAlunos().size(); indexArrEst++) {
						;
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
	public int geraIndexProfessor(int indexTimeSlot) {
		// IMPLEMENTAR AS HARD CONSTRAINTS
		int indexProfessorGerado;
		boolean val = false;
		do {
			indexProfessorGerado = aleatorio.nextInt(Arquivo.professoresEMC.size());
			if (cromossomoHash.get(indexTimeSlot) != null) {
				for (int indexArGene = 0; indexArGene < cromossomoHash.get(indexTimeSlot).size(); indexArGene++) {
						if (cromossomoHash.get(indexTimeSlot).get(indexArGene).getProfessor()
								.getCodigo() == Arquivo.professoresEMC.get(indexProfessorGerado).getCodigo()){
							val=true;
						}else{
							val=false;
						}
				}
//RESOLVER AMANHA HARDS CONTRAINTS =  PROFESSOR- HORARIOS INDISPONIVEIS
//				for (int i = 0; i <Arquivo.professoresEMC.get(indexProfessorGerado).getHorariosIndisponiveis().size(); i++) {
//					if(Arquivo.professoresEMC.get(indexProfessorGerado).getHorariosIndisponiveis().get(i)
//							.getCodigo() == indexTimeSlot){
//	                        val = true;
//					}
//				}
			} 
		} while (val);
		return indexProfessorGerado;
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
		// IMPLEMENTAR AS HARD CONSTRAINTS
		return aleatorio.nextInt(Arquivo.listaTimeSlots.size());
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
	public int geraIndexSala(int indexTimeslot) {
		// IMPLEMENTAR AS HARD CONSTRAINTS
		int indexSalaGerada;
		boolean valida = false;
		
		
		do{
			indexSalaGerada = aleatorio.nextInt(Arquivo.salasEMC.size());
			if(cromossomoHash.get(indexTimeslot) != null){
				for (int indexArGene = 0; indexArGene < cromossomoHash.get(indexTimeslot).size(); indexArGene++) {
					if(cromossomoHash.get(indexTimeslot).get(indexArGene).getSala().getCodigo() == Arquivo.salasEMC.get(indexSalaGerada).getCodigo()){
						valida= true;
					}else{
					
						valida =false;
					}
				}
			}
			return indexSalaGerada;
		}while(valida);
		
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
	public int geraIndexCurso() {
		// IMPLEMENTAR AS HARD CONSTRAINTS
		return aleatorio.nextInt(Arquivo.cursosEMC.size());
	}
}
