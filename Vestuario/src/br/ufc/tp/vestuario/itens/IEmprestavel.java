package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.BancoEmprestados;
import br.ufc.tp.vestuario.excecoes.JaEmprestadoException;
import br.ufc.tp.vestuario.excecoes.NaoEmprestadoException;

public interface IEmprestavel {
	public Boolean isEmprestado();
	
	public GregorianCalendar getDataEmprestimo();
	
	public GregorianCalendar getDataDevolucao();
    
	public boolean registrarEmprestimo(BancoEmprestados Emprestados, GregorianCalendar Deadline) throws JaEmprestadoException;
	
	public boolean registrarEmprestimo(BancoEmprestados Emprestados, int qtdDiad) throws JaEmprestadoException;
	
	public int qtdDiasEmprestado() throws NaoEmprestadoException;
	
	public int diasParadevolucao() throws NaoEmprestadoException;
	
	public boolean registrarDevolucao(BancoEmprestados Emprestados) throws NaoEmprestadoException;
}
