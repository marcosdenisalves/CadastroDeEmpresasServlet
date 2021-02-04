<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.models.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>
	<div>
		<c:if test="${not empty empresa}">
			A empresa ${ empresa } foi cadastrada com sucesso!
			<br /> 
		</c:if>
	</div>
		Lista de empresas:
	<br />
	<div>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${ empresa.nome } - <fmt:formatDate
						value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
					<a href="/gerenciador/entrada?acao=exibirEmpresas&id=${ empresa.id }">editar</a>
					<a href="/gerenciador/entrada?acao=removerEmpresas&id=${ empresa.id }">remover</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>