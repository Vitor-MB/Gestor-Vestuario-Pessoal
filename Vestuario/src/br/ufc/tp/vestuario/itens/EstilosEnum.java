package br.ufc.tp.vestuario.itens;

public enum EstilosEnum {
	CASUAL("CASUAL"),
	FORMAL("FORMAL"),
	ESPORTIVA("ESPORTIVA");
	
	private String estilo;
	
	EstilosEnum(String estilo){
		this.estilo = estilo;
	}
	
	public String getEstilo() {
		return estilo;
	}
}
