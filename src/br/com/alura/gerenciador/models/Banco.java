package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Asus");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("AMD");
		
		Usuario u1 = new Usuario();
		u1.setLogin("denis");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("paty");
		u2.setSenha("1234");

		listaEmpresas.addAll(Arrays.asList(empresa, empresa2));
		listaUsuarios.addAll(Arrays.asList(u1, u2));
		
	}
	
	public List<Usuario> getListaUsuarios() {
		return Banco.listaUsuarios;
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
