package es.us.master.api.rest.restaurantes.web.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.us.master.base.restaurantes.model.HitsDTO;
import es.us.master.base.restaurantes.model.RestauranteJSONGeneralDTO;
import es.us.master.base.restaurantes.model.Restaurantes;
import es.us.master.base.restaurantes.service.IRestaurantesService;
import es.us.master.base.usuario.model.Usuario;
import es.us.master.base.usuario.service.IUsuarioService;

@RestController
public class RestaurantesController {
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IRestaurantesService restauranteService;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public List<Usuario> hello() {
		return getUsuarioService().getUsers();
		

	}
	
	@RequestMapping(value = "/restaurantes", method = RequestMethod.GET)
	public List<Restaurantes> getRestaurantes() {
		return getRestauranteService().getRestaurantes();
	}
	
	@RequestMapping(value = "/restaurantesPorCercaniaLatLong/{lat}/{longitud}/{dist}", method = RequestMethod.GET)
	public List<Restaurantes> getRestaurantesLatLong(@PathVariable double lat,@PathVariable double longitud, @PathVariable double dist) {
		return getRestauranteService().getRestaurantesLatLongDistancia(lat,longitud,dist);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void addRestaurants(){
		BufferedReader reader = null;
	    	URL url;
			try {
				url = new URL("http://jesusvargas.ddns.net:8082/restaurants?size=130000&loc=37,-1&distance=200000km");
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 
		        ObjectMapper mapper = new ObjectMapper();
		        
				RestauranteJSONGeneralDTO r=mapper.readValue(url, RestauranteJSONGeneralDTO.class);
				Restaurantes restaurante=new Restaurantes();
				for (HitsDTO h : r.hits) {
					BeanUtils.copyProperties(h.get_source(), restaurante);
					String []latLong=h.get_source().locale.split(",");
					restaurante.setLatitud(latLong[0]);
					restaurante.setLongitud(latLong[1]);
					getRestauranteService().nuevoRestaurante(restaurante);
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
	
	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public IRestaurantesService getRestauranteService() {
		return restauranteService;
	}

	public void setRestauranteService(IRestaurantesService restauranteService) {
		this.restauranteService = restauranteService;
	}

}
