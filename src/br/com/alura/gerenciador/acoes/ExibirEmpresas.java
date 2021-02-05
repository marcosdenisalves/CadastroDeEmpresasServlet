package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.models.Banco;
import br.com.alura.gerenciador.models.Empresa;

public class ExibirEmpresas implements Acao {
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa empresa = banco.findById(id);
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditarEmpresas.jsp";
	}
}
