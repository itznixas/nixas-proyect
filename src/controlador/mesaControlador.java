package controlador;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import modelo.dataBase;
import modelo.mesasDAO;
import vista.MenuAdmin;

public class mesaControlador {

    private JButton btnMesa1;
    private JButton btnMesa2;
    private JButton btnMesa3;
    private JButton btnMesa4;
    private JButton btnMesa5;
    private JButton btnMesa6;
    private JButton btnActuaMesa;
    private boolean ocupado = false;
    private mesasDAO mesasDAO;
    private Connection connection;

    public mesaControlador(JButton btnMesa1, JButton btnMesa2, JButton btnMesa3, JButton btnMesa4, JButton btnMesa5, JButton btnMesa6, mesasDAO mesasDAO) {
        this.btnMesa1 = btnMesa1;
        this.btnMesa2 = btnMesa2;
        this.btnMesa3 = btnMesa3;
        this.btnMesa4 = btnMesa4;
        this.btnMesa5 = btnMesa5;
        this.btnMesa6 = btnMesa6;
        this.mesasDAO = mesasDAO;

        // Crear una instancia de DataBase
        dataBase db = new dataBase();

// Obtener la conexión
        Connection connection = db.getConnection();

        btnMesa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa1.setBackground(Color.GREEN);
                    btnMesa1.setForeground(Color.WHITE);
                    btnMesa1.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 1, "Libre"); // Actualizar estado en la base de datos
                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa1.setBackground(Color.RED);
                    btnMesa1.setForeground(Color.WHITE);
                    btnMesa1.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 1, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });

        btnMesa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa2.setBackground(Color.GREEN);
                    btnMesa2.setForeground(Color.WHITE);
                    btnMesa2.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 2, "Libre"); // Actualizar estado en la base de datos
                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa2.setBackground(Color.RED);
                    btnMesa2.setForeground(Color.WHITE);
                    btnMesa2.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 2, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });

        btnMesa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa3.setBackground(Color.GREEN);
                    btnMesa3.setForeground(Color.WHITE);
                    btnMesa3.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 3, "Libre"); // Actualizar estado en la base de datos
                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa3.setBackground(Color.RED);
                    btnMesa3.setForeground(Color.WHITE);
                    btnMesa3.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 3, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });

        btnMesa4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa4.setBackground(Color.GREEN);
                    btnMesa4.setForeground(Color.WHITE);
                    btnMesa4.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 4, "Libre"); // Actualizar estado en la base de datos

                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa4.setBackground(Color.RED);
                    btnMesa4.setForeground(Color.WHITE);
                    btnMesa4.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 4, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });

        btnMesa5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa5.setBackground(Color.GREEN);
                    btnMesa5.setForeground(Color.WHITE);
                    btnMesa5.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 5, "Libre"); // Actualizar estado en la base de datos
                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa5.setBackground(Color.RED);
                    btnMesa5.setForeground(Color.WHITE);
                    btnMesa5.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 5, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });

        btnMesa6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ocupado) {
                    // Cambiar a estado Libre y actualizar en la base de datos
                    btnMesa6.setBackground(Color.GREEN);
                    btnMesa6.setForeground(Color.WHITE);
                    btnMesa6.setText("Libre");
                    ocupado = false;
                    mesasDAO.actualizarEstadoMesa(connection, 6, "Libre"); // Actualizar estado en la base de datos
                } else {
                    // Cambiar a estado Ocupado y actualizar en la base de datos
                    btnMesa6.setBackground(Color.RED);
                    btnMesa6.setForeground(Color.WHITE);
                    btnMesa6.setText("Ocupado");
                    ocupado = true;
                    mesasDAO.actualizarEstadoMesa(connection, 6, "Ocupado"); // Actualizar estado en la base de datos
                }
            }
        });
    }

    public void cargarEstadosIniciales() {
        dataBase db = new dataBase();
        Connection connection = db.getConnection();

        if (connection != null) {
            mesasDAO mesasDao = new mesasDAO();

            // Actualizar el estado de cada mesa en la base de datos al iniciar la aplicación
            actualizarEstadoMesaEnBD(connection, 1, "ocupado"); // Ejemplo: establecer la primera mesa como ocupada
            actualizarEstadoMesaEnBD(connection, 2, "libre"); // Ejemplo: establecer la segunda mesa como libre
            // Repetir para otras mesas...

            System.out.println("Estados iniciales de las mesas actualizados en la base de datos.");
        } else {
            System.out.println("Error al establecer la conexión.");
        }
    }

    private void actualizarEstadoMesaEnBD(Connection connection, int idMesa, String estado) {
        mesasDAO.actualizarEstadoMesa(connection, idMesa, estado);
    }

