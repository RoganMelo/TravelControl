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
				<h3 id="titulo">Cadastrar Hotel</h3>
			</div>
			<div id="conteudo">
				<div id="inconteudo">
					<img id="hotel" src="Imagens/Hotel.png" />
					<form action="ServletHotel" onsubmit="return valida_form(this)"
						method="post" name="Cadastro">
						<b>Hotel:</b><input id="hotel1" type="text" name="nome" /> <br />
						<b>N° de Quartos:</b><input id="quartos" type="text"
							name="quartos" /> <br /> <b>Estrelas:</b> <input type="radio"
							value="5" name="estrelas" /><img width="80" height="12"
							src="Imagens/5 Estrelas.png" /> <br /> <input class="estrelas"
							type="radio" value="4" name="estrelas" /><img width="60"
							height="12" src="Imagens/4 Estrelas.png" /> <br /> <input
							class="estrelas" type="radio" value="3" name="estrelas" /><img
							width="44" height="12" src="Imagens/3 Estrelas.png" /> <br /> <input
							class="estrelas" type="radio" value="2" name="estrelas" /><img
							width="29" height="12" src="Imagens/2 Estrelas.png" /> <br /> <input
							class="estrelas" type="radio" value="1" name="estrelas" /><img
							width="13" height="12" src="Imagens/1 Estrela.png" /> <br /> <b>Preço:
							R$</b> <input id="valorhotel" type="text" name="valor" /> <br /> <br />
						<button type="submit">Cadastrar</button>
						<input type="text" id="method" name="operacao" value="novo"
							style="visibility: hidden;" />
					</form>
					<script type="text/javascript">
						function valida_form() {
							var digits="0123456789"
							var temp 
							var ok = true;
							for (var i=0;i<Cadastro.quartos.value.length;i++)
							 {
							  temp=Cadastro.quartos.value.substring(i,i+1)

							  if (digits.indexOf(temp)==-1)
							   {
							    alert("O campo quartos deve ser preenchido apenas com números!")
							    Cadastro.quartos.focus();
							    ok = false;
							    return(false);
							    break;
							   }

							  }
							for (var i=0;i<Cadastro.valor.value.length;i++)
							 {
							  temp=Cadastro.valor.value.substring(i,i+1)

							  if (digits.indexOf(temp)==-1)
							   {
							    alert("O campo valor deve ser preenchido apenas com números!")
							    Cadastro.valor.focus();
							    ok = false;
							    return(false);
							    break;
							   }

							  }
							if (document.getElementById("hotel1").value == "") {
								alert('Por favor, preencha o campo hotel');
								document.getElementById("hotel").focus();
								return false
							} else if (document.getElementById("quartos").value == "") {
								alert('Por favor, preencha o campo N° de Quartos');
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