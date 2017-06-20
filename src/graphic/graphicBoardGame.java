package graphic;

import controller.PathagonController;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;

public class graphicBoardGame extends PathagonView{


    /**
     * Creates new form graphicBoardGame
     * @param c
     */
    public graphicBoardGame(PathagonController c) {
        super(c);
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

        p01 = new javax.swing.JButton();
        p00 = new javax.swing.JButton();
        p02 = new javax.swing.JButton();
        p03 = new javax.swing.JButton();
        p04 = new javax.swing.JButton();
        p05 = new javax.swing.JButton();
        p06 = new javax.swing.JButton();
        p10 = new javax.swing.JButton();
        p11 = new javax.swing.JButton();
        p12 = new javax.swing.JButton();
        p13 = new javax.swing.JButton();
        p14 = new javax.swing.JButton();
        p15 = new javax.swing.JButton();
        p16 = new javax.swing.JButton();
        p1 = new javax.swing.JButton();
        p2 = new javax.swing.JButton();
        p3 = new javax.swing.JButton();
        p4 = new javax.swing.JButton();
        p5 = new javax.swing.JButton();
        p6 = new javax.swing.JButton();
        p7 = new javax.swing.JButton();
        p8 = new javax.swing.JButton();
        p9 = new javax.swing.JButton();
        p17 = new javax.swing.JButton();
        p18 = new javax.swing.JButton();
        p19 = new javax.swing.JButton();
        p20 = new javax.swing.JButton();
        p21 = new javax.swing.JButton();
        p22 = new javax.swing.JButton();
        p23 = new javax.swing.JButton();
        p24 = new javax.swing.JButton();
        p25 = new javax.swing.JButton();
        p26 = new javax.swing.JButton();
        p27 = new javax.swing.JButton();
        p28 = new javax.swing.JButton();
        p29 = new javax.swing.JButton();
        p30 = new javax.swing.JButton();
        p31 = new javax.swing.JButton();
        p32 = new javax.swing.JButton();
        p33 = new javax.swing.JButton();
        p34 = new javax.swing.JButton();
        p35 = new javax.swing.JButton();
        p36 = new javax.swing.JButton();
        p37 = new javax.swing.JButton();
        p38 = new javax.swing.JButton();
        p39 = new javax.swing.JButton();
        p40 = new javax.swing.JButton();
        p41 = new javax.swing.JButton();
        p42 = new javax.swing.JButton();
        player = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p01MouseClicked(evt);
            }
        });
        getContentPane().add(p01, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 50, 40));

        p00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p00MouseClicked(evt);
            }
        });
        getContentPane().add(p00, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 50, 40));

        p02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p02MouseClicked(evt);
            }
        });
        getContentPane().add(p02, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 50, 40));

        p03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p03MouseClicked(evt);
            }
        });
        getContentPane().add(p03, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 50, 40));

        p04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p04MouseClicked(evt);
            }
        });
        getContentPane().add(p04, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 50, 40));

        p05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p05MouseClicked(evt);
            }
        });
        getContentPane().add(p05, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 50, 40));

        p06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p06MouseClicked(evt);
            }
        });
        getContentPane().add(p06, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 50, 40));

        p10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p10MouseClicked(evt);
            }
        });
        getContentPane().add(p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 50, 40));

        p11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p11MouseClicked(evt);
            }
        });
        getContentPane().add(p11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 50, 40));

        p12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p12MouseClicked(evt);
            }
        });
        getContentPane().add(p12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 50, 40));

        p13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p13MouseClicked(evt);
            }
        });
        getContentPane().add(p13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 50, 40));

        p14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p14MouseClicked(evt);
            }
        });
        getContentPane().add(p14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 50, 40));

        p15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p15MouseClicked(evt);
            }
        });
        getContentPane().add(p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 50, 40));

        p16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p16MouseClicked(evt);
            }
        });
        getContentPane().add(p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 50, 40));

        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });
        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 50, 40));

        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });
        getContentPane().add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 50, 40));

        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });
        getContentPane().add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 50, 40));

        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });
        getContentPane().add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 50, 40));

        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });
        getContentPane().add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 50, 40));

        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });
        getContentPane().add(p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 50, 40));

        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p7MouseClicked(evt);
            }
        });
        getContentPane().add(p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 50, 40));

        p8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p8MouseClicked(evt);
            }
        });
        getContentPane().add(p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 50, 40));

        p9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p9MouseClicked(evt);
            }
        });
        getContentPane().add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 50, 40));

        p17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p17MouseClicked(evt);
            }
        });
        getContentPane().add(p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 50, 40));

        p18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p18MouseClicked(evt);
            }
        });
        getContentPane().add(p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 50, 40));

        p19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p19MouseClicked(evt);
            }
        });
        getContentPane().add(p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 50, 40));

        p20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p20MouseClicked(evt);
            }
        });
        getContentPane().add(p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 50, 40));

        p21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p21MouseClicked(evt);
            }
        });
        getContentPane().add(p21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 50, 40));

        p22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p22MouseClicked(evt);
            }
        });
        getContentPane().add(p22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 50, 40));

        p23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p23MouseClicked(evt);
            }
        });
        getContentPane().add(p23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 50, 40));

        p24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p24MouseClicked(evt);
            }
        });
        getContentPane().add(p24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 50, 40));

        p25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p25MouseClicked(evt);
            }
        });
        getContentPane().add(p25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 50, 40));

        p26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p26MouseClicked(evt);
            }
        });
        getContentPane().add(p26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 50, 40));

        p27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p27MouseClicked(evt);
            }
        });
        getContentPane().add(p27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 50, 40));

        p28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p28MouseClicked(evt);
            }
        });
        getContentPane().add(p28, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 50, 40));

        p29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p29MouseClicked(evt);
            }
        });
        getContentPane().add(p29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 50, 40));

        p30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p30MouseClicked(evt);
            }
        });
        getContentPane().add(p30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 50, 40));

        p31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p31MouseClicked(evt);
            }
        });
        getContentPane().add(p31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 50, 40));

        p32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p32MouseClicked(evt);
            }
        });
        getContentPane().add(p32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 50, 40));

        p33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p33MouseClicked(evt);
            }
        });
        getContentPane().add(p33, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 50, 40));

        p34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p34MouseClicked(evt);
            }
        });
        getContentPane().add(p34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 50, 40));

        p35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p35MouseClicked(evt);
            }
        });
        getContentPane().add(p35, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 50, 40));

        p36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p36MouseClicked(evt);
            }
        });
        getContentPane().add(p36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 50, 40));

        p37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p37MouseClicked(evt);
            }
        });
        getContentPane().add(p37, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 50, 40));

        p38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p38MouseClicked(evt);
            }
        });
        getContentPane().add(p38, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 50, 40));

        p39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p39MouseClicked(evt);
            }
        });
        getContentPane().add(p39, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 50, 40));

        p40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p40MouseClicked(evt);
            }
        });
        getContentPane().add(p40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 50, 40));

        p41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p41MouseClicked(evt);
            }
        });
        getContentPane().add(p41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 50, 40));

        p42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p42MouseClicked(evt);
            }
        });
        getContentPane().add(p42, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 50, 40));

        player.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        player.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(player, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphic/image/Menu.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p00MouseClicked
        ModifyBotton(0,0);
    }//GEN-LAST:event_p00MouseClicked

    private void p01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p01MouseClicked
        ModifyBotton(1,0);
    }//GEN-LAST:event_p01MouseClicked

    private void p02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p02MouseClicked
        ModifyBotton(2,0);
    }//GEN-LAST:event_p02MouseClicked

    private void p03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p03MouseClicked
        ModifyBotton(3,0);
    }//GEN-LAST:event_p03MouseClicked

    private void p04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p04MouseClicked
        ModifyBotton(4,0);
    }//GEN-LAST:event_p04MouseClicked

    private void p05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p05MouseClicked
        ModifyBotton(5,0);
    }//GEN-LAST:event_p05MouseClicked

    private void p06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p06MouseClicked
        ModifyBotton(6,0);
    }//GEN-LAST:event_p06MouseClicked

    private void p10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p10MouseClicked
        ModifyBotton(0,1);
    }//GEN-LAST:event_p10MouseClicked

    private void p11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p11MouseClicked
        ModifyBotton(1,1);
    }//GEN-LAST:event_p11MouseClicked

    private void p12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p12MouseClicked
        ModifyBotton(2,1);
    }//GEN-LAST:event_p12MouseClicked

    private void p13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p13MouseClicked
        ModifyBotton(3,1);
    }//GEN-LAST:event_p13MouseClicked

    private void p14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p14MouseClicked
        ModifyBotton(4,1);
    }//GEN-LAST:event_p14MouseClicked

    private void p15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p15MouseClicked
        ModifyBotton(5,1);
    }//GEN-LAST:event_p15MouseClicked

    private void p16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p16MouseClicked
        ModifyBotton(6,1);
    }//GEN-LAST:event_p16MouseClicked

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        ModifyBotton(0,2);
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        ModifyBotton(1,2);
    }//GEN-LAST:event_p2MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        ModifyBotton(2,2);
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        ModifyBotton(3,2);
    }//GEN-LAST:event_p4MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        ModifyBotton(4,2);
    }//GEN-LAST:event_p5MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
        ModifyBotton(5,2);
    }//GEN-LAST:event_p6MouseClicked

    private void p7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p7MouseClicked
        ModifyBotton(6,2);
    }//GEN-LAST:event_p7MouseClicked

    private void p8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p8MouseClicked
        ModifyBotton(0,3);
    }//GEN-LAST:event_p8MouseClicked

    private void p9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p9MouseClicked
        ModifyBotton(1,3);
    }//GEN-LAST:event_p9MouseClicked

    private void p17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p17MouseClicked
        ModifyBotton(2,3);
    }//GEN-LAST:event_p17MouseClicked

    private void p18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p18MouseClicked
        ModifyBotton(3,3);
    }//GEN-LAST:event_p18MouseClicked

    private void p19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p19MouseClicked
        ModifyBotton(4,3);
    }//GEN-LAST:event_p19MouseClicked

    private void p20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p20MouseClicked
        ModifyBotton(5,3);
    }//GEN-LAST:event_p20MouseClicked

    private void p21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p21MouseClicked
        ModifyBotton(6,3);
    }//GEN-LAST:event_p21MouseClicked

    private void p22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p22MouseClicked
        ModifyBotton(0,4);
    }//GEN-LAST:event_p22MouseClicked

    private void p23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p23MouseClicked
        ModifyBotton(1,4);
    }//GEN-LAST:event_p23MouseClicked

    private void p24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p24MouseClicked
        ModifyBotton(2,4);
    }//GEN-LAST:event_p24MouseClicked

    private void p25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p25MouseClicked
        ModifyBotton(3,4);
    }//GEN-LAST:event_p25MouseClicked

    private void p26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p26MouseClicked
        ModifyBotton(4,4);
    }//GEN-LAST:event_p26MouseClicked

    private void p27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p27MouseClicked
        ModifyBotton(5,4);
    }//GEN-LAST:event_p27MouseClicked

    private void p28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p28MouseClicked
        ModifyBotton(6,4);
    }//GEN-LAST:event_p28MouseClicked

    private void p29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p29MouseClicked
        ModifyBotton(0,5);
    }//GEN-LAST:event_p29MouseClicked

    private void p30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p30MouseClicked
        ModifyBotton(1,5);
    }//GEN-LAST:event_p30MouseClicked

    private void p31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p31MouseClicked
        ModifyBotton(2,5);
    }//GEN-LAST:event_p31MouseClicked

    private void p32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p32MouseClicked
        ModifyBotton(3,5);
    }//GEN-LAST:event_p32MouseClicked

    private void p33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p33MouseClicked
        ModifyBotton(4,5);
    }//GEN-LAST:event_p33MouseClicked

    private void p34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p34MouseClicked
        ModifyBotton(5,5);
    }//GEN-LAST:event_p34MouseClicked

    private void p35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p35MouseClicked
        ModifyBotton(6,5);
    }//GEN-LAST:event_p35MouseClicked

    private void p36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p36MouseClicked
        ModifyBotton(0,6);
    }//GEN-LAST:event_p36MouseClicked

    private void p37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p37MouseClicked
        ModifyBotton(1,6);
    }//GEN-LAST:event_p37MouseClicked

    private void p38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p38MouseClicked
        ModifyBotton(2,6);
    }//GEN-LAST:event_p38MouseClicked

    private void p39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p39MouseClicked
        ModifyBotton(3,6);
    }//GEN-LAST:event_p39MouseClicked

    private void p40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p40MouseClicked
        ModifyBotton(4,6);
    }//GEN-LAST:event_p40MouseClicked

    private void p41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p41MouseClicked
        ModifyBotton(5,6);
    }//GEN-LAST:event_p41MouseClicked

    private void p42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p42MouseClicked
        ModifyBotton(6,6);
    }//GEN-LAST:event_p42MouseClicked

    private void ModifyBotton(int x, int y){
        if(!gameControl.playerHasTurn()) {
            JOptionPane.showMessageDialog(null,"No es tu turno!","Aviso:",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!gameControl.canPlay(gameState.PLAYER1)){
            JOptionPane.showMessageDialog(null,"Ups.. no te quedan fichas","Aviso:",JOptionPane.WARNING_MESSAGE);
            gameControl.nextTurn();
            return;
        }
        if (gameControl.validPosition(x,y,gameState.PLAYER1)) {
            gameControl.playerPlay(x, y);
        } else {
            JOptionPane.showMessageDialog(null,"Movimiento bloqueado!!","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void paintMove(int x,int y,int player){
        Color c;                      
        if(player==-1){
            c = Color.YELLOW;
        }else{
            if(player==1){
                c=Color.BLACK;
            }else{ 
                c = Color.LIGHT_GRAY;
            }
        }
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        p00.setBackground(c);
                        break;
                    case 1:
                        p10.setBackground(c);;
                        break;
                    case 2:
                        p1.setBackground(c);;
                        break;
                    case 3:
                        p8.setBackground(c);;
                        break;
                    case 4:
                        p22.setBackground(c);;
                        break;
                    case 5:
                        p29.setBackground(c);;
                        break;
                    case 6:
                        p36.setBackground(c);;
                        break;
                } 
                break;
            case 1:
                switch (y) {
                    case 0:
                        p01.setBackground(c);
                        break;
                    case 1:
                        p11.setBackground(c);;
                        break;
                    case 2:
                        p2.setBackground(c);;
                        break;
                    case 3:
                        p9.setBackground(c);;
                        break;
                    case 4:
                        p23.setBackground(c);;
                        break;
                    case 5:
                        p30.setBackground(c);;
                        break;
                    case 6:
                        p37.setBackground(c);;
                        break;
                }
                break;
            case 2:
                switch (y) {
                    case 0:
                        p02.setBackground(c);
                        break;
                    case 1:
                        p12.setBackground(c);;
                        break;
                    case 2:
                        p3.setBackground(c);;
                        break;
                    case 3:
                        p17.setBackground(c);;
                        break;
                    case 4:
                        p24.setBackground(c);;
                        break;
                    case 5:
                        p31.setBackground(c);;
                        break;
                    case 6:
                        p38.setBackground(c);;
                        break;
                }
                break;
            case 3:
                switch (y) {
                    case 0:
                        p03.setBackground(c);
                        break;
                    case 1:
                        p13.setBackground(c);;
                        break;
                    case 2:
                        p4.setBackground(c);;
                        break;
                    case 3:
                        p18.setBackground(c);;
                        break;
                    case 4:
                        p25.setBackground(c);;
                        break;
                    case 5:
                        p32.setBackground(c);;
                        break;
                    case 6:
                        p39.setBackground(c);;
                        break;
                }
                break;
            case 4:
                switch (y) {
                    case 0:
                        p04.setBackground(c);
                        break;
                    case 1:
                        p14.setBackground(c);;
                        break;
                    case 2:
                        p5.setBackground(c);;
                        break;
                    case 3:
                        p19.setBackground(c);;
                        break;
                    case 4:
                        p26.setBackground(c);;
                        break;
                    case 5:
                        p33.setBackground(c);;
                        break;
                    case 6:
                        p40.setBackground(c);;
                        break;
                }
                break;
            case 5:
                switch (y) {
                    case 0:
                        p05.setBackground(c);
                        break;
                    case 1:
                        p15.setBackground(c);;
                        break;
                    case 2:
                        p6.setBackground(c);;
                        break;
                    case 3:
                        p20.setBackground(c);;
                        break;
                    case 4:
                        p27.setBackground(c);;
                        break;
                    case 5:
                        p34.setBackground(c);;
                        break;
                    case 6:
                        p41.setBackground(c);;
                        break;
                }
                break;
            case 6:
                switch (y) {
                    case 0:
                        p06.setBackground(c);
                        break;
                    case 1:
                        p16.setBackground(c);;
                        break;
                    case 2:
                        p7.setBackground(c);;
                        break;
                    case 3:
                        p21.setBackground(c);;
                        break;
                    case 4:
                        p28.setBackground(c);;
                        break;
                    case 5:
                        p35.setBackground(c);;
                        break;
                    case 6:
                        p42.setBackground(c);;
                        break;
                }
            break;
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton p00;
    private javax.swing.JButton p01;
    private javax.swing.JButton p02;
    private javax.swing.JButton p03;
    private javax.swing.JButton p04;
    private javax.swing.JButton p05;
    private javax.swing.JButton p06;
    private javax.swing.JButton p1;
    private javax.swing.JButton p10;
    private javax.swing.JButton p11;
    private javax.swing.JButton p12;
    private javax.swing.JButton p13;
    private javax.swing.JButton p14;
    private javax.swing.JButton p15;
    private javax.swing.JButton p16;
    private javax.swing.JButton p17;
    private javax.swing.JButton p18;
    private javax.swing.JButton p19;
    private javax.swing.JButton p2;
    private javax.swing.JButton p20;
    private javax.swing.JButton p21;
    private javax.swing.JButton p22;
    private javax.swing.JButton p23;
    private javax.swing.JButton p24;
    private javax.swing.JButton p25;
    private javax.swing.JButton p26;
    private javax.swing.JButton p27;
    private javax.swing.JButton p28;
    private javax.swing.JButton p29;
    private javax.swing.JButton p3;
    private javax.swing.JButton p30;
    private javax.swing.JButton p31;
    private javax.swing.JButton p32;
    private javax.swing.JButton p33;
    private javax.swing.JButton p34;
    private javax.swing.JButton p35;
    private javax.swing.JButton p36;
    private javax.swing.JButton p37;
    private javax.swing.JButton p38;
    private javax.swing.JButton p39;
    private javax.swing.JButton p4;
    private javax.swing.JButton p40;
    private javax.swing.JButton p41;
    private javax.swing.JButton p42;
    private javax.swing.JButton p5;
    private javax.swing.JButton p6;
    private javax.swing.JButton p7;
    private javax.swing.JButton p8;
    private javax.swing.JButton p9;
    public javax.swing.JLabel player;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView() {
        PathagonToken ultimoMovimiento = this.gameState.getLastMove();
        if (!ultimoMovimiento.isNull()) {

            if (this.gameState.hasBlockedMoves()) {
                List<PathagonToken> fichasComidas = this.gameState.getBlockedMoves();
                for (PathagonToken removido : fichasComidas) {
                    paintMove(removido.row,removido.col,0);
                }
            }
            paintMove(ultimoMovimiento.row,ultimoMovimiento.col, ultimoMovimiento.player);

        }

        if(gameControl.hasEnded()){
            gameControl.showResult();
        } else {
            if(!gameControl.playerHasTurn())
                gameControl.iaPlay();
        }
    }

    @Override
    public void alertDraw(){
        JOptionPane.showMessageDialog(null, "¡Eso estuvo reñido! ¡Es un merecido empate!", "Aviso: ", JOptionPane.WARNING_MESSAGE);
        dispose();
    }
    
    
    @Override
    public void alertWinner(String player) {
        String msj="Ese fue un gran juego pero "+player+" lo hizo mejor. TENEMOS UN GANADOR";
        JOptionPane.showMessageDialog(null,msj,"¡FELICIDADES!",JOptionPane.WARNING_MESSAGE);
        dispose();
    }


}
