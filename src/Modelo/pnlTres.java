
package Modelo;

import javax.swing.*;

public class pnlTres extends JPanel {

    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    
    public pnlTres() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/feeedback.png"))); // NOI18N
        jLabel1.setText("Recepcion");
        jLabel1.setFocusable(false);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 0, 443, 108));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagenVivanda2.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 114, 633, 429));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoBlanco.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 560));
    }// </editor-fold>                        
                 
}
