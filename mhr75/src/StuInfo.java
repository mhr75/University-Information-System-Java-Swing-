
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anik karmaker
 */
public class StuInfo extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form StuInfo
     */
    // Connection con;
    int index;
    static Socket s;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;

    public StuInfo(Socket a, ObjectInputStream b, ObjectOutputStream c) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mechaaboo.png")));
        setTitle("Student Info Tab");
        initComponents();
        s = a;
        dis = b;
        dos = c;
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
        setLocationRelativeTo(null);
        // createConnection();
        try {
            Show_Student_in_Jtable();
        } catch (Exception e) {
        }
    }

    public ArrayList<stInfo> getStudentList() throws SQLException {

        try {
            dos.writeObject("30");
            dos.flush();
            ArrayList<stInfo> stlist = new ArrayList<stInfo>();

            return stlist = (ArrayList<stInfo>) dis.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    public void Show_Student_in_Jtable() throws SQLException {
        ArrayList<stInfo> list = getStudentList();
        DefaultTableModel model = (DefaultTableModel) Student.getModel();
        //System.out.println("Booooo");
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            //System.out.println("nBooooo");
            row[0] = list.get(i).txt_name();
            row[1] = list.get(i).txt_id();
            row[2] = list.get(i).dname();
            row[3] = list.get(i).getEmail();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Student = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        name = new javax.swing.JButton();
        dept = new javax.swing.JButton();
        id = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Student Data Base", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Department", "Email"
            }
        ));
        Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Student);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back-arrow.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        name.setText("Sort by Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        dept.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dept.setText("Sort by Department");
        dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptActionPerformed(evt);
            }
        });

        id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        id.setText("Sort by ID");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/error.png"))); // NOI18N
        jButton5.setText("Block");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name)
                        .addGap(18, 18, 18)
                        .addComponent(dept)
                        .addGap(18, 18, 18)
                        .addComponent(id)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new admin(s, dis, dos).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        try {
            dos.writeObject("31");
            dos.flush();
            ArrayList<stInfo> stlist = new ArrayList<stInfo>();

            stlist = (ArrayList<stInfo>) dis.readObject();

            ArrayList<stInfo> list = stlist;
            DefaultTableModel model = (DefaultTableModel) Student.getModel();
            //System.out.println("Booooo");
            model.setRowCount(0);
            Object[] row = new Object[4];
            for (int i = 0; i < list.size(); i++) {
                //System.out.println("nBooooo");
                row[0] = list.get(i).txt_name();
                row[1] = list.get(i).txt_id();
                row[2] = list.get(i).dname();
                row[3] = list.get(i).getEmail();
                model.addRow(row);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_idActionPerformed

    private void deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptActionPerformed
        try {
            dos.writeObject("32");
            dos.flush();
            ArrayList<stInfo> stlist = new ArrayList<stInfo>();

            stlist = (ArrayList<stInfo>) dis.readObject();

            ArrayList<stInfo> list = stlist;
            DefaultTableModel model = (DefaultTableModel) Student.getModel();
            //System.out.println("Booooo");
            model.setRowCount(0);
            Object[] row = new Object[4];
            for (int i = 0; i < list.size(); i++) {
                //System.out.println("nBooooo");
                row[0] = list.get(i).txt_name();
                row[1] = list.get(i).txt_id();
                row[2] = list.get(i).dname();
                row[3] = list.get(i).getEmail();
                model.addRow(row);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_deptActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        try {
            dos.writeObject("33");
            dos.flush();
            ArrayList<stInfo> stlist = new ArrayList<stInfo>();

            stlist = (ArrayList<stInfo>) dis.readObject();

            ArrayList<stInfo> list = stlist;
            DefaultTableModel model = (DefaultTableModel) Student.getModel();
            //System.out.println("Booooo");
            model.setRowCount(0);
            Object[] row = new Object[4];
            for (int i = 0; i < list.size(); i++) {
                //System.out.println("nBooooo");
                row[0] = list.get(i).txt_name();
                row[1] = list.get(i).txt_id();
                row[2] = list.get(i).dname();
                row[3] = list.get(i).getEmail();
                model.addRow(row);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_nameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            int id = (getStudentList().get(index).txt_id());
            try {
                dos.writeObject("34");
                dos.flush();
                dos.writeObject("" + id);
                dos.flush();
                String r = (String) dis.readObject();
                if (r.equals("true")) {
                    JOptionPane.showMessageDialog(null, "Updated");
                }
            } catch (Exception ex) {
                System.out.println();
            }
            try {
                Show_Student_in_Jtable();
            } catch (Exception e) {
            }
        } catch (Exception ex) {
            //Logger.getLogger(main_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentMouseClicked
        // TODO add your handling code here:
        this.index = Student.getSelectedRow();
    }//GEN-LAST:event_StudentMouseClicked

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
            java.util.logging.Logger.getLogger(StuInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuInfo(s, dis, dos).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Student;
    private javax.swing.JButton dept;
    private javax.swing.JButton id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton name;
    // End of variables declaration//GEN-END:variables
}