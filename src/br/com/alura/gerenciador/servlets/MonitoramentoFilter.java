package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");

		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo de execução: " + acao + " " + (depois - antes) + " ms");
	}
}
