package br.ufc.tp.vestuario.excecoes;

public class PreenchimentoInvalidoExcption extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String campo;
	
	public PreenchimentoInvalidoExcption(String campo) {
		super(campo + " deve ser preenchido corretamente");
		this.campo = campo;
	}
	
	public String getCampo() {
		return campo;
	}
	
}