//    public void cargarEstadoMesas() {
//        dataBase db = new dataBase();
//        Connection connection = db.getConnection();
//
//        if (connection != null) {
//            mesasDAO = new mesasDAO(connection);
//            // Obtener el estado de cada mesa de la base de datos y actualizar los botones
//            boolean estadoMesa1 = mesasDAO.obtenerEstadoMesa(1);
//            actualizarBoton(btnMesa1, estadoMesa1);
//
//            // Repetir para otras mesas...
//        } else {
//            System.out.println("Error al establecer la conexión.");
//        }
//    }
    public void cargarEstadoMesas2() {
        dataBase db = new dataBase();
        Connection connection = db.getConnection();

        if (connection != null) {
            mesasDAO = new mesasDAO(connection);

            // Obtener el estado de cada mesa de la base de datos y actualizar los botones
            boolean estadoMesa1 = mesasDAO.obtenerEstadoMesa(1);
            actualizarBoton(btnMesa1, estadoMesa1);

            boolean estadoMesa2 = mesasDAO.obtenerEstadoMesa(2);
            actualizarBoton(btnMesa2, estadoMesa2);

            boolean estadoMesa3 = mesasDAO.obtenerEstadoMesa(3);
            actualizarBoton(btnMesa3, estadoMesa3);

            boolean estadoMesa4 = mesasDAO.obtenerEstadoMesa(4);
            actualizarBoton(btnMesa4, estadoMesa4);

            boolean estadoMesa5 = mesasDAO.obtenerEstadoMesa(5);
            actualizarBoton(btnMesa5, estadoMesa5);

            boolean estadoMesa6 = mesasDAO.obtenerEstadoMesa(6);
            actualizarBoton(btnMesa6, estadoMesa6);
        } else {
            System.out.println("Error al establecer la conexión.");
        }
    }

    private void actualizarBoton(JButton boton, boolean ocupado) {
        if (ocupado) {
            boton.setBackground(Color.RED);
            boton.setForeground(Color.WHITE);
            boton.setText("Ocupado");
        } else {
            boton.setBackground(Color.GREEN);
            boton.setForeground(Color.WHITE);
            boton.setText("Libre");
        }
    }

    private void actualizarEstadoBoton(JButton boton, int idMesa) throws SQLException {
        if (ocupado) {
            MenuAdmin admin = new MenuAdmin();
            boton.setBackground(Color.GREEN);
            boton.setForeground(Color.WHITE);
            boton.setText("Libre");
            ocupado = false;
            mesasDAO.actualizarEstadoMesa(idMesa, "Libre"); // Actualizar estado en la base de datos
            listarMesas(admin.tblEleccionMesa);
        } else {
            MenuAdmin admin = new MenuAdmin();
            boton.setBackground(Color.RED);
            boton.setForeground(Color.WHITE);
            boton.setText("Ocupado");
            ocupado = true;
            mesasDAO.actualizarEstadoMesa(idMesa, "Ocupado"); // Actualizar estado en la base de datos
            listarMesas(admin.tblEleccionMesa);
        }
    }

    public void listarMesas(JTable tblEleccionMesa) throws SQLException {

    }
}
