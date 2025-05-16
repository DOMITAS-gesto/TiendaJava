/**
 * Ejemplo de una clase extendida de Cliente para demostrar
 * el acceso a miembros protected
 */
public class EjemploProtected extends Cliente {
    private int puntos;

    public EjemploProtected(String nombre, String correo) {
        super(nombre, correo);
        this.puntos = 0;
    }

    public void mostrarEstadisticasCompra() {
        // Acceso permitido a historialDeCompras porque es protected
        // y esta es una subclase de Cliente
        System.out.println("Cliente Premium: " + nombre);
        System.out.println("Total de compras: " + historialDeCompras.size());
    }
}