/**
 * Interfaz que define el comportamiento de un producto vendible.
 * Proporciona un contrato para implementar el método de venta.
 */
interface Vendible {
    /**
     * Método para vender una cantidad específica del producto
     * @param cantidad Número de unidades a vender
     * @return true si la venta fue exitosa, false si no hay suficiente stock
     */
    boolean vender(int cantidad);
}