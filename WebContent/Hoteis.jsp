<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="css/Style_Cadastro de Hoteis.css" />
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
					<li><a href="Hoteis.jsp">Hot�is</a></li>
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
				<h3 id="titulo">Hot�is</h3>
			</div>
			<div id="conteudo">
				<div id="inconteudo">
					<img id="hotel" src="Imagens/Hotel.png" />
					<form action="ServletHotel" onsubmit="return valida_form(this)"
						method="post">
						<button type="submit">Cadastrar</button>
						<input type="text" id="method" name="operacao" value="cadastrar"
							style="visibility: hidden;" />
					</form>
					<form action="ServletHotel" onsubmit="return valida_form(this)"
						method="post">
						<button type="submit">Alterar</button>
						<input type="text" id="method" name="operacao" value="alterar"
							style="visibility: hidden;" />
					</form>
					<script type="text/javascript">
						function valida_form() {
							if (document.getElementById("hotel1").value == "") {
								alert('Por favor, preencha o campo hotel');
								document.getElementById("hotel").focus();
								return false
							} else if (document.getElementById("quartos").value == "") {
								alert('Por favor, preencha o campo N� de Quartos');
								document.getElementById("quartos").focus();
								return false;
							} else if (document.getElementById("valorhotel").value == "") {
								alert('Por favor, preencha o campo valor');
								document.getElementById("valorhotel").focus();
								return false;
							} else {
								alert('Cadastro de hotel feito com sucesso!');
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
					<li><a href="Duvidas.jsp">D�vidas</a></li>
					<li><a href="Facebook.jsp">Facebook</a></li>
					<li><a href="Email.jsp">E-mail</a></li>
					<li><a href="Telefone.jsp">Telefone</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>