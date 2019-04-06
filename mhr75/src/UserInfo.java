
import java.io.Serializable;


public class UserInfo implements Serializable {
     private  int id;
   private String name;
    private String dname;
    private String email;
    private String gender;
    private String app;
    public UserInfo(int c,String n,String a,int g)
    {
        id=c;
        name =n;
        //dname=d;
        email=a;
        if(g==1)gender="Male";
        else gender = "Female";
    }
    public UserInfo(int c,String n,String a,int g,int appp)
    {
        id=c;
        name =n;
        //dname=d;
        email=a;
        if(g==1)gender="Male";
        else gender = "Female";
        if(appp==0)app="Not Checked";
        if(appp==2)app="Rejected";
        if(appp==3)app="Blocked";
        
    }
    public String txt_name()
    {
    return name;
    }
    public int txt_id()
    {
    return id;
    }
    public String dname()
    {
    return dname;
    }
    public String getEmail()
    {
    return email;
    }
    public String getGender()
    {
        return gender;
    }
    public String getApp()
    {
    return app;
    }
}
