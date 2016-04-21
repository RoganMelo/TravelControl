package br.com.travelcontrol.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.travelcontrol.dao.DaoCidade;
import br.com.travelcontrol.dao.DaoEmpresa;
import br.com.travelcontrol.dao.DaoHotel;
import br.com.travelcontrol.dao.DaoRota;
import br.com.travelcontrol.dao.DaoUsuario;
import br.com.travelcontrol.dao.DaoViagem;

@WebListener
public class Listener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent context) {
		DaoUsuario daoUsuario = new DaoUsuario();
		DaoCidade daoCidade = new DaoCidade();
		DaoEmpresa daoEmpresa = new DaoEmpresa();
		DaoHotel daoHotel = new DaoHotel();
		DaoRota daoRota = new DaoRota();
		DaoViagem daoViagem = new DaoViagem();
		context.getServletContext().setAttribute("daoUsuario", daoUsuario);
		context.getServletContext().setAttribute("daoCidade", daoCidade);
		context.getServletContext().setAttribute("daoEmpresa", daoEmpresa);
		context.getServletContext().setAttribute("daoHotel", daoHotel);
		context.getServletContext().setAttribute("daoRota", daoRota);
		context.getServletContext().setAttribute("daoViagem", daoViagem);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		// Aqui deve ser apagado os daos.

	}

}
