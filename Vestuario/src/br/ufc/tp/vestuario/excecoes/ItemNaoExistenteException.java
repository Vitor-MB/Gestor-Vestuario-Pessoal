package br.ufc.tp.vestuario.excecoes;

public class ItemNaoExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ItemNaoExistenteException() {
		super("Item não existente");
	}

}
