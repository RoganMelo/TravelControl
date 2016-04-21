package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Empresa;

public class DaoEmpresa {
	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

	public void salvar(Empresa empresa) {
		empresas.add(empresa);
	}

	public void deletar(Empresa empresa) {
		for (int i = 0; i < empresas.size(); i++)
			if (empresas.get(i).equals(empresa)) {
				empresas.remove(i);
				return;
			}
	}

	public ArrayList<Empresa> procurar() {
		return empresas;
	}
}
