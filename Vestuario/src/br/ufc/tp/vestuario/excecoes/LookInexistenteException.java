package br.ufc.tp.vestuario.excecoes;

public class LookInexistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LookInexistenteException() {
		super("Esse look não existe");
		}

}
