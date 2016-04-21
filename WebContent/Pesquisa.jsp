<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Style_Pesquisa.css" />
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
				<ul>
					<li><h3 id="titulo">Pesquisa</h3></li>
					<li><img width="30" height="31" src="Imagens/Radar.png" /></li>
				</ul>
			</div>
			<div id="conteudo">
				<ul>
					<li>
						<form action="ServletPesquisa" method="post">
							<b>Rota:</b> <select id="viagem" name="viagem">
								<c:forEach items="${rotas}" var="viagem">
									<option value="${viagem.getRota()}">${viagem.getRota()}</option>
								</c:forEach>
							</select> <input type="text" id="method" name="operacao" value="pesquisar"
								style="visibility: hidden;" />
							<button type="submit">Pesquisar</button>
						</form>
					</li>
				</ul>
				<div id="informacao">
					<table style="width: 90%" border=1>
						<tr>
							<th>Passagem</th>
							<th>Empresa</th>
							<th>Hotel</th>
							<th>Dias</th>
							<th>Preço</th>
							<th>Cancelar</th>
						</tr>
							<form action="ServletPesquisa" method="post">
								<input type="text" id="method" name="operacao" value="deletar"
									style="visibility: hidden;" />  
									<c:forEach items="${viagens}" var="viagem">
										<tr>
											<td>${viagem.getRota().getRota()}</td>
											<td>${viagem.getEmpresa().getNome()}</td>	
											<td>${viagem.getHotel().getNome()}</td>
											<td>${viagem.getDias()}</td>
											<td>${viagem.getValor()}</td>
											<td><button type="submit"><img src="Imagens/Cancelar.png" width="25" height="25"></img></button></td>
											<input type="text id="rota" name="rota" value="${viagem.getRota().getRota()}"  style="display:none"/>
											<input type="text" id="empresa" name="empresa" value="${viagem.getEmpresa().getNome()}"  style="display:none"/>
											<input type="text" id="hotel" name="hotel" value="${viagem.getHotel().getNome()}"  style="display:none"/>
											<input type="text" id="dias" name="dias" value="${viagem.getDias()}" style="display:none"/>	
											<input type="text" id="valor" name="valor" value="${viagem.getValor()}" style="display:none"/>				
									</c:forEach>
							</form>
						</tr>
					</table>
					<input type="text" id="method" name="operacao" value="pesquisar"
						style="visibility: hidden;" />
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