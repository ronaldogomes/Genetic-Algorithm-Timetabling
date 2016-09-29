package testes;

import emc.TimeSlots;
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

	public ArrayList<TimeSlots> informacoesAg(ArrayList<String> entr) {
		// RETORNANDO ArrayList<TimeSlots> APENAS PARA TESTE
		ArrayList<TimeSlots> timesSlots = new ArrayList<TimeSlots>();
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
							timesSlots.add(new TimeSlots(codigo, codDiaSemana,
									horaIncioFim));
						}
						//
						i++;
					} while (!entr.get(i).matches("CURSO"));
				case "CURSO":
					do {
						if (entr.get(i)
								.matches(
										"\\d\\s{0,},\\s{0,}[\\W|\\w]{1,}\\s{0,},\\s{0,}\\d{1,2}\\s{0,},\\s{0,}\\d")) {
							System.out.println(entr.get(i));
						}
						//
						i++;
					} while (!entr.get(i).matches("TIPO DE SALA"));
				case "TIPO DE SALA":
					do {
						if (entr.get(i).matches(
								"\\d\\s{0,},\\s{0,}[\\w|\\W]{0,}\\s{0,}")) {
							System.out.println(entr.get(i));
						}
						//
						i++;
					} while (!entr.get(i).matches("SALA"));
				case "SALA":
					do { 
						if (entr.get(i)
								.matches(
										"\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}")) {
							// System.out.println(entr.get(i));
						}
						//
						i++;
					} while (!entr.get(i).matches("DISCIPLINA"));
				case "DISCIPLINA":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\W|\\w|\\d]{1,}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,},\\s{0,}\\d{1,3}\\s{0,}")) {
							//System.out.println(entr.get(i));
						}
						//
						i++;
					} while (!entr.get(i).matches("ESTUDANTE"));
				case "ESTUDANTE":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							System.out.println(entr.get(i));
						}
						//
						i++;
					} while (!entr.get(i).matches("PROFESSOR"));
				case "PROFESSOR":
					do {
						if (entr.get(i)
								.matches(
										"\\s{0,}\\d{1,3}\\s{0,},\\s{0,}[\\w|\\W|\\d]{1,}\\s{0,},\\s{0,}[\\s{0,}\\d{1,3}\\s{0,}|,\\s{0,}]{0,}")) {
							//System.out.println(entr.get(i));
						}
						//
						i++;
					} while (i < entr.size());
				default:
					break;
				}

			}
		}
		return timesSlots;
	}
}
