package es.us.master.restaurantes.service;

import org.springframework.transaction.annotation.Transactional;

import es.us.master.restaurantes.dao.IRestaurantesDAO;
import es.us.master.restaurantes.model.Restaurantes;
@Transactional
public class RestaurantesService implements IRestaurantesService {
	IRestaurantesDAO restaurantesDAO;

	public void nuevoRestaurante(Restaurantes e){
		restaurantesDAO.create(e);
	}
	
	
	public IRestaurantesDAO getRestaurantesDAO() {
		return restaurantesDAO;
	}

	public void setRestaurantesDAO(IRestaurantesDAO restaurantesDAO) {
		this.restaurantesDAO = restaurantesDAO;
	}
	
	

}
