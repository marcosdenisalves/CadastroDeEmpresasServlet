package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Asus");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("AMD");
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}

	public List<Empresa> getListaEmpresas() {
		return Banco.listaEmpresas;
	}
	
	public Empresa findById(Integer id) {
		for (Empresa empresa : listaEmpresas)
			if (empresa.getId() == id) return empresa;
		
		return null;
	}

	public void remover(Integer id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) it.remove();
		}
	}
}
