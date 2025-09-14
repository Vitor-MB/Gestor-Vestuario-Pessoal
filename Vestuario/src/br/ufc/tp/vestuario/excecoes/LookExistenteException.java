package br.ufc.tp.vestuario.excecoes;

public class LookExistenteException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public LookExistenteException(String ID) {
		super("Esse look já existe: " + ID);
	}

}
