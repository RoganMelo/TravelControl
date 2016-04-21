package br.com.travelcontrol.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.travelcontrol.bean.Usuario;
import br.com.travelcontrol.dao.DaoUsuario;
import br.com.travelcontrol.negocio.NegocioUsuario;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String operacao = request.getParameter("operacao");
		HttpSession sessao = request.getSession();
		if ("logar".equals(operacao) == true) {
			usuario.setNome(nome);
			sessao.setAttribute("usuariologado", usuario);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("Home2.jsp")
					.forward(request, response);
		} else if ("sair".equals(operacao) == true) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("Login.jsp");
		} else if ("cadastrar".equals(operacao) == true) {
			usuario.setNome(nome);
			usuario.setSenha(senha);
			DaoUsuario daoUsuario = (DaoUsuario) request.getServletContext()
					.getAttribute("daoUsuario");
			NegocioUsuario negocioUsuario = new NegocioUsuario(daoUsuario);
			negocioUsuario.adicionar(usuario);
			request.getServletContext().setAttribute("daoUsuario", daoUsuario);
			// request.setAttribute("resultado", "Usuario " + usuario.getNome()
			// + " cadastrado com sucesso");
			negocioUsuario = null;
			request.getRequestDispatcher("CadastrodeUsuario.jsp").forward(
					request, response);
		}
	}
}