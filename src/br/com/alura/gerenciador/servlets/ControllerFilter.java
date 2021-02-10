package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;

public class ControllerFilter implements Filter {
	
	private static String pacote = "br.com.alura.gerenciador.acoes.";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	@SuppressWarnings("rawtypes")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
