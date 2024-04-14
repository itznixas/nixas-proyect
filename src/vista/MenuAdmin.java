package vista;

import com.formdev.flatlaf.*;
import componentes.TextField;
import modelo.*;
import modelo.mesasDAO;
import appnixas.IconoNixas;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import componentes.alert.Notification;
import controlador.mesaControlador;
import java.awt.FontFormatException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import controlador.loginCtrl;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MenuAdmin extends javax.swing.JFrame {

    DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
    private Connection connection;

    public MenuAdmin() {
        initComponents();
        IconoNixas.establecerIcono(this);

        //jmiProductos.setEnabled(false);
        TablaRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        //Tabla Clientes

        tblClientes.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblClientes.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblClientes.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblClientes.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblClientes.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        tblClientes.getColumnModel().getColumn(5).setCellRenderer(TablaRenderer);

        //Tabla Empleados
        tblEmpleados.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblEmpleados.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblEmpleados.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblEmpleados.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblEmpleados.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        tblEmpleados.getColumnModel().getColumn(5).setCellRenderer(TablaRenderer);

        //Tabla Inventario
        tblInventario.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblInventario.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblInventario.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblInventario.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblInventario.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);

        tblEleccionMesa.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblEleccionMesa.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);

        tblEleccionMesa.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblEleccionMesa.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblEleccionMesa.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);

        tblPedidoPendiente.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(5).setCellRenderer(TablaRenderer);
        tblPedidoPendiente.getColumnModel().getColumn(6).setCellRenderer(TablaRenderer);

        tblPedidoListo.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(5).setCellRenderer(TablaRenderer);
        tblPedidoListo.getColumnModel().getColumn(6).setCellRenderer(TablaRenderer);

        tblFactura.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        tblFactura.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        tblFactura.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tblFactura.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tblFactura.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        tblFactura.getColumnModel().getColumn(5).setCellRenderer(TablaRenderer);

        regEmpleado reG = new regEmpleado() {
        };
        regEmpleadoDAO emD = new regEmpleadoDAO();
        int rol = emD.autenticacionRol(reG);
        lblRoles.setText(Integer.toString(rol));

        this.connection = connection; // Asigna la conexión
        mesasDAO mesasDao = new mesasDAO(connection);
        mesaControlador controller = new mesaControlador(btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5, btnMesa6, mesasDao);
        controller.cargarEstadoMesas2();
    }
    regEmpleado cliente = new regEmpleado() {
    };
    clienteDAO cliD = new clienteDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblRoles = new javax.swing.JLabel();
        jPanelRound1 = new LIB.JPanelRound();
        jLabel22 = new javax.swing.JLabel();
        jPanelRound2 = new LIB.JPanelRound();
        jLabel25 = new javax.swing.JLabel();
        jPanelRound3 = new LIB.JPanelRound();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        btnAggPedidos = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        txtCantidadProPed = new componentes.TextField();
        txtNomProducPed = new componentes.TextField();
        txtMesaId = new componentes.TextField();
        jcbMesero = new javax.swing.JComboBox<>();
        btnActuaMesa = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblEleccionMesa = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPedidoPendiente = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblPedidoListo = new javax.swing.JTable();
        txtPedidoListo = new componentes.TextField();
        btnCkeckIn = new javax.swing.JButton();
        txtIdPedidoConse = new componentes.TextField();
        btnPedidosListo = new javax.swing.JButton();
        btnActuaTabPenPet = new javax.swing.JButton();
        cmbComidas = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanelTransparente1 = new LIB.JPanelTransparente();
        jLabel3 = new javax.swing.JLabel();
        txtNombreC = new componentes.TextField();
        txtApellidoC = new componentes.TextField();
        txtDireccionC = new componentes.TextField();
        txtCedulaC = new componentes.TextField();
        txtTelefonoC = new componentes.TextField();
        btnAgregarC = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanelTransparente2 = new LIB.JPanelTransparente();
        txtNombreE = new componentes.TextField();
        txtApellidoE = new componentes.TextField();
        txtDocE = new componentes.TextField();
        txtCelE = new componentes.TextField();
        txtUserE = new componentes.TextField();
        cmbEmpleado = new javax.swing.JComboBox<>();
        btnAgregarEm = new javax.swing.JButton();
        txtClaveE = new componentes.TextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanelTransparente4 = new LIB.JPanelTransparente();
        jLabel24 = new javax.swing.JLabel();
        txtCantidadP = new componentes.TextField();
        txtPrecioP = new componentes.TextField();
        txtNombreP = new componentes.TextField();
        btnPorcion = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        cmbPorcion = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnConsultaCL = new javax.swing.JButton();
        btnEliminarClie = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtConsulatCL = new componentes.TextField();
        txtApellidoConsuCli = new componentes.TextField();
        txtDireccionConsuCli = new componentes.TextField();
        txtIdConsuCli = new componentes.TextField();
        txtTelefonoConsuCli = new componentes.TextField();
        btnActbCli = new javax.swing.JButton();
        txtNombreConsCli = new componentes.TextField();
        jButton8 = new javax.swing.JButton();
        txtCedulaConsuCli1 = new componentes.TextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnConsultarEm = new javax.swing.JButton();
        btnEliminarEmp = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtConsultarEm = new componentes.TextField();
        txtIdConsuEmpl = new componentes.TextField();
        txtCedulaConseEmpl = new componentes.TextField();
        txtUserConsuEmpl = new componentes.TextField();
        txtTelefonoConsuEmpl = new componentes.TextField();
        btnModificarEmpl = new javax.swing.JButton();
        btnActblE = new javax.swing.JButton();
        txtNombreConsuEmpl = new componentes.TextField();
        txtClaveConsuEmpl = new componentes.TextField();
        jcmRConsuEmpl = new javax.swing.JComboBox<>();
        txtApellidoConuEmpl = new componentes.TextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        btnAggProInv = new javax.swing.JButton();
        btnEliminarConsu = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        txtConsultarInventario = new componentes.TextField();
        txtCanProdInv = new componentes.TextField();
        btnActualizarInv = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        txtNomProdInv = new componentes.TextField();
        btnConsuInventario = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanelTransparente3 = new LIB.JPanelTransparente();
        jLabel23 = new javax.swing.JLabel();
        txtIdClienteFac = new componentes.TextField();
        txtIdCajeroFac = new componentes.TextField();
        txtIdMesero = new componentes.TextField();
        txtMetodoPago = new componentes.TextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        txtDescuentoFac = new componentes.TextField();
        txtApeMeseroFac = new componentes.TextField();
        txtNomCliFac = new componentes.TextField();
        txtApeCajeroFac = new componentes.TextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblFacturaEleccipn = new javax.swing.JTable();
        btnActualizarFactura = new javax.swing.JButton();
        txtNumFacturaDet = new componentes.TextField();
        txtProductoDet = new componentes.TextField();
        txtCantProdDet = new componentes.TextField();
        txtPrecioUniDet = new componentes.TextField();
        btnFacturar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblTotalFinal = new javax.swing.JLabel();
        txtApeClintFac = new componentes.TextField();
        txtNomClintFac = new componentes.TextField();
        txtNomMeseroFac = new componentes.TextField();
        txtNomCajeroFac = new componentes.TextField();
        txtProdStock = new componentes.TextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnMesa6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnMesa3 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa1 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNomProducPed1 = new componentes.TextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNomProducPed2 = new componentes.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiOrdenes = new javax.swing.JMenuItem();
        jmiClientes = new javax.swing.JMenuItem();
        jmiEmpleado = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiClienteConsu = new javax.swing.JMenuItem();
        jmiEmpleadoConsu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiCerrarSesion = new javax.swing.JMenu();
        moods = new javax.swing.JCheckBoxMenuItem();
        cerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkGradientFocus(1);
        kGradientPanel1.setkStartColor(new java.awt.Color(24, 42, 75));

        lblRoles.setText("ROL");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CLIENTES");

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel22)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("PRODUCTOS");

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel25)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel25)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("VENTAS");

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel26)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel26)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jPanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 70, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(lblRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 465, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Inicio", kGradientPanel1);

        jPanel26.setBackground(new java.awt.Color(41, 53, 87));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        jPanel32.setBackground(new java.awt.Color(61, 99, 157));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        jPanel33.setBackground(new java.awt.Color(61, 99, 157));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 230, -1));

        jPanel34.setBackground(new java.awt.Color(61, 99, 157));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        jPanel35.setBackground(new java.awt.Color(61, 99, 157));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        jPanel36.setBackground(new java.awt.Color(61, 99, 157));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        btnAggPedidos.setBackground(new java.awt.Color(41, 53, 87));
        btnAggPedidos.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAggPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnAggPedidos.setText("ADD");
        jPanel26.add(btnAggPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, 100, 33));

        jButton14.setBackground(java.awt.Color.red);
        jButton14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("DELETE");
        jPanel26.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 80, 100, 33));

        txtCantidadProPed.setHint("AMOUNT");
        txtCantidadProPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadProPedActionPerformed(evt);
            }
        });
        txtCantidadProPed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadProPedKeyPressed(evt);
            }
        });
        jPanel26.add(txtCantidadProPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 160, 40));

        txtNomProducPed.setHint("NAME OF PRODUCTS");
        jPanel26.add(txtNomProducPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 200, 40));

        txtMesaId.setHint("TABLE");
        jPanel26.add(txtMesaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 97, 40));

        jcbMesero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WAITERS", "" }));
        jcbMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMeseroActionPerformed(evt);
            }
        });
        jPanel26.add(jcbMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 260, 40));

        btnActuaMesa.setBackground(new java.awt.Color(41, 37, 87));
        btnActuaMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnActuaMesa.setText("UPDATE");
        btnActuaMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuaMesaActionPerformed(evt);
            }
        });
        jPanel26.add(btnActuaMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, -1, 30));

        tblEleccionMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAME", "SM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEleccionMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEleccionMesaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblEleccionMesa);

        jPanel26.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 170, 180));

        tblPedidoPendiente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPedidoPendiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TABLE", "WAITER", "PRODUCT", "AMOUNT", "STATE", "TIME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidoPendiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoPendienteMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblPedidoPendiente);

        jPanel26.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 420, 400));

        tblPedidoListo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPedidoListo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TABLE", "WAITER", "PRODUCT", "AMOUNT", "STATE", "TIME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidoListo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoListoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblPedidoListo);

        jPanel26.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, 410, 400));

        txtPedidoListo.setHint("AMOUNT");
        txtPedidoListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedidoListoActionPerformed(evt);
            }
        });
        jPanel26.add(txtPedidoListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, 80, 30));

        btnCkeckIn.setBackground(new java.awt.Color(41, 37, 87));
        btnCkeckIn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnCkeckIn.setForeground(new java.awt.Color(255, 255, 255));
        btnCkeckIn.setText("CHECK IN");
        btnCkeckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCkeckInActionPerformed(evt);
            }
        });
        jPanel26.add(btnCkeckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 590, 100, 30));

        txtIdPedidoConse.setHint("AMOUNT");
        jPanel26.add(txtIdPedidoConse, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, -1, -1));

        btnPedidosListo.setBackground(new java.awt.Color(41, 37, 87));
        btnPedidosListo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPedidosListo.setForeground(new java.awt.Color(255, 255, 255));
        btnPedidosListo.setText("READY");
        jPanel26.add(btnPedidosListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, -1, 30));

        btnActuaTabPenPet.setBackground(new java.awt.Color(41, 37, 87));
        btnActuaTabPenPet.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnActuaTabPenPet.setForeground(new java.awt.Color(255, 255, 255));
        btnActuaTabPenPet.setText("UPDATE");
        jPanel26.add(btnActuaTabPenPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, -1, 30));

        cmbComidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmbComidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbComidasMouseClicked(evt);
            }
        });
        jPanel26.add(cmbComidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 30));

        jTabbedPane.addTab("Pedidos", jPanel26);

        jPanel4.setBackground(new java.awt.Color(24, 42, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CLIENTS REGISTRATION");

        txtNombreC.setHint("NAME");

        txtApellidoC.setHint("LAST NAME");

        txtDireccionC.setHint("ADDRESS");

        txtCedulaC.setHint("DNI");

        txtTelefonoC.setHint("PHONE NUMBER");

        btnAgregarC.setBackground(new java.awt.Color(41, 37, 87));
        btnAgregarC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarC.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarC.setText("ADD");
        btnAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTransparente1Layout = new javax.swing.GroupLayout(jPanelTransparente1);
        jPanelTransparente1.setLayout(jPanelTransparente1Layout);
        jPanelTransparente1Layout.setHorizontalGroup(
            jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(jPanelTransparente1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTelefonoC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtCedulaC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellidoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarC, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTransparente1Layout.setVerticalGroup(
            jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransparente1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanelTransparente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jPanel4.add(jPanelTransparente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 460, 560));

        jTabbedPane.addTab("Clientes", jPanel4);

        jPanel6.setBackground(new java.awt.Color(24, 42, 75));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreE.setHint("NAME");

        txtApellidoE.setHint("LAST NAME");

        txtDocE.setHint("DNI");

        txtCelE.setHint("PHONE NUMBER");

        txtUserE.setHint("USER");

        cmbEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmbEmpleado.setActionCommand("Seleccionar...\nCajero\nAdministrador");
        cmbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpleadoActionPerformed(evt);
            }
        });

        btnAgregarEm.setBackground(new java.awt.Color(41, 37, 87));
        btnAgregarEm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarEm.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEm.setText("ADD");

        txtClaveE.setHint("PASSWORD");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EMPLOYEES REGISTRATION");

        javax.swing.GroupLayout jPanelTransparente2Layout = new javax.swing.GroupLayout(jPanelTransparente2);
        jPanelTransparente2.setLayout(jPanelTransparente2Layout);
        jPanelTransparente2Layout.setHorizontalGroup(
            jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addGroup(jPanelTransparente2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDocE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTransparente2Layout.createSequentialGroup()
                        .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTransparente2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtApellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtClaveE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarEm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTransparente2Layout.setVerticalGroup(
            jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransparente2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClaveE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanelTransparente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarEm, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(cmbEmpleado))
                .addGap(114, 114, 114))
        );

        jPanel6.add(jPanelTransparente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 480, 570));

        jTabbedPane.addTab("Empleados", jPanel6);

        jPanel5.setBackground(new java.awt.Color(24, 42, 75));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("PRODUCTS");

        txtCantidadP.setHint("QUANTITY");

        txtPrecioP.setHint("PRICE");

        txtNombreP.setHint("NAME");

        btnPorcion.setBackground(new java.awt.Color(41, 37, 87));
        btnPorcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPorcion.setForeground(new java.awt.Color(255, 255, 255));
        btnPorcion.setText("ADD");

        jToggleButton2.setBackground(java.awt.Color.red);
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("CLOSE");

        cmbPorcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        javax.swing.GroupLayout jPanelTransparente4Layout = new javax.swing.GroupLayout(jPanelTransparente4);
        jPanelTransparente4.setLayout(jPanelTransparente4Layout);
        jPanelTransparente4Layout.setHorizontalGroup(
            jPanelTransparente4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransparente4Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanelTransparente4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelTransparente4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombreP, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(txtPrecioP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPorcion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTransparente4Layout.setVerticalGroup(
            jPanelTransparente4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransparente4Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cmbPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(txtCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(txtPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanelTransparente4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addComponent(jPanelTransparente4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(495, 495, 495))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanelTransparente4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Productos", jPanel5);

        jPanel10.setBackground(new java.awt.Color(24, 42, 75));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Last name", "DNI", "Address", "Phone number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClientes.setFocusable(false);
        tblClientes.setRowHeight(25);
        tblClientes.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblClientes);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 700, 490));

        btnConsultaCL.setBackground(new java.awt.Color(41, 37, 87));
        btnConsultaCL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaCL.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaCL.setText("SEARCH");
        jPanel10.add(btnConsultaCL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 100, 40));

        btnEliminarClie.setBackground(java.awt.Color.red);
        btnEliminarClie.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarClie.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarClie.setText("DELETE");
        jPanel10.add(btnEliminarClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 90, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CLIENTS");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, -1));

        txtConsulatCL.setHint("DNI");
        jPanel10.add(txtConsulatCL, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 370, 40));

        txtApellidoConsuCli.setHint("LAST NAME");
        jPanel10.add(txtApellidoConsuCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 140, -1));

        txtDireccionConsuCli.setHint("ADDRESS");
        jPanel10.add(txtDireccionConsuCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 130, -1));

        txtIdConsuCli.setHint("DNI");
        jPanel10.add(txtIdConsuCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 140, -1));

        txtTelefonoConsuCli.setHint("PHONE NUMBER");
        jPanel10.add(txtTelefonoConsuCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 130, -1));

        btnActbCli.setBackground(new java.awt.Color(41, 37, 87));
        btnActbCli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActbCli.setForeground(new java.awt.Color(255, 255, 255));
        btnActbCli.setText("UPDATE");
        btnActbCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActbCliActionPerformed(evt);
            }
        });
        jPanel10.add(btnActbCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 650, 120, -1));

        txtNombreConsCli.setHint("NAME");
        jPanel10.add(txtNombreConsCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, -1));

        jButton8.setBackground(new java.awt.Color(41, 37, 87));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("MODIFY");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 120, 30));

        txtCedulaConsuCli1.setHint("DNI");
        jPanel10.add(txtCedulaConsuCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 140, -1));

        jTabbedPane.addTab("Cons. Cliente", jPanel10);

        jPanel23.setBackground(new java.awt.Color(24, 42, 75));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEmpleados.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Last name", "DNI", "Phone number", "Rol", "User", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblEmpleados);

        jPanel23.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 820, 490));

        btnConsultarEm.setBackground(new java.awt.Color(41, 37, 87));
        btnConsultarEm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultarEm.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarEm.setText("SEARCH");
        jPanel23.add(btnConsultarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 100, 40));

        btnEliminarEmp.setBackground(java.awt.Color.red);
        btnEliminarEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarEmp.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmp.setText("DELETE");
        jPanel23.add(btnEliminarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 90, 40));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("EMPLOYEES");
        jPanel23.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, -1));

        txtConsultarEm.setEditable(false);
        txtConsultarEm.setHint("DNI");
        jPanel23.add(txtConsultarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 370, 40));

        txtIdConsuEmpl.setHint("LAST NAME");
        txtIdConsuEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdConsuEmplActionPerformed(evt);
            }
        });
        jPanel23.add(txtIdConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 140, -1));

        txtCedulaConseEmpl.setHint("DNI");
        jPanel23.add(txtCedulaConseEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, -1));

        txtUserConsuEmpl.setHint("USER");
        txtUserConsuEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserConsuEmplActionPerformed(evt);
            }
        });
        jPanel23.add(txtUserConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 130, -1));

        txtTelefonoConsuEmpl.setHint("PHONE NUMBER");
        jPanel23.add(txtTelefonoConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 140, -1));

        btnModificarEmpl.setBackground(new java.awt.Color(41, 37, 87));
        btnModificarEmpl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificarEmpl.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpl.setText("MODIFY");
        jPanel23.add(btnModificarEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 120, -1));

        btnActblE.setBackground(new java.awt.Color(41, 37, 87));
        btnActblE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActblE.setForeground(new java.awt.Color(255, 255, 255));
        btnActblE.setText("UPDATE");
        jPanel23.add(btnActblE, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 650, 120, -1));

        txtNombreConsuEmpl.setHint("NAME");
        jPanel23.add(txtNombreConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, -1));

        txtClaveConsuEmpl.setHint("PASSWORD");
        jPanel23.add(txtClaveConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 130, -1));

        jcmRConsuEmpl.setEditable(true);
        jcmRConsuEmpl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Cajero" }));
        jPanel23.add(jcmRConsuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 120, 30));

        txtApellidoConuEmpl.setHint("LAST NAME");
        jPanel23.add(txtApellidoConuEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 140, -1));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Cons. Empleados", jPanel17);

        jPanel24.setBackground(new java.awt.Color(24, 42, 75));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAggProInv.setBackground(new java.awt.Color(41, 37, 87));
        btnAggProInv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAggProInv.setForeground(new java.awt.Color(255, 255, 255));
        btnAggProInv.setText("MODIFY");
        btnAggProInv.setBorderPainted(false);
        btnAggProInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggProInvActionPerformed(evt);
            }
        });
        jPanel24.add(btnAggProInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 100, 30));

        btnEliminarConsu.setBackground(java.awt.Color.red);
        btnEliminarConsu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarConsu.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarConsu.setText("DELETE");
        jPanel24.add(btnEliminarConsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 90, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("INVENTORY");
        jPanel24.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 280, -1));

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Entrada", "Salida", "Fecha", "id_Entrada", "id_Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblInventario);

        jPanel24.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 830, 490));

        txtConsultarInventario.setHint("NAME");
        jPanel24.add(txtConsultarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 330, 40));

        txtCanProdInv.setHint("QUANTITY");
        jPanel24.add(txtCanProdInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 140, -1));

        btnActualizarInv.setBackground(new java.awt.Color(41, 37, 87));
        btnActualizarInv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarInv.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarInv.setText("UPDATE");
        jPanel24.add(btnActualizarInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 630, 120, 30));

        btnExcel.setBackground(new java.awt.Color(41, 37, 87));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("EXCEL");
        jPanel24.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 120, 30));

        txtNomProdInv.setHint("NAME");
        jPanel24.add(txtNomProdInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, -1));

        btnConsuInventario.setBackground(new java.awt.Color(41, 37, 87));
        btnConsuInventario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsuInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnConsuInventario.setText("SEARCH");
        jPanel24.add(btnConsuInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 60, 120, 30));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cons. Inventario", jPanel18);

        jPanel20.setBackground(new java.awt.Color(24, 42, 75));

        jPanelTransparente3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("BILLING");
        jPanelTransparente3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 64));

        txtIdClienteFac.setHint("CLIENTE DNI");
        txtIdClienteFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteFacActionPerformed(evt);
            }
        });
        jPanelTransparente3.add(txtIdClienteFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 110, -1));

        txtIdCajeroFac.setHint("CAJERO DNI");
        jPanelTransparente3.add(txtIdCajeroFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, -1));

        txtIdMesero.setHint("MESERO DNI");
        jPanelTransparente3.add(txtIdMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, -1));

        txtMetodoPago.setHint("METODO DE PAGO");
        jPanelTransparente3.add(txtMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 110, -1));

        jToggleButton1.setBackground(java.awt.Color.red);
        jToggleButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("DELETE");
        jPanelTransparente3.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 260, 124, 32));

        txtDescuentoFac.setHint("DESCUENTO");
        jPanelTransparente3.add(txtDescuentoFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 110, -1));

        txtApeMeseroFac.setHint("NAME");
        txtApeMeseroFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMeseroFacActionPerformed(evt);
            }
        });
        txtApeMeseroFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeMeseroFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtApeMeseroFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 112, -1));

        txtNomCliFac.setHint("ID PEDIDOS");
        txtNomCliFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomCliFacActionPerformed(evt);
            }
        });
        txtNomCliFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomCliFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtNomCliFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(932, 260, 120, -1));

        txtApeCajeroFac.setHint("NAME");
        txtApeCajeroFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeCajeroFacActionPerformed(evt);
            }
        });
        txtApeCajeroFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeCajeroFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtApeCajeroFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 112, -1));

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TABLE", "WAITER", "PRODUCT", "AMOUNT", "STATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblFactura);

        jPanelTransparente3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 70, 600, 180));

        tblFacturaEleccipn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FACTURA", "PRODUCTO", "CANTIDAD", "PRECIO U", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblFacturaEleccipn);

        jPanelTransparente3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 600, 180));

        btnActualizarFactura.setBackground(new java.awt.Color(41, 37, 87));
        btnActualizarFactura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarFactura.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarFactura.setText("ACTUALIZAR");
        btnActualizarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarFacturaActionPerformed(evt);
            }
        });
        jPanelTransparente3.add(btnActualizarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 124, 32));

        txtNumFacturaDet.setHint("ID FACTURA");
        jPanelTransparente3.add(txtNumFacturaDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 70, -1));

        txtProductoDet.setHint("NOMBRE");
        txtProductoDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoDetActionPerformed(evt);
            }
        });
        txtProductoDet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoDetKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtProductoDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 128, -1));

        txtCantProdDet.setHint("CANTIDAD");
        txtCantProdDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCantProdDetMouseEntered(evt);
            }
        });
        jPanelTransparente3.add(txtCantProdDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 320, 120, -1));

        txtPrecioUniDet.setHint("PRECIO");
        txtPrecioUniDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUniDetActionPerformed(evt);
            }
        });
        jPanelTransparente3.add(txtPrecioUniDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 110, -1));

        btnFacturar.setBackground(new java.awt.Color(41, 37, 87));
        btnFacturar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("FACTURAR");
        jPanelTransparente3.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 124, 32));

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total");
        jPanelTransparente3.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 140, -1));

        lblTotalFinal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTotalFinal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalFinal.setText("Monto");
        jPanelTransparente3.add(lblTotalFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 130, -1));

        txtApeClintFac.setHint("NAME");
        txtApeClintFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeClintFacActionPerformed(evt);
            }
        });
        txtApeClintFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeClintFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtApeClintFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 112, -1));

        txtNomClintFac.setHint("NAME");
        txtNomClintFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomClintFacActionPerformed(evt);
            }
        });
        txtNomClintFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomClintFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtNomClintFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 112, -1));

        txtNomMeseroFac.setHint("NAME");
        txtNomMeseroFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomMeseroFacActionPerformed(evt);
            }
        });
        txtNomMeseroFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomMeseroFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtNomMeseroFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 112, -1));

        txtNomCajeroFac.setHint("NAME");
        txtNomCajeroFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomCajeroFacActionPerformed(evt);
            }
        });
        txtNomCajeroFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomCajeroFacKeyPressed(evt);
            }
        });
        jPanelTransparente3.add(txtNomCajeroFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 112, -1));

        txtProdStock.setHint("CANTIDAD");
        txtProdStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtProdStockMouseEntered(evt);
            }
        });
        jPanelTransparente3.add(txtProdStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 120, -1));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanelTransparente3, javax.swing.GroupLayout.PREFERRED_SIZE, 1309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanelTransparente3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Factura", jPanel20);

        jPanel1.setBackground(new java.awt.Color(24, 42, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 276, 218));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 410, 276, 218));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 276, 218));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TABLE 6");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 430, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 276, 218));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 276, 218));

        btnMesa6.setBackground(java.awt.Color.green);
        btnMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa6.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa6.setText("Libre");
        jPanel1.add(btnMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 630, 240, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoMesas.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 276, 218));

        btnMesa3.setBackground(java.awt.Color.green);
        btnMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa3.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa3.setText("Libre");
        jPanel1.add(btnMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 240, 30));

        btnMesa2.setBackground(java.awt.Color.green);
        btnMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa2.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa2.setText("Libre");
        jPanel1.add(btnMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 240, 30));

        btnMesa1.setBackground(java.awt.Color.green);
        btnMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa1.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa1.setText("Libre");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 240, 30));

        btnMesa4.setBackground(java.awt.Color.green);
        btnMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa4.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa4.setText("Libre");
        jPanel1.add(btnMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 240, 30));

        btnMesa5.setBackground(java.awt.Color.green);
        btnMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa5.setForeground(new java.awt.Color(255, 255, 255));
        btnMesa5.setText("Libre");
        jPanel1.add(btnMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 240, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TABLE 1");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TABLE 2");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TABLE 3");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TABLE 4");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("TABLE 5");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, -1, -1));

        jTabbedPane.addTab("Mesas", jPanel1);

        jPanel2.setBackground(new java.awt.Color(41, 53, 87));

        jPanel3.setBackground(new java.awt.Color(41, 53, 87));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apertura y Cierre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNomProducPed1.setHint("Search");

        jButton1.setBackground(new java.awt.Color(41, 37, 87));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Abrir");

        jButton2.setBackground(new java.awt.Color(41, 37, 87));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cerrar");

        txtNomProducPed2.setHint("Monto Inicial");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(txtNomProducPed1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(284, Short.MAX_VALUE)
                    .addComponent(txtNomProducPed2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(361, 361, 361)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNomProducPed1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(46, Short.MAX_VALUE)
                    .addComponent(txtNomProducPed2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Saldo inicial", "Entrada", "Caja", "Valor actual", "Hora cierre", "Fecha cierre"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1093, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addGap(128, 128, 128))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedPane.addTab("Abrir-cerrar Caja", jPanel2);

        getContentPane().add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        MenuBar.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("ADD");

        jmiOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoAgregarPedidos.png"))); // NOI18N
        jmiOrdenes.setText("ORDERS");
        jMenu1.add(jmiOrdenes);

        jmiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoAgregarClientes.png"))); // NOI18N
        jmiClientes.setText("CLIENTS");
        jMenu1.add(jmiClientes);

        jmiEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoAgregarEmpleados.png"))); // NOI18N
        jmiEmpleado.setText("EMPLOYEES");
        jMenu1.add(jmiEmpleado);

        jmiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoAgregarProductos.png"))); // NOI18N
        jmiProductos.setText("PRODUCTS");
        jMenu1.add(jmiProductos);

        MenuBar.add(jMenu1);

        jMenu2.setText("SEARCH");

        jmiClienteConsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoBuscarClientes.png"))); // NOI18N
        jmiClienteConsu.setText("CLIENTS");
        jMenu2.add(jmiClienteConsu);

        jmiEmpleadoConsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoBuscarEmpleados.png"))); // NOI18N
        jmiEmpleadoConsu.setText("EMPLOYEES");
        jMenu2.add(jmiEmpleadoConsu);

        MenuBar.add(jMenu2);

        jMenu3.setText("INVENTORY");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoInventarioBuscar.png"))); // NOI18N
        jMenuItem7.setText("SEARCH");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoInventarioReporte.png"))); // NOI18N
        jMenuItem8.setText("REPORT");
        jMenu3.add(jMenuItem8);

        MenuBar.add(jMenu3);

        jMenu4.setText("BILLLING");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoFacturaGenerar.png"))); // NOI18N
        jMenuItem9.setText("GENERATE");
        jMenu4.add(jMenuItem9);

        MenuBar.add(jMenu4);

        jMenu5.setText("CAJA");
        MenuBar.add(jMenu5);

        jmiCerrarSesion.setText("EXIT");
        jmiCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiCerrarSesionMouseClicked(evt);
            }
        });

        moods.setSelected(true);
        moods.setText("MOOD");
        moods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moodsActionPerformed(evt);
            }
        });
        jmiCerrarSesion.add(moods);

        cerrar.setText("EXIT");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jmiCerrarSesion.add(cerrar);

        MenuBar.add(jmiCerrarSesion);

        setJMenuBar(MenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void iniciar() {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAdmin m = new MenuAdmin();
                try {
                    loginCtrl lx = new loginCtrl(m);
                } catch (FontFormatException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                m.setVisible(true);
            }
        });
    }


    private void jmiCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCerrarSesionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiCerrarSesionMouseClicked

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarActionPerformed

    private void moodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moodsActionPerformed
        // TODO add your handling code here:
        if (moods.isSelected()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacLightLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });

        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacDarkLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }
    }//GEN-LAST:event_moodsActionPerformed

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void txtProductoDetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoDetKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoDetKeyPressed

    private void txtProductoDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoDetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoDetActionPerformed

    private void btnActualizarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarFacturaActionPerformed

    private void txtIdClienteFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteFacActionPerformed

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblInventarioMouseClicked

    private void btnAggProInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggProInvActionPerformed
        // TODO add your handling code here:be
    }//GEN-LAST:event_btnAggProInvActionPerformed

    private void txtUserConsuEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserConsuEmplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserConsuEmplActionPerformed

    private void txtIdConsuEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdConsuEmplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdConsuEmplActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        // TODO add your handling code here:
        int fila = tblEmpleados.rowAtPoint(evt.getPoint());
        txtIdConsuEmpl.setText(tblEmpleados.getValueAt(fila, 0).toString());
        txtNombreConsuEmpl.setText(tblEmpleados.getValueAt(fila, 1).toString());
        txtApellidoConuEmpl.setText(tblEmpleados.getValueAt(fila, 2).toString());
        txtCedulaConseEmpl.setText(tblEmpleados.getValueAt(fila, 3).toString());
        txtTelefonoConsuEmpl.setText(tblEmpleados.getValueAt(fila, 4).toString());

        txtUserConsuEmpl.setText(tblEmpleados.getValueAt(fila, 6).toString());
        txtClaveConsuEmpl.setText(tblEmpleados.getValueAt(fila, 7).toString());

        txtConsultarEm.setText(tblEmpleados.getValueAt(fila, 3).toString());
        int fSeleccionada = tblEmpleados.getSelectedRow();
        int cSeleccionada = tblEmpleados.getSelectedColumn();

        String tituloColumna = tblEmpleados.getColumnName(cSeleccionada); // Obtener el título de la columna seleccionada

        // Verificar si la columna seleccionada tiene el título "Password"
        if (tituloColumna.equals("Password")) {
            // Verificar si se ha seleccionado una fila válida
            if (fSeleccionada != -1) {
                Object valorCelda = tblEmpleados.getValueAt(fSeleccionada, cSeleccionada);
                JOptionPane.showMessageDialog(null, "La verdadera contraseña es: " + new String(valorCelda.toString()));
            }
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnActbCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActbCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActbCliActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // TODO add your handling code here:
        int fila = tblClientes.rowAtPoint(evt.getPoint());
        txtIdConsuCli.setText(tblClientes.getValueAt(fila, 0).toString());
        txtNombreConsCli.setText(tblClientes.getValueAt(fila, 1).toString());
        txtApellidoConsuCli.setText(tblClientes.getValueAt(fila, 2).toString());
        txtIdConsuCli.setText(tblClientes.getValueAt(fila, 3).toString());
        txtTelefonoConsuCli.setText(tblClientes.getValueAt(fila, 4).toString());
        txtDireccionConsuCli.setText(tblClientes.getValueAt(fila, 5).toString());
        txtConsulatCL.setText(tblClientes.getValueAt(fila, 3).toString());

        // Aquí puedes usar la variable 'fila' como la fila seleccionada
        System.out.println("Fila seleccionada: " + fila);
    }//GEN-LAST:event_tblClientesMouseClicked

    private void cmbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmpleadoActionPerformed

    private void btnAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCActionPerformed

    private void btnCkeckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCkeckInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCkeckInActionPerformed

    private void txtPedidoListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedidoListoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedidoListoActionPerformed

    private void tblPedidoListoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoListoMouseClicked
        // TODO add your handling code here:
        int fila = tblPedidoListo.rowAtPoint(evt.getPoint());
        txtPedidoListo.setText(tblPedidoListo.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_tblPedidoListoMouseClicked

    private void tblPedidoPendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoPendienteMouseClicked
        // TODO add your handling code here:
        int fila = tblPedidoPendiente.rowAtPoint(evt.getPoint());
        txtIdPedidoConse.setText(tblPedidoPendiente.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_tblPedidoPendienteMouseClicked

    private void tblEleccionMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEleccionMesaMouseClicked
        // TODO add your handling code here:
        int fila = tblEleccionMesa.rowAtPoint(evt.getPoint());
        txtMesaId.setText((String) tblEleccionMesa.getValueAt(fila, 1));
    }//GEN-LAST:event_tblEleccionMesaMouseClicked

    private void btnActuaMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuaMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActuaMesaActionPerformed

    private void jcbMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMeseroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMeseroActionPerformed

    private void txtCantidadProPedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProPedKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidadProPed.getText)) {
                loginCtrl l = new loginCtrl();

            }
        }
    }//GEN-LAST:event_txtCantidadProPedKeyPressed

    private void txtCantidadProPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProPedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProPedActionPerformed

    private void txtApeMeseroFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMeseroFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMeseroFacActionPerformed

    private void txtApeMeseroFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMeseroFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMeseroFacKeyPressed

    private void txtNomCliFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomCliFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomCliFacActionPerformed

    private void txtNomCliFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomCliFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomCliFacKeyPressed

    private void txtPrecioUniDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUniDetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUniDetActionPerformed

    private void txtApeCajeroFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeCajeroFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeCajeroFacActionPerformed

    private void txtApeCajeroFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeCajeroFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeCajeroFacKeyPressed

    private void txtCantProdDetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantProdDetMouseEntered
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Debes presionar ENTER para insertar los datos.");
        panel.showNotification();
    }//GEN-LAST:event_txtCantProdDetMouseEntered

    private void txtApeClintFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeClintFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeClintFacActionPerformed

    private void txtApeClintFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeClintFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeClintFacKeyPressed

    private void txtNomClintFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomClintFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomClintFacActionPerformed

    private void txtNomClintFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomClintFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomClintFacKeyPressed

    private void txtNomMeseroFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomMeseroFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomMeseroFacActionPerformed

    private void txtNomMeseroFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomMeseroFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomMeseroFacKeyPressed

    private void txtNomCajeroFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomCajeroFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomCajeroFacActionPerformed

    private void txtNomCajeroFacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomCajeroFacKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomCajeroFacKeyPressed

    private void cmbComidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbComidasMouseClicked
        // TODO add your handling code here:
         String nom = (String) cmbComidas.getSelectedItem();
        txtNomProducPed.setText(nom);

    }//GEN-LAST:event_cmbComidasMouseClicked

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        // TODO add your handling code here:
          int fila = tblFactura.rowAtPoint(evt.getPoint());
         txtNomCliFac.setText(tblFactura.getValueAt(fila, 0).toString());
        txtProductoDet.setText(tblFactura.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_tblFacturaMouseClicked

    private void txtProdStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProdStockMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdStockMouseEntered

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaLogin login;
                try {
                    login = new ventanaLogin();
                    loginCtrl lox = new loginCtrl(login);
                    login.setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    public javax.swing.JButton btnActbCli;
    public javax.swing.JButton btnActblE;
    public javax.swing.JButton btnActuaMesa;
    public javax.swing.JButton btnActuaTabPenPet;
    public javax.swing.JButton btnActualizarFactura;
    public javax.swing.JButton btnActualizarInv;
    public javax.swing.JButton btnAggPedidos;
    public javax.swing.JButton btnAggProInv;
    public javax.swing.JButton btnAgregarC;
    public javax.swing.JButton btnAgregarEm;
    public javax.swing.JButton btnCkeckIn;
    public javax.swing.JButton btnConsuInventario;
    public javax.swing.JButton btnConsultaCL;
    public javax.swing.JButton btnConsultarEm;
    public javax.swing.JButton btnEliminarClie;
    public javax.swing.JButton btnEliminarConsu;
    public javax.swing.JButton btnEliminarEmp;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnFacturar;
    public javax.swing.JButton btnMesa1;
    public javax.swing.JButton btnMesa2;
    public javax.swing.JButton btnMesa3;
    public javax.swing.JButton btnMesa4;
    public javax.swing.JButton btnMesa5;
    public javax.swing.JButton btnMesa6;
    public javax.swing.JButton btnModificarEmpl;
    public javax.swing.JButton btnPedidosListo;
    public javax.swing.JButton btnPorcion;
    public javax.swing.JMenuItem cerrar;
    public javax.swing.JComboBox<String> cmbComidas;
    public javax.swing.JComboBox<String> cmbEmpleado;
    public javax.swing.JComboBox<String> cmbPorcion;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton8;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    private LIB.JPanelRound jPanelRound3;
    private LIB.JPanelTransparente jPanelTransparente1;
    public LIB.JPanelTransparente jPanelTransparente2;
    private LIB.JPanelTransparente jPanelTransparente3;
    private LIB.JPanelTransparente jPanelTransparente4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JComboBox<String> jcbMesero;
    public javax.swing.JComboBox<String> jcmRConsuEmpl;
    public javax.swing.JMenu jmiCerrarSesion;
    public javax.swing.JMenuItem jmiClienteConsu;
    public javax.swing.JMenuItem jmiClientes;
    public javax.swing.JMenuItem jmiEmpleado;
    public javax.swing.JMenuItem jmiEmpleadoConsu;
    public javax.swing.JMenuItem jmiOrdenes;
    public javax.swing.JMenuItem jmiProductos;
    private keeptoo.KGradientPanel kGradientPanel1;
    public javax.swing.JLabel lblRoles;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JLabel lblTotalFinal;
    private javax.swing.JCheckBoxMenuItem moods;
    public javax.swing.JTable tblClientes;
    public javax.swing.JTable tblEleccionMesa;
    public javax.swing.JTable tblEmpleados;
    public javax.swing.JTable tblFactura;
    public javax.swing.JTable tblFacturaEleccipn;
    public javax.swing.JTable tblInventario;
    public javax.swing.JTable tblPedidoListo;
    public javax.swing.JTable tblPedidoPendiente;
    public componentes.TextField txtApeCajeroFac;
    public componentes.TextField txtApeClintFac;
    public componentes.TextField txtApeMeseroFac;
    public componentes.TextField txtApellidoC;
    public componentes.TextField txtApellidoConsuCli;
    public componentes.TextField txtApellidoConuEmpl;
    public componentes.TextField txtApellidoE;
    public componentes.TextField txtCanProdInv;
    public componentes.TextField txtCantProdDet;
    public componentes.TextField txtCantidadP;
    public componentes.TextField txtCantidadProPed;
    public componentes.TextField txtCedulaC;
    public componentes.TextField txtCedulaConseEmpl;
    public componentes.TextField txtCedulaConsuCli1;
    public componentes.TextField txtCelE;
    public componentes.TextField txtClaveConsuEmpl;
    public componentes.TextField txtClaveE;
    public componentes.TextField txtConsulatCL;
    public componentes.TextField txtConsultarEm;
    public componentes.TextField txtConsultarInventario;
    public componentes.TextField txtDescuentoFac;
    public componentes.TextField txtDireccionC;
    public componentes.TextField txtDireccionConsuCli;
    public componentes.TextField txtDocE;
    public componentes.TextField txtIdCajeroFac;
    public componentes.TextField txtIdClienteFac;
    public componentes.TextField txtIdConsuCli;
    public componentes.TextField txtIdConsuEmpl;
    public componentes.TextField txtIdMesero;
    public componentes.TextField txtIdPedidoConse;
    public componentes.TextField txtMesaId;
    public componentes.TextField txtMetodoPago;
    public componentes.TextField txtNomCajeroFac;
    public componentes.TextField txtNomCliFac;
    public componentes.TextField txtNomClintFac;
    public componentes.TextField txtNomMeseroFac;
    public componentes.TextField txtNomProdInv;
    public componentes.TextField txtNomProducPed;
    public componentes.TextField txtNomProducPed1;
    public componentes.TextField txtNomProducPed2;
    public componentes.TextField txtNombreC;
    public componentes.TextField txtNombreConsCli;
    public componentes.TextField txtNombreConsuEmpl;
    public componentes.TextField txtNombreE;
    public componentes.TextField txtNombreP;
    public componentes.TextField txtNumFacturaDet;
    public componentes.TextField txtPedidoListo;
    public componentes.TextField txtPrecioP;
    public componentes.TextField txtPrecioUniDet;
    public componentes.TextField txtProdStock;
    public componentes.TextField txtProductoDet;
    public componentes.TextField txtTelefonoC;
    public componentes.TextField txtTelefonoConsuCli;
    public componentes.TextField txtTelefonoConsuEmpl;
    public componentes.TextField txtUserConsuEmpl;
    public componentes.TextField txtUserE;
    // End of variables declaration//GEN-END:variables

}
