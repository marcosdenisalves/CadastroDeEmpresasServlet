<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="novaEmpresaCtx"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="template.jsp"/>
	<form action="${novaEmpresaCtx}" method="post">
		Nome: <input type="text" name="nome"/>
		Data Abertura: <input type="text" name="data"/>
		<input type="hidden" name="acao" value="NovasEmpresas"/>
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>