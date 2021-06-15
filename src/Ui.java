
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import metodosInternos.MetodosInternos;
import metodos_externos.Intercalacion;
import metodos_externos.MezclaDirecta;
import metodos_externos.MezclaNatural;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ING-JUANMATA
 */
public class Ui extends javax.swing.JFrame {

    private int[] datos;
    MetodosInternos internos;
    MezclaNatural natural;
    MezclaDirecta directa;
    Intercalacion intercalacion;

    /**
     * Creates new form Ui
     */
    public Ui() {
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

        pnlOrdenamientos = new javax.swing.JPanel();
        btnBurbuja = new javax.swing.JButton();
        btnQuick = new javax.swing.JButton();
        btnRadix = new javax.swing.JButton();
        btnShell = new javax.swing.JButton();
        btnNatural = new javax.swing.JButton();
        btnDirecta = new javax.swing.JButton();
        btnIntercalacion = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        pnlResultados = new javax.swing.JPanel();
        pnlDesorden = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDesorden = new javax.swing.JList<>();
        pnlOrden = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaOrden = new javax.swing.JList<>();
        pnlInternos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuick = new javax.swing.JTextField();
        txtRadix = new javax.swing.JTextField();
        txtShell = new javax.swing.JTextField();
        txtBurbuja = new javax.swing.JTextField();
        pnlExternos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDirecto = new javax.swing.JTextField();
        txtIntercalacion = new javax.swing.JTextField();
        txtNatural = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlOrdenamientos.setLayout(new java.awt.GridLayout(8, 1, 0, 15));

        btnBurbuja.setText("BURBUJA");
        btnBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBurbujaActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnBurbuja);

