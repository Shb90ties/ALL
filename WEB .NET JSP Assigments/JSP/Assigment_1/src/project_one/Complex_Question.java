
package project_one;


class Complex_Question extends Question
{
    private String[] Options;
    
    public Complex_Question(String questn,String[] option,int Answer_index,Difficulty diffclty,String subject)
    {
        super(questn,option[Answer_index],diffclty,subject);
        Options = option;
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
