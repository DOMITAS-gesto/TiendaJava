import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una tienda en el sistema.
 * Gestiona un inventario de productos y operaciones relacionadas.
 */
public class Tienda {
    private String nombre;
    private List<Producto> inventario;

    /**
     * Constructor que inicializa la tienda con un nombre
     * @param nombre Nombre de la tienda
     */
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    /**
     * Método para agregar un producto al inventario
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    /**
     * Método para listar todos los productos del inventario
     */
    public void listarProductos() {
        System.out.println("Inventario de " + nombre + ":");
        if (inventario.isEmpty()) {
            System.out.println("No hay productos en el inventario");
            return;
        }

        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }

    /**
     * Método para buscar un producto por su nombre
     * @param nombre Nombre del producto a buscar
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Ejemplo de escenario de venta
     */
    public void realizarEscenarioVenta() {
        // Crear productos para la tienda
        Producto laptop = new Producto("Laptop", 1200.0, 10);
        Producto celular = new Producto("Celular", 500.0, 20);
        Producto tablet = new Producto("Tablet", 300.0, 15);

        // Agregar productos a la tienda
        agregarProducto(laptop);
        agregarProducto(celular);
        agregarProducto(tablet);

        // Crear un cliente
        Cliente cliente = new Cliente("Juan Pérez", "juan@example.com");

        // Mostrar inventario inicial
        System.out.println("\n--- Inventario Inicial ---");
        listarProductos();

        // Cliente realiza compras
        System.out.println("\n--- Realizando Compras ---");
        cliente.realizarCompra(this, "Laptop", 2);
        cliente.realizarCompra(this, "Celular", 1);

        // Intento de compra con cantidad no disponible
        cliente.realizarCompra(this, "Tablet", 20);

        // Mostrar inventario actualizado
        System.out.println("\n--- Inventario Actualizado ---");
        listarProductos();

        // Mostrar historial de compras del cliente
        System.out.println("\n--- Historial de Compras ---");
        cliente.mostrarHistorialCompras();

        // Reabastecer un producto
        System.out.println("\n--- Reabastecimiento ---");
        Producto reabastecerTablet = buscarProducto("Tablet");
        if (reabastecerTablet != null) {
            reabastecerTablet.reabastecer(10);
        }

        // Mostrar inventario final
        System.out.println("\n--- Inventario Final ---");
        listarProductos();
    }
}
