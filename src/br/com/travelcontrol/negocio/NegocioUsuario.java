package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Usuario;
import br.com.travelcontrol.dao.DaoUsuario;

public class NegocioUsuario {
	private DaoUsuario daoUsuario;

	public NegocioUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public void adicionar(Usuario usuario) {
		daoUsuario.salvar(usuario);
	}

	public Usuario deletar(Usuario usuario) {
		daoUsuario.deletar(usuario);
		return usuario;
	}

	public Usuario procurar(Usuario usuario) {
		ArrayList<Usuario> usuarios = daoUsuario.procurar();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuario.equals(usuarios.get(i))) {
				return usuarios.get(i);
			}
		}
		return usuario;
	}
	
	public Usuario procurarUsuario(String usuario) {
		ArrayList<Usuario> usuarios = daoUsuario.procurar();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuario.equals(usuarios.get(i))) {
				return usuarios.get(i);
			}
		}
		return null;
	}

	public List<Usuario> listarTodos() {
		return daoUsuario.procurar();
	}
}
