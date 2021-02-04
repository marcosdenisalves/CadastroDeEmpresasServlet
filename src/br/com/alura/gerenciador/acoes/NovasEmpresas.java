package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.models.Banco;
import br.com.alura.gerenciador.models.Empresa;

public class NovasEmpresas {
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Empresa empresa = new Empresa();
			Banco banco = new Banco();
			
			empresa.setNome(request.getParameter("nome"));
			request.setAttribute("empresa", empresa.getNome());
			sdf.parse(request.getParameter("data"));
			banco.adicionar(empresa);

			return "redirect:entrada?acao=listarEmpresas";

		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}
}