        btnQuick.setText("QUICKSORT");
        btnQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnQuick);

        btnRadix.setText("RADIX");
        btnRadix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadixActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnRadix);

        btnShell.setText("SHELL");
        btnShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShellActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnShell);

        btnNatural.setText("MEZCLA NATURAL");
        btnNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaturalActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnNatural);

        btnDirecta.setText("MEZCLA DIRECTA");
        btnDirecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectaActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnDirecta);

        btnIntercalacion.setText("INTERCALACION");
        btnIntercalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntercalacionActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnIntercalacion);

        btnNuevo.setText("NUEVO SET");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlOrdenamientos.add(btnNuevo);

        getContentPane().add(pnlOrdenamientos, java.awt.BorderLayout.LINE_START);

        pnlResultados.setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        pnlDesorden.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(listaDesorden);

        pnlDesorden.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlResultados.add(pnlDesorden);

        pnlOrden.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(listaOrden);

        pnlOrden.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlResultados.add(pnlOrden);

        pnlInternos.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BURBUJA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUICKSORT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(jLabel2, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RADIX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SHELL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(jLabel4, gridBagConstraints);

        txtQuick.setEditable(false);
        txtQuick.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuick.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(txtQuick, gridBagConstraints);

        txtRadix.setEditable(false);
        txtRadix.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRadix.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(txtRadix, gridBagConstraints);

        txtShell.setEditable(false);
        txtShell.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtShell.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(txtShell, gridBagConstraints);

        txtBurbuja.setEditable(false);
        txtBurbuja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBurbuja.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlInternos.add(txtBurbuja, gridBagConstraints);

        pnlResultados.add(pnlInternos);

        pnlExternos.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("MEZCLA NATURAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(jLabel5, gridBagConstraints);

        jLabel6.setText("MEZCLA DIRECTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(jLabel6, gridBagConstraints);

        jLabel7.setText("INTERCALACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(jLabel7, gridBagConstraints);

        txtDirecto.setEditable(false);
        txtDirecto.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(txtDirecto, gridBagConstraints);

        txtIntercalacion.setEditable(false);
        txtIntercalacion.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(txtIntercalacion, gridBagConstraints);

        txtNatural.setEditable(false);
        txtNatural.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pnlExternos.add(txtNatural, gridBagConstraints);

        pnlResultados.add(pnlExternos);

        getContentPane().add(pnlResultados, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        int total = Integer.parseInt(JOptionPane.showInputDialog("INTRODUZCA EL TOTAL DE DATOS A ORDENAR"));
        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        datos = new int[total];
        for (int i = 0; i < total; i++) {
            datos[i] = (int) (Math.random() * Integer.MAX_VALUE);
            modelo.addElement(datos[i]);
        }
        listaDesorden.setModel(modelo);
        directa = new MezclaDirecta(datos);
        natural = new MezclaNatural(datos);
        int[] aux = new int[datos.length / 2];
        int[] aux2 = new int[datos.length - aux.length];
        System.arraycopy(datos, 0, aux, 0, datos.length / 2);
        System.arraycopy(datos, datos.length / 2, aux2, 0, aux2.length);
        intercalacion = new Intercalacion(aux, aux2);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaturalActionPerformed
        long total = System.currentTimeMillis();
        natural.ordenar();
        total = System.currentTimeMillis() - total;
        txtNatural.setText(total / 1000 + " SEGUNDOS");
    }//GEN-LAST:event_btnNaturalActionPerformed

    private void btnDirectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectaActionPerformed
        long total = System.currentTimeMillis();
        directa.ordenar();
        total = System.currentTimeMillis() - total;
        txtDirecto.setText(total / 1000 + " SEGUNDOS");
    }//GEN-LAST:event_btnDirectaActionPerformed

    private void btnIntercalacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntercalacionActionPerformed
        long total = System.currentTimeMillis();
        intercalacion.ordenar();
        total = System.currentTimeMillis() - total;
        txtIntercalacion.setText(total / 1000 + " SEGUNDOS");
    }//GEN-LAST:event_btnIntercalacionActionPerformed

    private void btnBurbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurbujaActionPerformed
        internos = new MetodosInternos(datos);
        long total = System.currentTimeMillis();
        internos.burbuja();
        total = System.currentTimeMillis() - total;
        txtBurbuja.setText(total + " MILISEGUNDOS");
        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        for (int i = 0; i < internos.A.length; i++) {
            modelo.addElement(internos.A[i]);
        }
        listaOrden.setModel(modelo);
    }//GEN-LAST:event_btnBurbujaActionPerformed

    private void btnQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickActionPerformed
        internos = new MetodosInternos(datos);
        long total = System.currentTimeMillis();
        internos.Quicksort();
        total = System.currentTimeMillis() - total;
        txtQuick.setText(total + " MILISEGUNDOS");
        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        for (int i = 0; i < internos.A.length; i++) {
            modelo.addElement(internos.A[i]);
        }
        listaOrden.setModel(modelo);
    }//GEN-LAST:event_btnQuickActionPerformed

    private void btnRadixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadixActionPerformed
        internos = new MetodosInternos(datos);
        long total = System.currentTimeMillis();
        internos.radix();
        total = System.currentTimeMillis() - total;
        txtRadix.setText(total + " MILISEGUNDOS");
        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        for (int i = 0; i < internos.A.length; i++) {
            modelo.addElement(internos.A[i]);
        }
        listaOrden.setModel(modelo);
    }//GEN-LAST:event_btnRadixActionPerformed

    private void btnShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShellActionPerformed
        internos = new MetodosInternos(datos);
        long total = System.currentTimeMillis();
        internos.shell();
        total = System.currentTimeMillis() - total;
        txtShell.setText(total + " MILISEGUNDOS");
        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        for (int i = 0; i < internos.A.length; i++) {
            modelo.addElement(internos.A[i]);
        }
        listaOrden.setModel(modelo);
    }//GEN-LAST:event_btnShellActionPerformed

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
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBurbuja;
    private javax.swing.JButton btnDirecta;
    private javax.swing.JButton btnIntercalacion;
    private javax.swing.JButton btnNatural;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuick;
    private javax.swing.JButton btnRadix;
    private javax.swing.JButton btnShell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Integer> listaDesorden;
    private javax.swing.JList<Integer> listaOrden;
    private javax.swing.JPanel pnlDesorden;
    private javax.swing.JPanel pnlExternos;
    private javax.swing.JPanel pnlInternos;
    private javax.swing.JPanel pnlOrden;
    private javax.swing.JPanel pnlOrdenamientos;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JTextField txtBurbuja;
    private javax.swing.JTextField txtDirecto;
    private javax.swing.JTextField txtIntercalacion;
    private javax.swing.JTextField txtNatural;
    private javax.swing.JTextField txtQuick;
    private javax.swing.JTextField txtRadix;
    private javax.swing.JTextField txtShell;
    // End of variables declaration//GEN-END:variables
}