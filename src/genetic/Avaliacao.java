package genetic;

import emc.*;
import entr_saida.Arquivo;

public class Avaliacao {// mudar nome para mais adequado

	public static boolean isCromossomoValido(Cromossomo cromossomo) {
		boolean isProfValido = true;
		for (int i = 0; i < 169; i++) {
			// se um timeslot é invalido
			if (cromossomo.getCromossomoHash().get(i) != null) {
				if (!Cromossomo.validaTS(i)) {
					System.out.println(cromossomo.getCromossomoHash().get(i)+"timeslot "+i+" inválido "+Arquivo.listaTimeSlots.get(i).getCodigo());
					return false;
				}

				for (int j = 0; j < cromossomo.getCromossomoHash().get(i).size(); j++) {
					for (int j2 = j + 1; j2 < cromossomo.getCromossomoHash().get(i).size() - 1; j2++) {
						// se a choque de horario do professor
						if (cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getCodigo() == cromossomo
								.getCromossomoHash().get(i).get(j2).getProfessor().getCodigo()) {
							System.out.println("Choque de horario do professor "+cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getNome()+" neste timeslot "+i);
							return false;
						}
					}

					for (int k = 0; k < cromossomo.getCromossomoHash().get(i).get(j).getProfessor()
							.getDisciplinasMinistrar().size(); k++) {
						if (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigo() == cromossomo
								.getCromossomoHash().get(i).get(j).getProfessor().getDisciplinasMinistrar().get(k)
								.getCodigo()) {
							break;
						} else if (k == cromossomo.getCromossomoHash().get(i).get(j).getProfessor()
								.getDisciplinasMinistrar().size() - 1) {
							System.out.println("O professor "
									+ cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getNome()
									+ " não ministra a disciplina"
									+ cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getDescricao());
							return false;
						}
					}
					if (cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getListaTSIndFixa() != null) {
						for (int j2 = 0; j2 < cromossomo.getCromossomoHash().get(i).get(j).getProfessor()
								.getListaTSIndFixa().size(); j2++) {
							if (cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getListaTSIndFixa().get(j2)
									.getCodigo() == i) {
								System.out.println("Professor: "
										+ cromossomo.getCromossomoHash().get(i).get(j).getProfessor().getNome()
										+ " não está disponivel para faculdade no timeslot : "
										+ i);
								return false;
							}
						}
					}

				}
			}
		}
		return true;
	}

}
