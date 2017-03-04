import java.io.*;
import java.util.*;

class Score implements Serializable
{
    private String[] log;
    private boolean[] final_score;
    private int count;
    
    public Score()
    {
        log = new String[0];
        final_score = new boolean[0];
        count = 0;
    }
    
    public String[] get_Log()
    {
        if( count == 0 )
        {   String[] temp = new String[1];  temp[0] =""; return temp;   }
        return this.log;
    }
    
    public void Add_score(Question q,boolean succeed)
    {
        String temp = q.getCode();
        temp += " "+q.toString();
        if( succeed )
        {
            temp += " RIGHT ANSWER V";
        }
        else
        {
            temp += " WRONG ANSWER! X,right one was ";
            temp += q.getAnswer();
        }
        temp += " // Subject : "+q.get_Subject();
        this.count++;
        add_to_final_score(succeed);
        add_to_log(temp);
    }
    
    private void add_to_final_score(boolean b)
    {
        boolean[] temp = new boolean[final_score.length+1];
        for(int i=0; i< final_score.length; i++)
        {
            temp[i] = final_score[i];
        }
        temp[log.length] = b;
        this.final_score = temp;
    }
    
    private void add_to_log(String s)
    {
        String[] temp = new String[log.length+1];
        for(int i=0; i< log.length; i++)
        {
            temp[i] = log[i];
        }
        temp[log.length] = s;
        this.log = temp;
    }
    
    public int get_score()
    {
        if( count == 0 ){   return 0;   }
        int sum; sum =0;
        for(int i=0; i< final_score.length; i++ )
        {
            if( final_score[i] )
            {   sum += 10;  }
        }
        return sum;
    }
}
