
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Faculty extends javax.swing.JFrame implements Serializable {

    // Connection con;
    int id;
    static Socket s;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;

    public Faculty(int a, Socket aa, ObjectInputStream b, ObjectOutputStream c) {
        //System.out.println(a);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mechaaboo.png")));

        setTitle("Faculty Tab");
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
        id = a;
        s = aa;
        dis = b;
        dos = c;
        initComponents();
        //   createConnection();
        showInfo();
    }

    public Faculty(Socket aa, ObjectInputStream b, ObjectOutputStream c) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s = aa;
        dis = b;
        dos = c;
        initComponents();
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
        // createConnection();
        showInfo();
    }

    public void ShowItem(int index) throws SQLException {
        sid.setText(Integer.toString(getStudentList().get(index).txt_id()));
        sname.setText(getStudentList().get(index).txt_name());
        int a = getStudentList().get(index).txt_gen();
        if (a == 1) {
            sgen.setText("Male");
        } else {
            sgen.setText("Female");
        }
        sdname.setText(getStudentList().get(index).dname());

        // txt_name.setText(getStudentList().get(index).getName());
        // txt_id.setText(getStudentList().get(index).getId());
        // txt_sem.setText(Integer.toString(getStudentList().get(index).getSemester()));
        // txt_cgpa.setText(Double.toString(getStudentList().get(index).getCgpa()));
        // lbl_image.setIcon(ResizeImage(null,getStudentList().get(index).getImage()));
    }

    public ArrayList<stu> getStudentList() throws SQLException {
        try {
            String s = upc_id.getText();
          //  System.out.println(s);
            ArrayList<stu> stlist = new ArrayList<stu>();
            dos.writeObject("6");
            dos.flush();
            dos.writeObject(s);
            dos.flush();
            stlist = (ArrayList<stu>) dis.readObject();
            return stlist;
        } catch (Exception e) {

        }
        return null;
    }

    public void Show_Student_in_Jtable() throws SQLException {
        ArrayList<stu> list = getStudentList();
        DefaultTableModel model = (DefaultTableModel) Student.getModel();
        //   System.out.println("Booooo");
        model.setRowCount(0);
        Object[] row = new Object[1];
        for (int i = 0; i < list.size(); i++) {
            //     System.out.println("nBooooo");
            row[0] = list.get(i).txt_id();
            model.addRow(row);
        }
    }

    void showInfo() {
        try {
            dos.writeObject("7");
            dos.flush();
            dos.writeObject("" + id);
            dos.flush();
            List l = (List) dis.readObject();
            String pop[] = (String[]) l.get(0);
            txt_name.setText(pop[0]);
            int d = Integer.parseInt(pop[1]);
            String c;
            if (d == 1) {
                c = "Male";
            } else {
                c = "Female";
            }
            txt_gen.setText(c);
            txt_dname.setText(pop[2]);
            txt_id.setText(Integer.toString(id));

        } catch (Exception e) {
         //   System.out.println("Hei man how you doing !");
        }
    }

    void showNone() {
        c_id.setText("");
        cc_id.setText("");
        c_d.setText("");
        c_c.setText("");
        //  txt_rn.setText(Integer.toString(0));
        //  txt_amount.setText(Integer.toString(0));
        //  txt_dt.setText("");
    }

    public boolean checkInputs() {
        if (c_id.getText() == null || cc_id.getText() == null || c_d.getText() == null || c_c.getText() == null) {
            return false;
        } else {
            try {
                Integer.parseInt(c_c.getText());
                return true;
            } catch (Exception e) {
                //   System.out.println("Bhao");
                return false;
            }
        }
        //return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cc_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        c_d = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LogIn = new javax.swing.JButton();
        LogIn1 = new javax.swing.JButton();
        LogIn3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        c_c = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        upc_id = new javax.swing.JTextField();
        marks = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Student = new javax.swing.JTable();
        LogIn4 = new javax.swing.JButton();
        LogIn2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        sgen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sdname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txt_gen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_dname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        qwe = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        LogIn5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 3), "Faculty Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 102, 102))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 204)), "Course You Teach", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        cc_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Department:");

        c_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        c_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_idActionPerformed(evt);
            }
        });

        c_d.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Course Details :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Course_id:");

        LogIn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        LogIn.setText("Add");
        LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInActionPerformed(evt);
            }
        });

        LogIn1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update1.png"))); // NOI18N
        LogIn1.setText("Update");
        LogIn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn1ActionPerformed(evt);
            }
        });

        LogIn3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        LogIn3.setText("Delete");
        LogIn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Credit:");

        c_c.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        c_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("*all in capital letters");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_d)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(c_c, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LogIn1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LogIn3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogIn1)
                            .addComponent(LogIn3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogIn)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 2), "Update Marks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        upc_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        marks.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Marks:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Course ID:");

        Student.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Student ID"
            }
        ));
        Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Student);

        LogIn4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exchange.png"))); // NOI18N
        LogIn4.setText("Insert");
        LogIn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn4ActionPerformed(evt);
            }
        });

        LogIn2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        LogIn2.setText("Search");
        LogIn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enter.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marks, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogIn4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(LogIn2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogIn2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(upc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogIn4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(marks, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 204)), "Student Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        sgen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Department:");

        sname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Id:");

        sdname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Gender:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Name:");

        sid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sname)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(sdname))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(sgen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 204)), "Faculty Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(153, 255, 204));

        txt_gen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Department:");

        txt_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Id:");

        txt_dname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Gender:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Name:");

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        qwe.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        qwe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update1.png"))); // NOI18N
        qwe.setText("Update Info");
        qwe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qweActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("*all in capital letters");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(txt_gen)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dname)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(qwe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(qwe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        LogIn5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back1.png"))); // NOI18N
        LogIn5.setText("Back");
        LogIn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogIn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogIn5)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void c_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_idActionPerformed

    private void LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInActionPerformed
        String cId;
        if (checkInputs()) {
            try {
                dos.writeObject("8");
                dos.flush();
                List l = new ArrayList<>();
                String pop[] = new String[4];

                //PreparedStatement pre =con.prepareStatement("insert into course (course_id,course_details,dname,credit) values(?,?,?,? )");
                pop[0] = c_id.getText();
                pop[1] = (cc_id.getText());
                pop[2] = (c_d.getText());
                pop[3] = ((c_c.getText()));
                //pre.execute();
                l.add(pop);
                dos.writeObject(l);
                dos.flush();

                // System.out.println("heiyo");
                l = new ArrayList<>();
                pop = new String[2];

                pop[0] = "" + (id);
                pop[1] = (c_id.getText());
                l.add(pop);
                dos.writeObject(l);
                dos.flush();
                String res = (String) dis.readObject();
                if (res.equals("true")) {
                    JOptionPane.showMessageDialog(null, "New course Found!");
                } else {
                    JOptionPane.showMessageDialog(null, "New problem Found!");
                }
                showNone();
            } catch (Exception ex) {
                //System.out.println("lol");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Something wrong with your Inputs", "Wrong Insertion", -1);
        }

    }//GEN-LAST:event_LogInActionPerformed

    private void LogIn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn1ActionPerformed
        // TODO add your handling code here:
        try {
            dos.writeObject("9");
            dos.flush();
            List l = new ArrayList<>();
            String[] pop = new String[4];
            pop[0] = (cc_id.getText());
            pop[1] = (c_d.getText());
            pop[2] = ((c_c.getText()));
            pop[3] = (c_id.getText());
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();

            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "not Updated");
            }
        } catch (Exception ex) {
          //  System.out.println();
        }
    }//GEN-LAST:event_LogIn1ActionPerformed

    private void LogIn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn2ActionPerformed
        // TODO add your handling code here:
        try {
            Show_Student_in_Jtable();
        } catch (Exception e) {
            //    System.out.println("Hi ");
        }
    }//GEN-LAST:event_LogIn2ActionPerformed

    private void LogIn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn3ActionPerformed
        // TODO add your handling code here:
        try {

            dos.writeObject("10");
            dos.flush();
            List l = new ArrayList<>();
            String pop[] = new String[1];

            //PreparedStatement rp=con.prepareStatement("delete from teaches where c_id=?");
            pop[0] = (c_id.getText());
            // rp.executeUpdate();
            // rp.close();

            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            l = new ArrayList<>();
            pop = new String[1];
            //PreparedStatement ps=con.prepareStatement("delete from course where course_id=?");
            pop[0] = (c_id.getText());
            //ps.executeUpdate();
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Deleted");
            }
            showNone();

        } catch (Exception ex) {
            //      System.out.println("hoy nai hoy nai :p ");
        }
    }//GEN-LAST:event_LogIn3ActionPerformed

    private void LogIn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn4ActionPerformed
        // TODO add your handling code here:

        try {
            dos.writeObject("11");
            dos.flush();
            List l = new ArrayList<>();
            String pop[] = new String[4];
            //   PreparedStatement pre =con.prepareStatement("insert into result (std_id,f_id,c_id,gpa) values(?,?,?,?)");
            pop[0] = ((sid.getText()));
            pop[1] = ("" + id);
            pop[2] = (upc_id.getText());
            pop[3] = (marks.getText());
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Marks Updated");
            }

            showNone();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_LogIn4ActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void qweActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qweActionPerformed

        try {
            dos.writeObject("12");
            dos.flush();
            dos.writeObject("" + id);
            dos.flush();
            List l = new ArrayList<>();
            String pop[] = new String[2];
            //String UpdateQuery="update user set name= ?,gender=? where id="+id;
            //System.out.println("hoyy");
            //PreparedStatement   ps=con.prepareStatement(UpdateQuery);
            // System.out.println("hoyy");
            pop[0] = (txt_name.getText());
            pop[1] = txt_gen.getText();
            // System.out.println("hoyy");
            //int ew;
            // if(qwe.equalsIgnoreCase("female"))ew=2;
            // else ew=1;
            // ps.setInt(2, ew);
            // System.out.println("hoyy");
            // ps.executeUpdate();
            //ps.close();
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            l = new ArrayList<>();
            pop = new String[1];

            //UpdateQuery="update faculty set dname=? where id="+id;
            // System.out.println("hoyy 2");
            //ps=con.prepareStatement(UpdateQuery);
            // System.out.println("hoyy 2");
            pop[0] = (txt_dname.getText());
            // System.out.println("hoyy 2 ");
            //ps.executeUpdate();            
            // ps.close();
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Updated");
            }
        } catch (Exception ex) {
            //System.out.println("hoy nai");
        }
    }//GEN-LAST:event_qweActionPerformed

    private void LogIn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new login(s, dis, dos).setVisible(true);
    }//GEN-LAST:event_LogIn5ActionPerformed

    private void c_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cActionPerformed

    private void StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentMouseClicked
        // TODO add your handling code here:
        int index = Student.getSelectedRow();
        try {
            ShowItem(index);
        } catch (Exception ex) {
            //Logger.getLogger(main_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StudentMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            dos.writeObject("13");
            dos.flush();
            List l = new ArrayList<>();
            String pop[] = new String[2];

            //PreparedStatement pre =con.prepareStatement("update result set GPA=? where c_id=?");
            pop[0] = ((marks.getText()));
            pop[1] = (upc_id.getText());
            //pre.executeUpdate();
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Marks Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Marks not Updated");
            }
            showNone();
        } catch (Exception ex) {
            //  System.out.println("Update hoy nai");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Faculty(s, dis, dos).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogIn;
    private javax.swing.JButton LogIn1;
    private javax.swing.JButton LogIn2;
    private javax.swing.JButton LogIn3;
    private javax.swing.JButton LogIn4;
    private javax.swing.JButton LogIn5;
    private javax.swing.JTable Student;
    private javax.swing.JTextField c_c;
    private javax.swing.JTextField c_d;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField cc_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marks;
    private javax.swing.JButton qwe;
    private javax.swing.JTextField sdname;
    private javax.swing.JTextField sgen;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField txt_dname;
    private javax.swing.JTextField txt_gen;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField upc_id;
    // End of variables declaration//GEN-END:variables
}
