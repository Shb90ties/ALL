
package Servlets;

public class SQL_A 
{
    private int index = 1;
    private String answer;
    private int type;
    private String code;
    
    public SQL_A(String code,int type,String Answer,int index)
    {
        this.code= code;
        this.type = type;
        this.answer = Answer;
        this.index = index;
    }
    
    public SQL_A(String code,int type,String Answer)
    {
        this.code= code;
        this.type = type;
        this.answer = Answer;
    }
    
    public SQL_A(){}
    
    public String getCode()
    {
        return this.code;
    }
    
    public void setCode(String c)
    {
        this.code = c;
    }
    
    public int getType()
    {
        return this.type;
    }
    
    public void setType(int t)
    {
        this.type = t;
    }
    
    public String getAnswer()
    {
        return this.answer;
    }
    
    public void setAnswer(String a)
    {
        this.answer = a;
    }
    
    public int getIndex()
    {
        return this.index;
    }
    
    public void setIndex(int i)
    {
        this.index = i;
    }
}
