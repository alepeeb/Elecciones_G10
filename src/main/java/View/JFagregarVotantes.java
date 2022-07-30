package View;

import Classes.ClsMensaje;
import Classes.ClsVotante;
import Controller.CtlVotante;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFagregarVotantes extends javax.swing.JFrame {

    //Icono Mensaje Cambpos vacios
    ImageIcon iconFormulario = new ImageIcon("src/main/resources/imgs/form.png");
    //Icono Mensaje Good
    ImageIcon iconGood = new ImageIcon("src/main/resources/imgs/thumbs-up.png");
    //Icono Mensaje Warning
    ImageIcon iconWarning = new ImageIcon("src/main/resources/imgs/warning.png");

    LinkedList<ClsVotante> votantes = new LinkedList<>();
    CtlVotante controlador;

    public JFagregarVotantes() {
        initComponents();
        this.controlador = new CtlVotante();
        this.ObtenerVotantes();

        this.btnEliminar.setVisible(false);
        this.btnEditar.setVisible(false);
        this.btnAgregar.setVisible(true);
        this.btnNuevo.setVisible(false);
    }

    public void ObtenerVotantes() {

        //LinkedList<ClsVotante> votantes = this.controlador.ObtenerVotantes();
        this.votantes = this.controlador.ObtenerVotantes();
        this.ActalizarTabla(votantes);

    }

    public ClsVotante BuscarVotante(String id) {

        for (ClsVotante votante : this.votantes) {

            if (votante.getNumeroDocumento().equals(id)) {
                return votante;
            }

        }

        return null;

    }

    public void ActalizarTabla(LinkedList<ClsVotante> lista) {

        DefaultTableModel model = (DefaultTableModel) this.tblVotante.getModel();

        model.setRowCount(0);

        for (ClsVotante votante : lista) {

            Object[] row = {votante.getNumeroDocumento(), votante.getNombre(), votante.getTelefono(), votante.getCorreo(), votante.getDireccion()};
            model.addRow(row);

        }

    }

    public void LimbiarCampos() {

        this.txtDocumento.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.txtCorreo.setText("");
        this.txtDireccion.setText("");
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
        JtableVotante = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVotante = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buscarField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar votantes");
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.window);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Agregar votantes");

        JtableVotante.setBackground(java.awt.SystemColor.control);

        jPanel2.setBackground(java.awt.SystemColor.control);

        labelNombre.setText("Nombre*");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        labelDocumento.setText("Número documento*");
        labelDocumento.setToolTipText("");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        labelTelefono.setText("Teléfono*");

        labelCorreo.setText("Correo*");

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

        labelDireccion.setText("Dirección");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(labelNombre)
                                    .addComponent(txtNombre)
                                    .addComponent(labelTelefono)
                                    .addComponent(labelDireccion))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelCorreo)
                                    .addComponent(labelDocumento)
                                    .addComponent(txtDocumento)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 316, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(labelCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        JtableVotante.addTab("Agregar votante", jPanel2);

        jPanel3.setBackground(java.awt.SystemColor.control);

        tblVotante.setAutoCreateRowSorter(true);
        tblVotante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número documento", "Nombre", "Teléfono", "Correo", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVotante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVotanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVotante);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        JtableVotante.addTab("Lista votantes", jPanel3);

        btnRegresar.setBackground(java.awt.SystemColor.controlHighlight);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/angulo-izquierdo.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jButton1.setBackground(java.awt.SystemColor.controlHighlight);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buscarField.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtableVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(JtableVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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

        String nombre = txtNombre.getText();
        String numeroDocumento = txtDocumento.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();

        if (txtNombre.getText().equals("") || txtDocumento.getText().equals("") || txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe completar los campos obligatorios (*)", null, 2, iconFormulario);
        } else {

            boolean a = Validaciones(1, nombre);
            boolean b = Validaciones(2, numeroDocumento);
            boolean c = Validaciones(3, telefono);
            boolean d = Validaciones(4, correo);

            if (a && b && c && d) {

                boolean existe = controlador.UsuarioExiste(numeroDocumento);
                
                if (existe) {
                    JOptionPane.showMessageDialog(rootPane, "Ya existe un usuario con este número de documento", null, 2, iconWarning);
                } else {
                    
                    ClsVotante votante = new ClsVotante(numeroDocumento, nombre, telefono, correo, direccion);
                    ClsMensaje mensaje = this.controlador.agregarVotante(votante);

                    if (mensaje.getTipo().equals(mensaje.OK)) {
                        this.ObtenerVotantes();
                        LimbiarCampos();
                        JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed


    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        String numeroDocumento = this.txtDocumento.getText();
        ClsVotante votante = this.BuscarVotante(numeroDocumento);

        String nombre = this.txtNombre.getText();
        votante.setNombre(nombre);

        String telefono = this.txtTelefono.getText();
        votante.setTelefono(telefono);

        String correo = this.txtCorreo.getText();
        votante.setCorreo(correo);

        String direccion = this.txtDireccion.getText();
        votante.setDireccion(direccion);

        if (txtNombre.getText().equals("") || txtDocumento.getText().equals("") || txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe completar los campos obligatorios (*)", null, 2, iconFormulario);
        } else {

            boolean a = Validaciones(1, nombre);
            boolean b = Validaciones(2, numeroDocumento);
            boolean c = Validaciones(3, telefono);
            boolean d = Validaciones(4, correo);

            if (a && b && c && d) {
                
                ClsMensaje mensaje = this.controlador.ActualizarVotante(votante);
                if (mensaje.getTipo().equals(mensaje.OK)) {

                    this.ObtenerVotantes();
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int opctionSelected = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quiere eliminar este votante?", null, 2, 1, iconWarning);

        if (opctionSelected == 0) {
            int column = 0;
            int row = this.tblVotante.getSelectedRow();
            String cedula = this.tblVotante.getModel().getValueAt(row, column).toString();

            ClsMensaje mensaje = this.controlador.EliminarVotante(cedula);

            if (mensaje.getTipo().equals(mensaje.OK)) {

                this.ObtenerVotantes();

                this.txtDocumento.enable();
                this.btnEliminar.setVisible(false);
                this.btnEditar.setVisible(false);
                this.btnNuevo.setVisible(false);
                this.btnAgregar.setVisible(true);
                this.LimbiarCampos();
            }
            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblVotanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVotanteMouseClicked
        int column = 0;
        int row = this.tblVotante.getSelectedRow();
        String cedula = this.tblVotante.getModel().getValueAt(row, column).toString();
        ClsVotante votante = this.BuscarVotante(cedula);
        //this.JtableVotante.setSelectedIndex(0);

        if (votante != null) {

            this.txtDocumento.setText(votante.getNumeroDocumento());

            this.txtNombre.setText(votante.getNombre());

            this.txtTelefono.setText(votante.getTelefono());

            this.txtCorreo.setText(votante.getCorreo());

            this.txtDireccion.setText(votante.getDireccion());

            this.txtDocumento.disable();

            this.btnEliminar.setVisible(true);
            this.btnEditar.setVisible(true);
            this.btnNuevo.setVisible(true);
            this.btnAgregar.setVisible(false);
            this.JtableVotante.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tblVotanteMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String code = buscarField.getText();
        boolean found = false;

        for (ClsVotante votante : votantes) {
            if (votante.getNumeroDocumento().equals(code)) {
                txtDocumento.setText(votante.getNumeroDocumento());
                txtNombre.setText(votante.getNombre());
                txtTelefono.setText(votante.getTelefono());
                txtCorreo.setText(votante.getCorreo());
                txtDireccion.setText(votante.getDireccion());

                this.txtDocumento.disable();
                this.btnEliminar.setVisible(true);
                this.btnEditar.setVisible(true);
                this.btnNuevo.setVisible(true);
                this.btnAgregar.setVisible(false);

                found = true;
                break;

            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Código no encontrado");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.btnEliminar.setVisible(false);
        this.btnEditar.setVisible(false);
        this.btnNuevo.setVisible(false);
        this.btnAgregar.setVisible(true);

        this.txtDocumento.enable();

        LimbiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

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
                new JFagregarVotantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JtableVotante;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField buscarField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelDocumento;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    public javax.swing.JTable tblVotante;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtDocumento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
