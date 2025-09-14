package br.ufc.tp.vestuario;

import br.ufc.tp.vestuario.excecoes.JaEmprestadoException;
import br.ufc.tp.vestuario.excecoes.NaoEmprestadoException;
import br.ufc.tp.vestuario.itens.IEmprestavel;
import br.ufc.tp.vestuario.itens.Item;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BancoEmprestados {
	
	private List<IEmprestavel> Emprestados;
	private static BancoEmprestados instancia;


	public BancoEmprestados() {
		Emprestados = new ArrayList<IEmprestavel>();
	}
	
	public static BancoEmprestados getInstancia() {
        if (instancia == null) {
            instancia = new BancoEmprestados();
        }
        return instancia;
    }
	
	public boolean adicionar(Item i) throws JaEmprestadoException {
		IEmprestavel e = (IEmprestavel) i;
		
		if(Emprestados.contains(e)) {
			throw new JaEmprestadoException(i.getID());
		}
		else {
			Emprestados.add(e);
			System.out.println(i.getID() + " registrado no Banco de Emprestimos");
			return true;
		}
	}
	
	public boolean remover(Item i) throws NaoEmprestadoException {
		IEmprestavel e = (IEmprestavel) i;
		if(Emprestados.contains(e)) {
			System.out.println(i.getID() +  " removido do Banco de Emprestimos!");
			Emprestados.remove(e);
			return true;
		}else {
			throw new NaoEmprestadoException(i.getID());
		}
	}	
	
	public void ListarEmprestados() throws NaoEmprestadoException {
		 if (Emprestados.isEmpty()) {
		        throw new NaoEmprestadoException("");
		    }
		 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\nLista de Itens Emprestados:");
		for(IEmprestavel e : Emprestados) {
			Item i = (Item) e;
				System.out.println(i.getID() + " (Emprestado em: " + formato.format(e.getDataEmprestimo().getTime()) + " - Data de devolução: " + formato.format(e.getDataDevolucao().getTime()) + ") " + e.diasParadevolucao() + " Dias para a devolução");
			}
		System.out.println();
		}
	
}

