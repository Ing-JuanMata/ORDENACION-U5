/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_externos;

<<<<<<< Updated upstream
import metodosInternos.MetodosInternos;
=======
import io.ManejoArchivo;
>>>>>>> Stashed changes
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import metodosInternos.MetodosInternos;

/**
 *
 * @author ING-JUANMATA
 */
public class UI extends javax.swing.JFrame {

    MezclaNatural natural;
    MezclaDirecta directa;
    Intercalacion intercalacion;
<<<<<<< Updated upstream
    
    MetodosInternos arregloA;
    MetodosInternos arregloB;
=======
    MetodosInternos arregloA;
    MetodosInternos arregloB;
    
>>>>>>> Stashed changes

    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Directorio = new javax.swing.JFileChooser();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        comboMetodos = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtMinimo = new javax.swing.JTextField();
        txtMaximo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnCrear.setText("Crear Archivo");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCrear, gridBagConstraints);

        btnLeer.setText("Leer Archivo");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnLeer, gridBagConstraints);

        comboMetodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mezcla Natural", "Mezcla Directa", "Intercalacion" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(comboMetodos, gridBagConstraints);

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnOrdenar, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Minimo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Maximo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Metodo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(txtCantidad, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(txtMinimo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(txtMaximo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        if (txtCantidad.getText().equals("") || txtMinimo.getText().equals("") || txtMaximo.getText().equals("")) {
            return;
        }
        
<<<<<<< Updated upstream
=======
        ManejoArchivo.eliminar("arregloA.u5");
        ManejoArchivo.eliminar("arregloB.u5");
        
>>>>>>> Stashed changes
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int minimo = Integer.parseInt(txtMinimo.getText());
        int maximo = Integer.parseInt(txtMaximo.getText());
        
        arregloA = new MetodosInternos();
        arregloB = new MetodosInternos();
        
        arregloA.arreglo(cantidad, minimo, maximo);
        arregloB.arreglo(cantidad, minimo, maximo);
<<<<<<< Updated upstream
=======
        
        String numsA = "";
        String numsB = "";

        for (int i = 0; i < cantidad; i++) {
            numsA += i == cantidad - 1 ? arregloA.A[i] : arregloA.A[i] + "\n";
        }

        for (int i = 0; i < cantidad; i++) {
            numsB += i == cantidad - 1 ? arregloB.A[i] : arregloB.A[i] + "\n";
        }
        
        if (ManejoArchivo.escribir(numsA, "arregloA.u5", true) && ManejoArchivo.escribir(numsB, "arregloB.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("arregloA.u5", "respaldoarregloA.u5");
            ManejoArchivo.copiarArchivo("arregloB.u5", "respaldoarregloB.u5");
            return;
        }else{
            System.out.println("FALLO DE INICIALIZACION");
        }
        
        
>>>>>>> Stashed changes
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        
        long tiempo;
        switch (comboMetodos.getSelectedIndex()) {
            case 0:
<<<<<<< Updated upstream
                natural = new MezclaNatural(arregloA.A);
=======
                natural = new MezclaNatural("arregloA.u5");
>>>>>>> Stashed changes
                tiempo = System.currentTimeMillis();
                natural.ordenar();
                tiempo = System.currentTimeMillis() - tiempo;
                JOptionPane.showMessageDialog(this, "La ordenacion ha durado: " + tiempo / 1000 + " segundos", "TIEMPO EJECUCION", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
<<<<<<< Updated upstream
                directa = new MezclaDirecta(arregloA.A);
=======
                directa = new MezclaDirecta("arregloA.u5");
>>>>>>> Stashed changes
                tiempo = System.currentTimeMillis();
                directa.ordenar();
                tiempo = System.currentTimeMillis() - tiempo;
                JOptionPane.showMessageDialog(this, "La ordenacion ha durado: " + tiempo / 1000 + " segundos", "TIEMPO EJECUCION", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
<<<<<<< Updated upstream
                arregloA.burbuja();
                arregloB.burbuja();

                intercalacion = new Intercalacion(arregloA.A, arregloB.A);
=======
                arregloA.Quicksort();
                arregloB.Quicksort();
                
                int cantidadA = arregloA.A.length;
                int cantidadB = arregloB.A.length;
                
                String numsA = "";
                String numsB = "";

                for (int i = 0; i < cantidadA; i++) {
                    numsA += i == cantidadA - 1 ? arregloA.A[i] : arregloA.A[i] + "\n";
                }

                for (int i = 0; i < cantidadB; i++) {
                    numsB += i == cantidadB - 1 ? arregloB.A[i] : arregloB.A[i] + "\n";
                }
                
                ManejoArchivo.eliminar("arregloA.u5");
                ManejoArchivo.eliminar("arregloB.u5");
                
                if (ManejoArchivo.escribir(numsA, "arregloA.u5", true) && ManejoArchivo.escribir(numsB, "arregloB.u5", true)) {
                    System.out.println("INICIALIZACION EXITOSA");
                    ManejoArchivo.copiarArchivo("arregloA.u5", "respaldoarregloA.u5");
                    ManejoArchivo.copiarArchivo("arregloB.u5", "respaldoarregloB.u5");
                } else {
                    System.out.println("FALLO DE INICIALIZACION");
                }
                
                
                intercalacion = new Intercalacion("arregloA.u5", "arregloB.u5");
>>>>>>> Stashed changes
                tiempo = System.currentTimeMillis();
                intercalacion.ordenar();
                tiempo = System.currentTimeMillis() - tiempo;
                JOptionPane.showMessageDialog(this, "La ordenacion ha durado: " + tiempo / 1000 + " segundos", "TIEMPO EJECUCION", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        Directorio.setCurrentDirectory(new File(System.getProperty("user.dir")));
        switch (comboMetodos.getSelectedIndex()) {
            case 0:
                if (Directorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File f = Directorio.getSelectedFile();
                    natural = new MezclaNatural(f.getAbsolutePath());
                }
                break;
            case 1:
                if (Directorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File f = Directorio.getSelectedFile();
                    directa = new MezclaDirecta(f.getAbsolutePath());
                }
                break;
            case 2:
                File f1 = null;
                File f2 = null;
                while (f1 == null) {
                    if (Directorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                        f1 = Directorio.getSelectedFile();
                    }
                }

                while (f2 == null) {
                    if (Directorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                        f2 = Directorio.getSelectedFile();
                    }
                }

                intercalacion = new Intercalacion(f1.getAbsolutePath(), f2.getAbsolutePath());

                break;
        }
    }//GEN-LAST:event_btnLeerActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Directorio;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> comboMetodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMaximo;
    private javax.swing.JTextField txtMinimo;
    // End of variables declaration//GEN-END:variables
}
