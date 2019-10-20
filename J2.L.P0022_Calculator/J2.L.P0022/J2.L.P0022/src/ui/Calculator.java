/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Drol
 */
public class Calculator extends javax.swing.JFrame {

    /**
     * Creates new form Calculator
     */
    public Calculator() {
        initComponents();
        this.setVisible(true);
    }

    public JLabel getjLabelStatus() {
        return jLabelStatus;
    }

    public void setjLabelStatus(JLabel jLabelStatus) {
        this.jLabelStatus = jLabelStatus;
    }

    public JButton getjButtonAddition() {
        return jButtonAddition;
    }

    public void setjButtonAddition(JButton jButtonAddition) {
        this.jButtonAddition = jButtonAddition;
    }

    public JButton getjButtonDivision() {
        return jButtonDivision;
    }

    public void setjButtonDivision(JButton jButtonDivision) {
        this.jButtonDivision = jButtonDivision;
    }

    public JButton getjButtonDot() {
        return jButtonDot;
    }

    public void setjButtonDot(JButton jButtonDot) {
        this.jButtonDot = jButtonDot;
    }

    public JButton getjButtonGetResult() {
        return jButtonGetResult;
    }

    public void setjButtonGetResult(JButton jButtonGetResult) {
        this.jButtonGetResult = jButtonGetResult;
    }

    public JButton getjButtonInverse() {
        return jButtonInverse;
    }

    public void setjButtonInverse(JButton jButtonInverse) {
        this.jButtonInverse = jButtonInverse;
    }

    public JButton getjButtonMemoryAdd() {
        return jButtonMemoryAdd;
    }

    public void setjButtonMemoryAdd(JButton jButtonMemoryAdd) {
        this.jButtonMemoryAdd = jButtonMemoryAdd;
    }

    public JButton getjButtonMemoryClear() {
        return jButtonMemoryClear;
    }

    public void setjButtonMemoryClear(JButton jButtonMemoryClear) {
        this.jButtonMemoryClear = jButtonMemoryClear;
    }

    public JButton getjButtonMemoryRecall() {
        return jButtonMemoryRecall;
    }

    public void setjButtonMemoryRecall(JButton jButtonMemoryRecall) {
        this.jButtonMemoryRecall = jButtonMemoryRecall;
    }

    public JButton getjButtonMemorySubtract() {
        return jButtonMemorySubtract;
    }

    public void setjButtonMemorySubtract(JButton jButtonMemorySubtract) {
        this.jButtonMemorySubtract = jButtonMemorySubtract;
    }

    public JButton getjButtonMultiply() {
        return jButtonMultiply;
    }

    public void setjButtonMultiply(JButton jButtonMultiply) {
        this.jButtonMultiply = jButtonMultiply;
    }

    public JButton getjButtonNumber0() {
        return jButtonNumber0;
    }

    public void setjButtonNumber0(JButton jButtonNumber0) {
        this.jButtonNumber0 = jButtonNumber0;
    }

    public JButton getjButtonNumber1() {
        return jButtonNumber1;
    }

    public void setjButtonNumber1(JButton jButtonNumber1) {
        this.jButtonNumber1 = jButtonNumber1;
    }

    public JButton getjButtonNumber2() {
        return jButtonNumber2;
    }

    public void setjButtonNumber2(JButton jButtonNumber2) {
        this.jButtonNumber2 = jButtonNumber2;
    }

    public JButton getjButtonNumber3() {
        return jButtonNumber3;
    }

    public void setjButtonNumber3(JButton jButtonNumber3) {
        this.jButtonNumber3 = jButtonNumber3;
    }

    public JButton getjButtonNumber4() {
        return jButtonNumber4;
    }

    public void setjButtonNumber4(JButton jButtonNumber4) {
        this.jButtonNumber4 = jButtonNumber4;
    }

    public JButton getjButtonNumber5() {
        return jButtonNumber5;
    }

    public void setjButtonNumber5(JButton jButtonNumber5) {
        this.jButtonNumber5 = jButtonNumber5;
    }

    public JButton getjButtonNumber6() {
        return jButtonNumber6;
    }

    public void setjButtonNumber6(JButton jButtonNumber6) {
        this.jButtonNumber6 = jButtonNumber6;
    }

    public JButton getjButtonNumber7() {
        return jButtonNumber7;
    }

