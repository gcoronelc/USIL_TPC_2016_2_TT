package pe.usil.prueba;

import pe.usil.model.Producto;
import pe.usil.service.ProductoService;

public class Prueba03 {

    public static void main(String[] args) {
        try {
            Producto bean = new Producto();

            bean.setCategoria(1);
            bean.setNombre("Mas ");
            bean.setDescripcion("Hola");
            bean.setPrecio(15.00);
            bean.setStock(15);
            bean.setEstado(1);
            
            ProductoService service = new ProductoService();
            service.nuevo(bean);
            System.out.println("Producto insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
