package es.us.master.api.rest.usuarios.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.us.master.base.usuario.model.Usuario;
import es.us.master.base.usuario.service.IUsuarioService;

@RestController
public class UsuariosController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public List<Usuario> hello() {
		return getUsuarioService().getUsers();
	}
	
	@RequestMapping(value = "/login/{usuario}/{contrasena}", method = RequestMethod.GET)
	public Usuario login(@PathVariable String usuario, @PathVariable String contrasena) {
		return getUsuarioService().getLogin(usuario, contrasena);
	}
	
	
	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
