package es.us.master.base.restaurantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import es.us.master.base.restaurantes.dao.IRestaurantesDAO;
import es.us.master.base.restaurantes.model.Restaurantes;

@Transactional
@Service
public class RestaurantesService implements IRestaurantesService {
	
	@Autowired
	IRestaurantesDAO restaurantesDAO;

	public void nuevoRestaurante(Restaurantes e) {
		restaurantesDAO.create(e);
	}

	public List<Restaurantes> getRestaurantes() {
		return restaurantesDAO.fetchAll();
	}

	
	public List<Restaurantes> getRestaurantesLatLongDistancia(double lat, double longitud, double distancia) {
		Search criterio = new Search(Restaurantes.class);

		// Earth’s radius, sphere
		long r = 6378137;

		// offsets in meters
		double dn = distancia;
		double de = distancia;

		// Coordinate offsets in radians
		float dLat = (float) dn / r;
		float dLon = (float) (de / (r * Math.cos(Math.PI * lat / 180)));

		// OffsetPosition, decimal degrees
		double mayorLat = lat + dLat * 180 / Math.PI;
		double mayorLongitud = longitud + dLon * 180 / Math.PI;

		double menorLat = lat - dLat * 180 / Math.PI;
		double menorLongitud = longitud - dLon * 180 / Math.PI;
		criterio.addFilterGreaterOrEqual("latitud", menorLat);
		criterio.addFilterLessOrEqual("latitud", mayorLat);
		criterio.addFilterGreaterOrEqual("longitud", menorLongitud);
		criterio.addFilterLessOrEqual("longitud", mayorLongitud);

		return restaurantesDAO.search(criterio);

	}

	public IRestaurantesDAO getRestaurantesDAO() {
		return restaurantesDAO;
	}

	public void setRestaurantesDAO(IRestaurantesDAO restaurantesDAO) {
		this.restaurantesDAO = restaurantesDAO;
	}

}
