package Servlets;




public class YesNo_Question extends Question
{
    private boolean YES;
   
    public YesNo_Question(String questn,boolean yes_answer,Difficulty diffclty,String subject)
    {
        super(questn,"YES/NO question",diffclty,subject);
        this.YES = yes_answer;
    }
    
    @Override
    public int get_my_Type()
    {
        return 3;
    }
    
    @Override
    public YesNo_Question duplicate()
    {
        YesNo_Question temp = new YesNo_Question(super.toString(), YES, super.getDifficulty_Object(), super.get_Subject());
        return temp;
    }
    
    @Override
    public String getAnswer()
    {
        if( this.YES )
        {
            return "YES";
        }
        return "NO";
    }
    
    public boolean getAnswer_in_bool()
    {
        return this.YES;
    }
    
    @Override
    public boolean answer_question()
    {
        System.out.println(super.toString());
        System.out.println("Difficulty : "+super.getDifficulty());
        System.out.println("1 YES 2 NO");
        Project_One temp = new Project_One();
        int ans = temp.scan_int(1, 2);
        boolean answr = ( ans == 1 );
        return ( answr == YES );
    }
}
