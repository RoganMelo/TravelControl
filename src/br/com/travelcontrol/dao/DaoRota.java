package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Rota;

public class DaoRota {
	private ArrayList<Rota> rotas = new ArrayList<Rota>();

	public void salvar(Rota rota) {
		rotas.add(rota);
	}

	public void deletar(Rota rota) {
		for (int i = 0; i < rotas.size(); i++)
			if (rotas.get(i).equals(rota)) {
				rotas.remove(i);
				return;
			}
	}

	public ArrayList<Rota> procurar() {
		return rotas;
	}
}
