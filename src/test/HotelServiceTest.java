package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.ConfiguracaoJDBC;
import daoImpl.HotelDaoImpl;
import model.Hotel;
import service.HotelService;

class HotelServiceTest {
	private HotelService hotelService = new HotelService(new HotelDaoImpl(new ConfiguracaoJDBC()));

	@Test
	void test() {
		Hotel hotel = new Hotel("Sheraton", "Barata Ribeiro", 418, "Rio de Janeiro", "RJ", false);
		hotelService.salvar(hotel);
		assertTrue(hotel.getId() != null);

		hotel = new Hotel("Hilton", "Nsa de Copacabana", 680, "Rio de Janeiro", "RJ", true);
		hotelService.salvar(hotel);
		assertTrue(hotel.getId() != null);
		
		hotel = new Hotel("Marriot", "Atlantica", 1000, "Rio de Janeiro", "RJ", true);
		hotelService.salvar(hotel);
		assertTrue(hotel.getId() != null);
		
		hotel = new Hotel("Heritage", "Paulista", 100, "Sao Paulo", "SP", false);
		hotelService.salvar(hotel);
		assertTrue(hotel.getId() != null);
		
		hotel = new Hotel("Pousada Iracema", "Iracema Falls", 1, "Presidente Figueiredo", "AM", false);
		hotelService.salvar(hotel);
		assertTrue(hotel.getId() != null);
		
		List<Hotel> hoteis = hotelService.buscarTodos();
		System.out.println("\n\nAbaixo está a lista de todos os hoteis salvos no banco");
		for(Hotel h: hoteis)
		{
			System.out.println(h.toString());
		}
	}

}
