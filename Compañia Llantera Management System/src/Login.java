import Project.ConnectionProvider;
import Project.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static sun.util.calendar.CalendarUtils.mod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ENDUSER
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    ConnectionProvider con;
    Connection conn;
    public Login() {
        initComponents();
        new home().setVisible(true);
        //home.btnRegistrarUsuarios.setVisible(false);
        //home.btnEmpleados.setVisible(false);
        con=new ConnectionProvider();
        conn=con.getCon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 200, -1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 200, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("Mostrar Contraseña");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close Jframe.png"))); // NOI18N
        jButton2.setText("Cerrar aplicacion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 520, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGIN PRUEBA.gif"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login bg PRUEBA.jpeg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTON DE CERRAR APLICACION
        int a =JOptionPane.showConfirmDialog(null, "¿De verdad quieres cerrar la aplicacion?","Selecciona",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            System.exit(0);
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:login
       String Usuario  ="Administrador";
       String Contraseña ="pass";
       
       //String Empleado  = "usuarionormal"; //empleado
       String Contra = "asdfg";        //work
              
       String Pass = new String(jPasswordField1.getPassword());
       String user = new String(jTextField1.getText());
        try
        {
           // conn = con.getCon();
            //Statement st=conn.createStatement();
            //ResultSet rs= st.executeQuery("select id_usuarios, usuario, password_u, nombre_U, id_tipo from usuarios where usuario = ? ");
            conn = con.getCon();
            Statement st=conn.createStatement();   
            //ResultSet rs= st.executeQuery("select u.id_usuarios, u.usuario, u.password_u, u.nombre_U, t.nombre from usuarios as u INNER JOIN tipo_usuario as t on u.id_tipo = t.id where usuario ='"+user+"'");
            ResultSet rs= st.executeQuery("select * from usuarios where usuario = '"+user+"'" );
            if(rs.next())
            {
                if(Pass.equals(Contraseña) && user.equals(Usuario)){
                    JOptionPane.showMessageDialog(null,"Bienvenido "+user+"");
                   // if(user.equals(rs.getString(2))){
                        setVisible(false);
                       // home.btnEmpleados.setVisible(true);
                       // new home().setVisible(true);
                  //  }
                //jPasswordField1.setText(rs.getString(3));
                }else if(Pass.equals(Contra)){
                    JOptionPane.showMessageDialog(null,"Bienvenido "+user+"");
                    //if(jPasswordField1.getPassword().equals(rs.getString(3))){
                        setVisible(false);
                        home.btnRegistrarUsuarios.setVisible(false);
                        //home.btnEmpleados.setVisible(false);
                       // new home().setVisible(true); 
                  //  }
                }else if(Pass.equals(rs.getString(3))){
                    JOptionPane.showMessageDialog(null,"Bienvenido "+user+"");
                    setVisible(false);
                    home.btnRegistrarUsuarios.setVisible(false);
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"Los datos son erroneos");
                }
            }
            else
                JOptionPane.showMessageDialog(null,"Los datos son erroneos");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }  
    home.txtrecibi1.setText(jTextField1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            jPasswordField1.setEchoChar((char)0);
        }
        else
            jPasswordField1.setEchoChar('.');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
