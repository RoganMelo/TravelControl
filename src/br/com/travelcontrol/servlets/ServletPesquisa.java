package br.com.travelcontrol.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.travelcontrol.bean.Viagem;
import br.com.travelcontrol.dao.DaoEmpresa;
import br.com.travelcontrol.dao.DaoHotel;
import br.com.travelcontrol.dao.DaoRota;
import br.com.travelcontrol.dao.DaoViagem;
import br.com.travelcontrol.negocio.NegocioEmpresa;
import br.com.travelcontrol.negocio.NegocioHotel;
import br.com.travelcontrol.negocio.NegocioRota;
import br.com.travelcontrol.negocio.NegocioViagem;

@WebServlet("/ServletPesquisa")
public class ServletPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletPesquisa() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		DaoEmpresa daoEmpresa = (DaoEmpresa) request.getServletContext()
				.getAttribute("daoEmpresa");
		NegocioEmpresa negocioEmpresa = new NegocioEmpresa(daoEmpresa);
		DaoHotel daoHotel = (DaoHotel) request.getServletContext()
				.getAttribute("daoHotel");
		NegocioHotel negocioHotel = new NegocioHotel(daoHotel);
		DaoRota daoRota = (DaoRota) request.getServletContext().getAttribute(
				"daoRota");
		NegocioRota negocioRota = new NegocioRota(daoRota);
		request.setAttribute("rotas", negocioRota.listarTodos());
		DaoViagem daoViagem = (DaoViagem) request.getServletContext()
				.getAttribute("daoViagem");
		NegocioViagem negocioViagem = new NegocioViagem(daoViagem);
		request.setAttribute("viagens", negocioViagem.listarTodos());
		if ("pesquisar".equals(operacao)) {
			ArrayList<Viagem> resultadoViagem = negocioViagem
					.procurarViagem(request.getParameter("viagem"));
			if (resultadoViagem != null) {
				request.setAttribute("viagens", resultadoViagem);
			} else {
				request.setAttribute("rota", null);
				request.setAttribute("empresa", null);
				request.setAttribute("preco", 0);
				request.setAttribute("hotel", null);
			}

			request.getServletContext().setAttribute("daoViagem", daoViagem);
			// request.setAttribute("resultado", "Viagem" +
			// " cadastrada com sucesso");
			negocioViagem = null;
		} else if ("deletar".equals(operacao)) {
			Viagem deletaViagem = new Viagem();
			deletaViagem.setEmpresa(negocioEmpresa.procurarEmpresa(request
					.getParameter("empresa")));
			deletaViagem.setHotel(negocioHotel.procurarHotel(request
					.getParameter("hotel")));
			deletaViagem.setRota(negocioRota.procurarRota(request
					.getParameter("rota")));
			deletaViagem.setValor(Float.parseFloat(request
					.getParameter("valor")));
			deletaViagem
					.setDias(Integer.parseInt(request.getParameter("dias")));
			negocioViagem.deletar(deletaViagem);
			negocioViagem = null;
		}
		request.getRequestDispatcher("Pesquisa.jsp").forward(request, response);
	}

}
