<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Style_Login.css" />
<link rel="shortcut icon" type="image/x-icon" href="Imagens/Icon.ico" />
<title>Travel Control</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<img width="274" height="149" src="Imagens/Picture1.png" />
		</div>
		<div id="menu">
			<div id="inmenu">
				<ul>
					<li><marquee width="813" behavior="alternate">
							<b>Faça o login para ter acesso ao conteúdo do site.</b>
						</marquee></li>
				</ul>
			</div>
		</div>
		<div id="principal">
			<div id="cabecalho">
				<h3 id="titulo">Login</h3>
			</div>
			<div id="conteudo">
				<div id="inconteudo">
					<img id="cadeado" src="Imagens/Cadeado.png" />
					<form action="ServletUsuario" onsubmit="return valida_form(this)"
						method="post">
						<b>Nome:</b><input id="nome" type="text" name="nome" /> <br /> <br />
						<b>Senha:</b><input id="senha" type="password" name="senha" /> <br />
						<br />
						<button type="submit" value="Enviar">Login</button>
						<input type="text" id="method" name="operacao" value="logar"
							style="visibility: hidden;" /> <br /> <br />
						<h5>ou</h5>
						<br />
						<h4>
							<a href="CadastrodeUsuario.jsp"><b>Cadastre-se</b></a>
						</h4>
					</form>
					<script type="text/javascript">
						function valida_form() {
							if (document.getElementById("nome").value == "") {
								alert('Por favor, preencha o campo nome');
								document.getElementById("nome").focus();
								return false
							}
							if (document.getElementById("senha").value == "") {
								alert('Por favor, preencha o campo senha');
								document.getElementById("senha").focus();
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