    public void setjButtonNumber7(JButton jButtonNumber7) {
        this.jButtonNumber7 = jButtonNumber7;
    }

    public JButton getjButtonNumber8() {
        return jButtonNumber8;
    }

    public void setjButtonNumber8(JButton jButtonNumber8) {
        this.jButtonNumber8 = jButtonNumber8;
    }

    public JButton getjButtonNumber9() {
        return jButtonNumber9;
    }

    public void setjButtonNumber9(JButton jButtonNumber9) {
        this.jButtonNumber9 = jButtonNumber9;
    }

    public JButton getjButtonOpposition() {
        return jButtonOpposition;
    }

    public void setjButtonOpposition(JButton jButtonOpposition) {
        this.jButtonOpposition = jButtonOpposition;
    }

    public JButton getjButtonPercen() {
        return jButtonPercen;
    }

    public void setjButtonPercen(JButton jButtonPercen) {
        this.jButtonPercen = jButtonPercen;
    }

    public JButton getjButtonRoot() {
        return jButtonRoot;
    }

    public void setjButtonRoot(JButton jButtonRoot) {
        this.jButtonRoot = jButtonRoot;
    }

    public JButton getjButtonSubtraction() {
        return jButtonSubtraction;
    }

    public void setjButtonSubtraction(JButton jButtonSubtraction) {
        this.jButtonSubtraction = jButtonSubtraction;
    }

    public JTextField getjTextFieldShowResult() {
        return jTextFieldShowResult;
    }

    public void setjTextFieldShowResult(JTextField jTextFieldShowResult) {
        this.jTextFieldShowResult = jTextFieldShowResult;
    }

    public void addActionForButtonNumber(ActionListener al) {
        jButtonNumber0.addActionListener(al);
        jButtonNumber1.addActionListener(al);
        jButtonNumber2.addActionListener(al);
        jButtonNumber3.addActionListener(al);
        jButtonNumber4.addActionListener(al);
        jButtonNumber5.addActionListener(al);
        jButtonNumber6.addActionListener(al);
        jButtonNumber7.addActionListener(al);
        jButtonNumber8.addActionListener(al);
        jButtonNumber9.addActionListener(al);
    }

    public void addActionForButtonDot(ActionListener al) {
        jButtonDot.addActionListener(al);
    }

    public void addActionForOpposition(ActionListener al) {
        jButtonOpposition.addActionListener(al);
    }

    public void addActionForInversion(ActionListener al) {
        jButtonInverse.addActionListener(al);
    }

    public void addActionForSubmit(ActionListener al) {
        jButtonGetResult.addActionListener(al);
    }

    public void addActionForRoot(ActionListener al) {
        jButtonRoot.addActionListener(al);
    }

    public void addActionForPercent(ActionListener al) {
        jButtonPercen.addActionListener(al);
    }

    //+,-,*,/
    public void addActionForNormalOperator(ActionListener al) {
        jButtonAddition.addActionListener(al);
        jButtonDivision.addActionListener(al);
        jButtonSubtraction.addActionListener(al);
        jButtonMultiply.addActionListener(al);
    }

    public void addActionForMemoryClear(ActionListener al) {
        jButtonMemoryClear.addActionListener(al);
    }

    public void addActionForMemoryRecall(ActionListener al) {
        jButtonMemoryRecall.addActionListener(al);
    }

    public void addActionForMemoryAdd(ActionListener al) {
        jButtonMemoryAdd.addActionListener(al);
    }

    public void addActionForMemorySubtract(ActionListener al) {
        jButtonMemorySubtract.addActionListener(al);
    }

    public void setValueToScreen(String value) {
        jTextFieldShowResult.setText(value);
    }

    public String getValueInScreen() {
        return jTextFieldShowResult.getText();
    }

