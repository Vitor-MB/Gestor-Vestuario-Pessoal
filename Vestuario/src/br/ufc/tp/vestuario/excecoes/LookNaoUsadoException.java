package br.ufc.tp.vestuario.excecoes;

public class LookNaoUsadoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LookNaoUsadoException() {
		super("Look não usado nenhuma vez");
	}

}
