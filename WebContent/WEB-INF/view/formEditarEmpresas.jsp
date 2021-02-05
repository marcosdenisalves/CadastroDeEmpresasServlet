<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="editarEmpresaCtx"/>
<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" var="dataFormatada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${editarEmpresaCtx}" method="post">
		Nome: <input type="text" name="nome" value="${ empresa.nome }"/>
		Data Abertura: <input type="text" name="data" value="${ dataFormatada }"/>
		<input type="hidden" name="id" value="${ empresa.id }"/>
		<input type="hidden" name="acao" value="EditarEmpresas"/>		
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>