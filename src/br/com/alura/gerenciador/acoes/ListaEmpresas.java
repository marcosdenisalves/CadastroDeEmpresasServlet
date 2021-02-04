package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.models.Banco;

public class ListaEmpresas {

	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		
		request.setAttribute("empresas", banco.getListaEmpresas());
		
		return "forward:listarEmpresas.jsp";
	}
}
