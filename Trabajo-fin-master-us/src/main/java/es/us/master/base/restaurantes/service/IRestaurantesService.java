package es.us.master.base.restaurantes.service;

import java.util.List;

import es.us.master.base.restaurantes.model.Restaurantes;

// TODO: Auto-generated Javadoc
/**
 * The Interface IRestaurantesService.
 */
public interface IRestaurantesService {
	
	/**
	 * Añade un restaurante a la base de datos
	 *
	 * @param e the e
	 */
	void nuevoRestaurante(Restaurantes e);
	
	/**
	 * Obtiene todos los restaurantes
	 *
	 * @return the restaurantes
	 */
	List<Restaurantes> getRestaurantes();
	
	/**
	 * Calculamos un offset para la latitud y la longitud recibida. Este
	 * offset se calcula a partir de la distancia en metros a la que se quiere
	 * buscar restaurantes cercanos. Se devuelven los restaurantes dentro de ese
	 * rango
	 *
	 * @param lat the lat
	 * @param longitud the longitud
	 * @param distancia the distancia
	 * @return the restaurantes lat long distancia
	 */
	List<Restaurantes> getRestaurantesLatLongDistancia(double lat,double longitud,double distancia);
}
