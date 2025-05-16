/**
 * Clase principal para demostrar el punto 8: ¿Qué pasa si se intenta acceder a un atributo private?
 */
public class AccesoPrivado {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("María López", "maria@example.com");

        // Esto compila porque nombre es public
        System.out.println("Nombre: " + cliente.nombre);

        // Esto NO compilaría porque correo es private
        // System.out.println("Correo: " + cliente.correo); // Error de compilación

        // Forma correcta de acceder al atributo privado es mediante un getter
        System.out.println("Correo: " + cliente.getCorreo());

        // Acceso a atributo protected desde otra clase (no subclase)
        // tampoco está permitido directamente
        // System.out.println(cliente.historialDeCompras); // Error de compilación
    }
}
