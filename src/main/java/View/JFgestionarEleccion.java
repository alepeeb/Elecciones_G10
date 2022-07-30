package View;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import Classes.ClsVotacion;
import Controller.CtlCandidato;
import Controller.CtlEleccion;
import Controller.CtlVotacion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFgestionarEleccion extends javax.swing.JFrame {

    //Icono Mensaje Cambpos vacios
    ImageIcon iconFormulario = new ImageIcon("src/main/resources/imgs/form.png");
    //Icono Mensaje Good
    ImageIcon iconGood = new ImageIcon("src/main/resources/imgs/thumbs-up.png");
    //Icono Mensaje Warning
    ImageIcon iconWarning = new ImageIcon("src/main/resources/imgs/warning.png");

    CtlCandidato controladorCandidato;
    CtlEleccion controladorEleccion;
    CtlVotacion controladorVotacion;

    LinkedList<ClsEleccion> elecciones;
    LinkedList<ClsVotacion> votos;

    public JFgestionarEleccion() {
        initComponents();

        this.elecciones = new LinkedList<>();
        this.controladorCandidato = new CtlCandidato();
        this.controladorEleccion = new CtlEleccion();
        this.ObtenerCandidatos();
        this.ObtenerElecciones();

        this.idEleccion.setVisible(false);
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

            Object[] row = {candidato.getNumeroDocumento(), candidato.getNombre(), candidato.getVotos(), ""};
            model.addRow(row);
        }
    }

    public void ObtenerElecciones() {

        this.elecciones = this.controladorEleccion.ObtenerElecciones();
        this.ActalizarTabla(elecciones);
    }

    public ClsEleccion BuscarEleccion(int idEleccion) {

        for (ClsEleccion eleccion : this.elecciones) {

            if (eleccion.getIdEleccion() == idEleccion) {
                return eleccion;
            }

        }

        return null;

    }

    public void LimpiarCampos() {
        this.txtNombreEleccion.setText("");
        this.comboTipoEleccion.setSelectedIndex(0);
        this.fechaInicio.setDate(null);
        this.fechaFin.setDate(null);
        this.idEleccion.setText("");

        this.btnAgregar.setEnabled(true);
    }

    public boolean Validarfecha(String fechaInicio, String fechaFin) {
        try {
            // Verifica que la fecha inicio sea menor a la fecha fin
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdformat.parse(fechaInicio);
            Date date2 = sdformat.parse(fechaFin);

            if (date1.before(date2)) {
                return true;
            }
        } catch (ParseException ex) {
        }
        return false;
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
        btnEliminarAsociacion = new javax.swing.JToggleButton();
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
        idEleccion = new javax.swing.JTextField();

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

        btnEliminarAsociacion.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminarAsociacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        btnEliminarAsociacion.setText("Eliminar");
        btnEliminarAsociacion.setFocusPainted(false);
        btnEliminarAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsociacionActionPerformed(evt);
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
        comboCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCandidatosActionPerformed(evt);
            }
        });

        btnAsociar.setBackground(java.awt.SystemColor.controlHighlight);
        btnAsociar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/enlace.png"))); // NOI18N
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(149, 149, 149))
                    .addGroup(CandidatosxEleccionLayout.createSequentialGroup()
                        .addGroup(CandidatosxEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCandidatos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CandidatosxEleccionLayout.createSequentialGroup()
                                .addComponent(btnAsociar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                            .addComponent(btnEliminarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fechaInicio.setBackground(new java.awt.Color(255, 255, 255));

        fechaFin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Lista de elecciones");

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
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

        btnCerrar.setBackground(java.awt.SystemColor.controlHighlight);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEliminarEleccion.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminarEleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        btnEliminarEleccion.setText("Eliminar");
        btnEliminarEleccion.setFocusPainted(false);
        btnEliminarEleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEleccionActionPerformed(evt);
            }
        });

        btnEditar.setBackground(java.awt.SystemColor.controlHighlight);
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
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
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarEleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        Lista_eleccionesLayout.setVerticalGroup(
            Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lista_eleccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lista_eleccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Lista_eleccionesLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEliminarEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Lista candidatos por elección");

        idEleccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idEleccion.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(idEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTipoEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar))
                            .addComponent(jLabel6)
                            .addComponent(CandidatosxEleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lista_elecciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idEleccion))
                    .addComponent(Title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoEleccion)
                            .addComponent(txtNombreEleccion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
            } else {
                JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconWarning);
            }

        } catch (Exception en) {

            String msg = "Debes seleccionar una una elección y esta no debe tener candidatos asociados";
            JOptionPane.showMessageDialog(rootPane, msg, null, 2, iconWarning);

        }


    }//GEN-LAST:event_btnEliminarEleccionActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        try {

            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String id = this.tblListaElecciones.getModel().getValueAt(row, column).toString();
            int idEleccion = Integer.parseInt(id);
            String estado = "Cerrado";

            int opction = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que quiere cerrar esta elección?, "
                    + "\n una vez cerrada no se podra votar.", "Advertencia", 2, 1, iconWarning);
            if (opction == 0) {

                ClsEleccion estadoE = new ClsEleccion(idEleccion, estado);
                ClsMensaje mensaje = this.controladorEleccion.ActualizaEstado(estadoE);

                if (mensaje.getTipo().equals(mensaje.OK)) {
                    this.ObtenerElecciones();
                    this.LimpiarCampos();

                    JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una elección", null, 2, iconWarning);
        }


    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsociacionActionPerformed

        try {

            // Eleccion
            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

            //candidatos
            int column_ = 0;
            int row_ = this.tblListaCandidatosElecciones.getSelectedRow();
            String idCandidato = this.tblListaCandidatosElecciones.getModel().getValueAt(row_, column_).toString();

            ClsMensaje mensaje = this.controladorEleccion.EliminarAsociacion(idEleccion, idCandidato);

            if (mensaje.getTipo().equals(mensaje.OK)) {
                LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);
                this.ActualizarTablaCandidatosEleccion(lista);
            }

            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una candidato", null, 2, iconWarning);
        }
    }//GEN-LAST:event_btnEliminarAsociacionActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        JFmenuPrincipal menuP = new JFmenuPrincipal();
        menuP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        try {

            String nombre = this.txtNombreEleccion.getText();
            String tipo = this.comboTipoEleccion.getSelectedItem().toString();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicio = formatoFecha.format(this.fechaInicio.getDate());
            String fechaFin = formatoFecha.format(this.fechaFin.getDate());

            if (nombre.equals("") || fechaInicio.equals("") || fechaFin.equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Debe completar todos los campos", null, 2, iconFormulario);

            } else {

                if (Validarfecha(fechaInicio, fechaFin)) {

                    ClsEleccion eleccion = new ClsEleccion(nombre, tipo, fechaInicio, fechaFin, "Creado");
                    ClsMensaje mensaje = this.controladorEleccion.AgregarEleccion(eleccion);

                    if (mensaje.getTipo().equals(ClsMensaje.OK)) {
                        this.ObtenerElecciones();
                    }
                    JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "La fecha de inicio debe ser menor a la fecha fin", null, 2, iconWarning);
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, "Debe digelenciar todos los campos", null, 2, iconFormulario);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        try {

            int idEleccion = Integer.parseInt(this.idEleccion.getText());
            ClsEleccion eleccion = this.BuscarEleccion(idEleccion);

            String nombre = this.txtNombreEleccion.getText();
            eleccion.setNombre(nombre);

            String tipo = this.comboTipoEleccion.getSelectedItem().toString();
            eleccion.setTipo(tipo);

            // Formato fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicio = formatoFecha.format(this.fechaInicio.getDate());
            eleccion.setFechaInicio(fechaInicio);
            String fechaFin = formatoFecha.format(this.fechaFin.getDate());
            eleccion.setFechaFin(fechaFin);

            if (nombre.equals("") || fechaInicio.equals("") || fechaFin.equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Debe completar todos los campos", null, 2, iconFormulario);

            } else {

                if (Validarfecha(fechaInicio, fechaFin)) {

                    ClsMensaje mensaje = this.controladorEleccion.ActualizarEleccion(eleccion);

                    if (mensaje.getTipo().equals(ClsMensaje.OK)) {
                        this.ObtenerElecciones();
                        this.LimpiarCampos();
                    }
                    JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "La fecha de inicio debe ser menor a la fecha fin", null, 2, iconWarning);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Debe digelenciar todos los campos", null, 2, iconFormulario);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        try {
            int row = this.tblListaElecciones.getSelectedRow();
            String fechaInicio = this.tblListaElecciones.getModel().getValueAt(row, 3).toString();
            String fechaFin = this.tblListaElecciones.getModel().getValueAt(row, 4).toString();

            String nombre = this.tblListaElecciones.getModel().getValueAt(row, 1).toString();
            String tipo = this.tblListaElecciones.getModel().getValueAt(row, 2).toString();
            String idPropuesta = this.tblListaElecciones.getModel().getValueAt(row, 0).toString();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date fechaI = formatoFecha.parse(fechaInicio);
                Date fechaF = formatoFecha.parse(fechaFin);

                this.fechaInicio.setDate(fechaI);
                this.fechaFin.setDate(fechaF);
                this.txtNombreEleccion.setText(nombre);
                this.comboTipoEleccion.setSelectedItem(tipo);
                this.idEleccion.setText(idPropuesta);

                this.btnAgregar.setEnabled(false);
                this.btnActualizar.setEnabled(true);
            } catch (ParseException e) {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debe seccionar una elección", null, 2, iconWarning);
        }


    }//GEN-LAST:event_btnEditarActionPerformed


    private void btnAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociarActionPerformed

        try {
            int column = 0;
            int row = this.tblListaElecciones.getSelectedRow();
            String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

            String[] partesComboCandidato = this.comboCandidatos.getSelectedItem().toString().split("-", 2);

            String idCandidato = partesComboCandidato[1];

            ClsMensaje mensaje = this.controladorEleccion.AsociarCandidato(idEleccion, idCandidato);

            if (mensaje.getTipo().equals(mensaje.OK)) {

                LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);

                this.ActualizarTablaCandidatosEleccion(lista);
            }

            JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion(), null, 2, iconGood);
        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una candidato", null, 2, iconWarning);
        }

    }//GEN-LAST:event_btnAsociarActionPerformed

    private void tblListaEleccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaEleccionesMouseClicked

        int column = 0;
        int row = this.tblListaElecciones.getSelectedRow();
        String idEleccion = this.tblListaElecciones.getModel().getValueAt(row, column).toString();

        LinkedList<ClsCandidato> lista = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);
        this.ActualizarTablaCandidatosEleccion(lista);

    }//GEN-LAST:event_tblListaEleccionesMouseClicked

    private void comboCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCandidatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCandidatosActionPerformed

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
    private javax.swing.JPanel Lista_elecciones;
    private javax.swing.JLabel Title;
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JButton btnAsociar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JToggleButton btnEliminarAsociacion;
    private javax.swing.JButton btnEliminarEleccion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboCandidatos;
    private javax.swing.JComboBox<String> comboTipoEleccion;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JTextField idEleccion;
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
