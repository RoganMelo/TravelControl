package br.com.travelcontrol.dao;

import java.util.ArrayList;

import br.com.travelcontrol.bean.Hotel;

public class DaoHotel {
	private ArrayList<Hotel> hoteis = new ArrayList<Hotel>();

	public void salvar(Hotel hotel) {
		hoteis.add(hotel);
	}

	public void deletar(Hotel hotel) {
		for (int i = 0; i < hoteis.size(); i++)
			if (hoteis.get(i).equals(hotel)) {
				hoteis.remove(i);
				return;
			}
	}

	public ArrayList<Hotel> procurar() {
		return hoteis;
	}
}
