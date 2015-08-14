package es.us.master.api.rest.restaurantes.web.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.us.master.base.restaurantes.model.HitsDTO;
import es.us.master.base.restaurantes.model.RestauranteJSONGeneralDTO;
import es.us.master.base.restaurantes.model.Restaurantes;
import es.us.master.base.restaurantes.service.IRestaurantesService;

@RestController
public class RestaurantesController {

    @Autowired
    private IRestaurantesService restauranteService;

    @RequestMapping(value = "/restaurantes", method = RequestMethod.GET)
    public List<Restaurantes> getRestaurantes() {
	return getRestauranteService().getRestaurantes();
    }

    @RequestMapping(value = "/restaurantesPorCercaniaLatLong/{lat}/{longitud}/{dist}", method = RequestMethod.GET)
    public List<Restaurantes> getRestaurantesLatLong(@PathVariable double lat, @PathVariable double longitud,
	    @PathVariable double dist) {
	List<Restaurantes> r = getRestauranteService().getRestaurantesLatLongDistancia(lat, longitud, dist);
	return r;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addRestaurants(@RequestParam Integer size) {
	URL url;
	try {
	    url = new URL("http://jesusvargas.ddns.net:8082/restaurants?size=" + size + "&loc=37,-1&distance=200000km");

	    ObjectMapper mapper = new ObjectMapper();

	    RestauranteJSONGeneralDTO r = mapper.readValue(url, RestauranteJSONGeneralDTO.class);
	    Restaurantes restaurante = new Restaurantes();
	    int i = 0;
	    for (HitsDTO h : r.hits) {
		BeanUtils.copyProperties(h.get_source(), restaurante);
		String[] latLong = h.get_source().locale.split(",");
		restaurante.setLatitud(Double.valueOf(latLong[0]));
		restaurante.setLongitud(Double.valueOf(latLong[1]));
		restaurante.setIdentificador(h.get_source().getId());

		getRestauranteService().nuevoRestaurante(restaurante);
		i++;
		System.out.println(i);
	    }

	    System.out.println("fin");
	} catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @RequestMapping(value = "/addFromFile", method = RequestMethod.GET)
    public void addRestaurantsFromFile() {

	File f = new File("/Users/alemarcha26/Desktop/gitapi/Trabajo-fin-master-us/RecursosExternos/estesi.json");
	ObjectMapper mapper = new ObjectMapper();

	RestauranteJSONGeneralDTO r;
	try {
	    r = mapper.readValue(f, RestauranteJSONGeneralDTO.class);
	    Restaurantes restaurante = new Restaurantes();
	    int i = 0;
	    for (HitsDTO h : r.hits) {
		BeanUtils.copyProperties(h.get_source(), restaurante);
		String[] latLong = h.get_source().locale.split(",");
		restaurante.setLatitud(Double.valueOf(latLong[0]));
		restaurante.setLongitud(Double.valueOf(latLong[1]));
		restaurante.setIdentificador(h.get_source().getId());
		getRestauranteService().nuevoRestaurante(restaurante);
		i++;
		System.out.println(i);
	    }

	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public IRestaurantesService getRestauranteService() {
	return restauranteService;
    }

    public void setRestauranteService(IRestaurantesService restauranteService) {
	this.restauranteService = restauranteService;
    }

}
