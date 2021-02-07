package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.models.Banco;
import br.com.alura.gerenciador.models.Usuario;

public class Login implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		HttpSession session = request.getSession();
		
		for (Usuario usuario : banco.getListaUsuarios()) {
			if (usuario.ehIgual(login, senha)) {
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:entrada?acao=ListarEmpresas";
			}
		}
		return "redirect:entrada?acao=LoginForm";
	}
}
