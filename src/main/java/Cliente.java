import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un cliente en el sistema.
 * Almacena información personal y el historial de compras.
 */
public class Cliente {
    // Ejemplos de diferentes modificadores de acceso
    public String nombre;        // Accesible desde cualquier clase
    private String correo;       // Solo accesible dentro de esta clase
    protected List<Compra> historialDeCompras; // Accesible desde esta clase y subclases

    /**
     * Constructor que inicializa los atributos del cliente
     * @param nombre Nombre del cliente
     * @param correo Correo electrónico del cliente
     */
    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.historialDeCompras = new ArrayList<>();
    }

    /**
     * Método para realizar una compra en la tienda
     * @param tienda Tienda donde realizar la compra
     * @param nombreProducto Nombre del producto a comprar
     * @param cantidad Cantidad de unidades a comprar
     * @return true si la compra fue exitosa
     */
    public boolean realizarCompra(Tienda tienda, String nombreProducto, int cantidad) {
        Producto producto = tienda.buscarProducto(nombreProducto);

        if (producto == null) {
            System.out.println("Producto no encontrado en la tienda");
            return false;
        }

        boolean ventaExitosa = producto.vender(cantidad);

        if (ventaExitosa) {
            // Registrar la compra en el historial
            Compra nuevaCompra = new Compra(producto, cantidad, producto.getPrecio());
            historialDeCompras.add(nuevaCompra);
            System.out.println("Compra registrada para " + this.nombre);
            return true;
        }

        return false;
    }

    /**
     * Método para mostrar el historial de compras del cliente
     */
    public void mostrarHistorialCompras() {
        System.out.println("Historial de compras de " + nombre + ":");
        if (historialDeCompras.isEmpty()) {
            System.out.println("No hay compras registradas");
            return;
        }

        double total = 0;
        for (Compra compra : historialDeCompras) {
            System.out.println(compra);
            total += compra.getTotal();
        }

        System.out.println("Total gastado: $" + total);
    }

    // Ejemplo de método getter para acceder a un atributo privado
    public String getCorreo() {
        return correo;
    }

    // Ejemplo de método setter para modificar un atributo privado
    public void setCorreo(String correo) {
        // Podríamos agregar validación aquí
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        } else {
            System.out.println("Formato de correo inválido");
        }
    }
}