package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.travelcontrol.bean.Cidade;
import br.com.travelcontrol.dao.DaoCidade;
import br.com.travelcontrol.dao.DaoEmpresa;
import br.com.travelcontrol.dao.DaoHotel;
import br.com.travelcontrol.dao.DaoRota;
import br.com.travelcontrol.dao.DaoViagem;
import br.com.travelcontrol.negocio.NegocioCidade;
import br.com.travelcontrol.negocio.NegocioEmpresa;
import br.com.travelcontrol.negocio.NegocioHotel;
import br.com.travelcontrol.negocio.NegocioRota;
import br.com.travelcontrol.negocio.NegocioViagem;

@WebServlet("/ServletCidade")
public class ServletCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCidade() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cidade cidade = new Cidade();
		String operacao = request.getParameter("operacao");
		DaoHotel daoHotel = (DaoHotel) request.getServletContext()
				.getAttribute("daoHotel");
		NegocioHotel negocioHotel = new NegocioHotel(daoHotel);
		request.setAttribute("hoteis", negocioHotel.listarTodos());
		DaoCidade daoCidade = (DaoCidade) request.getServletContext()
				.getAttribute("daoCidade");
		NegocioCidade negocioCidade = new NegocioCidade(daoCidade);
		request.setAttribute("cidades", negocioCidade.listarTodos());
		if ("novo".equals(operacao)) {
			cidade.setNome(request.getParameter("cidade"));
			cidade.setHotel(negocioHotel.procurarHotel(request
					.getParameter("hotel")));
			negocioCidade.adicionar(cidade);
			request.getServletContext().setAttribute("daoCidade", daoCidade);
			// request.setAttribute("resultado", "Cidade " + cidade.getNome() +
			// " cadastrada com sucesso");
			negocioCidade = null;
			request.getRequestDispatcher("CadastrodeCidades.jsp").forward(
					request, response);
		} else if ("pesquisar".equals(operacao)) {
			cidade = negocioCidade.procurarCidade(request.getParameter("cidade"));
			if (cidade != null) {
				request.setAttribute("cidade", cidade.getNome());
				request.setAttribute("hotel", cidade.getHotel().getNome());
			} else {
				request.setAttribute("cidade", null);
				request.setAttribute("hotel", null);
			}
			request.getRequestDispatcher("AlteraCidades.jsp").forward(request,
					response);
		} else if ("editar".equals(operacao)) {
			Cidade cidadeAlterada = new Cidade();
			if(!(request.getParameter("cidadeAlterada")==null)){
				cidade = negocioCidade.procurarCidade(request.getParameter("cidadeAlterada"));
				cidadeAlterada.setNome(request.getParameter("cidadeAlterada"));
				cidadeAlterada.setHotel(negocioHotel.procurarHotel(request
						.getParameter("hotelAlterado")));
				negocioCidade.altera(cidade, cidadeAlterada);
				DaoEmpresa daoEmpresa = (DaoEmpresa)request.getServletContext().getAttribute("daoEmpresa");
				DaoRota daoRota = (DaoRota)request.getServletContext().getAttribute("daoRota");
				DaoViagem daoViagem = (DaoViagem)request.getServletContext().getAttribute("daoViagem");
				NegocioEmpresa negocioEmpresa = new NegocioEmpresa(daoEmpresa);
				NegocioRota negocioRota = new NegocioRota(daoRota);
				NegocioViagem negocioViagem = new NegocioViagem(daoViagem);
				negocioRota.atualizaCidade(cidade);
				negocioViagem.atualizaCidade(cidade,cidadeAlterada);
				negocioEmpresa.atualizaCidade(cidade);
				request.getServletContext().setAttribute("daoCidade", daoCidade);
				request.getServletContext().setAttribute("daoRota", daoRota);
				request.getServletContext().setAttribute("daoEmpresa", daoEmpresa);
				request.getServletContext().setAttribute("daoViagem", daoViagem);
				negocioCidade = null;
			}
			request.getRequestDispatcher("AlteraCidades.jsp").forward(request,
					response);
		} else if ("cadastrar".equals(operacao)) {
			request.getRequestDispatcher("CadastrodeCidades.jsp").forward(
					request, response);
		} else if ("alterar".equals(operacao)) {
			request.getRequestDispatcher("AlteraCidades.jsp").forward(request,
					response);
		}
	}

}