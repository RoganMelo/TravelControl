package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Viagem;

public class DaoViagem {
	private ArrayList<Viagem> viagens = new ArrayList<Viagem>();

	public void salvar(Viagem viagem) {
		viagens.add(viagem);
	}

	public void deletar(Viagem viagem) {
		for (int i = 0; i < viagens.size(); i++)
			if (viagens.get(i).equals(viagem)) {
				viagens.remove(i);
				return;
			}
	}

	public ArrayList<Viagem> procurar() {
		return viagens;
	}
}
