<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Style_Passagem.css" />
<link rel="shortcut icon" type="image/x-icon" href="Imagens/Icon.ico" />
<title>Travel Control</title>
<script type="text/javascript">
	function valida_form() {
		var digits = "0123456789"
		var stars = "12345"
		var temp
		var ok = true;
		for (var i = 0; i < Comprar.dias.value.length; i++) {
			temp = Comprar.dias.value.substring(i, i + 1)

			if (digits.indexOf(temp) == -1) {
				alert("O campo quartos deve ser preenchido apenas com números!")
				Comprar.dias.focus();
				ok = false;
				return (false);
				break;
			}

		}
		if (document.getElementById("empresas").value == "") {
			alert('Por favor, preencha o campo empresa');
			document.getElementById("empresas").focus();
			return false
		}
		if (document.getElementById("dias").value == "") {
			alert('Por favor, preencha o campo dias');
			document.getElementById("dias").focus();
			return false
		}
	}
</script>
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
				<ul>
					<li><h3 id="titulo">Viagem</h3></li>
				</ul>
			</div>
			<div id="conteudo">
				<img id="viagem" style="float: left;" width="250" height="165"
					src="Imagens/Viagem.png" />
				<form id="Comprar" method="post" action="ServletViagem" onsubmit="return valida_form(this)"name="Comprar">
					<ul>
						<li><b>Empresa que disponibiliza a viagem:</b> <select
							id="empresas" name="empresa">
								<c:forEach items="${empresas}" var="empresa">
									<option value="${empresa.getNome()}">${empresa.getNome()}</option>
								</c:forEach>
						</select></li>
						<li><b>Dias: </b><input type="text" id="dias" name="dias" />
						</li>
						<li><input type="text" id="method" name="operacao"
							value="cadastrar" style="visibility: hidden;" /></li>
						<li><button style="float: center;" type="submit"
								id="pesquisar">Cadastrar</button></li>
					</ul>
				</form>
				<br />
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