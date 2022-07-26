package View;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import Controller.CtlCandidato;
import Controller.CtlEleccion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JFgestionarEleccion extends javax.swing.JFrame {

    CtlCandidato controladorCandidato;
    CtlEleccion controladorEleccion;

    LinkedList<ClsEleccion> elecciones;

    public JFgestionarEleccion() {
        initComponents();

        this.elecciones = new LinkedList<>();
        this.controladorCandidato = new CtlCandidato();
        this.controladorEleccion = new CtlEleccion();
        this.ObtenerCandidatos();
        this.ObtenerElecciones();
    }

    public void ObtenerCandidatos() {

        LinkedList<ClsCandidato> candidatos = this.controladorCandidato.ObtenerCandidatos();

        DefaultComboBoxModel model = (DefaultComboBoxModel) this.comboCandidatos.getModel();
        model.removeAllElements();

        for (ClsCandidato candidato : candidatos) {
            model.addElement(candidato.getNombre() + "-" + candidato.getNumeroDocumento());
        }

        this.comboCandidatos.setModel(model);

    }

    public void ActalizarTabla(LinkedList<ClsEleccion> lista) {

        DefaultTableModel model = (DefaultTableModel) this.tblListaElecciones.getModel();

        model.setRowCount(0);

        for (ClsEleccion eleccion : lista) {

            Object[] row = {eleccion.getIdEleccion(),
                eleccion.getNombre(),
                eleccion.getTipo(),
                eleccion.getFechaInicio(),
                eleccion.getFechaFin(),
                eleccion.getEstado(),
                eleccion.getGanador()};
            model.addRow(row);

        }

    }

    private void ActualizarTablaCandidatosEleccion(LinkedList<ClsCandidato> lista) {
        DefaultTableModel model = (DefaultTableModel) this.tblListaCandidatosElecciones.getModel();

        model.setRowCount(0);

        for (ClsCandidato candidato : lista) {

            Object[] row = {candidato.getNumeroDocumento(), candidato.getNombre(), "", ""};
            model.addRow(row);

        }
    }

    public void ObtenerElecciones() {

        this.elecciones = this.controladorEleccion.ObtenerElecciones();
        this.ActalizarTabla(elecciones);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEleccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboTipoEleccion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CandidatosxEleccion = new javax.swing.JPanel();
        EliminarAsociacion = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaCandidatosElecciones = new javax.swing.JTable();
        comboCandidatos = new javax.swing.JComboBox<>();
        btnAsociar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JToggleButton();
        btnActualizar = new javax.swing.JToggleButton();
        Lista_elecciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaElecciones = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnEliminarEleccion = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elecciones");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(102, 102, 102));
        Title.setText("Gestionar Elecciones");

        btnRegresar.setBackground(java.awt.SystemColor.controlHighlight);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/angulo-izquierdo.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Tipo");

        comboTipoEleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Precidenciales", "Elecciones Regionales", "Elección legislativa" }));

        jLabel3.setText("Fecha inicio");

        jLabel4.setText("Fecha fin");

        CandidatosxEleccion.setBackground(java.awt.SystemColor.menu);
        CandidatosxEleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        EliminarAsociacion.setBackground(new java.awt.Color(255, 204, 204));
        EliminarAsociacion.setText("Eliminar");
        EliminarAsociacion.setFocusPainted(false);
        EliminarAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAsociacionActionPerformed(evt);
            }
        });

        tblListaCandidatosElecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Candidato", "# Votos", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblListaCandidatosElecciones);

        comboCandidatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAsociar.setText("Asociar");
        btnAsociar.setFocusPainted(false);
        btnAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsociarActionPerformed(evt);
            }
        });

        jLabel7.setText("Candidato");

        javax.swing.GroupLayout CandidatosxEleccionLayout = new javax.swing.GroupLayout(CandidatosxEleccion);
        CandidatosxEleccion.setLayout(CandidatosxEleccionLayout);
        CandidatosxEleccionLayout.setHorizontalGroup(
            CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(comboCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                        .addComponent(btnAsociar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EliminarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        CandidatosxEleccionLayout.setVerticalGroup(
            CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EliminarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fechaInicio.setBackground(new java.awt.Color(255, 255, 255));

        fechaFin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Lista de elecciones");

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        Lista_elecciones.setBackground(java.awt.SystemColor.menu);
        Lista_elecciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tblListaElecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Elección", "Tipo", "Fecha inicio", "Fecha Fin", "Estado", "Ganador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaElecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaEleccionesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListaElecciones);

        btnCerrar.setText("Cerrar");
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEliminarEleccion.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminarEleccion.setText("Eliminar");
        btnEliminarEleccion.setFocusPainted(false);
        btnEliminarEleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEleccionActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lista_eleccionesLayout = new javax.swing.GroupLayout(Lista_elecciones);
        Lista_elecciones.setLayout(Lista_eleccionesLayout);
        Lista_eleccionesLayout.setHorizontalGroup(
            Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lista_eleccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarEleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        Lista_eleccionesLayout.setVerticalGroup(
            Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lista_eleccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lista_eleccionesLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Lista candidatos por elección");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(Lista_elecciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CandidatosxEleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Title)
                            .addGap(18, 18, 18)
                            .addComponent(btnRegresar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtNombreEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboTipoEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnActualizar))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lista_elecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CandidatosxEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEleccionActionPerformed

        try {

            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

            ClsMensaje mensaje = this.controladorEleccion.EliminarEleccion(idEleccion);

            if (mensaje.getTipo().equals(mensaje.OK)) {
                this.ObtenerElecciones();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una una elección"
                    + " y esta no debe tener candidatos asociados.");
        }
    }//GEN-LAST:event_btnEliminarEleccionActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void EliminarAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAsociacionActionPerformed
        try {

            // Eleccion
            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String idEleccion =this.tblListaElecciones.getModel().getValueAt(row, column).toString();
            System.out.println(idEleccion);

            //candidatos
            int column_ = 0;
            int row_ = this.tblListaCandidatosElecciones.getSelectedRow();
            String idCandidato = this.tblListaCandidatosElecciones.getModel().getValueAt(row_, column_).toString();
            System.out.println(idCandidato);

            ClsMensaje mensaje = this.controladorEleccion.EliminarAsociacion(idEleccion, idCandidato);

            if (mensaje.getTipo().equals(mensaje.OK)) {
                LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);
                this.ActualizarTablaCandidatosEleccion(lista);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una una elección"
                    + " y esta no debe tener candidatos asociados.");
        }
    }//GEN-LAST:event_EliminarAsociacionActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        JFmenuPrincipal menuP = new JFmenuPrincipal();
        menuP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String nombre = this.txtNombreEleccion.getText();
        String tipo = this.comboTipoEleccion.getSelectedItem().toString();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formatoFecha.format(this.fechaInicio.getDate());
        String fechaFin = formatoFecha.format(this.fechaFin.getDate());

        ClsEleccion eleccion = new ClsEleccion(nombre, tipo, fechaInicio, fechaFin, "Creado");

        ClsMensaje respuesta = this.controladorEleccion.AgregarEleccion(eleccion);

        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            this.ObtenerElecciones();
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

//TO-DO completar esta parte

        int column = 0;
        int row = this.tblListaElecciones.getSelectedRow();
        String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();
        //ClsEleccion eleccion = this.BuscarElleccion(idEleccion);

        try {
            String date = "13 Oct 2016";
            Date date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
            this.fechaInicio.setDate(date2);
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociarActionPerformed

        try {
            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

            String[] partesComboCandidato = this.comboCandidatos.getSelectedItem().toString().split("-", 2);

            String idCandidato = partesComboCandidato[1];
            System.out.println(idCandidato);

            ClsMensaje mensaje = this.controladorEleccion.AsociarCandidato(idEleccion, idCandidato);

            if (mensaje.getTipo().equals(mensaje.OK)) {

                LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);

                this.ActualizarTablaCandidatosEleccion(lista);
            }

            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion());
        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una elección");
        }
    }//GEN-LAST:event_btnAsociarActionPerformed

    private void tblListaEleccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaEleccionesMouseClicked
        int column = 0;
        int row = this.tblListaElecciones.getSelectedRow();
        String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

        LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);
        this.ActualizarTablaCandidatosEleccion(lista);
    }//GEN-LAST:event_tblListaEleccionesMouseClicked

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
            java.util.logging.Logger.getLogger(JFgestionarEleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFgestionarEleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFgestionarEleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFgestionarEleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFgestionarEleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CandidatosxEleccion;
    private javax.swing.JToggleButton EliminarAsociacion;
    private javax.swing.JPanel Lista_elecciones;
    private javax.swing.JLabel Title;
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JButton btnAsociar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarEleccion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboCandidatos;
    private javax.swing.JComboBox<String> comboTipoEleccion;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblListaCandidatosElecciones;
    private javax.swing.JTable tblListaElecciones;
    private javax.swing.JTextField txtNombreEleccion;
    // End of variables declaration//GEN-END:variables

}
