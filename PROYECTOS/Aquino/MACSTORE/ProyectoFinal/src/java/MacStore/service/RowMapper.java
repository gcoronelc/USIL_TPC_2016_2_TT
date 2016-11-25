package MacStore.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import MacStore.model.Campania;
import MacStore.model.Categoria;
import MacStore.model.Empleado;
import MacStore.model.Producto;
import MacStore.model.Promocion;
import MacStore.model.Usuario;


public class RowMapper {

    public Empleado EmpleadoToBean(ResultSet rs) throws SQLException {

        Empleado bean = new Empleado();
        bean.setCodigo(rs.getInt("idemp"));
        bean.setNombre(rs.getString("nombre"));
        bean.setApellido(rs.getString("apellido"));
        bean.setEmail(rs.getString("email"));
        bean.setTelefono(rs.getString("telefono"));
        bean.setDni(rs.getString("dni"));
        bean.setDireccion(rs.getString("direccion"));
        bean.setEstado(rs.getDouble("estado"));
        return bean;
    }

    public Usuario UsuarioToBean(ResultSet rs) throws SQLException {

        Usuario bean = new Usuario();
        bean.setCodigo(rs.getInt("idemp"));
        bean.setUsuario(rs.getString("usuario"));
        bean.setClave(rs.getString("clave"));
        bean.setEstado(rs.getDouble("estado"));
        return bean;
    }

    public Producto ProductoToBean(ResultSet rs) throws SQLException {

        Producto bean = new Producto();
        bean.setCodigo(rs.getInt("idprod"));
        bean.setCategoria(rs.getInt("idcat"));
        bean.setNombre(rs.getString("nombre"));
        bean.setDescripcion(rs.getString("descripcion"));
        bean.setPrecio(rs.getDouble("precio"));
        bean.setStock(rs.getInt("stock"));
        bean.setEstado(rs.getInt("estado"));
        return bean;
    }

    public Categoria CategoriaToBean(ResultSet rs) throws SQLException {

        Categoria bean = new Categoria();
        bean.setCodigo(rs.getInt("idcat"));
        bean.setNombre(rs.getString("nombre"));
        bean.setDescripcion(rs.getString("descripcion"));
        return bean;
    }

    public Promocion PromocionToBean(ResultSet rs) throws SQLException {

        Promocion bean = new Promocion();
        bean.setCodigo(rs.getInt("idprom"));
        bean.setFecInicio(rs.getString("fecInicio"));
        bean.setFecFin(rs.getString("fecFin"));
        bean.setPrecio(rs.getInt("precio"));
        bean.setOferta(rs.getInt("oferta"));
        bean.setIdprod(rs.getInt("idprod"));
        bean.setEstado(rs.getInt("estado"));
        bean.setAnulado(rs.getInt("anulado"));
        
        return bean;
    }
    
    public Campania CampaniaToBean(ResultSet rs) throws SQLException {

        Campania bean = new Campania();
        bean.setCodigo(rs.getInt("idcamp"));
        bean.setNombre(rs.getString("nombre"));
        bean.setDescripcion(rs.getString("descripcion"));
        bean.setFecInicio(rs.getString("fecInicio"));
        bean.setFecFin(rs.getString("fecFin"));
        bean.setEstado(rs.getInt("estado"));
        bean.setAnulado(rs.getInt("anulado"));
        return bean;
    }

}
