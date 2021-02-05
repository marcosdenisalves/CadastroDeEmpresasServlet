package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;

public class NovaEmpresaForm implements Acao {
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "forward:formNovasEmpresas.jsp";
	}
}
