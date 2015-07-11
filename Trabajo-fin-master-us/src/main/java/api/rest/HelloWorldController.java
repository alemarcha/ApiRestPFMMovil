package api.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.us.master.restaurantes.model.HitsDTO;
import es.us.master.restaurantes.model.RestauranteJSONGeneralDTO;
import es.us.master.restaurantes.model.Restaurantes;
import es.us.master.restaurantes.service.IRestaurantesService;
import es.us.master.usuario.model.Usuario;
import es.us.master.usuario.service.IUsuarioService;

@RestController
public class HelloWorldController {
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IRestaurantesService restauranteService;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public List<Usuario> hello() {
		return getUsuarioService().getUsers();
		

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
