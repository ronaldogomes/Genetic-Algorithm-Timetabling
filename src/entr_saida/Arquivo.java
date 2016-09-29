package entr_saida;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Professor;
import emc.Sala;
import emc.TimeSlots;
import emc.TipoSala;
import genetic.Gene;

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

	public void informacoesAg(ArrayList<String> entr,
			ArrayList<Curso> cursosEMC, ArrayList<Disciplina> DisciplinasEMC,
			ArrayList<Estudante> alunosEMC,
			ArrayList<Professor> professoresEMC, ArrayList<Sala> salasEMC,
			ArrayList<TimeSlots> listaTimeSlots, ArrayList<TipoSala> tipoSalaEMC) {
		for (int i = 0; i < entr.size(); i++) {
			if (!(entr.get(i).matches("//\\w{0,}|//d{0,}"))) {
				switch (entr.get(i)) {
				case "TIMESLOT":
					do {
						if (entr.get(i)
								.matches(
										"\\d{1,3}\\s{0,},\\s{0,}\\d\\s{0,},\\s{0,}\\d{1,2}\\s{0,}:\\s{0,}\\d{1,2},\\d{1,2}:\\d{1,2}")) {
							Integer codigo = Integer.parseInt(entr.get(i)
									.split(",")[0]);
							Integer codDiaSemana = Integer.parseInt(entr.get(i)
									.split(",")[1]);
							String horaIncioFim = entr.get(i).split(",")[2]
									+ "," + entr.get(i).split(",")[2];
							listaTimeSlots.add(new TimeSlots(codigo,
									codDiaSemana, horaIncioFim));// ARRAY DE
																	// OBJETOS
																	// TIMESLOT
																	// CRIADO
						}
						//
						i++;
					} while (!entr.get(i).matches("CURSO"));
				case "CURSO":
					do {
						if (entr.get(i)
								.matches(
										"\\d\\s{0,},\\s{0,}[\\W|\\w]{1,}\\s{0,},\\s{0,}\\d{1,2}\\s{0,},\\s{0,}\\d")) {
							int codigo = Integer.parseInt(entr.get(i)
									.split(",")[0]);
							String nome = entr.get(i).split(",")[1];
							int numPeriodo = Integer.parseInt(entr.get(i)
									.split(",")[2].trim());
							int turno = Integer
									.parseInt(entr.get(i).split(",")[3].trim());

							cursosEMC.add(new Curso(codigo, nome, numPeriodo,
									turno));
							//
						}
						//
						i++;
					} while (!entr.get(i).matches("TIPO DE SALA"));
				case "TIPO DE SALA":
					do {
						if (entr.get(i).matches(
								"\\d\\s{0,},\\s{0,}[\\w|\\W]{0,}\\s{0,}")) {
							tipoSalaEMC.add(new TipoSala(Integer.parseInt(entr
									.get(i).split(",")[0]), entr.get(i).split(
									",")[1]));
						}
						//
						i++;
					} while (!entr.get(i).matches("SALA"));
				case "SALA":
					do {
						if (entr.get(i)
								.matches(
										"\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}")) {
							int codigo = Integer.parseInt(entr.get(i)
									.split(",")[0]);
							String descricao = entr.get(i).split(",")[1].trim();
							TipoSala tipoSala = tipoSalaEMC
									.get(Integer.parseInt(entr.get(i)
											.split(",")[2].trim()) - 1);
							int capacidade = Integer.parseInt(entr.get(i)
									.split(",")[3].trim());
							salasEMC.add(new Sala(codigo, descricao, tipoSala,
									capacidade));

						}
						//
						i++;
					} while (!entr.get(i).matches("DISCIPLINA"));
				case "DISCIPLINA":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\W|\\w|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,}")) {

							int codigo = Integer.parseInt(entr.get(i)
									.split(",")[0].trim());
							int codigoCurso = Integer.parseInt(entr.get(i)
									.split(",")[1].trim());
							int codigoPeriodo = Integer.parseInt(entr.get(i)
									.split(",")[2].trim());
							String descricao = entr.get(i).split(",")[3].trim();
							int cargaHorariaTeorica = Integer.parseInt(entr
									.get(i).split(",")[4].trim());
							int tipoSalaTeoria = Integer.parseInt(entr.get(i)
									.split(",")[5].trim());
							int cargaHorariaPratica = Integer.parseInt(entr
									.get(i).split(",")[6].trim());
							int tipoSalaPratica = Integer.parseInt(entr.get(i)
									.split(",")[7].trim());

							DisciplinasEMC.add(new Disciplina(codigo,
									codigoCurso, codigoPeriodo, descricao,
									cargaHorariaTeorica, tipoSalaTeoria,
									cargaHorariaPratica, tipoSalaPratica));
							// CRIAR ARRAY DE OBJETOS DISCIPLINA
						}
						//
						i++;
					} while (!entr.get(i).matches("ESTUDANTE"));
				case "ESTUDANTE":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							// CRIAR ARRAY DE OBJETOS ESTUDANTE
						}
						//
						i++;
					} while (!entr.get(i).matches("PROFESSOR"));
				case "PROFESSOR":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							// CRIAR ARRAY DE OBJETOS PROFESSOR
						}
						//
						i++;
					} while (i < entr.size());
				}

			}
		}
	}
}
