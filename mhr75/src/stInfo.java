
import java.io.Serializable;


public class stInfo implements Serializable{
     private  int id;
   private String name;
    private String dname;
    private String email;
    public stInfo(int c,String n,String d,String a)
    {
        id=c;
        name =n;
        dname=d;
        email=a;
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
}
