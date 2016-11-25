package MegaStore.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import MegaStore.db.AccesoDB;
import MegaStore.model.Promocion;
import MegaStore.service.espec.PromocionServiceEspec;
import MegaStore.service.mapper.PromocionMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class PromocionServiceImpl implements PromocionServiceEspec {

  @Override
  public List<Promocion> getPromociones(int idprod) {
    List<Promocion> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idprom, fecinicio, fecfin, idprod, nombre, pactual, precio, oferta, estado, anulado from v_promocion where idprod=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idprod);
      ResultSet rs = pstm.executeQuery();
      PromocionMapper mapper = new PromocionMapper();
      while (rs.next()) {
        lista.add(mapper.mapRow(rs));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "Error en el proceso. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}
