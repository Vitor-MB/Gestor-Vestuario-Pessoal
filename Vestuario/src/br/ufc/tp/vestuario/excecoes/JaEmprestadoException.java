package br.ufc.tp.vestuario.excecoes;

public class JaEmprestadoException extends Exception {

	private static final long serialVersionUID = 1L;
	private String ID;
    public JaEmprestadoException(String ID) {
        super("Item '" + ID + "' já está emprestado.");
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }

}
