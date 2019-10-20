/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Drol
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        this.setVisible(true);
    }

    public JButton getjButtonDecodeProgram() {
        return jButtonDecodeProgram;
    }

    public void setjButtonDecodeProgram(JButton jButtonDecodeProgram) {
        this.jButtonDecodeProgram = jButtonDecodeProgram;
    }

    public JButton getjButtonEncodeProgram() {
        return jButtonEncodeProgram;
    }

    public void setjButtonEncodeProgram(JButton jButtonEncodeProgram) {
        this.jButtonEncodeProgram = jButtonEncodeProgram;
    }

    public void addActionListenerEncodeProgram(ActionListener al) {
        jButtonEncodeProgram.addActionListener(al);
    }

    public void addActionListenerDecodeProgram(ActionListener al) {
        jButtonDecodeProgram.addActionListener(al);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEncodeProgram = new javax.swing.JButton();
        jButtonDecodeProgram = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonEncodeProgram.setText("Encrypt");

        jButtonDecodeProgram.setText("Decrypt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDecodeProgram, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jButtonEncodeProgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDecodeProgram, jButtonEncodeProgram});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButtonEncodeProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButtonDecodeProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonDecodeProgram, jButtonEncodeProgram});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDecodeProgram;
    private javax.swing.JButton jButtonEncodeProgram;
    // End of variables declaration//GEN-END:variables
}
