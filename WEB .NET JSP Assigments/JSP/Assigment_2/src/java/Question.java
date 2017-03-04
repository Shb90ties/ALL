


import java.util.*;
import java.io.*;

class Question implements Serializable
{
    private String Q,A;
    private Difficulty diff;
    private String sub;
    private String code;
    
    public Question(String questn,String answr,Difficulty diffclty,String subject)
    {
        this.Q = questn;
        this.A = answr;
        this.diff = diffclty;
        this.sub = subject;
        Random rand = new Random();
        int r = rand.nextInt((5000 - 1000) + 1) + 1000;
        this.code = Integer.toString(r);
    }
    
    public int get_my_Type()
    {
        return 1;
    }
    
    public String[] get_complex_Answers()
    {
        return null;
    }
    
    public Question duplicate()
    {
        Question temp = new Question(Q, A, diff, sub);
        return temp;
    }
    
    public Difficulty getDifficulty_Object()
    {
        return this.diff;
    }
    
    public String getCode()
    {
        return this.code;
    }
    
    @Override
    public String toString()
    {
        return Q;
    }
    
    public String getAnswer()
    {
        return A;
    }
    
    public String getDifficulty()
    {
        return diff.toString();
    }
    
    public String get_Subject()
    {
        return sub;
    }
    
    public boolean answer_question()
    {
        Project_One temp = new Project_One();
        System.out.println(Q+"?");
        System.out.println("Difficulty : "+diff.toString());
        String ans = temp.scan_string();
        return ( ans.equals(A) );
    }
}