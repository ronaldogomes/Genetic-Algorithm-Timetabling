package emc;

import java.util.ArrayList;

public class TipoSala {
	private int codigo;
	private String descricao;
	
	
	
	public TipoSala(int codigo, String descricao){
		this.codigo=codigo;
		this.descricao=descricao;
		
	}
	/**
	 * 
	 * @param tipoSalas
	 * @param codigoTipoSala
	 * @return
	 * <h2>Descrição</h2>
 	 * <p>Retorna qual tipoSala tem aquele codigo (codigoTipoSala) de uma array list de timeSlots</p>
	 * <p>caso o codigo não pertença a nenhum tipoSala do array passado por parametro então retorna null</p>
	 */
	
	public static TipoSala qualTipoSala(ArrayList<TipoSala> tipoSalas, int codigoTipoSala){
		for (int i = 0; i < tipoSalas.size(); i++) {
			if (tipoSalas.get(i).getCodigo()==codigoTipoSala) {
				return tipoSalas.get(i);
			}
		}
		return null;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
