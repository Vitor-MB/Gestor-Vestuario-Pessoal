package br.ufc.tp.vestuario.itens;

public enum MaterialEnum {
	OURO("Ouro"),
	PRATA("Prata"),
	DIAMANTE("Diamante"),
	RUBI("Rubi");
	
	private String code;
	
	MaterialEnum(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
