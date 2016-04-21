package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Cidade;
import br.com.travelcontrol.bean.Empresa;
import br.com.travelcontrol.bean.Viagem;
import br.com.travelcontrol.dao.DaoViagem;

public class NegocioViagem {
	private DaoViagem daoViagem;

	public NegocioViagem(DaoViagem daoViagem) {
		this.daoViagem = daoViagem;
	}

	public void adicionar(Viagem viagem) {
		daoViagem.salvar(viagem);
	}

	public Viagem deletar(Viagem viagem) {
		daoViagem.deletar(viagem);
		return viagem;
	}

	public Viagem procurar(Viagem viagem) {
		ArrayList<Viagem> viagens = daoViagem.procurar();
		for (int i = 0; i < viagens.size(); i++) {
			if (viagem.equals(viagens.get(i))) {
				return viagens.get(i);
			}
		}
		return viagem;
	}

	public ArrayList<Viagem> procurarViagem(String viagem) {
		ArrayList<Viagem> viagens = daoViagem.procurar();
		ArrayList<Viagem> resultado = new ArrayList<Viagem>();
		for (int i = 0; i < viagens.size(); i++) {
			if (viagem.equals(viagens.get(i).getRota().getRota())) {
				resultado.add(viagens.get(i));
			}
		}
		return resultado;
	}
	
	public void atualizaCidade(Cidade cidade,Cidade cidadeAlterada) {
		ArrayList<Viagem> viagens = daoViagem.procurar();
		if(!(cidade == null))
			for (int i = 0; i < viagens.size(); i++) {

				if (cidade.equals(viagens.get(i).getRota().getDestino())) {
					viagens.get(i).getRota().setDestino(cidadeAlterada);
					
				}else if(cidade.equals(viagens.get(i).getRota().getOrigem()))
				{
					viagens.get(i).getRota().setOrigem(cidadeAlterada);
				}
					
			}
	}
	
	public void atualizaEmpresa(Empresa empresa,Empresa empresaAlterada) {
		ArrayList<Viagem> viagens = daoViagem.procurar();
		if(!(empresa == null))
			for (int i = 0; i < viagens.size(); i++) {
				if (empresa.equals(viagens.get(i).getEmpresa())) {
					viagens.get(i).setEmpresa(empresaAlterada);		
					return;
				}	
			}
	}

	public List<Viagem> listarTodos() {
		return daoViagem.procurar();
	}
}
