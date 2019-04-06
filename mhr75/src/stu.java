
import java.io.Serializable;


public class stu implements Serializable{
   private  int id;
   private String name;
    private int gender;
    private String dname;
    public stu(int c,String n,int g,String d)
    {
        id=c;
        name =n;
        gender=g;
        dname=d;
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
    public int txt_gen()
    {
    return gender;
    } 
}
