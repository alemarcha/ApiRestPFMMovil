package es.us.master.base.usuario.service;

import java.util.List;

import es.us.master.base.usuario.model.Usuario;

public interface IUsuarioService {
	
	/**
	 * Devuelve todos los usuarios de la base de datos.
	 * @return
	 */
	List<Usuario> getUsers();
	
	/**
	 * Devuelve un usuario si existe con ese nombre de usuario y contraseña
	 * @param usuario
	 * @param contrasena
	 * @return
	 */
	Usuario getLogin(String usuario, String contrasena);
	
	/**
	 * Añade un usuario a la tabla usuario(Registro)
	 * @param usuario
	 * @return
	 */
	boolean addUser(Usuario usuario);
}
