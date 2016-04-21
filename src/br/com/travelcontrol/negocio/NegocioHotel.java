package br.com.travelcontrol.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.travelcontrol.bean.Hotel;
import br.com.travelcontrol.dao.DaoHotel;

public class NegocioHotel {
	private DaoHotel daoHotel;

	public NegocioHotel(DaoHotel daoHotel) {
		this.daoHotel = daoHotel;
	}

	public void adicionar(Hotel hotel) {
		daoHotel.salvar(hotel);
	}

	public Hotel deletar(Hotel hotel) {
		daoHotel.deletar(hotel);
		return hotel;
	}

	public Hotel procurar(Hotel hotel) {
		ArrayList<Hotel> hoteis = daoHotel.procurar();
		for (int i = 0; i < hoteis.size(); i++) {
			if (hotel.equals(hoteis.get(i))) {
				return hoteis.get(i);
			}
		}
		return hotel;
	}

	public Hotel procurarHotel(String hotel) {
		ArrayList<Hotel> hoteis = daoHotel.procurar();
		for (int i = 0; i < hoteis.size(); i++) {
			if (hotel.equals(hoteis.get(i).getNome())) {
				return hoteis.get(i);
			}
		}
		return null;
	}
	
	public void altera(Hotel hotel, Hotel hotelAlterado) {
		ArrayList<Hotel> hoteis = daoHotel.procurar();
		for (int i = 0; i < hoteis.size(); i++) {
			if (hotel.equals(hoteis.get(i))){
				hoteis.remove(i);
				hoteis.add(i, hotelAlterado);
			}
		}
	}

	public List<Hotel> listarTodos() {
		return daoHotel.procurar();
	}
}
