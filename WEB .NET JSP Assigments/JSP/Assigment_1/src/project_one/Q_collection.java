
package project_one;

import java.io.*;

class Q_collection implements Serializable
{
    private Question[] collection;
    private int n,s_n;
    private String[] subjects;
    
    public Q_collection ()
    {
        this.collection = new Question[1];
        this.n = this.s_n = 0;
        this.subjects = new String [1];
    }
    
    public void add_question(Question Q)
    {
        Question[] temp = new Question[n+1];
        for(int i=0; i<n; i++)
        {
            temp[i] = collection[i];
        }
        temp[n] = Q;
        add_subject(Q.get_Subject());
        this.n = n+1;
        this.collection = temp;
    }
    
    public boolean is_Empty()
    {
        return (this.n <= 0);
    }
    
    public boolean remove_question(int index)
    {
        if( index < 0 || index >= this.n || this.is_Empty() )
        {
            return false;
        }
        int count = 0;
        Question[] temp = new Question[n-1];
        for(int i=0; i<this.n; i++)
        {
            if( i != index )
            {
                temp[count] = collection[i];
                count++;
            }
        }
        String temp_subject = collection[index].get_Subject();
        this.n = n-1;
        this.collection = temp;
        remove_subject(temp_subject);
        return true;
    }
    
    public String[] toString_Questions()
    {
        String[] Questions = new String [n];
        for(int i=0; i<n; i++)
        {
            Questions[i] = collection[i].toString();
        }
        return Questions;
    }
    
    public String[] toString_Answers()
    {
        String[] Answers = new String [n];
        for(int i=0; i<n; i++)
        {
            Answers[i] = collection[i].getAnswer();
        }
        return Answers;
    }
    
    private void add_subject(String subject)
    {
        if( Subject_exists(subject) )
        {   return; }
        String[] temp = new String[s_n+1];
        for(int i=0; i<s_n; i++)
        {
            temp[i] = subjects[i];
        }
        temp[s_n] = subject;
        this.s_n = s_n+1;
        this.subjects = temp;
    }
    
    private void remove_subject(String subject)
    {
        boolean exists = false;
        for(int i=0; i<n; i++)
        {
            if( subject.equals(collection[i].get_Subject()))
            {   exists = true;  }
        }
        if( exists ){   return; }
        String[] temp = new String [s_n-1];
        int count = 0;
        for(int i=0; i< s_n; i++)
        {
            if( !subjects[i].equals(subject) )
            {
                temp[count] = subjects[i];
                count++;
            }
        }
        this.subjects = temp;
        this.s_n = s_n-1;
    }
    
    private boolean Subject_exists(String subject)
    {
        for(int i=0; i<s_n; i++)
        {
            if( subjects[i].equals(subject) )
            {   return true;    }
        }
        return false;
    }
    
    public String[] get_subjects()
    {
        return subjects;
    }
    
    public Question[] questions_from_subject(String subject)
    {
        if( !Subject_exists(subject) )
        {   return null;    }
        Question[] temp = new Question[1];
        int t_n = 0;
        for(int i=0; i<n; i++)
        {
            if( subject.equals(collection[i].get_Subject()) )
            {
                Question[] temp_ = new Question[t_n+1];
                for(int j=0; j < t_n; j++)
                {
                    temp_[j] = temp[j];
                }
                temp_[t_n] = collection[i];
                temp = temp_;
                t_n = t_n+1;
            }
        }
        return temp;
    }
    
    public boolean Question_exists(Question question)
    {
        for(int i=0; i < n; i++)
        {
            if( question.toString().equals(collection[i].toString())
                &&  question.getAnswer().equals(collection[i].getAnswer()) )
            {   return true;    }
        }
        return false;
    }
}
