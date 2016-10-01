package entr_saida;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;
import genetic.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class Arquivo {
	/**
	 * 
	 * @param nome
	 *            String path do arquivo
	 * @return ArrayList<String> com as linhas do arquivo
	 */
	public ArrayList<String> lerArquivo(String nome) {
		ArrayList<String> retorno = new ArrayList<String>();
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			retorno.add(linha.trim());
			while ((linha = lerArq.readLine()) != null) {
				retorno.add(linha.trim());
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		System.out.println();
		return retorno;
	}
	/**
	 * 
	 * @param infgormEntrArq	-ArrayList com conteudo do arquivo ag-informacoes.csv
	 * @param cursosEMC			-ArrayList a ser carregado com os cursos descrito no ag-informacoes.csv				
	 * @param DisciplinasEMC	-ArrayList a ser carregado com as disciplinas descrito no ag-informacoes.csv	
	 * @param alunosEMC			-ArrayList a ser carregado com os alunos descrito no ag-informacoes.csv	
	 * @param professoresEMC	-ArrayList a ser carregado com os professores descrito no ag-informacoes.csv	
	 * @param salasEMC			-ArrayList a ser carregado com as salas descrito no ag-informacoes.csv	
	 * @param listaTimeSlots	-ArrayList a ser carregado com os timeslots descrito no ag-informacoes.csv	
	 * @param tipoSalaEMC		-ArrayList a ser carregado com os tipos de sala descrito no ag-informacoes.csv	
	 * <h2>Descrição</h2>
	 * <p>Este metodo recebe o arquivo em forma de ArrayList e carrega os objetos nos ArrayLists tambem passados
	 * por parâmetros. Ao final todos os objetos descritos no arquivo está em uma das arraylist que foi passado
	 * por parâmetro.</p>
	 * <h3>Usando o método</h3>
	 * <p>	1° carregue o arquivo ag-informacoes.csv em um ArrayList<String> através do método lerArquivo
	 * 		2°Crie os arraylists as ser passado por parametro<p/>
	 */
	public void informacoesAg(ArrayList<String> infgormEntrArq,
			ArrayList<Curso> cursosEMC, ArrayList<Disciplina> DisciplinasEMC,
			ArrayList<Estudante> alunosEMC,
			ArrayList<Professor> professoresEMC, ArrayList<Sala> salasEMC,
			ArrayList<TimeSlots> listaTimeSlots, ArrayList<TipoSala> tipoSalaEMC) {
		for (int i = 0; i < infgormEntrArq.size(); i++) {
			if (!(infgormEntrArq.get(i).matches("//\\w{0,}|//d{0,}"))) {
				switch (infgormEntrArq.get(i)) {
				case "TIMESLOT":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\d{1,3}\\s{0,},\\s{0,}\\d\\s{0,},\\s{0,}\\d{1,2}\\s{0,}:\\s{0,}\\d{1,2},\\d{1,2}:\\d{1,2}")) {
							Integer codigo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[0]);
							Integer codDiaSemana = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[1]);
							String horaIncioFim = infgormEntrArq.get(i).split(",")[2]
									+ "," + infgormEntrArq.get(i).split(",")[2];
							listaTimeSlots.add(new TimeSlots(codigo,
									codDiaSemana, horaIncioFim));// ARRAY DE
																	// OBJETOS
																	// TIMESLOT
																	// CRIADO
						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("CURSO"));
				case "CURSO":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\d\\s{0,},\\s{0,}[\\W|\\w]{1,}\\s{0,},\\s{0,}\\d{1,2}\\s{0,},\\s{0,}\\d")) {
							int codigo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[0]);
							String nome = infgormEntrArq.get(i).split(",")[1];
							int numPeriodo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[2].trim());
							int turno = Integer
									.parseInt(infgormEntrArq.get(i).split(",")[3].trim());

							cursosEMC.add(new Curso(codigo, nome, numPeriodo,
									turno));
							//
						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("TIPO DE SALA"));
				case "TIPO DE SALA":
					do {
						if (infgormEntrArq.get(i).matches(
								"\\d\\s{0,},\\s{0,}[\\w|\\W]{0,}\\s{0,}")) {
							tipoSalaEMC.add(new TipoSala(Integer.parseInt(infgormEntrArq
									.get(i).split(",")[0]), infgormEntrArq.get(i).split(
									",")[1]));
						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("SALA"));
				case "SALA":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}")) {
							int codigo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[0]);
							String descricao = infgormEntrArq.get(i).split(",")[1].trim();
							TipoSala tipoSala = tipoSalaEMC
									.get(Integer.parseInt(infgormEntrArq.get(i)
											.split(",")[2].trim()) - 1);
							int capacidade = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[3].trim());
							salasEMC.add(new Sala(codigo, descricao, tipoSala,
									capacidade));

						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("DISCIPLINA"));
				case "DISCIPLINA":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\W|\\w|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,}")) {

							int codigo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[0].trim());
							int codigoCurso = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[1].trim());
							int codigoPeriodo = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[2].trim());
							String descricao = infgormEntrArq.get(i).split(",")[3].trim();
							int cargaHorariaTeorica = Integer.parseInt(infgormEntrArq
									.get(i).split(",")[4].trim());
							int tipoSalaTeoria = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[5].trim());
							int cargaHorariaPratica = Integer.parseInt(infgormEntrArq
									.get(i).split(",")[6].trim());
							int tipoSalaPratica = Integer.parseInt(infgormEntrArq.get(i)
									.split(",")[7].trim());

							DisciplinasEMC.add(new Disciplina(codigo,
									codigoCurso, codigoPeriodo, descricao,
									cargaHorariaTeorica, tipoSalaTeoria,
									cargaHorariaPratica, tipoSalaPratica));
							// CRIAR ARRAY DE OBJETOS DISCIPLINA
						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("ESTUDANTE"));
				case "ESTUDANTE":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							int codigo = Integer.parseInt(infgormEntrArq.get(i).split(",")[0].trim());
							String nome = infgormEntrArq.get(i).split(",")[1].trim();
							ArrayList<Disciplina> disciplinasCursar = new ArrayList<Disciplina>();
							for (int j = 2; j < infgormEntrArq.get(i).split(",").length-1; j++) {
								disciplinasCursar.add(DisciplinasEMC.get(Integer.parseInt(infgormEntrArq.get(i).split(",")[j].trim())));
							}
							alunosEMC.add(new Estudante(codigo, nome, disciplinasCursar));
						}
						//
						i++;
					} while (!infgormEntrArq.get(i).matches("PROFESSOR"));
				case "PROFESSOR":
					do {
						if (infgormEntrArq.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							int codigo = Integer.parseInt(infgormEntrArq.get(i).split(",")[0].trim());
							String nome = infgormEntrArq.get(i).split(",")[1].trim();
							ArrayList<Disciplina> disciplinasMinistrar = new ArrayList<Disciplina>();
							for (int j = 2; j < infgormEntrArq.get(i).split(",").length-1; j++) {
								disciplinasMinistrar.add(DisciplinasEMC.get(Integer.parseInt(infgormEntrArq.get(i).split(",")[j].trim())));
							}
							professoresEMC.add(new Professor(codigo, nome, disciplinasMinistrar));
						}
						//
						i++;
					} while (i < infgormEntrArq.size());
				}

			}
		}
	}
}
