package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.travelcontrol.bean.Empresa;
import br.com.travelcontrol.dao.DaoEmpresa;
import br.com.travelcontrol.dao.DaoRota;
import br.com.travelcontrol.dao.DaoViagem;
import br.com.travelcontrol.negocio.NegocioEmpresa;
import br.com.travelcontrol.negocio.NegocioRota;
import br.com.travelcontrol.negocio.NegocioViagem;

@WebServlet("/ServletEmpresa")
public class ServletEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEmpresa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = new Empresa();
		String operacao = request.getParameter("operacao");
		DaoRota daoRota = (DaoRota) request.getServletContext().getAttribute(
				"daoRota");
		NegocioRota negocioRota = new NegocioRota(daoRota);
		request.setAttribute("rotas", negocioRota.listarTodos());
		DaoEmpresa daoEmpresa = (DaoEmpresa) request.getServletContext()
				.getAttribute("daoEmpresa");
		NegocioEmpresa negocioEmpresa = new NegocioEmpresa(daoEmpresa);
		request.setAttribute("empresas", negocioEmpresa.listarTodos());
		if ("novo".equals(operacao)) {
			empresa.setNome(request.getParameter("nome"));
			empresa.setRota(negocioRota.procurarRota(request
					.getParameter("rota")));
			empresa.setValor(Float.parseFloat(request.getParameter("valor")));
			negocioEmpresa.adicionar(empresa);
			request.getServletContext().setAttribute("daoEmpresa", daoEmpresa);
			// request.setAttribute("resultado", "Empresa " + empresa.getNome()
			// + " cadastrada com sucesso");
			negocioEmpresa = null;
			request.getRequestDispatcher("CadastrodeEmpresas.jsp").forward(
					request, response);
		} else if ("pesquisar".equals(operacao)) {
			empresa = negocioEmpresa.procurarEmpresa(request
					.getParameter("empresa"));
			if (empresa != null) {
				request.setAttribute("empresa", empresa.getNome());
				request.setAttribute("rota", empresa.getRota().getRota());
				request.setAttribute("valor", empresa.getValor());
			} else {
				request.setAttribute("empresa", null);
				request.setAttribute("rota", null);
				request.setAttribute("valor", 0);
			}
			request.getRequestDispatcher("AlteraEmpresas.jsp").forward(request,
					response);
		} else if ("editar".equals(operacao)) {
			Empresa empresaAlterada = new Empresa();
			empresa = negocioEmpresa.procurarEmpresa(request
					.getParameter("empresaAlterada"));
			empresaAlterada.setNome(request.getParameter("empresaAlterada"));
			empresaAlterada.setRota(negocioRota.procurarRota(request
					.getParameter("rotaAlterada")));
			if(!(request.getParameter("valorAlterado") == ""))
			{
				empresaAlterada.setValor(Float.parseFloat(request
						.getParameter("valorAlterado")));
				negocioEmpresa.altera(empresa, empresaAlterada);
				request.getServletContext().setAttribute("daoEmpresa", daoEmpresa);
				negocioEmpresa = null;
			}
			DaoViagem daoViagem = (DaoViagem) request.getServletContext().getAttribute("daoViagem");
			NegocioViagem negocioViagem = new NegocioViagem(daoViagem);
			negocioViagem.atualizaEmpresa(empresa, empresaAlterada);
			negocioViagem = null;
			request.getServletContext().setAttribute("daoViagem", daoViagem);
			request.getRequestDispatcher("AlteraEmpresas.jsp").forward(request,
					response);
		} else if ("cadastrar".equals(operacao)) {
			request.getRequestDispatcher("CadastrodeEmpresas.jsp").forward(
					request, response);
		} else if ("alterar".equals(operacao)) {
			request.getRequestDispatcher("AlteraEmpresas.jsp").forward(request,
					response);
		}
	}

}