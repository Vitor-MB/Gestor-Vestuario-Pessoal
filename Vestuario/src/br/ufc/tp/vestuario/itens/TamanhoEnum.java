package br.ufc.tp.vestuario.itens;

public enum TamanhoEnum {
	PP("PP"),
	P("P"),
	M("M"),
	G("G"), 
	GG("GG");
	
	private String tamanho;
	
	TamanhoEnum(String tamanho){
		this.tamanho = tamanho;
	}
	
	public String getTamanho() {
		return this.tamanho;
	}
	
}
