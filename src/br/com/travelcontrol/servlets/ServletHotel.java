package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.travelcontrol.bean.Hotel;
import br.com.travelcontrol.dao.DaoHotel;
import br.com.travelcontrol.negocio.NegocioHotel;

@WebServlet("/ServletHotel")
public class ServletHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletHotel() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Hotel hotel = new Hotel();
		String operacao = request.getParameter("operacao");
		DaoHotel daoHotel = (DaoHotel) request.getServletContext()
				.getAttribute("daoHotel");
		NegocioHotel negocioHotel = new NegocioHotel(daoHotel);
		request.setAttribute("hoteis", negocioHotel.listarTodos());
		if ("novo".equals(operacao)) {
			hotel.setNome(request.getParameter("nome"));
			hotel.setQuartos(Integer.parseInt(request.getParameter("quartos")));
			hotel.setEstrelas(Integer.parseInt(request.getParameter("estrelas")));
			hotel.setValor(Float.parseFloat(request.getParameter("valor")));
			negocioHotel.adicionar(hotel);
			request.getServletContext().setAttribute("daoHotel", daoHotel);
			// request.setAttribute("resultado", "Hotel " + hotel.getNome() +
			// " cadastrado com sucesso");
			negocioHotel = null;
			request.getRequestDispatcher("CadastrodeHoteis.jsp").forward(
					request, response);
		} else if ("pesquisar".equals(operacao)) {
			hotel = negocioHotel.procurarHotel(request.getParameter("hotel"));
			if (hotel != null) {
				request.setAttribute("hotel", hotel.getNome());
				request.setAttribute("quartos", hotel.getQuartos());
				request.setAttribute("estrelas", hotel.getEstrelas());
				request.setAttribute("valor", hotel.getValor());
			} else {
				request.setAttribute("hotel", null);
				request.setAttribute("quartos", 0);
				request.setAttribute("estrelas", 0);
				request.setAttribute("valor", 0);
			}
			request.getRequestDispatcher("AlteraHoteis.jsp").forward(request,
					response);
		} else if ("editar".equals(operacao)) {
			Hotel hotelAlterado = new Hotel();
			hotel = negocioHotel.procurarHotel(request.getParameter("hotelAlterado"));
			hotelAlterado.setNome(request.getParameter("hotelAlterado"));
			hotelAlterado.setQuartos(Integer.parseInt(request
					.getParameter("quartosAlterados")));
			hotelAlterado.setEstrelas(Integer.parseInt(request
					.getParameter("estrelasAlteradas")));
			hotelAlterado.setValor(Float.parseFloat(request
					.getParameter("valorAlterado")));
			negocioHotel.altera(hotel, hotelAlterado);
			request.getServletContext().setAttribute("daoHotel", daoHotel);
			negocioHotel = null;
			request.getRequestDispatcher("AlteraHoteis.jsp").forward(request,
					response);
		} else if ("cadastrar".equals(operacao)) {
			request.getRequestDispatcher("CadastrodeHoteis.jsp").forward(
					request, response);
		} else if ("alterar".equals(operacao)) {
			request.getRequestDispatcher("AlteraHoteis.jsp").forward(request,
					response);
		}
	}
}