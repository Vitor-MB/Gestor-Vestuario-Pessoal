package br.ufc.tp.vestuario.itens;


public enum ConservacaoEnum {
	RUIM("RUIM"),
	REGULAR("REGULAR"),
	BOA("BOA"),
	EXCELENTE("EXCELENTE");
	
	private String code;
	
	ConservacaoEnum(String code){
		this.code = code;
	}
	
	public String getString() {
		return code;
	}
}
