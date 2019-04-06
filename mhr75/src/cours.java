
import java.io.Serializable;


public class cours implements Serializable{
    private String course_id;
    private String course_details;
    private String dname;
    private int credit;
    public cours(String c_id,String cc_id,String c_d,int c)
    {
    course_id=c_id;
    course_details=cc_id;
    dname=c_d;
    credit=c;
    }
    public String c_id()
    {
    return course_id;
    }
    public String cc_id()
    {
    return course_details;
    }
    public String c_d()
    {
    return dname;
    }
    public int c_c()
    {
    return credit;
    }
}
