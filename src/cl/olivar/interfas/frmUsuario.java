/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.interfas;

import cl.olivar.datos.DUsuario;
import cl.olivar.logica.LUsuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Tecnico
 */
public class frmUsuario extends javax.swing.JInternalFrame {

    DUsuario ddu = new DUsuario();
    LUsuario lgu = new LUsuario();

    String Estado = "";

    /**
     * Creates new form frmUsuario
     */
    public frmUsuario() {
        initComponents();

        BuscaUS("");
//     frmUsuario.this.setBackground(new Color(0, 0, 0, 0));
        txtId.setEnabled(false);
        habilitado(true);
//--------------------------------Metodo para Tomar los texto del radio button ---------------------------------------------
        btnActivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnActivo) {

                    Estado = btnActivo.getText();
                }
            }
        });
        btnInactivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnInactivo) {

                    Estado = btnInactivo.getText();
                }
            }
        });
        Limite(txtNombre, 24,true);
        Limite(txtUsuario, 12,true);
        Limite(txtCorreo, 12,false);
        Limite(txtApellido, 24,true);
        Limite(txtClave, 14,false);
        Limite(txtBuscar, 14,true);
        Limite(txtNombre, 24,true);

//        TipoDato(txtNombre);
    }
//--------------------------------Metodo Para Limpiar las casillas de texto -------------------------------- 

    public void limpiar() {

        txtApellido.setText("");
        txtClave.setText("");
        txtConfirmaClave.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtUsuario.setText("");
        txtId.setText("");
    }
//--------------------------------Metodos para Buscar Usuario y mostro en tabla -------------------------------- 

    public void BuscaUS(String usuario) {

        DefaultTableModel miModelo;

        ddu.setUsuario(usuario);
        miModelo = lgu.MostUsuario(ddu);
        tblUsuario.setModel(miModelo);

    }
//--------------------------------Metodo para Habilitar y desabilitar Casillas de texto -------------------------------- 

    public void habilitado(boolean btn) {

        txtNombre.setEnabled(!btn);
        txtUsuario.setEnabled(!btn);
        txtClave.setEnabled(!btn);
        txtConfirmaClave.setEnabled(!btn);
        cmbPerfil.setEnabled(!btn);
        txtCorreo.setEnabled(!btn);
        txtApellido.setEnabled(!btn);
        btnActivo.setEnabled(!btn);
        btnInactivo.setEnabled(!btn);

        btnNuevo.setEnabled(btn);
        btnEditar.setEnabled(btn);
        btnGuardar.setEnabled(!btn);

    }
