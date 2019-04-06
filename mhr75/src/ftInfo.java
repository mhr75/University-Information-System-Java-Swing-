
import java.io.Serializable;



public class ftInfo implements Serializable{
    private  int id;
   private String name;
    private String dname;
    private  String email;
    private String rm;
    public ftInfo(int c,String n,String d,String a,String r)
    {
        id=c;
        name =n;
        dname=d;
        email=a;
        rm=r;
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
    public String getRoom()
    {
    return rm;
    }
}
