package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Cidade;
import br.com.travelcontrol.bean.Empresa;
import br.com.travelcontrol.dao.DaoEmpresa;

public class NegocioEmpresa {
	private DaoEmpresa daoEmpresa;

	public NegocioEmpresa(DaoEmpresa daoEmpresa) {
		this.daoEmpresa = daoEmpresa;
	}

	public void adicionar(Empresa empresa) {
		daoEmpresa.salvar(empresa);
	}

	public Empresa deletar(Empresa empresa) {
		daoEmpresa.deletar(empresa);
		return empresa;
	}

	public Empresa procurar(Empresa empresa) {
		ArrayList<Empresa> empresas = daoEmpresa.procurar();
		for (int i = 0; i < empresas.size(); i++) {
			if (empresa.equals(empresas.get(i))) {
				return empresas.get(i);
			}
		}
		return null;
	}

	public Empresa procurarEmpresa(String empresa) {
		ArrayList<Empresa> empresas = daoEmpresa.procurar();
		for (int i = 0; i < empresas.size(); i++) {
			if (empresa.equals(empresas.get(i).getNome())) {
				return empresas.get(i);
			}
		}
		return null;
	}
	
	public void altera(Empresa empresa, Empresa empresaAlterada) {
		ArrayList<Empresa> empresas = daoEmpresa.procurar();
		if(!(empresa == null))
			for (int i = 0; i < empresas.size(); i++) {
				if (empresa.equals(empresas.get(i))){
					empresas.add(i, empresaAlterada);
					return;
				}
			}
	}

	public void atualizaCidade(Cidade cidade) {
		ArrayList<Empresa> empresas = daoEmpresa.procurar();
		if(!(cidade == null))
			for (int i = 0; i < empresas.size(); i++) {
				if (cidade.equals(empresas.get(i).getRota().getDestino())) {
					empresas.get(i).getRota().setDestino(cidade);
				}else if(cidade.equals(empresas.get(i).getRota().getOrigem()))
				{
					empresas.get(i).getRota().setOrigem(cidade);
				}
					
			}
	}
	
	public List<Empresa> listarTodos() {
		return daoEmpresa.procurar();
	}
}