//--------------------------------Metodo para Eliminar los Usuario  -------------------------------- 

    public void EliminarUsuario(String id) {

        ddu.setId(Integer.parseInt(id));

        String msj = lgu.EliminarUsuario(ddu);

        if (msj.equals("si")) {
            JOptionPane.showMessageDialog(rootPane, "Usuario Eliminado de Forma correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Ah Ocurrido un Error al Eliminar El Usuario", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        }
    }
//--------------------------------Metodo para Limitar Caracteres en las Casillas de Texto, y tipo de datos a escribir--------------------------- 

    public void Limite(JTextField caracteres, int n, boolean si) {
        caracteres.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (caracteres.getText().length() >= n) {
                    e.consume();
                }
                if(si){
                char evento = e.getKeyChar();
                if (Character.isDigit(evento)) {

                    getToolkit().beep();//este metodo avisa si se modifica el textod dentro de la casilla 
                    e.consume();

//                    JOptionPane.showMessageDialog(rootPane, "no se escribe Numero");
                }
            }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        txtConfirmaClave = new javax.swing.JPasswordField();
        txtId = new javax.swing.JTextField();
        btnActivo = new javax.swing.JRadioButton();
        btnInactivo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        btncVer = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 253, 253));
        setClosable(true);
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(0, 184, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        /*tblUsuario = new javax.swing.JTable(){

            public boolean isCellEditable(int fila, int columna){

                return false;
            }
        }*/
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Nombre", "Apellido", "Correo", "Contraseña", "perfil", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.getTableHeader().setReorderingAllowed(false);
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 184, 216));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Correo");

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Contraseña ");

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Confirma Contraseña"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Perfil");

        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione una Obcion", "Administrador", "medio", "Basico" }));
        cmbPerfil.setToolTipText("");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setAutoscrolls(false);

        txtApellido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbEmail.setText("@Colegiosannicolas.cl");

        txtClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtConfirmaClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnGrupo.add(btnActivo);
        btnActivo.setText("Habilitado");

        btnGrupo.add(btnInactivo);
        btnInactivo.setText("Desabilitar");

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("Estado");

        btncVer.setText("Ver");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEmail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtConfirmaClave, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInactivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncVer))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnActivo)
                    .addComponent(btnInactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncVer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfirmaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 244));
        jLabel9.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 202, 245));
        jLabel9.setText("Registro De Usuario");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/olivar/imagen/btnEditar.png"))); // NOI18N
        btnEditar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/olivar/imagen/btnEditar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/olivar/imagen/btnGuardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/olivar/imagen/btnNuevo.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtId.getText().equals("")) {
            EliminarUsuario(txtId.getText());
        } else {
            JOptionPane.showMessageDialog(null, "No ha Selecionado Usuario", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        BuscaUS("");
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        // TODO add your handling code here:
        int fila = tblUsuario.getSelectedRow();
        txtId.setText(tblUsuario.getValueAt(fila, 0).toString());
        txtNombre.setText(tblUsuario.getValueAt(fila, 2).toString());
        txtUsuario.setText(tblUsuario.getValueAt(fila, 1).toString());
        txtCorreo.setText(tblUsuario.getValueAt(fila, 4).toString());
        txtApellido.setText(tblUsuario.getValueAt(fila, 3).toString());
        /* txtClave.setText(tblUsuario.getValueAt(fila, 5).toString());
       txtConfirmaClave.setText(tblUsuario.getValueAt(fila, 5).toString());*/
        cmbPerfil.setSelectedItem(tblUsuario.getValueAt(fila, 6).toString());
        Estado = tblUsuario.getValueAt(fila, 7).toString();
        if (Estado.endsWith("Habilitado")) {
            btnActivo.setSelected(true);
        } else {
            btnInactivo.setSelected(true);
        }


    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:  
        String confClave = new String(txtConfirmaClave.getPassword());
        String clave = new String(txtClave.getPassword());
        String perfil = (String) cmbPerfil.getSelectedItem();
        String msg = "";
//--------------------------------Verificar que las cajas de texto no esten vacias --------------------------------  
        if (txtApellido.getText().equals("") || txtNombre.getText().equals("") || txtUsuario.getText().equals("")
                || clave.equals("") || confClave.equals("") || perfil.equals("") || Estado.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Datos Nombre es Obligatorio", "Mensaje", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocusInWindow();
            txtApellido.requestFocusInWindow();
            txtClave.requestFocusInWindow();
            txtConfirmaClave.requestFocusInWindow();
            txtCorreo.requestFocusInWindow();
            txtNombre.requestFocusInWindow();
            txtUsuario.requestFocusInWindow();
            txtId.requestFocusInWindow();

            return;

        }

//--------------------------------Evento de Guardar Nuevos Usuarios --------------------------------------
        if (txtId.getText().equals("")) {

            ddu.setUsuario(txtUsuario.getText());
            ddu.setNombre(txtNombre.getText());
            ddu.setApellido(txtApellido.getText());
            ddu.setCorreo(txtCorreo.getText() + lbEmail.getText());
            ddu.setEstado(Estado);
            ddu.setContraseña(clave);
            ddu.setPerfil(perfil);

            msg = lgu.InsertarUsuario(ddu);
            habilitado(true);

            if (msg.endsWith("si")) {
                JOptionPane.showMessageDialog(rootPane, "Usuario Registrado de Forma correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Ah Ocurrido un Error", "Informacion", JOptionPane.ERROR_MESSAGE);

            }
//--------------------------------Evento para Editar los Usuarios Existentes ------------------------------------            

        } else {

            ddu.setId(Integer.parseInt(txtId.getText()));
            ddu.setUsuario(txtUsuario.getText());
            ddu.setNombre(txtNombre.getText());
            ddu.setApellido(txtApellido.getText());
            ddu.setCorreo(txtCorreo.getText() + lbEmail.getText());
            ddu.setEstado(Estado);
            String pass = DigestUtils.md5Hex(clave);
            ddu.setContraseña(pass);
            ddu.setPerfil(perfil);

            msg = lgu.EditarUsuario(ddu);

            if (msg.equals("si")) {
                limpiar();
                JOptionPane.showMessageDialog(rootPane, "Usuario Actualizado de Forma correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Ah Ocurrido un Error al actualizar", "Informacion", JOptionPane.ERROR_MESSAGE);

            }

        }

        if (!clave.endsWith(confClave)) {

            JOptionPane.showMessageDialog(null, "Las Contraseñas No coinsiden", "Informacion", JOptionPane.QUESTION_MESSAGE);

            txtClave.setText("");
            txtConfirmaClave.setText("");
        }
        BuscaUS("");
        habilitado(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitado(false);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        habilitado(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        BuscaUS(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnActivo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnInactivo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox btncVer;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirmaClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
