package br.ufc.tp.vestuario.excecoes;

public class NaoEmprestavelException extends Exception{

	private static final long serialVersionUID = 1L;

	public NaoEmprestavelException() {
		super("Esse item não é emprestável!");
	}

}
