package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Cidade;
import br.com.travelcontrol.bean.Rota;
import br.com.travelcontrol.dao.DaoRota;

public class NegocioRota {
	private DaoRota daoRota;

	public NegocioRota(DaoRota daoRota) {
		this.daoRota = daoRota;
	}

	public void adicionar(Rota rota) {
		daoRota.salvar(rota);
	}

	public Rota deletar(Rota rota) {
		daoRota.deletar(rota);
		return rota;
	}

	public Rota procurar(Rota rota) {
		ArrayList<Rota> rotas = daoRota.procurar();
		for (int i = 0; i < rotas.size(); i++) {
			if (rota.equals(rotas.get(i))) {
				return rotas.get(i);
			}
		}
		return rota;
	}

	public Rota procurarRota(String rota) {
		ArrayList<Rota> rotas = daoRota.procurar();
		if(!(rota == null))
			for (int i = 0; i < rotas.size(); i++) {
				if (rota.equals(rotas.get(i).getRota())) {
					return rotas.get(i);
				}
			}
		return null;
	}
	
	public void atualizaCidade(Cidade cidade) {
		ArrayList<Rota> rotas = daoRota.procurar();
		if(!(cidade == null))
			for (int i = 0; i < rotas.size(); i++) {
				if (cidade.equals(rotas.get(i).getDestino())) {
					rotas.get(i).setDestino(cidade);
				}else if(cidade.equals(rotas.get(i).getOrigem()))
				{
					rotas.get(i).setOrigem(cidade);
				}
					
			}
	}

	public List<Rota> listarTodos() {
		return daoRota.procurar();
	}
}
