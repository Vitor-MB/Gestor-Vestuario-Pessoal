package br.ufc.tp.vestuario;

import java.util.List;

import br.ufc.tp.vestuario.excecoes.LookExistenteException;
import br.ufc.tp.vestuario.excecoes.LookInexistenteException;
import br.ufc.tp.vestuario.excecoes.LookInvalidoException;

import java.util.ArrayList;

public class BancoLooks {
	
	private List<Look> Looks;
	
	private static BancoLooks instancia;
	
	public BancoLooks() {
		Looks = new ArrayList<Look>();
	}
	
	public static BancoLooks getInstancia() {
        if (instancia == null) {
            instancia = new BancoLooks();
        }
        return instancia;
    }
	
	public List<Look> getLooks(){
		return Looks;
	}
	
	public void salvar(Look l) throws LookInvalidoException, LookExistenteException {
		if(l.isLookValido()) {
			if(!Looks.contains(l)) {
				System.out.println("Look salvo");
				Looks.add(l);		
			}else {
				throw new LookExistenteException(l.getID());
			}
		}else{
			throw new LookInvalidoException(l.getID());
		}
	}
	
	public void deletar(Look l) throws LookInexistenteException {
		if(Looks.contains(l)) {
			Looks.remove(l);
			System.out.println("Look removido!");
			
		}else {
			throw new LookInexistenteException();
		}
	}
	
	public void deletar(String id) throws LookInexistenteException {
		Look l = getLook(id);
		if(Looks.contains(l)) {
			Looks.remove(l);
			System.out.println("Look removido!");
			
		}else {
			throw new LookInexistenteException();
		}
	}
	
	public Look getLook(String id) throws LookInexistenteException {
	    for (Look l : Looks) {
	        if (l.getID().equals(id)) {
	            return l;
	        }
	    }
	    throw new LookInexistenteException();
	}

}
