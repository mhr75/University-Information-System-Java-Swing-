
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame implements Runnable, Serializable {

    //static Connection con;
    static Socket s;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;
    JFrame frame = new JFrame();
    public static String password = "102030";

    public login(Socket a, ObjectInputStream b, ObjectOutputStream c) {
        s = a;
        dis = b;
        dos = c;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mechaaboo.png")));
        setTitle("Log in Option");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    dos.writeObject("404");
                    dos.flush();
                    e.getWindow().dispose();
                } catch (Exception ee) {

                }
                System.exit(0);
            }
        });
        setLocation(750, 450);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogIn = new javax.swing.JButton();
        forgotPassword = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_us = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel1.setToolTipText("Log In");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("User ID:");

        LogIn.setBackground(new java.awt.Color(255, 255, 255));
        LogIn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/classroom.png"))); // NOI18N
        LogIn.setText("Log In");
        LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInActionPerformed(evt);
            }
        });

        forgotPassword.setBackground(new java.awt.Color(255, 255, 255));
        forgotPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        forgotPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset_password_1201020.png"))); // NOI18N
        forgotPassword.setText("Forgot Password");
        forgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Password:");

        txt_us.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_pass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back-arrow.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Log in Bar");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N

        jLabel6.setText("------------------------------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(forgotPassword))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_pass)
                                    .addComponent(txt_us, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_us, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forgotPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogIn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInActionPerformed
        try {

         //   System.out.println("hey again ");
            boolean mhr = true;
            String abc = (String) txt_pass.getText();
            if (txt_us.getText().equalsIgnoreCase("admin")) {
               // System.out.println("hey again 2");

                if (abc.equals(password)) {
                 //   System.out.print("hiiiiii");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(false);
                    mhr = false;
                    new admin(s, dis, dos).setVisible(true);
                }
            }
            if (mhr) {
                int a = Integer.parseInt(txt_us.getText());
                dos.writeObject("1");
                dos.flush();
                dos.writeObject((String) "" + a);
                dos.flush();
                List l = (List) dis.readObject();
                String[] pop = (String[]) l.get(0);

                int d = 0;
                boolean adi = true;
                String b = pop[0];
                d = Integer.parseInt(pop[1]);
                int appz = Integer.parseInt(pop[2]);
                String c = txt_pass.getText();
                if (b.equals(c)) {
                    adi = false;
                    if (appz == 1) {
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setVisible(false);
                        if (d == 1) {
                            new Student(a, s, dis, dos).setVisible(true);
                            adi = false;
                        }
                        if (d == 2) {
                            new Faculty(a, s, dis, dos).setVisible(true);
                            adi = false;
                        }
                        if (d == 3) {
                            new Accountent(a, s, dis, dos).setVisible(true);
                            adi = false;
                        }

                    }
                    if (appz == 2) {
                        JLabel label = new JLabel("Your account Rejected By Admin");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "ERROR OCCURED", JOptionPane.WARNING_MESSAGE);
                        //JOptionPane.showMessageDialog(null, "Your account Rejected By Admin");
                    }
                    if (appz == 3) {
                        JLabel label = new JLabel("Your account Blocked By Admin");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "ERROR OCCURED", JOptionPane.WARNING_MESSAGE);

                        //JOptionPane.showMessageDialog(null, "Your account Blocked By Admin");
                    }
                    if (appz == 0) {
                        JLabel label = new JLabel("Wait for Approval");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "ERROR OCCURED", JOptionPane.WARNING_MESSAGE);

                        // JOptionPane.showMessageDialog(null, "Wait for Approval");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Something wrong with your Pass or with your username ");
                    setVisible(false);
                    new login(s, dis, dos).setVisible(true);
                }

                //  break Loop1;
            }

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null,"Something wrong with your Pass or with your username ");
        }

    }//GEN-LAST:event_LogInActionPerformed

    private void forgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ForgotPassword(s, dis, dos).setVisible(true);
    }//GEN-LAST:event_forgotPasswordActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed

    }//GEN-LAST:event_txt_passActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);

        new Home(s, dis, dos).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogIn;
    private javax.swing.JButton forgotPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_us;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
