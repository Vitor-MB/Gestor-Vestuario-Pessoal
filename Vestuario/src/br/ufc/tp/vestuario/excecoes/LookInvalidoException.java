package br.ufc.tp.vestuario.excecoes;

public class LookInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String ID;
	
	public LookInvalidoException(String ID) {
		super(ID + "está inválido\nVocê deve preencher: SupInterno, Inferior, Calçado e Nome do Look");
		this.ID = ID;
	}
	
	public String getId() {
		return ID;
	}

}
