/**
 * Clase que representa un producto en el sistema de la tienda.
 * Implementa la interfaz Vendible para asegurar que tenga el comportamiento requerido.
 */
public class Producto implements Vendible {
    // Atributos con modificadores de acceso adecuados
    private String nombre;          // Encapsulado - solo accesible mediante métodos
    private double precio;          // Encapsulado - solo accesible mediante métodos
    private int cantidadDisponible; // Encapsulado - solo accesible mediante métodos

    /**
     * Constructor que inicializa todos los atributos del producto
     * @param nombre Nombre del producto
     * @param precio Precio unitario del producto
     * @param cantidadDisponible Cantidad inicial en inventario
     */
    public Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Implementación del método vender de la interfaz Vendible
     * @param cantidad Número de unidades a vender
     * @return true si la venta fue exitosa, false si no hay suficiente stock
     */
    @Override
    public boolean vender(int cantidad) {
        // Control: verificar que la cantidad a vender sea válida y haya suficiente stock
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a vender debe ser mayor que cero");
            return false;
        }

        if (cantidad > cantidadDisponible) {
            System.out.println("Error: No hay suficiente stock disponible");
            return false;
        }

        // Actualizar el inventario
        cantidadDisponible -= cantidad;
        System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre);
        return true;
    }

    /**
     * Método para reabastecer el inventario del producto
     * @param cantidad Número de unidades a agregar al inventario
     * @return true si el reabastecimiento fue exitoso
     */
    public boolean reabastecer(int cantidad) {
        // Control: verificar que la cantidad a reabastecer sea válida
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a reabastecer debe ser mayor que cero");
            return false;
        }

        // Actualizar el inventario
        cantidadDisponible += cantidad;
        System.out.println("Reabastecimiento realizado: " + cantidad + " unidades de " + nombre);
        return true;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: $" + precio + ", Stock: " + cantidadDisponible;
    }
}
