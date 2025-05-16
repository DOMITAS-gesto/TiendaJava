/**
 * Clase principal para demostrar todo el sistema
 */
public class Main {
    public static void main(String[] args) {
        // Crear una tienda
        Tienda tienda = new Tienda("Mi Tienda de Electrónicos");

        // Ejecutar el escenario de venta
        tienda.realizarEscenarioVenta();
    }
}