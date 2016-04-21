package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.travelcontrol.bean.Rota;
import br.com.travelcontrol.dao.DaoCidade;
import br.com.travelcontrol.dao.DaoRota;
import br.com.travelcontrol.negocio.NegocioCidade;
import br.com.travelcontrol.negocio.NegocioRota;

@WebServlet("/ServletRota")
public class ServletRota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRota() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Rota rota = new Rota();
		String operacao = request.getParameter("operacao");
		DaoCidade daoCidade = (DaoCidade) request.getServletContext()
				.getAttribute("daoCidade");
		NegocioCidade negocioCidade = new NegocioCidade(daoCidade);
		request.setAttribute("cidades", negocioCidade.listarTodos());
		if ("cadastrar".equals(operacao)) {
			rota.setOrigem(negocioCidade.procurarCidade(request
					.getParameter("origem")));
			rota.setDestino(negocioCidade.procurarCidade(request
					.getParameter("destino")));
			rota.setRota(rota.getOrigem().getNome() + " -> " + rota.getDestino().getNome());
			DaoRota daoRota = (DaoRota) request.getServletContext()
					.getAttribute("daoRota");
			NegocioRota negocioRota = new NegocioRota(daoRota);
			negocioRota.adicionar(rota);
			request.getServletContext().setAttribute("daoRota", daoRota);
			// request.setAttribute("resultado", "Rota " + rota.getRota() +
			// " cadastrada com sucesso");
			negocioRota = null;
		}
		request.getRequestDispatcher("Rotas.jsp").forward(request, response);
	}

}