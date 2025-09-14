package br.ufc.tp.vestuario.excecoes;

public class NaoLavavelException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String ID;

	public NaoLavavelException(String ID) {
		super("Esse Item não é lavável");
		this.ID = ID;
	}
	
	public String ID() {
		return ID;
	}

}
