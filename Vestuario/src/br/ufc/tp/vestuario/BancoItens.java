package br.ufc.tp.vestuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.tp.vestuario.excecoes.ItemJaExistenteException;
import br.ufc.tp.vestuario.excecoes.ItemNaoExistenteException;
import br.ufc.tp.vestuario.itens.*;

public class BancoItens {
	
	private Map<String, Item> Itens;
	
	private static BancoItens instancia;
	
	public BancoItens() {
		Itens = new HashMap<String, Item>();
	}
	//Variavel global
	public static BancoItens getInstancia() {
        if (instancia == null) {
            instancia = new BancoItens();
        }
        return instancia;
    }
	
	public void CadastrarItem(Item i) throws ItemJaExistenteException {
		if(!Itens.containsKey(i.getID())) {
			Itens.put(i.getID(), i);
			System.out.println("Item adicionado com sucesso!");
			
		}else {
			throw new ItemJaExistenteException();
		}
	}
	
	public void RemoverItem(Item i) throws ItemNaoExistenteException {
		if(Itens.containsKey(i.getID())) {
			Itens.remove(i.getID());
			System.out.println("Item removido");
			
		}else {
			throw new ItemNaoExistenteException();
		}
	}
	
	public void RemoverItem(String Id) throws ItemNaoExistenteException {
		if(Itens.containsKey(Id)) {
			Itens.remove(Id);
			System.out.println("Item removido");
			
		}else {
			throw new ItemNaoExistenteException();
		}
	}
	
	public Item getItem(String Id) throws ItemNaoExistenteException {
		if(Itens.containsKey(Id)) {
			System.out.println("Item encontrado!");
			return Itens.get(Id);
		}else {
			throw new ItemNaoExistenteException();
		}
	
	}
	
	public Map<String, Item> getBancoItens(){
		return Itens;
	}
	
	public void ListarItens() {
		System.out.println("\nLista de Itens:");
		for(Item i : this.Itens.values()) {
			System.out.println("ID:\"" + i.getID() +"\"/ Conservação: "+ i.getConservacao()+" /Loja: " + i.getLoja()+" /Cor: " + i.getCor());
		}
		System.out.println();
	}
	
	//FILTROS PARA AS CLASSES
	
	public List<Item> getSupInternos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof SupInterno)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getSupExternos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof SupExterno)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getInferiores() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Inferior)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getCalcados() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Calcado)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> Intimos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Intimo)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getAcessorios() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Acessorio)  lista.add(i);
	    }
	    return lista;
	}
}