    public void setStatus(String status) {
        jLabelStatus.setText(status);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldShowResult = new javax.swing.JTextField();
        jButtonMemoryClear = new javax.swing.JButton();
        jButtonMemoryRecall = new javax.swing.JButton();
        jButtonMemoryAdd = new javax.swing.JButton();
        jButtonMemorySubtract = new javax.swing.JButton();
        jButtonRoot = new javax.swing.JButton();
        jButtonNumber7 = new javax.swing.JButton();
        jButtonNumber8 = new javax.swing.JButton();
        jButtonNumber9 = new javax.swing.JButton();
        jButtonDivision = new javax.swing.JButton();
        jButtonPercen = new javax.swing.JButton();
        jButtonNumber4 = new javax.swing.JButton();
        jButtonNumber5 = new javax.swing.JButton();
        jButtonNumber6 = new javax.swing.JButton();
        jButtonMultiply = new javax.swing.JButton();
        jButtonInverse = new javax.swing.JButton();
        jButtonNumber1 = new javax.swing.JButton();
        jButtonNumber2 = new javax.swing.JButton();
        jButtonNumber3 = new javax.swing.JButton();
        jButtonSubtraction = new javax.swing.JButton();
        jButtonNumber0 = new javax.swing.JButton();
        jButtonDot = new javax.swing.JButton();
        jButtonOpposition = new javax.swing.JButton();
        jButtonAddition = new javax.swing.JButton();
        jButtonGetResult = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Calculator");
        setResizable(false);

        jTextFieldShowResult.setEditable(false);
        jTextFieldShowResult.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jTextFieldShowResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldShowResult.setText("0");

        jButtonMemoryClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonMemoryClear.setText("MC");

        jButtonMemoryRecall.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonMemoryRecall.setText("MR");

        jButtonMemoryAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonMemoryAdd.setText("M+");

        jButtonMemorySubtract.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonMemorySubtract.setText("M-");
        jButtonMemorySubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemorySubtractActionPerformed(evt);
            }
        });

        jButtonRoot.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonRoot.setText("√");

        jButtonNumber7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber7.setText("7");

        jButtonNumber8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber8.setText("8");

        jButtonNumber9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber9.setText("9");

        jButtonDivision.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonDivision.setText("/");

        jButtonPercen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonPercen.setText("%");

        jButtonNumber4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber4.setText("4");

        jButtonNumber5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber5.setText("5");

        jButtonNumber6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber6.setText("6");

        jButtonMultiply.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonMultiply.setText("*");

        jButtonInverse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonInverse.setText("1/x");

        jButtonNumber1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber1.setText("1");

        jButtonNumber2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber2.setText("2");

        jButtonNumber3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber3.setText("3");

        jButtonSubtraction.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonSubtraction.setText("-");

        jButtonNumber0.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNumber0.setText("0");

        jButtonDot.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonDot.setText(".");

        jButtonOpposition.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonOpposition.setText("+/-");

        jButtonAddition.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonAddition.setText("+");

        jButtonGetResult.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonGetResult.setText("=");

        jLabelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStatus.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldShowResult)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonMemoryClear, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonMemoryRecall, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonMemoryAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonMemorySubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonInverse, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSubtraction, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPercen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDot, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonOpposition, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAddition, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGetResult, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldShowResult, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMemoryClear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMemoryRecall, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMemoryAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMemorySubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPercen, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInverse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSubtraction, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDot, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonOpposition, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddition, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonGetResult, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMemorySubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemorySubtractActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemorySubtractActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddition;
    private javax.swing.JButton jButtonDivision;
    private javax.swing.JButton jButtonDot;
    private javax.swing.JButton jButtonGetResult;
    private javax.swing.JButton jButtonInverse;
    private javax.swing.JButton jButtonMemoryAdd;
    private javax.swing.JButton jButtonMemoryClear;
    private javax.swing.JButton jButtonMemoryRecall;
    private javax.swing.JButton jButtonMemorySubtract;
    private javax.swing.JButton jButtonMultiply;
    private javax.swing.JButton jButtonNumber0;
    private javax.swing.JButton jButtonNumber1;
    private javax.swing.JButton jButtonNumber2;
    private javax.swing.JButton jButtonNumber3;
    private javax.swing.JButton jButtonNumber4;
    private javax.swing.JButton jButtonNumber5;
    private javax.swing.JButton jButtonNumber6;
    private javax.swing.JButton jButtonNumber7;
    private javax.swing.JButton jButtonNumber8;
    private javax.swing.JButton jButtonNumber9;
    private javax.swing.JButton jButtonOpposition;
    private javax.swing.JButton jButtonPercen;
    private javax.swing.JButton jButtonRoot;
    private javax.swing.JButton jButtonSubtraction;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JTextField jTextFieldShowResult;
    // End of variables declaration//GEN-END:variables
}
