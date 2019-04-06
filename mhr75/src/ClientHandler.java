

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

   public class ClientHandler extends Thread  implements Serializable
{ 
       Connection con;
    final ObjectInputStream dis; 
    final ObjectOutputStream dos; 
    final Socket s; 
  
    public ClientHandler(Socket s, ObjectInputStream dis, ObjectOutputStream dos)  
    { 
    
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
        createConnection();
    }
    
    void createConnection()
    {
     try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","root");
     }
     
     catch(Exception e )
     {
         
     }
    }
    
    
    
    @Override
    public void run()  
    {  
        Loop2:
     while(true)
     {
     try {
            if(s==null){break;}
                String abc = (String) dis.readObject();
                System.out.println(abc+"<<----");
                switch(abc)
                {
                    case "1":
                    {
                        List l =new ArrayList<>();
                        String a =(String) dis.readObject();
                        System.out.println(a+"<<--");
                        Statement st= con.createStatement();
                        ResultSet rs= st.executeQuery("select password,UserType,app from user where id='"+a+"'");
                        boolean adi=true;
                        Loop1:
                        while(rs.next())
                        {
                            String [] pop = new String [3];
                            pop[1-1]= rs.getString("password");
                            pop[2-1]= (rs.getString("UserType"));
                            pop[3-1]=(rs.getString("app"));
                            l.add(pop);
                        }
                        st.close();
                        rs.close();
                    dos.writeObject(l);
                    dos.flush();
                    }
                    break;
                    
                    case "2":
                    {
                        List l= (ArrayList)dis.readObject();
                        String [] pop =(String[]) l.get(0);
                        PreparedStatement pst =con.prepareStatement("update user set password = ? where Name=? and ID=? and ans=?");
                        pst.setString(1,pop[0]);
                        pst.setString(2,pop[1]);
                        pst.setInt(3,Integer.parseInt(pop[02]));
                        pst.setString(4,pop[3]);
                        pst.execute();
                        pst.close();
                        dos.writeObject("true");
                        dos.flush();
                    }
                    break;
                    
                    case "3":
                    {
                            List l= new ArrayList<>();
                            String pop [] =new String [2];
                            String id=(String)dis.readObject();
                            int a = Integer.parseInt(id);
                            Statement st= con.createStatement();
                            ResultSet rs= st.executeQuery("select name,gender from user where id="+a);
                            Loop1:
                            while(rs.next())
                            {
                            pop[0]= rs.getString("name");
                            pop[1]=rs.getString("gender");
                            break Loop1;
                            }
                            l.add(pop);
                            dos.writeObject(l);
                            dos.flush();
                           st.close();
                           rs.close();   
                    }
                    break;
                    
                    case "4":
                    {
                    List l=(List) dis.readObject();
                    String [] pop =(String []) l.get(0);
                    PreparedStatement pre =con.prepareStatement("insert into fees (std_id,acc_id,Recipt_no,Bank_name,Date,Amount) values(?,?,?,?,?,? )");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setInt(2,Integer.parseInt(pop[1]));
                    pre.setInt(3,Integer.parseInt( pop[2]));
                    pre.setString(4,pop[3]);
                    pre.setString(5,pop[4]);
                    pre.setInt(6,Integer.parseInt( pop[5]));
                    pre.execute();
                    pre.close();
                    String kop="true";
                    dos.writeObject(kop);
                    dos.flush();
                    }
                    break;
                    
                    case "5":
                    {
                    String id = (String) dis.readObject();
                    int a = Integer.parseInt(id);
                    List l = (List)dis.readObject();
                    String pop []= (String [])l.get(0);
                    String UpdateQuery="update user set name= ?,gender=? where id="+a;
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setString(1, pop[0]);
                    String qwe =pop[1];
                    int ew;
                    if(qwe.equalsIgnoreCase("female"))ew=2;
                    else ew=1;
                    ps.setInt(2, ew);
                    ps.executeUpdate();
                    ps.close();
                    String res ="true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case "6":
                    {
                        ArrayList <stu> stlist=new ArrayList<stu>();
                        String aa = (String) dis.readObject();
                    PreparedStatement st=con.prepareStatement("select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id=?");
                    st.setString(1,aa);
                    ResultSet rs=st.executeQuery();
                    stu u;
                    while(rs.next())
                    {
                    u=new stu(Integer.parseInt(rs.getString("id")),rs.getString("Name"),Integer.parseInt(rs.getString("gender")),rs.getString("dname"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                      rs.close();
                    }
                    break;
                    
                    case"7":
                    {
                    String id=(String)dis.readObject();
                    int aa = Integer.parseInt(id);
                    Statement st =con.createStatement();
                    String a="select user.name,user.gender,faculty.dname from  user INNER JOIN faculty ON  user.id = faculty.id where user.id="+aa;
                    ResultSet rs=st.executeQuery(a);
                    List l= new ArrayList<>();
                    String pop [] =new String [3];
                   
                    while(rs.next())
                    {
                    pop[0]=(rs.getString("name"));
                    pop[1]=(rs.getString("gender"));
                    pop[2]=(rs.getString("dname"));
                    
                    }
                    l.add(pop);
                    dos.writeObject(l);
                    dos.flush();
                      st.close();
                      rs.close();
                    }
                    break;
                    
                    case"8":
                    {
                    List l= (List) dis.readObject();
                    String [] pop= (String[])l.get(0);
                    PreparedStatement pre =con.prepareStatement("insert into course (course_id,course_details,dname,credit) values(?,?,?,? )");
                    
                    pre.setString(1,pop[0]);
                    pre.setString(2,pop[1]);
                    pre.setString(3,pop[02]);
                    pre.setInt(4,Integer.parseInt(pop[03]));
                    pre.execute();
                    pre.close();
                    
                    l= (List) dis.readObject();
                    pop= (String[])l.get(0);
                    pre =con.prepareStatement("insert into teaches (f_id,c_id) values(?,?)");
              
                    pre.setInt(1,Integer.parseInt(pop[0]));
                    pre.setString(2,pop[1]);
                    pre.execute();
                    pre.close();
                    String res="true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"9":
                    {
                        List l= (List) dis.readObject();
                        String pop [] = (String[])l.get(0);
                        
                    String UpdateQuery="update course set course_details= ?,dname=?,credit=? where course_id=?";
                 PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setString(1, pop[0]);
                    ps.setString(2,pop[01]);
                    ps.setInt(3,Integer.parseInt(pop[02]));
                    ps.setString(4,pop[03]);
                    ps.executeUpdate();
                    ps.close();
                    String res= "true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"10":
                    {
                        List l= (List) dis.readObject();
                    String [] pop= (String[])l.get(0);
                    PreparedStatement rp=con.prepareStatement("delete from teaches where c_id=?");
                    rp.setString(1, pop[0]);
                    rp.executeUpdate();
                    rp.close();
                    l= (List) dis.readObject();
                    pop= (String[])l.get(0);
                    PreparedStatement ps=con.prepareStatement("delete from course where course_id=?");
                    ps.setString(1,pop[0]);
                    ps.executeUpdate();
                    ps.close();
                    String res= "true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"11":
                    {
                    List l = (List)dis.readObject();
                    String pop [] =(String [])l.get(0);
                    PreparedStatement pre =con.prepareStatement("insert into result (std_id,f_id,c_id,gpa) values(?,?,?,?)");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setInt(2,Integer.parseInt(pop[1]));
                    pre.setString(3, pop[2]);
                    pre.setString(4,pop[3]);
                    pre.execute();
                    pre.close();
                    String res= "true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"12":
                    {
                        
                    String id=(String)dis.readObject();
                    int aa = Integer.parseInt(id);
                    String UpdateQuery="update user set name= ?,gender=? where id="+aa;
                        //System.out.println("hoyy");
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    // System.out.println("hoyy");
                     List l= (List) dis.readObject();
                    String [] pop= (String[])l.get(0);
                    ps.setString(1, pop[0]);
                    String qwe =pop[1];
                      // System.out.println("hoyy");
                    int ew;
                    if(qwe.equalsIgnoreCase("female"))ew=2;
                    else ew=1;
                    ps.setInt(2, ew);
                      // System.out.println("hoyy");
                    ps.executeUpdate();
                    ps.close();
                    
                    l= (List) dis.readObject();
                    pop= (String[])l.get(0);
                    
                    
                    UpdateQuery="update faculty set dname=? where id="+id;
                       // System.out.println("hoyy 2");
                     ps=con.prepareStatement(UpdateQuery);
                      // System.out.println("hoyy 2");
                     ps.setString(1, pop[0]);
                       // System.out.println("hoyy 2 ");
                       ps.executeUpdate();            
                    ps.close();
                    String res= "true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"13":
                    {
                        List l = (List)dis.readObject();
                    String pop [] =(String [])l.get(0);
                    PreparedStatement pre =con.prepareStatement("update result set GPA=? where c_id=?");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setString(2,pop[1]);
                    pre.executeUpdate();
                    pre.close();
                    String res= "true";
                    dos.writeObject(res);
                    dos.flush();
                    }
                    break;
                    
                    case"14":
                    {
                        String a=(String) dis.readObject();
                        ArrayList <result> stlist=new ArrayList<result>();
                        PreparedStatement st=con.prepareStatement("SELECT distinct result.c_id, user.name, result.gpa FROM ((result INNER JOIN teaches ON result.f_id = teaches.f_id) INNER JOIN user ON teaches.f_id = user.id) where result.std_id=?");
                         st.setString(1,a);
                        ResultSet rs=st.executeQuery();
                        result u;
                        int i=0;
                        while(rs.next())
                        {
                         u=new result(Integer.parseInt(a),rs.getString("c_id"),(rs.getString("name")),Integer.parseInt(rs.getString("GPA")));
                         stlist.add(u);
                        }
                        dos.writeObject( stlist);
                        dos.flush();
                          st.close();
                        rs.close();
                    }
                    break;
                    
                    case"15":
                    {
                        List l =new ArrayList <>();
                        String pop[]=new String[5];
                        int aa=(int)dis.readObject();
                        
                        String b= "select user.ID, user.Name, user.gender, student.dname,amount from ((user inner join student on user.ID = student.ID)inner join fees on student.ID = fees.std_id) where user.id=?";   
                        PreparedStatement st=con.prepareStatement(b);
                         st.setInt(1,aa);
                        ResultSet rs=st.executeQuery();
                        boolean adi=true;
                        while(rs.next())
                        {
                            adi=false;
                           // System.out.println("Result set er infos");
                        pop[0]=(rs.getString("name"));
                        pop[1]= (rs.getString("gender"));
                        pop[2]=(rs.getString("dname"));
                        pop[3]=""+aa;
                        pop[4]= (rs.getString("amount"));
                        break;
                        }
                        if(adi)l=feeLess(aa);
                        else l.add(pop);
                        dos.writeObject(l);
                        dos.flush();
                          st.close();
                        rs.close();
                    }
                    break;
                    
                    case"16":
                    {
                        String id=(String)dis.readObject();
                        int aa = Integer.parseInt(id);
                        List l = (List) dis.readObject();
                        String pop[]=(String[]) l.get(0);
                        String UpdateQuery="update user set name= ?,gender=? where id="+aa;
                        PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                        ps.setString(1, pop[0]);
                        String qwe =pop[1];
                        int ew;
                        if(qwe.equalsIgnoreCase("female"))ew=2;
                        else ew=1;
                        ps.setInt(2, ew);
                        ps.executeUpdate();
                        ps.close();
                        l = (List) dis.readObject();
                        pop=(String[]) l.get(0);
                        
                        UpdateQuery="update Student set dname=? where id="+aa;
                        ps=con.prepareStatement(UpdateQuery);
                        ps.setString(1,pop[0]);
                        ps.executeUpdate();            
                        ps.close();
                        String res = "true";
                        dos.writeObject(res);
                        dos.flush();
                    }
                    break;
                    
                    case"17":
                    {
                        ArrayList <cours> stlist=new ArrayList<cours>();
                        String query= "Select * from course";
                        Statement st=con.createStatement();
                        ResultSet rs=st.executeQuery(query);
                        cours stu;
                        while(rs.next())
                        {
                        stu=new cours(rs.getString("course_id"),rs.getString("course_details"),rs.getString("dname"),Integer.parseInt(rs.getString("credit")));
                        stlist.add(stu);
                        }
                        dos.writeObject(stlist);
                        dos.flush();
                          st.close();
                        rs.close();
                    }
                    break;
                    
                    case"18":
                    {
                        List l = (List) dis.readObject();
                        String [] pop = (String []) l.get(0);
                        PreparedStatement pre =con.prepareStatement("insert into takes (s_id,c_id) values(?,?)"); 
                        pre.setInt(1,Integer.parseInt(pop[0]));
                        pre.setString(2,pop[1]);
                        pre.execute();
                        pre.close();
                        String res= "true";
                        dos.writeObject(res);
                        dos.flush();
                    }
                    break;
                    
                    case"19":
                    {
                        String id = (String) dis.readObject();
                    PreparedStatement rp=con.prepareStatement("delete from takes where c_id=?");
                     rp.setString(1, id);
                    rp.executeUpdate();
                    rp.close();
                    String res= "true";
                        dos.writeObject(res);
                        dos.flush();
                    }
                    break;
                    
                    case"20":
                    {
                    List l = (List) dis.readObject();
                        String [] pop = (String []) l.get(0);
                            
                    PreparedStatement pre =con.prepareStatement("insert into user (ID,Name,Password,Gender,UserType,Ans,email) values(?,?,?,?,?,?,? )");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setString(2, pop[01]);
                    pre.setString(3,(pop[02]));
                    pre.setInt(4, Integer.parseInt(pop[03]));
                    int b;
                    pre.setInt(5,b=Integer.parseInt(pop[04]));
                    pre.setString(6,pop[5]);
                    pre.setString(7, pop[6]);
              //      System.out.println("ji");
                    pre.execute();
                    pre.close();
                //    System.out.println("ji");
                    l=(List)dis.readObject();
                    pop=(String[]) l.get(0);
                    if(b==1)
                    {
                  //      System.out.println("ji");
                    pre =con.prepareStatement("insert into student (ID,Dname) values(?,?)");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setString(2, pop[01]);
                    pre.execute();
                    }
                    if(b==2)
                    {
                    //    System.out.println("ji");
                    pre =con.prepareStatement("insert into faculty (ID,Dname,rm) values(?,?,?)");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.setString(2, pop[01]);
                    //String abc=JOptionPane.showInputDialog("Enter the Consultation Room number");
                    pre.setString(3, pop[02]);
                    //System.out.println(abc);
                    pre.execute();
                    }
                    if(b==3)
                    {                
                      //  System.out.println("ji");
                    pre =con.prepareStatement("insert into accountent (ID) values(?)");
                    pre.setInt(1,Integer.parseInt( pop[0]));
                    pre.execute();

                    }
                    pre.close();
                    String r ="true";
                    dos.writeObject(r);
                    dos.flush();
                    }
                    break;
                    
                    case"21":
                    {
                     ArrayList <acInfo> stlist=new ArrayList<acInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,user.email FROM     user INNER JOIN accountent ON user.id = accountent.id where user.app=1");
                    ResultSet rs=st.executeQuery();
                    acInfo u;
                    while(rs.next())
                    {
                     u=new acInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"22":
                    {
                    ArrayList <acInfo> stlist=new ArrayList<acInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,user.email FROM user INNER JOIN accountent ON user.id = accountent.id order by user.name and user.app=1");
                    ResultSet rs=st.executeQuery();
                    acInfo u;
                    while(rs.next())
                    {
                     u=new acInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"23":
                    {
                    ArrayList <acInfo> stlist=new ArrayList<acInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,user.email FROM user INNER JOIN accountent ON user.id = accountent.id order by user.id and user.app=1");
                    ResultSet rs=st.executeQuery();
                    acInfo u;
                    while(rs.next())
                    {
                     u=new acInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"24":
                    {
                        String a= (String)dis.readObject();
                        int id= Integer.parseInt(a);
                    String UpdateQuery="update user set app= ? where user.id="+id;
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setInt(1, (Integer.parseInt("3")));
                    ps.executeUpdate();
                    ps.close();
                    String r ="true";
                    dos.writeObject(r);
                    dos.flush();
                    }
                    break;
                    
                    case"25":
                    {
                    ArrayList <ftInfo> stlist=new ArrayList<ftInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,faculty.dname,user.email,faculty.rm FROM user INNER JOIN faculty ON user.id = faculty.id where user.app=1");
                    ResultSet rs=st.executeQuery();
                    ftInfo u;
                    while(rs.next())
                    {
                     u=new ftInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"),rs.getString("rm"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"26":
                    {
                    ArrayList <ftInfo> stlist=new ArrayList<ftInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,faculty.dname,user.email,faculty.rm FROM user INNER JOIN faculty ON user.id = faculty.id order by faculty.id where user.app=1");
                    ResultSet rs=st.executeQuery();
                    ftInfo u;
                    while(rs.next())
                    {
                     u=new ftInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"),rs.getString("rm"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"27":
                    {
                     ArrayList <ftInfo> stlist=new ArrayList<ftInfo>();
                        PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,faculty.dname,user.email,faculty.rm FROM user INNER JOIN faculty ON user.id = faculty.id  order by faculty.dname where user.app=1");
                        ResultSet rs=st.executeQuery();
                        ftInfo u;
                        while(rs.next())
                        {
                         u=new ftInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"),rs.getString("rm"));
                         stlist.add(u);
                        }
                    dos.writeObject(stlist);
                    dos.flush();
                          st.close();
                        rs.close();
                        }
                    break;
                    
                    case"28":
                    {
                        ArrayList <ftInfo> stlist=new ArrayList<ftInfo>();
                        PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,faculty.dname,user.email,faculty.rm FROM user INNER JOIN faculty ON user.id = faculty.id order by user.name where user.app=1");
                        ResultSet rs=st.executeQuery();
                        ftInfo u;
                        while(rs.next())
                        {
                         u=new ftInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"),rs.getString("rm"));
                         stlist.add(u);
                        }
                    dos.writeObject(stlist);
                    dos.flush();
                              st.close();
                        rs.close();
                    }
                    break;
                    case"29":
                    {
                    String a = (String) dis.readObject();
                    int id = Integer.parseInt(a);
                    String UpdateQuery="update user set app= ? where user.id="+id;
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setInt(1, (Integer.parseInt("3")));
                    ps.executeUpdate();
                    ps.close();
                    String r = "true";
                    dos.writeObject(r);
                    dos.flush();
                    }
                    break;
                    
                    case"30":
                    {
                    ArrayList <stInfo> stlist=new ArrayList<stInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,student.dname,user.email FROM user INNER JOIN student ON user.id = student.id where user.app=1");
                    //System.out.println("hoise ");
                    // st.setString(1,txt_id.getText());
                  //  String nmn= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id="+s;
                    ResultSet rs=st.executeQuery();
                   // System.out.println("hoise");
                    stInfo u;
                    while(rs.next())
                    {
                     u=new stInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"));
                     stlist.add(u);
                    }
                    
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"31":
                    {
                    ArrayList <stInfo> stlist=new ArrayList<stInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,student.dname,user.email FROM user INNER JOIN student ON user.id = student.id order by student.id where user.app=1");
                    //System.out.println("hoise ");
                    // st.setString(1,txt_id.getText());
                  //  String nmn= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id="+s;
                    ResultSet rs=st.executeQuery();
                //    System.out.println("hoise");
                    stInfo u;
                    while(rs.next())
                    {
                     u=new stInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"32":
                    {
                     ArrayList <stInfo> stlist=new ArrayList<stInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,student.dname,user.email FROM user INNER JOIN student ON user.id = student.id order by student.dname where user.app=1");
                    //System.out.println("hoise ");
                    // st.setString(1,txt_id.getText());
                  //  String nmn= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id="+s;
                    ResultSet rs=st.executeQuery();
                  //  System.out.println("hoise");
                    stInfo u;
                    while(rs.next())
                    {
                     u=new stInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"33":
                    {
                    ArrayList <stInfo> stlist=new ArrayList<stInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,student.dname,user.email FROM user INNER JOIN student ON user.id = student.id order by user.name where user.app=1");
                    //System.out.println("hoise ");
                    // st.setString(1,txt_id.getText());
                  //  String nmn= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id="+s;
                    ResultSet rs=st.executeQuery();
                    //System.out.println("hoise");
                    stInfo u;
                    while(rs.next())
                    {
                     u=new stInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("dname"),rs.getString("email"));
                     stlist.add(u);
                    }
                    dos.writeObject(stlist);
                    dos.flush();
                      st.close();
                        rs.close();
                    }
                    break;
                    
                    case"34":
                    {
                        String a=(String)dis.readObject();
                        int id = Integer.parseInt(a);
                        String UpdateQuery="update user set app= ? where user.id="+id;
                        PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                        ps.setInt(1, (Integer.parseInt("3")));

                        ps.executeUpdate();
                        ps.close();
                        String r = "true";
                                dos.writeObject(r);
                                dos.flush();
                    }
                    break;
                    
                    case"35":
                    {
                    ArrayList <UserInfo> stlist=new ArrayList<UserInfo>();
                    PreparedStatement st=con.prepareStatement("SELECT user.name,user.id,user.email,user.gender,user.app FROM     user where app=0 or app=2 or app=3");
                   // System.out.println("hoise ");
                    // st.setString(1,txt_id.getText());
                  //String nmn= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)inner join takes on student.ID = takes.s_id) where takes.c_id="+s;
                    ResultSet rs=st.executeQuery();
                    //System.out.println("hoise");
                    UserInfo u;
                    while(rs.next())
                    {
                     u=new UserInfo(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("email"),Integer.parseInt(rs.getString("gender")),Integer.parseInt(rs.getString("app")));
                     stlist.add(u);
                    }
                     dos.writeObject(stlist);
                     dos.flush();
                       st.close();
                        rs.close();
                    }
                    break;
                    
                    case"36":
                    {
                        String a= (String)dis.readObject();
                        int id = Integer.parseInt(a);
                    String UpdateQuery="update user set app= ? where user.id="+id;
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setInt(1, (Integer.parseInt("1")));
                    
                    ps.executeUpdate();
                    ps.close();
                    
                    String r = "true";
                    dos.writeObject(r);
                    dos.flush();
                    }
                    break;
                    
                    case"37":
                    {
                            String a= (String)dis.readObject();
                        int id = Integer.parseInt(a);
                    
                    String UpdateQuery="update user set app= ? where user.id="+id;
                    PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setInt(1, (Integer.parseInt("2")));
                    
                    ps.executeUpdate();
                    ps.close();
                    String r = "true";
                    dos.writeObject(r);
                    dos.flush();
                    
                    }
                    break;
                    
                    case "404":
                    {
                        dis.close();
                        dos.close();
                    s.close();
                    
                    break Loop2;
                    }
                   // break;
                    default:
                    {
                    dos.close();
                    dis.close();
                    s.close();
                    }
                    break;
                    
                    
                }
                
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
     }
    } 
    public List feeLess(int a)
    {
    try {
               List l =new ArrayList <>();
               String pop[]=new String[5];
                        
                        String b= "select user.ID, user.Name, user.gender, student.dname from ((user inner join student on user.ID = student.ID)) where user.id=?";   
                        PreparedStatement st=con.prepareStatement(b);
                        st.setInt(1,a);
                        ResultSet rs=st.executeQuery();
                        boolean adi=true;
                        while(rs.next())
                        {
                            adi=false;
                           // System.out.println("Result set er infos");
                        pop[0]=(rs.getString("name"));
                        pop[1]= (rs.getString("gender"));
                        pop[2]=(rs.getString("dname"));
                        pop[3]=""+a;
                        pop[4]= ("0");
                        break;
                        }
                        rs.close();
                        st.close();
                        l.add(pop);
                        return l;
    }
    catch(Exception e)
    {
        
    }
    return null;
    }
}

