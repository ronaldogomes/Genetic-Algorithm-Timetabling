package entr_saida;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import genetic.Cromossomo;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class XLS {
	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputArquivo;


	public void setOutputFile(String inputArquivo) {
		this.inputArquivo = inputArquivo;
	}

	/**
	 * 
	 * @param cromossomo
	 */
	public void insere(Cromossomo cromossomo) {
		// Cria um novo arquivo
		File arquivo = new File(inputArquivo);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("pt", "BR"));
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(arquivo, wbSettings);
			workbook.createSheet("Jexcel", 0);
			WritableSheet excelSheet = workbook.getSheet(0);
			criaLabel(excelSheet);
			defineConteudo(excelSheet, cromossomo);
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Define um nome para a planilha
		catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Método responsável pela definição das labels
	private void criaLabel(WritableSheet sheet) throws WriteException {
		// Cria o tipo de fonte como TIMES e tamanho
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// Define o formato da célula
		times = new WritableCellFormat(times10pt);
		// Efetua a quebra automática das células
		times.setWrap(true);
		// Cria a fonte em negrito com underlines
		WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		// UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// Efetua a quebra automática das células
		timesBoldUnderline.setWrap(true);
		CellView cv = new CellView();
		cv.setFormat(times);// Bom pessoal, é isso ai, qualquer dúvida é só
							// avisar.
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);

		// peridos dos 3 cursos
		int a = 4;
		while (a < 28) {
			for (int i = a; i <= 11 + a; i++) {
				if (i > 35)
					break;
				addCaption(sheet, i, 3, i - (a - 1) + "° Periodo");
			}
			if (a > 11) {
				a += 9;
			} else {
				a += 11;
			}
			a++;
		}

		// horarios para cada dia da semana
		a = 4;
		int cont = 0;
		while (a < 85) {
			if (a < 85) {
				for (int i = a; i < 15 + a; i++) {
					addCaption(sheet, 3, i, (i + 3) - (cont * 15) + "");
				}
				cont++;
				a += 14;
				a++;
			}
		}
		// rotulo turnos
		int i = 4, c = 1, ds = 4;
		while (i < 85) {
			if (c == 1) {
				sheet.mergeCells(2, i, 2, i + 5);
				addCaption(sheet, 2, ds, "MATUTINO");
				i += 6;
				c++;
				ds += 6;
			}
			if (c == 2) {
				sheet.mergeCells(2, i, 2, i + 5);
				addCaption(sheet, 2, ds, "VESPERTINO");
				i += 6;
				c++;
				ds += 6;
			}
			if (c == 3) {
				sheet.mergeCells(2, i, 2, i + 2);
				addCaption(sheet, 2, ds, "NOTURNO");
				i += 3;
				c = 1;
				ds += 3;
			}
		}
		sheet.mergeCells(1, 4, 1, 18);
		addCaption(sheet, 1, 4, "SEGUNDA");

		sheet.mergeCells(1, 19, 1, 33);
		addCaption(sheet, 1, 19, "TERÇA");

		sheet.mergeCells(1, 34, 1, 48);
		addCaption(sheet, 1, 34, "QUARTA");

		sheet.mergeCells(1, 49, 1, 63);
		addCaption(sheet, 1, 49, "QUINTA");

		sheet.mergeCells(1, 64, 1, 78);
		addCaption(sheet, 1, 64, "SEXTA");

		sheet.mergeCells(1, 79, 1, 93);
		addCaption(sheet, 1, 79, "SABADO");

		sheet.mergeCells(4, 1, 15, 2);
		addCaption(sheet, 4, 1, "ENGENHARIA DE COMPUTAÇÃO");

		sheet.mergeCells(16, 1, 25, 2);
		addCaption(sheet, 16, 1, "ENGENHARIA ELÉTRICA");

		sheet.mergeCells(26, 1, 35, 2);
		addCaption(sheet, 26, 1, "ENGENHARIA MECÂNICA");
	}

	private void defineConteudo(WritableSheet sheet, Cromossomo cromossomo)
			throws WriteException, RowsExceededException {
		String sGene;

		int i = 0;
		int lin, col;
		do {
			if (cromossomo.getCromossomoHash().get(i) != null && Cromossomo.validaTS(i)) {
				for (int j = 0; j < cromossomo.getCromossomoHash().get(i).size(); j++) {
					switch ((i + 23) / 24) {
					case 2:
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									- 3);

							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									- 3);

							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3
									+ 12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									- 3);

							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3
									+ 22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					case 3:
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									+ 12);
							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									+ 12);
							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3
									+ 12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3) {
							lin = (Integer.parseInt(
									cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora().split(":")[0])
									+ 12);
							col = (cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo() + 3
									+ 22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					case 4:
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+27);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3);
							addCaption(sheet, col, lin, sGene);
						}

						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+26);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+27);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					case 5:
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1){
							lin= (Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+42);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3);
							addCaption(sheet, col, lin, sGene);
							}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+42);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+42);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					case 6:					
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+57);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3);
							addCaption(sheet, col, lin, sGene);
							}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2){
							lin= (Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+57);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3){
							lin= (Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+57);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					case 7:
						sGene = cromossomo.getCromossomoHash().get(i).get(j).toString();
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 1){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+73);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3);
							addCaption(sheet, col, lin, sGene);
						}

						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 2){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+73);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +12);
							addCaption(sheet, col, lin, sGene);
						}
						if (cromossomo.getCromossomoHash().get(i).get(j).getCurso().getCodigo() == 3){
							lin=(Integer.parseInt(cromossomo.getCromossomoHash().get(i).get(j).getTimeslots().getHora()
									.split(":")[0])+73);
							col=(cromossomo.getCromossomoHash().get(i).get(j).getDisciplina().getCodigPeriodo()
											+ 3 +22);
							addCaption(sheet, col, lin, sGene);
						}
						break;
					}
				}
			}
			i++;
		} while (i < 169);

	}
	private void addCaption(WritableSheet planilha, int coluna, int linha, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(coluna, linha, s, timesBoldUnderline);
		planilha.addCell(label);
	}

}