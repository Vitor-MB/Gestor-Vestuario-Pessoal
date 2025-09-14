package br.ufc.tp.vestuario.excecoes;

public class NaoPossuiEstiloException extends Exception{
	
	public NaoPossuiEstiloException() {
		super("Esse item não possui a variável Estilo");
	}

}
