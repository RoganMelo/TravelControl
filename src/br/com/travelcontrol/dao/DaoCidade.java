package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Cidade;

public class DaoCidade {
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

	public void salvar(Cidade cidade) {
		cidades.add(cidade);
	}

	public void deletar(Cidade cidade) {
		for (int i = 0; i < cidades.size(); i++)
			if (cidades.get(i).equals(cidade)) {
				cidades.remove(i);
				return;
			}
	}

	public ArrayList<Cidade> procurar() {
		return cidades;
	}
}
