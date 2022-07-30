package View;

import Classes.ClsCandidato;
import Classes.ClsMensaje;
import Classes.ClsPropuesta;
import Controller.CtlCandidato;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFgestionarCandidatos extends javax.swing.JFrame {

    //Icono Mensaje Cambpos vacios
    ImageIcon iconFormulario = new ImageIcon("src/main/resources/imgs/form.png");
    //Icono Mensaje Good
    ImageIcon iconGood = new ImageIcon("src/main/resources/imgs/thumbs-up.png");
    //Icono Mensaje Warning
    ImageIcon iconWarning = new ImageIcon("src/main/resources/imgs/warning.png");

    CtlCandidato controlador;
    LinkedList<ClsCandidato> candidatos;
    LinkedList<ClsPropuesta> propuestas;

    public JFgestionarCandidatos() {
        initComponents();
        this.controlador = new CtlCandidato();
        this.ObtenerCandidatos();

        this.btnEditar.setVisible(false);
        this.btnEliminar.setVisible(false);
        this.btnNuevo.setVisible(false);
        this.editarPropuesta.setEnabled(false);
        this.eliminarPropuesta.setEnabled(false);
    }

    public void ObtenerCandidatos() {

        this.candidatos = this.controlador.ObtenerCandidatos();
        this.ActalizarTabla(candidatos);
    }

    public void ObtenerPropuestas(String idCandidato) {

        this.propuestas = this.controlador.ObtenerPropuestas(idCandidato);
        this.ActualizarTablaPropuestas(propuestas);
    }

    public void ActalizarTabla(LinkedList<ClsCandidato> lista) {

        DefaultTableModel model = (DefaultTableModel) this.tblCandidato.getModel();

        model.setRowCount(0);

        for (ClsCandidato candidato : lista) {

            Object[] row = {candidato.getNumeroDocumento(), candidato.getNombre(), candidato.getPartidoPolitico(), candidato.getTelefono(), candidato.getCorreo(), candidato.getCiudadrigen(), candidato.getMensajeCampania()};
            model.addRow(row);

        }

    }

    public void ActualizarTablaPropuestas(LinkedList<ClsPropuesta> lista) {

        DefaultTableModel model = (DefaultTableModel) this.tblPropuestas.getModel();

        model.setRowCount(0);

        for (ClsPropuesta propuesta : lista) {

            Object[] row = {propuesta.getIdPropuesta(), propuesta.getSector(), propuesta.getDescripcion()};
            model.addRow(row);

        }

    }

    public ClsCandidato BuscarCandidato(String id) {

        for (ClsCandidato candidato : this.candidatos) {

            if (candidato.getNumeroDocumento().equals(id)) {
                return candidato;
            }

        }

        return null;

    }

    public ClsPropuesta BuscarPropuestas(String id) {

        for (ClsPropuesta propuesta : this.propuestas) {

            if (propuesta.getIdPropuesta().equals(id)) {
                return propuesta;
            }

        }

        return null;

    }

    public void LimbiarCampos() {

        this.txtDocumento.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.txtCorreo.setText("");
        this.txtDescripcion.setText("");
        this.comboPartidos.setSelectedItem("");
        this.txtCiudadOrigen.setText("");
        this.txtMesajeC.setText("");
    }

    public void LimpiarPropuestas() {

        try {

            this.ActualizarTablaPropuestas(propuestas);
            this.comboSector.setSelectedItem("");
            this.descripcionPropuesta.setText("");
            this.txtCode.setText("");

        } catch (Exception e) {
            this.comboSector.setSelectedItem("");
            this.descripcionPropuesta.setText("");
            this.txtCode.setText("");
            this.txtIdCandidato.setText("");
        }
    }

// :::::::::::: Validaciones
    public boolean Validaciones(int tipo, String campo) {

        switch (tipo) {
            case 1: // nombre
                if (campo.matches("^[a-zA-ZÀ-ÿ\\s]{1,40}$")) {
                    this.labelNombre.setForeground(Color.black);
                    return true;
                } else {
                    this.labelNombre.setForeground(Color.red);
                }
                break;
            case 2: // Documento
                if (campo.matches("[0-9]*")) {
                    this.labelDocumento.setForeground(Color.black);
                    return true;
                } else {
                    this.labelDocumento.setForeground(Color.red);
                }
                break;
            case 3: // Teléfono
                if (campo.matches("^\\d{7,10}$")) {
                    this.labelTelefono.setForeground(Color.black);
                    return true;
                } else {
                    this.labelTelefono.setForeground(Color.red);
                }
                break;
            case 4: // Correo
                if (campo.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
                    this.labelCorreo.setForeground(Color.black);
                    return true;
                } else {
                    this.labelCorreo.setForeground(Color.red);
                }
                break;
            case 5: // Ciudad Origen
                if (campo.matches("^[a-zA-ZÀ-ÿ\\s]{1,40}$")) {
                    this.labelCiudadO.setForeground(Color.black);
                    return true;
                } else {
                    this.labelCiudadO.setForeground(Color.red);
                }
                break;
            default:
                throw new AssertionError();
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jtable = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboPartidos = new javax.swing.JComboBox<>();
        labelCiudadO = new javax.swing.JLabel();
        txtCiudadOrigen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMesajeC = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidato = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPropuestas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboSector = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionPropuesta = new javax.swing.JTextArea();
        agregarPropuesta = new javax.swing.JButton();
        eliminarPropuesta = new javax.swing.JButton();
        editarPropuesta = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIdCandidato = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        buscarField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar candidatos");
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.window);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Gestionar Candidatos");

        jPanel2.setBackground(java.awt.SystemColor.menu);

        labelNombre.setText("Nombre*");

        labelDocumento.setText("Número documento*");

        labelTelefono.setText("Teléfono*");

        labelCorreo.setText("Correo*");

        jLabel7.setText("Partido político*");

        comboPartidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Partido Liberal Colombiano", "Partido Conservador Colombiano", "Movimiento Autoridades Indígenas de Colombia AICO", "Nuevo Liberalismo", "Partido Verde Oxigeno", "Unión Patriótica UP", "Salvacion nacional", "Partido Alianza Social Independiente ASI", "Partido Cambio Radical", "Partido Político Mira", "Partido Social de Unidad Nacional «Partido de la U»", "Partido Alianza Verde", "Partido Polo Democrático Alternativo", "Colombia Humana", "Partido Centro Democrático", "Movimiento Alternativo Indígena y Social MAIS", "Comunes", "Partido Colombia Justa Libres", "Partido Colombia Renaciente", "Partido ADA", "Partido Dignidad" }));
        comboPartidos.setFocusable(false);

        labelCiudadO.setText("Ciudad de origen*");

        jLabel9.setText("Descripción");

        jLabel11.setText("Mensaje Campaña*");

        btnEliminar.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(204, 204, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEditar.setText("Actualizar");
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(java.awt.SystemColor.controlHighlight);
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/usuario.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre)
                    .addComponent(labelTelefono)
                    .addComponent(labelCorreo)
                    .addComponent(labelDocumento)
                    .addComponent(txtDocumento)
                    .addComponent(txtCorreo))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMesajeC, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCiudadOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(labelCiudadO, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboPartidos, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelCiudadO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion)))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMesajeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        Jtable.addTab("Agregar candidato", jPanel2);

        jPanel3.setBackground(java.awt.SystemColor.menu);

        tblCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Númro documento", "Nombre", "Partido Político", "Teléfono", "Correo", "Ciudad Origén", "Mensaje Campaña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandidatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCandidato);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        Jtable.addTab("Lista candidatos", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.menu);

        tblPropuestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sector", "Propuesta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPropuestas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPropuestasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPropuestas);

        jPanel5.setBackground(java.awt.SystemColor.menu);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Sector");

        comboSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salud", "Seguridad", "Agrícultura", "TI", "Hacienda" }));

        jLabel12.setText("Propuesta");

        descripcionPropuesta.setColumns(20);
        descripcionPropuesta.setRows(5);
        jScrollPane3.setViewportView(descripcionPropuesta);

        agregarPropuesta.setBackground(new java.awt.Color(204, 255, 204));
        agregarPropuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/agregar.png"))); // NOI18N
        agregarPropuesta.setText("Agregar");
        agregarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPropuestaActionPerformed(evt);
            }
        });

        eliminarPropuesta.setBackground(new java.awt.Color(255, 204, 204));
        eliminarPropuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        eliminarPropuesta.setText("Eliminar");
        eliminarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPropuestaActionPerformed(evt);
            }
        });

        editarPropuesta.setBackground(new java.awt.Color(204, 204, 255));
        editarPropuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        editarPropuesta.setText("Actulizar");
        editarPropuesta.setFocusPainted(false);
        editarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPropuestaActionPerformed(evt);
            }
        });

        txtCode.setEnabled(false);

        jLabel10.setText("ID propuesta");

        txtIdCandidato.setEnabled(false);

        jLabel13.setText("ID candidato");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboSector, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editarPropuesta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregarPropuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(eliminarPropuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(editarPropuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Jtable.addTab("Propuestas", jPanel4);

        btnRegresar.setBackground(java.awt.SystemColor.controlHighlight);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/angulo-izquierdo.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(java.awt.SystemColor.controlHighlight);
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jtable, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(Jtable, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        JFmenuPrincipal menuP = new JFmenuPrincipal();
        menuP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String numeroDocumento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String partido_politico = (String) comboPartidos.getSelectedItem();
        String ciudad_origen = txtCiudadOrigen.getText();
        String descripcion = txtDescripcion.getText();
        String mensajeCampania = txtMesajeC.getText();
        //String porpuestas = txtPropuestas.getText();

        if (nombre.equals("")
                || numeroDocumento.equals("")
                || telefono.equals("")
                || correo.equals("")
                || ciudad_origen.equals("")
                || mensajeCampania.equals("")) {

            JOptionPane.showMessageDialog(rootPane, "Debe completar los campos obligatorios (*)", null, 2, iconFormulario);

        } else {
            boolean a = Validaciones(1, nombre);
            boolean b = Validaciones(2, numeroDocumento);
            boolean c = Validaciones(3, telefono);
            boolean d = Validaciones(4, correo);
            boolean e = Validaciones(5, ciudad_origen);

            if (a && b && c && d && e) {

                ClsCandidato candi = new ClsCandidato(numeroDocumento, nombre, telefono, correo, partido_politico, ciudad_origen, descripcion, mensajeCampania);

                ClsMensaje mensaje = this.controlador.AgregarCandidato(candi);

                if (mensaje.getTipo().equals(mensaje.OK)) {
                    this.ObtenerCandidatos();
                    LimbiarCampos();
                }
                JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int opction = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quiere eliminar este votante?", null, 2, 1, iconWarning);

        if (opction == 0) {

            int column = 0;
            int row = this.tblCandidato.getSelectedRow();

            String cedula = this.tblCandidato.getModel().getValueAt(row, column).toString();

            ClsMensaje mensaje = this.controlador.EliminarCandidato(cedula);

            if (mensaje.getTipo().equals(mensaje.OK)) {

                this.ObtenerCandidatos();

                this.txtDocumento.enable();

                this.btnEliminar.setVisible(false);
                this.btnEditar.setVisible(false);
                this.btnNuevo.setVisible(false);
                this.btnAgregar.setVisible(true);

                LimbiarCampos();
                LimpiarPropuestas();
            }

            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String code = buscarField.getText();
        boolean found = false;

        for (ClsCandidato candidato : candidatos) {

            if (candidato.getNumeroDocumento().equals(code)) {
                this.txtDocumento.setText(candidato.getNumeroDocumento());
                this.txtNombre.setText(candidato.getNombre());
                this.txtTelefono.setText(candidato.getTelefono());
                this.txtCorreo.setText(candidato.getCorreo());
                this.txtDescripcion.setText(candidato.getDescripcion());
                this.comboPartidos.setSelectedItem(candidato.getPartidoPolitico());
                this.txtCiudadOrigen.setText(candidato.getCiudadrigen());
                this.txtMesajeC.setText(candidato.getMensajeCampania());

                if (candidato != null) {

                    LinkedList<ClsPropuesta> propuestas = this.controlador.ObtenerPropuestas(code);
                    if (propuestas != null) {
                        candidato.setPropuestas(propuestas);
                        this.ActualizarTablaPropuestas(candidato.getPropuestas());

                        this.comboSector.setSelectedItem("");
                        this.descripcionPropuesta.setText("");
                        this.txtIdCandidato.setText(candidato.getNumeroDocumento());
                    }
                }
                found = true;
                break;
            }
        }

        if (!found) {

            this.txtDocumento.setText("");
            this.txtNombre.setText("");
            this.txtTelefono.setText("");
            this.txtCorreo.setText("");
            this.txtDescripcion.setText("");
            this.comboPartidos.setSelectedItem("");
            this.txtCiudadOrigen.setText("");
            this.txtMesajeC.setText("");
            this.txtIdCandidato.setText("");

            try {
                this.ActualizarTablaPropuestas(propuestas);
            } catch (Exception e) {

            }

            JOptionPane.showMessageDialog(this, "Código no encontrado");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        String numeroDocumento = this.txtDocumento.getText();
        ClsCandidato candidato = this.BuscarCandidato(numeroDocumento);

        String nombre = this.txtNombre.getText();
        candidato.setNombre(nombre);

        String telefono = this.txtTelefono.getText();
        candidato.setTelefono(telefono);

        String correo = this.txtCorreo.getText();
        candidato.setCorreo(correo);

        String ciudaOrigen = this.txtCiudadOrigen.getText();
        candidato.setCiudadrigen(ciudaOrigen);

        String partidoPolitico = this.comboPartidos.getSelectedItem().toString();
        candidato.setPartidoPolitico(partidoPolitico);

        String mensajeC = this.txtMesajeC.getText();
        candidato.setMensajeCampania(mensajeC);

        String descripcion = this.txtDescripcion.getText();
        candidato.setDescripcion(descripcion);

        if (nombre.equals("")
                || numeroDocumento.equals("")
                || telefono.equals("")
                || correo.equals("")
                || ciudaOrigen.equals("")
                || mensajeC.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe completar los campos obligatorios (*)", null, 2, iconFormulario);
        } else {

            boolean a = Validaciones(1, nombre);
            boolean b = Validaciones(2, numeroDocumento);
            boolean c = Validaciones(3, telefono);
            boolean d = Validaciones(4, correo);
            boolean e = Validaciones(5, ciudaOrigen);

            if (a && b && c && d && e) {

                ClsMensaje mensaje = this.controlador.ActualizarCandidato(candidato);

                if (mensaje.getTipo().equals(mensaje.OK)) {

                    this.ObtenerCandidatos();
                    LimbiarCampos();

                    this.btnEliminar.setVisible(false);
                    this.btnEditar.setVisible(false);
                    this.btnNuevo.setVisible(false);
                    this.btnAgregar.setVisible(true);
                }
                JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
            }

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblCandidatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandidatoMouseClicked
        // click mouse
        int column = 0;
        int row = this.tblCandidato.getSelectedRow();
        String cedula = this.tblCandidato.getModel().getValueAt(row, column).toString();
        ClsCandidato candidato = this.BuscarCandidato(cedula);

        if (candidato != null) {

            this.txtDocumento.setText(candidato.getNumeroDocumento());

            this.txtNombre.setText(candidato.getNombre());

            this.txtTelefono.setText(candidato.getTelefono());

            this.txtCorreo.setText(candidato.getCorreo());

            this.txtDescripcion.setText(candidato.getDescripcion());

            this.comboPartidos.setSelectedItem(candidato.getPartidoPolitico());

            this.txtMesajeC.setText(candidato.getMensajeCampania());

            this.txtCiudadOrigen.setText(candidato.getCiudadrigen());

            this.txtDocumento.disable();

            if (candidato != null) {

                LinkedList<ClsPropuesta> propuestas = this.controlador.ObtenerPropuestas(cedula);

                if (propuestas != null) {
                    candidato.setPropuestas(propuestas);
                    this.ActualizarTablaPropuestas(candidato.getPropuestas());

                    this.comboSector.setSelectedItem("");
                    this.descripcionPropuesta.setText("");
                    this.txtCode.setText("");
                    this.txtIdCandidato.setText(candidato.getNumeroDocumento());

                }

            }

            //
            this.btnEliminar.setVisible(true);
            this.btnEditar.setVisible(true);
            this.btnNuevo.setVisible(true);
            this.btnAgregar.setVisible(false);
            this.Jtable.setSelectedIndex(0);
        }


    }//GEN-LAST:event_tblCandidatoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.btnEliminar.setVisible(false);
        this.btnEditar.setVisible(false);
        this.btnNuevo.setVisible(false);
        this.btnAgregar.setVisible(true);

        LimbiarCampos();

        this.txtDocumento.enable();

        LimpiarPropuestas();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void agregarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPropuestaActionPerformed

        String sector = this.comboSector.getSelectedItem().toString();
        String descripcion = this.descripcionPropuesta.getText();

        String cedula = this.txtIdCandidato.getText(); // prueba
        ClsCandidato candidato = this.BuscarCandidato(cedula);

        if (candidato != null) {

            if (descripcion.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "No puede agregar una propuesta vacia", null, 2, iconWarning);
            } else {
                ClsPropuesta propuesta = new ClsPropuesta(cedula, sector, descripcion);

                ClsMensaje respuesta = this.controlador.AgregarPropuesta(propuesta);

                if (respuesta.getTipo().equals(ClsMensaje.OK)) {

                    propuesta.setIdPropuesta(respuesta.getData());
                    candidato.getPropuestas().add(propuesta);
                    this.ActualizarTablaPropuestas(candidato.getPropuestas());

                    this.ObtenerPropuestas(cedula);
                    LimpiarPropuestas();
                    ActualizarTablaPropuestas(propuestas);
                }
            }

            this.descripcionPropuesta.setText("");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione un candidato", null, 2, iconWarning);
        }


    }//GEN-LAST:event_agregarPropuestaActionPerformed

    private void editarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPropuestaActionPerformed

        String idPropuesta = this.txtCode.getText();
        String idCandidato = this.txtIdCandidato.getText();

        ClsPropuesta propuesta = this.BuscarPropuestas(idPropuesta);

        String descripcion = this.descripcionPropuesta.getText();
        propuesta.setDescripcion(descripcion);

        String sector = this.comboSector.getSelectedItem().toString();
        propuesta.setSector(sector);

        ClsMensaje mensaje = this.controlador.ActualizarPropuesta(propuesta);

        if (mensaje.getTipo().equals(mensaje.OK)) {
            this.ObtenerPropuestas(idCandidato);

            this.editarPropuesta.setEnabled(false);
            this.eliminarPropuesta.setEnabled(false);
            this.agregarPropuesta.setEnabled(true);
            LimpiarPropuestas();
        }

        JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);

    }//GEN-LAST:event_editarPropuestaActionPerformed

    private void tblPropuestasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPropuestasMouseClicked

        // candidato
        int column = 0;
        int row = this.tblCandidato.getSelectedRow();
        String cedula = this.tblCandidato.getModel().getValueAt(row, column).toString();

        // tabla propuesta
        int roww = this.tblPropuestas.getSelectedRow();
        String pro = this.tblPropuestas.getModel().getValueAt(roww, column).toString();

        this.propuestas = this.controlador.ObtenerPropuestas(cedula);
        ClsPropuesta propuesta = this.BuscarPropuestas(pro);

        if (propuesta != null) {

            this.ActualizarTablaPropuestas(propuestas);
            this.comboSector.setSelectedItem(propuesta.getSector());
            this.descripcionPropuesta.setText(propuesta.getDescripcion());
            this.txtCode.setText(propuesta.getIdPropuesta());
            this.txtIdCandidato.setText(propuesta.getIdCandidato());

            this.editarPropuesta.setEnabled(true);
            this.eliminarPropuesta.setEnabled(true);
            this.agregarPropuesta.setEnabled(false);
        }

    }//GEN-LAST:event_tblPropuestasMouseClicked

    private void eliminarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPropuestaActionPerformed

        String idPropuesta = this.txtCode.getText();
        String idCandidato = this.txtIdCandidato.getText();

        int opction = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quiere eliminar este propuesta?", null, 2, 1, iconWarning);

        if (opction == 0) {

            ClsMensaje mensaje = this.controlador.EliminarPropuesta(idPropuesta);

            if (mensaje.getTipo().equals(mensaje.OK)) {

                this.ObtenerPropuestas(idCandidato);

                ActualizarTablaPropuestas(propuestas);

                this.eliminarPropuesta.setEnabled(false);
                this.editarPropuesta.setEnabled(false);
                this.agregarPropuesta.setEnabled(true);
                LimpiarPropuestas();

            }

            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
        }
    }//GEN-LAST:event_eliminarPropuestaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFagregarVotantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFagregarVotantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFagregarVotantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFagregarVotantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFgestionarCandidatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Jtable;
    private javax.swing.JButton agregarPropuesta;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField buscarField;
    private javax.swing.JComboBox<String> comboPartidos;
    private javax.swing.JComboBox<String> comboSector;
    private javax.swing.JTextArea descripcionPropuesta;
    private javax.swing.JButton editarPropuesta;
    private javax.swing.JButton eliminarPropuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelCiudadO;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDocumento;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTable tblCandidato;
    private javax.swing.JTable tblPropuestas;
    private javax.swing.JTextField txtCiudadOrigen;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtIdCandidato;
    private javax.swing.JTextField txtMesajeC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
