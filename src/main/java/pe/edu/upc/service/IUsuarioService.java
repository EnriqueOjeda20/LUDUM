package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService {
	public void insert(Usuario uc);

	public void eliminar(int codigoUsuario);

	List<Usuario> list();

	public List<Usuario> finByNameUsuario(Usuario ucc);
}
