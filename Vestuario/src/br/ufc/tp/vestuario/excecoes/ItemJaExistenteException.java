package br.ufc.tp.vestuario.excecoes;

public class ItemJaExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ItemJaExistenteException() {
		super("Item já existente");
	}

}
