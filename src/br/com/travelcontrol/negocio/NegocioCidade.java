package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Cidade;
import br.com.travelcontrol.dao.DaoCidade;

public class NegocioCidade {
	private DaoCidade daoCidade;

	public NegocioCidade(DaoCidade daoCidade) {
		this.daoCidade = daoCidade;
	}

	public void adicionar(Cidade cidade) {
		daoCidade.salvar(cidade);
	}

	public Cidade deletar(Cidade cidade) {
		daoCidade.deletar(cidade);
		return cidade;
	}

	public Cidade procurar(Cidade cidade) {
		ArrayList<Cidade> cidades = daoCidade.procurar();
		for (int i = 0; i < cidades.size(); i++) {
			if (cidade.equals(cidades.get(i))) {
				return cidades.get(i);
			}
		}
		return cidade;
	}

	public Cidade procurarCidade(String cidade) {
		ArrayList<Cidade> cidades = daoCidade.procurar();
		for (int i = 0; i < cidades.size(); i++) {
			if (cidade.equals(cidades.get(i).getNome())) {
				return cidades.get(i);
			}
		}
		return null;
	}
	
	public void altera(Cidade cidade, Cidade cidadeAlterada) {
		ArrayList<Cidade> cidades = daoCidade.procurar();
		if(!(cidade==null))
			for (int i = 0; i < cidades.size(); i++) {
				if (cidade.equals(cidades.get(i))){
					cidades.remove(i);
					cidades.add(i, cidadeAlterada);
				}
			}
	}

	public List<Cidade> listarTodos() {
		return daoCidade.procurar();
	}
}
