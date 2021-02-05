package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;

@WebServlet("/entrada")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String pacote = "br.com.alura.gerenciador.acoes.";
	
	@SuppressWarnings("rawtypes")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nomeDaClasse = pacote + request.getParameter("acao");
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			String nome = acao.executar(request, response);
			
			String[] split = nome.split(":");
			if (split[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + split[1]);
				rd.forward(request, response);
			}else {
				response.sendRedirect(split[1]);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
