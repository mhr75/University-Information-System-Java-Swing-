
import java.io.Serializable;


public class result implements Serializable{
    private int student_id;
  private String course_id;
    private String f_id;
    private int marks;
    public result(int a, String b, String c,int d)
    {
        student_id=a;
        course_id=b;
        f_id=c;
        marks=d;
    }
    public int s_id()
    {
    return student_id;
    }
    public String c_id()
    {
    return course_id;
    }
    public String f_id()
    {
    return f_id;
    }
    public String gpa()
    {
    if(marks>=90)return "A";
    else if(marks>=85)return "A-";    
    else if(marks>=80)return "B+";
    else if(marks>=75)return "B";
    else if(marks>=70)return "B-";
    else if(marks>=65)return "C";
    else if(marks>=60)return "C-";
    else return "F";
    
    
    }  
}
