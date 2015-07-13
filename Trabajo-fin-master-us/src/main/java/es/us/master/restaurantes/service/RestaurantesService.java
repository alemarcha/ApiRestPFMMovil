package es.us.master.restaurantes.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import es.us.master.restaurantes.dao.IRestaurantesDAO;
import es.us.master.restaurantes.model.Restaurantes;
@Transactional
public class RestaurantesService implements IRestaurantesService {
	IRestaurantesDAO restaurantesDAO;

	public void nuevoRestaurante(Restaurantes e){
		restaurantesDAO.create(e);
	}
	
	public List<Restaurantes> getRestaurantes(){
		return restaurantesDAO.fetchAll();
	}
	
	public List<Restaurantes> getRestaurantesLatLongDistancia(double lat,double longitud,double distancia){
		Search criterio= new Search(Restaurantes.class);
//		//Position, decimal degrees
//		 lat = 51.0
//		 lon = 0.0
//
//		 //Earth’s radius, sphere
//		 R=6378137
//
//		 //offsets in meters
//		 dn = 100
//		 de = 100
//
//		 //Coordinate offsets in radians
//		 dLat = dn/R
//		 dLon = de/(R*Cos(Pi*lat/180))
//
//		 //OffsetPosition, decimal degrees
//		 latO = lat + dLat * 180/Pi
//		 lonO = lon + dLon * 180/Pi 
		criterio.addFilterGreaterOrEqual("latitud", lat-distancia);
		criterio.addFilterGreaterOrEqual("longitud", longitud-distancia);
		
		
		return restaurantesDAO.search(criterio);
		
		
	}
	
	public IRestaurantesDAO getRestaurantesDAO() {
		return restaurantesDAO;
	}

	public void setRestaurantesDAO(IRestaurantesDAO restaurantesDAO) {
		this.restaurantesDAO = restaurantesDAO;
	}
	
	

}
