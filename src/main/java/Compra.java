import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase auxiliar que representa una compra individual en el historial del cliente
 */
public class Compra {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private LocalDateTime fechaCompra;

    public Compra(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaCompra = LocalDateTime.now();
    }

    public double getTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fechaCompra.format(formatter) + " - " +
                producto.getNombre() + " x" + cantidad +
                " ($" + precioUnitario + " c/u) = $" + getTotal();
    }
}