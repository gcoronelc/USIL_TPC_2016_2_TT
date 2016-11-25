package pe.usil.prueba;

import java.util.List;
import pe.usil.model.Producto;
import pe.usil.service.ProductoService;

public class Prueba02 {

    public static void main(String[] args) {
        try {
            Producto bean = new Producto();
            bean.setCodigo(1);

            ProductoService service = new ProductoService();
            List<Producto> lista = service.leerProducto(bean);

            for (Producto p : lista) {
                System.out.println(p.getCodigo() + " | " + p.getNombre() + " | " + p.getCategoria()
                        + " | " + p.getDescripcion() + " | " + p.getPrecio() + " | " + p.getStock() + " | " + p.getEstado());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
