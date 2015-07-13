package es.us.master.restaurantes.service;

import java.util.List;

import es.us.master.restaurantes.model.Restaurantes;

public interface IRestaurantesService {
	void nuevoRestaurante(Restaurantes e);
	List<Restaurantes> getRestaurantes();
	List<Restaurantes> getRestaurantesLatLongDistancia(double lat,double longitud,double distancia);
}
