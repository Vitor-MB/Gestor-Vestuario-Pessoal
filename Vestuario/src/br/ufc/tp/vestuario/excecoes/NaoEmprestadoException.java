package br.ufc.tp.vestuario.excecoes;

public class NaoEmprestadoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String ID;

	public NaoEmprestadoException(String ID) {
		super("O Item não está emprestado");
		this.ID = ID;
	}
	
	public String getID() {
		return this.ID;
	}

}
