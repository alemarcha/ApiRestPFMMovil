package es.us.master.base.usuario.service;

import java.util.List;

import es.us.master.base.usuario.model.Usuario;

public interface IUsuarioService {
	
	/**
	 * Devuelve todos los usuarios de la base de datos.
	 * @return
	 */
	public List<Usuario> getUsers();
}
