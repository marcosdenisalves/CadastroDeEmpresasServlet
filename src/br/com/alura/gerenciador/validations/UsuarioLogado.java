package br.com.alura.gerenciador.validations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.models.Usuario;

public class UsuarioLogado {
	
	public static boolean acessoNegado (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String acao = request.getParameter("acao");
		Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");

		return !(usuario == null && !(acao.equals("LoginForm") || acao.equals("Login"))) ? false : true;
	}
}
