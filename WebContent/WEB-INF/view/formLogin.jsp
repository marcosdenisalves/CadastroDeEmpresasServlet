<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="entradaContext"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${entradaContext}" method="post">

		Nome: <input type="text" name="login"/>
		Senha: <input type="password" name="senha"/>

		<input type="hidden" name="acao" value="Login"/>
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>