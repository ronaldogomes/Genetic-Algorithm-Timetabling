package testes;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import emc.Curso;
import emc.Disciplina;
import emc.Estudante;
import emc.Sala;
import emc.TimeSlots;
import genetic.Gene;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Disciplina> disc=new ArrayList<Disciplina>();
		disc.add(new Disciplina(01, 01, "Desc", 64, 0, 0, 0));
		Estudante aluno = new Estudante(01, "Chaib", disc);
		
		
		
		
		
		String nome = "/home/ronaldo/workspace/Genetic-Algorithm-Timetabling/files/ag-informacoes.csv";
		Arquivo arquivo = new Arquivo();
		ArrayList<String> linhaPorLinha = arquivo.lerArquivo(nome);
		for (int i = 0; i < linhaPorLinha.size(); i++) {
			//System.out.println(linhaPorLinha.get(i));
		}
		ArrayList<TimeSlots> timeSlots = arquivo.informacoesAg(linhaPorLinha);
		for (int i = 0; i < timeSlots.size(); i++) {
			//System.out.println("Codigo TimeSlot: "+timeSlots.get(i).getCodigo()+"|  codigoDiaSemana :"+timeSlots.get(i).getCodDiaSemana());

		}
	}

}
