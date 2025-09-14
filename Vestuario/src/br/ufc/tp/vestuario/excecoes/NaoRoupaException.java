package br.ufc.tp.vestuario.excecoes;

public class NaoRoupaException extends Exception {
	
	public NaoRoupaException() {
		super("Esse item não possui um Tamanho");
	}

}
