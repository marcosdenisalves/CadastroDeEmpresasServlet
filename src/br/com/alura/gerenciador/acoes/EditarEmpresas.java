package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.models.Banco;
import br.com.alura.gerenciador.models.Empresa;

public class EditarEmpresas implements Acao {
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Banco banco = new Banco();

			Integer id = Integer.valueOf(request.getParameter("id"));
			Empresa empresaAtualizada = banco.findById(id);

			empresaAtualizada.setNome(request.getParameter("nome"));
			empresaAtualizada.setDataAbertura(sdf.parse(request.getParameter("data")));
			request.setAttribute("empresaAtualizada", empresaAtualizada);

			return "redirect:entrada?acao=ListarEmpresas";
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}
}
