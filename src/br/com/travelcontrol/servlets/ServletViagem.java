package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.travelcontrol.bean.Viagem;
import br.com.travelcontrol.dao.DaoEmpresa;
import br.com.travelcontrol.dao.DaoViagem;
import br.com.travelcontrol.negocio.NegocioEmpresa;
import br.com.travelcontrol.negocio.NegocioViagem;

@WebServlet("/ServletViagem")
public class ServletViagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletViagem() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Viagem viagem = new Viagem();
		String operacao = request.getParameter("operacao");
		DaoEmpresa daoEmpresa = (DaoEmpresa) request.getServletContext()
				.getAttribute("daoEmpresa");
		NegocioEmpresa negocioEmpresa = new NegocioEmpresa(daoEmpresa);
		request.setAttribute("empresas", negocioEmpresa.listarTodos());
		if ("cadastrar".equals(operacao)) {
			viagem.setEmpresa(negocioEmpresa.procurarEmpresa(request
					.getParameter("empresa")));
			viagem.setRota(viagem.getEmpresa().getRota());
			viagem.setHotel(viagem.getEmpresa().getRota().getDestino()
					.getHotel());
			viagem.setDias(Integer.parseInt(request.getParameter("dias")));
			viagem.setValor(viagem.getEmpresa().getValor()
					+ (float) viagem.getDias()
					* (viagem.getEmpresa().getRota().getDestino().getHotel()
							.getValor()));
			DaoViagem daoViagem = (DaoViagem) request.getServletContext()
					.getAttribute("daoViagem");
			NegocioViagem negocioViagem = new NegocioViagem(daoViagem);
			negocioViagem.adicionar(viagem);
			request.getServletContext().setAttribute("daoViagem", daoViagem);
			// request.setAttribute("resultado", "Viagem" +
			// " cadastrada com sucesso");
			negocioViagem = null;
		}
		request.getRequestDispatcher("Viagem.jsp").forward(request, response);
	}

}