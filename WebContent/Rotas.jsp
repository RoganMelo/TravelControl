<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Style_Rotas.css" />
<link rel="shortcut icon" type="image/x-icon" href="Imagens/Icon.ico" />
<title>Travel Control</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<img style="float: left;" width="274" height="149"
				src="Imagens/Picture1.png" />
			<div>
				<form style="float: right;" action="ServletUsuario" method="post">
					<ul>
						<li><button type="submit">Sair</button></li>
						<li><input type="text" id="method" name="operacao"
							value="sair" style="visibility: hidden;" /></li>
					</ul>
				</form>
			</div>
		</div>
		<div id="menu">
			<div id="inmenu">
				<ul>
					<li><a href="Home2.jsp">Home</a></li>
					<li><a href="Hoteis.jsp">Hotéis</a></li>
					<li><a href="Cidades.jsp">Cidades</a></li>
					<li><a href="ServletRota">Rotas</a></li>
					<li><a href="Empresas.jsp">Empresas</a></li>
					<li><a href="ServletViagem">Viagem</a></li>
					<li><a href="ServletPesquisa">Pesquisa</a></li>
				</ul>
			</div>
		</div>
		<div id="principal">
			<div id="cabecalho">
				<h3 id="titulo">Rota</h3>
			</div>
			<div id="conteudo">
				<img id="hotel" src="Imagens/Rota.png" />
				<form action="ServletRota" onsubmit="return valida_form(this)"
					method="post">
					<b>Origem:</b> <select id="origem" name="origem">
						<c:forEach items="${cidades}" var="cidade">
							<option value="${cidade.getNome()}">${cidade.getNome()}</option>
						</c:forEach>
					</select> <br /> <br /> <b>Destino:</b> <select id="destino" name="destino">
						<c:forEach items="${cidades}" var="cidade">
							<option value="${cidade.getNome()}">${cidade.getNome()}</option>
						</c:forEach>
					</select> <br /> <br />
					<button type="submit">Cadastrar</button>
					<input type="text" id="method" name="operacao" value="cadastrar"
						style="visibility: hidden;" />
				</form>
				<script type="text/javascript">
					function valida_form() {
						if (document.getElementById("origem").value == "") {
							alert('Por favor, preencha o campo origem');
							document.getElementById("origem").focus();
							return false
						} else if (document.getElementById("destino").value == "") {
							alert('Por favor, preencha o campo destino');
							document.getElementById("destino").focus();
							return false
						} else {
							alert('Cadastro de rota feito com sucesso!');
						}
					}
				</script>
			</div>
		</div>
		<div id="clear"></div>
		<div id="antesrodape">
			<img width="171" height="190" src="Imagens/Mascote.png" />
		</div>
		<div id="rodape">
			<div id="inrodape">
				<ul>
					<li><a href="PossoAjudar.jsp">Posso Ajudar?</a></li>
					<li><a href="Duvidas.jsp">Dúvidas</a></li>
					<li><a href="Facebook.jsp">Facebook</a></li>
					<li><a href="Email.jsp">E-mail</a></li>
					<li><a href="Telefone.jsp">Telefone</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>