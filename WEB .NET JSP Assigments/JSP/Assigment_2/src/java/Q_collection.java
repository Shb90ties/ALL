

import java.io.*;
import java.util.*;

class Q_collection implements Serializable
{
    private Question[] collection;
    private int n,s_n;
    private String[] subjects;
    public Score CollectionScore;
    
    public Q_collection ()
    {
        this.collection = new Question[1];
        this.n = this.s_n = 0;
        this.subjects = new String [1];
        this.CollectionScore = new Score();
    }
    
    public Question get_question_by_code(String code)
    {
        for(int i=0; i<collection.length; i++)
        {
            if( collection[i].getCode().equals(code))
            {   return collection[i];   }
        }
        return null;
    }
    
    public Question[] get_Q_Collection()
    {
        return this.collection;
    }
    
    public Q_collection duplicate()
    {
        Q_collection temp = new Q_collection();
        for(int i=0; i < collection.length;i++)
        {
            temp.add_question(collection[i].duplicate());
        }
        return temp;
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
    
    public void delete_by_code(String code)
    {
        for(int i=0; i<collection.length; i++)
        {
            if(collection[i].getCode().equals(code))
            {
                remove_question(i);
            }
        }
    }
    
    public boolean Still_got_questions_subject_difficulty(String subject,Difficulty dif)
    {
        for(int i=0; i<collection.length;i++)
        {
            if( collection[i].get_Subject().equals(subject)
                    && collection[i].getDifficulty().equals(dif.toString()))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean Still_got_questions_subject_difficulty(String[] subjects,Difficulty dif)
    {
        for(int i=0; i< subjects.length; i++)
        {
            if( Still_got_questions_subject_difficulty(subjects[i], dif))
            {   return true;    }
        }
        return false;
    }
    
    public String get_Answer_by_code(String code)
    {
        for(int i=0;i<collection.length;i++)
        {
            if(collection[i].getCode().equals(code))
            {   return collection[i].getAnswer();   }
        }
        return "";
    }
    
    public Question Question_from_subjects_with_diff(String[] subjects,Difficulty dif)
    {
        if( !Still_got_questions_subject_difficulty(subjects,dif)){ return null;    }
        Random rand = new Random();
        while(true)
        {
            int i = rand.nextInt(subjects.length);
            if( Still_got_questions_subject_difficulty(subjects[i],dif))
            {
                return get_Random_Question_with_Diff(subjects[i], dif);
            }
        }
    }
    
    public Question get_Random_Question_with_Diff(String subject,Difficulty diff)
    {   /* only after knowing that there's a question in this^ subject */
        Q_collection temp = new Q_collection();
        for (Question collection1 : collection) 
        {
            if (collection1.getDifficulty().equals(diff.toString())) {
                temp.add_question(collection1);
            }
        }
        return temp.get_Random_Question_from_sub(subject);
        
    }
    
    public Question get_Random_Question_from_sub(String subject)
    {
        if(!Subject_exists(subject)){   return null;    }
        Random rand = new Random();
        Question[] temp = questions_from_subject(subject);
        int i = rand.nextInt(temp.length);
        return temp[i];
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
    
    public Q_collection getCollection() throws IOException, ClassNotFoundException, InputMismatchException
    {
        Q_collection Q_c;
        try
        {
            FileInputStream FIS = new FileInputStream("List.dat");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            Q_c = (Q_collection)OIS.readObject();
        }
        catch (IOException e)
        {
            Q_c = new Q_collection();
        }
        finally{}
        return Q_c;
    }
    
    public void Save_Collection(Q_collection Q_c) throws IOException
    {
        FileOutputStream FOS = new FileOutputStream("List.dat");
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        OOS.writeObject(Q_c);
    }
}
