package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.models.Banco;

public class RemoverEmpresas implements Acao {
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco(); 
		banco.remover(Integer.valueOf(request.getParameter("id")));
		
		return "redirect:entrada?acao=ListarEmpresas";
	}
}
