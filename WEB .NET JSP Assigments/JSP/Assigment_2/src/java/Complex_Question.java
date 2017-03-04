



class Complex_Question extends Question
{
    private String[] Options;
    private int i;
    public Complex_Question(String questn,String[] option,int Answer_index,Difficulty diffclty,String subject)
    {
        super(questn,option[Answer_index],diffclty,subject);
        Options = option;
        i=Answer_index;
    }
    
    @Override
    public int get_my_Type()
    {
        return 2;
    }
    
    @Override
    public String[] get_complex_Answers()
    {
        return this.Options;
    }
    
    @Override
    public Complex_Question duplicate()
    {
        Complex_Question temp = new Complex_Question(super.toString(), Options, i, super.getDifficulty_Object(),
                super.get_Subject());
        return temp;
    }
    
    public String[] getOptions()
    {
        return Options;
    }
    
    @Override
    public boolean answer_question()
    {
        System.out.println(super.toString());
        System.out.println("Difficulty : "+super.getDifficulty());
        for(int i=0; i<Options.length; i++)
        {
            System.out.println(i+")"+Options[i]);
        }
        System.out.println("select the answer");
        Project_One temp = new Project_One();
        int ans = temp.scan_int(0, (Options.length-1));
        String ans_word = Options[ans];
        return ( ans_word.equals(super.getAnswer()) );
    }
}
