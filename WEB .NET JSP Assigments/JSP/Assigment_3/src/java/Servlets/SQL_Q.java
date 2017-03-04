
package Servlets;

import java.util.List;

public class SQL_Q 
{
    private int type;
    private String code, question;
    private int difficulty;
    private String category;
    
    public SQL_Q(String Code,int Type,int Difficulty,String Question,String Category)
    {
        this.code = Code;
        this.type = Type;
        this.difficulty = Difficulty;
        this.question = Question;
        this.category = Category;
    }
    
    public SQL_Q(){}

    public int getType() 
    {  
        return type;

    }  

    public void setType(int t) 
    {  
        this.type = t;  

    }  

    public String getCode() 
    {  
        return code;  
    }  

    public void setCode(String c) 
    {  
        this.code = c;  
    }  

    public String getQuestion() 
    {  
        return question;  
    }  
    public void setQuestion(String q) 
    {  
        this.question = q;  
    }  

    public int getDifficulty() 
    {  
        return difficulty;  
    }
    
    public void setDifficulty(int d) 
    {  
        this.difficulty = d;  
    }
    
    public void setCategory(String c)
    {
        this.category = c;
    }
    
    public String getCategory()
    {
        return this.category;
    }
    
    public Question to_bat_Question()
    {
        UserDB u = new UserDB();
        Difficulty dif = new Difficulty(difficulty);
        if( type == 1 ){ return to_bat_Question_type_1(u,dif); }
        if( type == 2 ){ return to_bat_Question_type_2(u,dif); }
        return to_bat_Question_type_3(u,dif);
    }
    
    private Question to_bat_Question_type_1(UserDB u,Difficulty d)
    {
        String Answer = u.getSQL_A(this.code).getAnswer();
        return new Question(question, Answer, d, this.category);
    }
    
    private Question to_bat_Question_type_2(UserDB u,Difficulty d)
    {
        List<SQL_A> Answers = u.getSQL_Answers(this.code);
        String[] answers = new String[Answers.size()];
        for(int i=0; i<answers.length; i++)
        {
            answers[i] = Answers.get(i).getAnswer();
        }
        int index=1;
        for( SQL_A a : Answers){ index = a.getIndex(); }
        return new Complex_Question(question, answers, (index-1), d, this.category);
    }
        
    
    private Question to_bat_Question_type_3(UserDB u,Difficulty d)
    {
        String Answer = u.getSQL_A(code).getAnswer();
        boolean answer = false;
        if( Answer.equals("YES")){  answer = true; }
        return new YesNo_Question(question, answer, d, this.category);
    }
    
}
