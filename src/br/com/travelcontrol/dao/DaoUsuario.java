package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Usuario;

public class DaoUsuario {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public void salvar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void deletar(Usuario usuario) {
		for (int i = 0; i < usuarios.size(); i++)
			if (usuarios.get(i).equals(usuario)) {
				usuarios.remove(i);
				return;
			}
	}

	public ArrayList<Usuario> procurar() {
		return usuarios;
	}
}
