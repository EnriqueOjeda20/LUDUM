package pe.edu.upc.dao;
import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioDao {
		public void insert(Usuario uc);
		public List<Usuario> list();
		public void eliminar(int codigoUsuario);
		public List<Usuario> finByNameUsuario(Usuario ucc);
}
