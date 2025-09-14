package br.ufc.tp.vestuario.itens;

public enum AcessoriosEnum {
	//CABEÇA
	PULSEIRA("BRAÇO"),
	BRACELETE("BRAÇO"),
	ANEL("BRAÇO"),
	RELÓGIO("BRAÇO"),
	BRINCO("CABEÇA"),
	OCULOS("CABEÇA"),
	BONÉ("CABEÇA"),
	COLAR("PESCOÇO");
	
	private String ParteCorpo;
	
	AcessoriosEnum(String ParteCorpo){
		this.ParteCorpo = ParteCorpo;
	}
	
	public String getParteCorpo() {
		return ParteCorpo;
	}
}
