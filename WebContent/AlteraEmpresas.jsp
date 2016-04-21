<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="css/Style_Cadastro de Empresas.css" />
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
				<h3 id="titulo">Alterar Empresa</h3>
			</div>
			<div id="conteudo">
				<div id="inconteudo">
					<img id="hotel" src="Imagens/Empresa.png" />
					<form action="ServletEmpresa"
						onsubmit="return valida_pesquisa(this)" method="post">
						<b>Empresa:</b> <select id="empresa" name="empresa">
							<c:forEach items="${empresas}" var="empresa">
								<option value="${empresa.getNome()}">${empresa.getNome()}</option>
							</c:forEach>
						</select>
						<button type="submit">Pesquisar</button>
						<input type="text" id="method" name="operacao" value="pesquisar"
							style="visibility: hidden;" />
					</form>
					<form action="ServletEmpresa"
						onsubmit="return valida_alteracao(this)" method="post" name="Alterar">
						<input style="visibility: hidden;" name="empresaAlterada"
							type="text" value="${empresa}"><br /> <b>Empresa: </b>${empresa}
						<br /> <b>Rota:</b> <select id="rotas" name="rotaAlterada">
							<c:forEach items="${rotas}" var="rota">
								<option value="${rota.getRota()}">${rota.getRota()}</option>
							</c:forEach>
						</select> <br /> <b>Preço: R$</b> <input id="valorrota" type="text"
							name="valorAlterado" /> <br />
						<button type="submit">Alterar</button>
						<input type="text" id="method" name="operacao" value="editar"
							style="visibility: hidden;" />
					</form>
					<script type="text/javascript">
						function valida_pesquisa() {
							if (document.getElementById("empresa").value == "") {
								alert('Por favor, preencha o campo empresa');
								document.getElementById("empresa").focus();
								return false
							}
						}
						function valida_alteracao() {
							var digits = "0123456789"
							var stars = "12345"
							var temp
							var ok = true;
							for (var i = 0; i < Alterar.valorAlterado.value.length; i++) {
								temp = Alterar.valorAlterado.value
										.substring(i, i + 1)

								if (digits.indexOf(temp) == -1) {
									alert("O campo quartos deve ser preenchido apenas com números!")
									Alterar.valorAlterado.focus();
									ok = false;
									return (false);
									break;
								}

							}
							if (document.getElementById("empresa").value == "") {
								alert('Por favor, preencha o campo empresa');
								document.getElementById("empresa").focus();
								return false
							}
							if (document.getElementById("rota").value == "") {
								alert('Por favor, preencha o campo rota');
								document.getElementById("rota").focus();
								return false
							}
							if (document.getElementById("valorrota").value == "") {
								alert('Por favor, preencha o campo valor');
								document.getElementById("valorrota").focus();
								return false
							}
						}
					</script>
				</div>
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