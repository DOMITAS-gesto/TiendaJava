// Archivo: GestionTiendaGUI.java
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para la interfaz gráfica de gestión de tienda
 * Implementa una ventana con formulario de registro de productos y
 * una tabla para visualizar y gestionar los productos registrados
 */
public class GestionTiendaGUI extends JFrame {

    // Componentes de la interfaz
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JButton btnGuardar;
    private JButton btnEliminar;

    // Lista de productos
    private List<Producto> listaProductos;

    /**
     * Constructor que inicializa la ventana y sus componentes
     */
    public GestionTiendaGUI() {
        // Configuración básica de la ventana
        setTitle("Gestión de Tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Inicializar la lista de productos
        listaProductos = new ArrayList<>();

        // Configurar el layout principal
        setLayout(new BorderLayout(10, 10));

        // Crear y agregar los componentes
        crearPanelFormulario();
        crearPanelTabla();

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * Crea el panel de formulario para registro de productos
     */
    private void crearPanelFormulario() {
        // Panel contenedor con BorderLayout
        JPanel panelForm = new JPanel(new BorderLayout(10, 10));
        panelForm.setBorder(new EmptyBorder(20, 20, 10, 20));

        // Título del formulario
        JLabel lblTitulo = new JLabel("Registro de Nuevo Producto");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelForm.add(lblTitulo, BorderLayout.NORTH);

        // Panel para los campos de texto con GridLayout
        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 10, 10));

        // Campo Nombre
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelCampos.add(txtNombre);

        // Campo Precio
        panelCampos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField(10);
        panelCampos.add(txtPrecio);

        // Campo Cantidad
        panelCampos.add(new JLabel("Cantidad Disponible:"));
        txtCantidad = new JTextField(10);
        panelCampos.add(txtCantidad);

        panelForm.add(panelCampos, BorderLayout.CENTER);

        // Panel para el botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnGuardar = new JButton("Guardar Producto");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
        panelBoton.add(btnGuardar);
        panelForm.add(panelBoton, BorderLayout.SOUTH);

        // Agregar el panel de formulario al norte de la ventana principal
        add(panelForm, BorderLayout.NORTH);
    }

    /**
     * Crea el panel con la tabla de productos
     */
    private void crearPanelTabla() {
        // Panel contenedor
        JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
        panelTabla.setBorder(new EmptyBorder(10, 20, 20, 20));

        // Título de la tabla
        JLabel lblTitulo = new JLabel("Productos Registrados");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelTabla.add(lblTitulo, BorderLayout.NORTH);

        // Crear modelo de tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");

        // Crear tabla con el modelo
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Scroll pane para la tabla
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        panelTabla.add(scrollPane, BorderLayout.CENTER);

        // Panel para el botón eliminar
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnEliminar = new JButton("Eliminar Producto");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
        panelBotones.add(btnEliminar);
        panelTabla.add(panelBotones, BorderLayout.SOUTH);

        // Agregar el panel de tabla al centro de la ventana principal
        add(panelTabla, BorderLayout.CENTER);
    }

    /**
     * Método para guardar un nuevo producto desde el formulario
     */
    private void guardarProducto() {
        // Obtener datos del formulario
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();

        // Validar que no haya campos vacíos
        if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convertir y validar valores numéricos
            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            // Validar que sean valores positivos
            if (precio <= 0 || cantidad <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El precio y la cantidad deben ser valores positivos",
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el producto
            Producto producto = new Producto(nombre, precio, cantidad);
            listaProductos.add(producto);

            // Imprimir en consola
            System.out.println("Producto registrado:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: $" + precio);
            System.out.println("Cantidad: " + cantidad);

            // Agregar a la tabla
            Object[] fila = {listaProductos.size(), nombre, "$" + precio, cantidad};
            modeloTabla.addRow(fila);

            // Limpiar el formulario
            limpiarFormulario();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this,
                    "Producto guardado correctamente",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            // Error al convertir los valores numéricos
            JOptionPane.showMessageDialog(this,
                    "El precio y la cantidad deben ser valores numéricos",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para eliminar el producto seleccionado de la tabla
     */
    private void eliminarProducto() {
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tablaProductos.getSelectedRow();

        // Validar que haya una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un producto para eliminar",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar de la lista de productos (debemos ajustar por el índice real)
            int idProducto = filaSeleccionada; // En este caso simple, la fila corresponde al índice

            if (idProducto >= 0 && idProducto < listaProductos.size()) {
                Producto producto = listaProductos.get(idProducto);
                System.out.println("Eliminando producto: " + producto.getNombre());

                // Eliminar de la lista
                listaProductos.remove(idProducto);

                // Eliminar de la tabla
                modeloTabla.removeRow(filaSeleccionada);

                // Actualizar los IDs en la tabla (opcional)
                actualizarIDsTabla();
            }
        }
    }

    /**
     * Actualiza los IDs de los productos en la tabla después de una eliminación
     */
    private void actualizarIDsTabla() {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.setValueAt(i + 1, i, 0);
        }
    }

    /**
     * Limpia los campos del formulario
     */
    private void limpiarFormulario() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtNombre.requestFocus();
    }

    /**
     * Método principal para ejecutar la aplicación
     */
    public static void main(String[] args) {
        // Establecer el look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear la ventana en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionTiendaGUI();
            }
        });
    }
}