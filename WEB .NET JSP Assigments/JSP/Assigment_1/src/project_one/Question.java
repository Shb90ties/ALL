
package project_one;

import java.util.*;
import java.io.*;

class Question implements Serializable
{
    private String Q,A;
    private Difficulty diff;
    private String sub;
    
    public Question(String questn,String answr,Difficulty diffclty,String subject)
    {
        this.Q = questn;
        this.A = answr;
        this.diff = diffclty;
        this.sub = subject;
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