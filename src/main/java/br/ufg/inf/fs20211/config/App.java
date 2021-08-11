package br.ufg.inf.fs20211.config;

import java.time.LocalDate;

import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;

public class App {

	public static void main(String[] args) {
		System.out.println("Começando");
		testeJpaHospedagem();
		System.out.println("Finaliazdo.");
	}
	
	public static void testeJpaQuarto() {
		QuartoCtrl ctrl = new QuartoCtrl ();
		HotelCtrl hotelCtrl = new HotelCtrl();
		System.out.println("Busca Todos");
		for(Quarto h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(3));
		
		System.out.println("Inserir no banco");
		Quarto q1 = new Quarto(null, hotelCtrl.findById(1), CategoriaQuarto.APARTAMENTO, 3, 1010, 150.0);
		Quarto q2 = new Quarto(null, hotelCtrl.findById(2), CategoriaQuarto.DORMITORIO, 8, 310, 50.0);
		Quarto q3 = new Quarto(null, hotelCtrl.findById(3), CategoriaQuarto.LUXO, 5, 1210, 550.0);
		Quarto q4 = new Quarto(null, hotelCtrl.findById(4), CategoriaQuarto.SIMPLES, 2, 110, 100.0);
		q1 = ctrl.insert(q1);
		System.out.println(q1);
		
		q2 = ctrl.insert(q2);
		System.out.println(q2);
		
		q3 = ctrl.insert(q3);
		System.out.println(q3);
		
		q4 = ctrl.insert(q4);
		System.out.println(q4);
		
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}
		
		System.out.println("Alterar no banco");
		q1.setPrDiaria(175.0);
		q1 = ctrl.update(q1);

		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}

		
		
		System.out.println("Excluir");
		ctrl.delete(q3.getIdQuarto());
		System.out.println("Terminou");
	}
	
	public static void testeJpaHotel() {
		HotelCtrl ctrl = new HotelCtrl();
		System.out.println("Busca Todos");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(3));
		
		System.out.println("Inserir no banco");
		Hotel hotel = new Hotel(null, "Teste", "Qualquer Lugar", 10);
		hotel = ctrl.insert(hotel);
		System.out.println(hotel);
		
		System.out.println("Alterar no banco");
		hotel.setNmHotel("Teste Alterado");
		hotel = ctrl.update(hotel);
		System.out.println(hotel);
		
		
		System.out.println("Excluir");
		ctrl.delete(hotel.getIdHotel());
		System.out.println("Terminou");
	}
	
	// Implementação
	
	public static void testeJpaHospede() {
		HospedeCtrl ctrl = new HospedeCtrl();
		
		System.out.println("Inserir no banco");
		Hospede hospede = new Hospede("Elias", LocalDate.of(2001, 03, 9), 123);
		hospede = ctrl.insert(hospede);
		System.out.println(hospede);
		
		System.out.println("Busca Todos");
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(1));
		
		System.out.println("Alterar no banco");
		hospede.setNmHospede("Elias Alterado");
		hospede = ctrl.update(hospede);
		System.out.println(hospede);
		
		
		System.out.println("Excluir");
		ctrl.delete(hospede.getIdHospede());
		System.out.println("Terminou");
	}

	public static void testeJpaHospedagem() {
		HospedagemCtrl ctrl = new HospedagemCtrl();
		QuartoCtrl ctrlQuarto = new QuartoCtrl();
		Quarto quarto = ctrlQuarto.findById(1);
		HospedeCtrl ctrlHospede = new HospedeCtrl();
		Hospede hospede = ctrlHospede.findById(1);
		
		System.out.println("Inserir no banco");
		Hospedagem hospedagem = new Hospedagem(quarto, hospede, LocalDate.of(2021,8,10), LocalDate.of(2021,8,12));
		hospedagem = ctrl.insert(hospedagem);
		System.out.println(hospedagem);
		
		System.out.println("Busca Todos");
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(1));
		
		System.out.println("Alterar no banco");
		hospedagem.setDtCheckout(LocalDate.of(2021, 8, 20));
		hospedagem = ctrl.update(hospedagem);
		System.out.println(hospedagem);
		
		
		System.out.println("Excluir");
		ctrl.delete(hospedagem.getIdHospedagem());
		System.out.println("Terminou");
	}
}
