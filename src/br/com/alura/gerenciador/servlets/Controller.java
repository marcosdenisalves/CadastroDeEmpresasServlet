package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.EditarEmpresas;
import br.com.alura.gerenciador.acoes.ExibirEmpresas;
import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.NovasEmpresas;
import br.com.alura.gerenciador.acoes.RemoverEmpresas;

@WebServlet("/entrada")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String nome = null;

		if (paramAcao.equals("listarEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executar(request, response);
		}

		if (paramAcao.equals("removerEmpresas")) {
			RemoverEmpresas acao = new RemoverEmpresas();
			nome = acao.executar(request, response);
		}

		if (paramAcao.equals("exibirEmpresas")) {
			ExibirEmpresas acao = new ExibirEmpresas();
			nome = acao.executar(request, response);
		}

		if (paramAcao.equals("editarEmpresas")) {
			EditarEmpresas acao = new EditarEmpresas();
			nome = acao.executar(request, response);
		}

		if (paramAcao.equals("novasEmpresas")) {
			NovasEmpresas acao = new NovasEmpresas();
			nome = acao.executar(request, response);
		}
		
		String[] split = nome.split(":");
		if (split[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(split[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(split[1]);
		}
	}
}
