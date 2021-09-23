package pe.edu.upc.dao;
import java.util.List;
 
import pe.edu.upc.entities.Usuario;
public interface IUsuarioDao {
		public void insert(Usuario usur);
		public List<Usuario> list();
		public void eliminar(int idUsuario);

		public List<Usuario> finByNameUsuario(Usuario us);
}
