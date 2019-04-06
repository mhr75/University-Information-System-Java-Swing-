
import java.io.Serializable;


public class acInfo implements Serializable{
    private  int id;
   private String name;
   private String email;
   private String approve;
   // private String dname;
    public acInfo(int c,String n,String a)
    {
        id=c;
        name =n;
        email=a;
      //  dname=d;
    }
    public acInfo(int c,String n,String a, int app)
    {
        id=c;
        name =n;
        email=a;
        if(app==3)approve="Yes";
        else approve ="No";
      //  dname=d;
    }
    public String txt_name()
    {
    return name;
    }
    public int txt_id()
    {
    return id;
    }
    public String getEmail()
    {
        return email;
    }
    public String getApp()
    {
        return approve;
    } 
}
