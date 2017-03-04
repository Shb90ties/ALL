package Servlets;



import java.util.*;
import java.io.*;


public class Project_One {
    Q_collection Q_temp = new Q_collection();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, InputMismatchException
    {
        Project_One methods = new Project_One();
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
            System.out.println("no list file was found, stats new list");
        }
        finally{}
        
        methods.first_screen(Q_c);
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
    
    public void clear_console()
    {
        for(int i=0; i<4 ;i++)
        {
            System.out.println("\b");
        }
        System.out.println("___________________");
    }
    
    public int scan_int(int min, int max) /*insert 0~n-1*/
    {
        Scanner scan_n = new Scanner(System.in);
        int num = min -1;
        while( num < min || num > max )
        {
            try
            {
                num = scan_n.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please type a number...");
                scan_n.next();
            }
            finally
            {
                if( num < min || num > max )
                {
                    System.out.println("Please enter a number between "+min+" ~ "+max);
                }
            }
        }
        return num;
    }
    
    public String scan_string()
    {
        Scanner scan_s = new Scanner(System.in);
        String line = scan_s.nextLine();
        return line;
    }
         
    private void first_screen(Q_collection Q_c) throws IOException
    {
        System.out.println("1 for Admin menu");
        System.out.println("2 for user menu");
        Q_temp = new Q_collection();
        if( scan_int(1,2) == 1 )
        {
            admin_menu_start(Q_c);
        }
        else
        {
            user_menu(Q_c);
        }
    }
    
    private void admin_menu_start(Q_collection Q_c) throws IOException
    {
        clear_console();
        if( !Q_c.is_Empty() )
        {
            admin_menu(Q_c);
            return;
        }
        System.out.println("The list is empty add a Question");
        Question Q = make_question();
        Q_c.add_question(Q);
        save_List(Q_c);
        admin_menu_start(Q_c);
    }
    
    private Question make_question()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Question subject :");
        String sub = scan_string();
        System.out.println("The question :");
        String questn = scan_string();
        System.out.println("The difficulty level?");
        System.out.println("1 Easy 2 Medium 3 Hard");
        int dif = scan_int(1,3);
        Difficulty diff = new Difficulty(dif);
        System.out.println("Type of answer?");
        System.out.println("1 open answer, 2 options answer, 3 yes/no answer");
        int i = scan_int(1,3);
        if( i == 2 )
        {
             System.out.println("how many options?");
             int j = scan_int(2,5);
             String[] temp = new String[j];
             for(int k=0; k<j; k++)
             {
                 System.out.println("answer number "+k+")");
                 temp[k] = scan_string();
             }
             System.out.println("answer index?(with the 0)^");
             int index = scan_int(0,(j-1));
             return new Complex_Question(questn,temp,index,diff,sub);
        }
        else
        {
            if(i == 3)
            {
                System.out.println("1 for YES, 2 for NO");
                int bol = scan_int(1,2);
                boolean bool = (bol == 1);
                return new YesNo_Question(questn,bool,diff,sub);
            }
            else
            {
                System.out.println("The answer?");
                String ans = scan_string();
                return new Question(questn,ans,diff,sub);
            }
        }
    }
    
    private void admin_menu(Q_collection Q_c) throws IOException
    {   
        System.out.println("___Questions_List___");
        String[] temp = Q_c.toString_Questions();
        for(int i=0; i < temp.length; i++)
        {
            System.out.println("Question number "+i+")"+temp[i]);
        }
        System.out.println("\b");
        System.out.println("1 add new Question 2 remove a question 3 go back to first screen");
        int i = scan_int(1,3);
        if( i == 1 )
        {
            Question Q = make_question();
            Q_c.add_question(Q);
            System.out.println("Save new list? Yes 1 No 2");
            int j = scan_int(1,2);
            if( j == 1 ){   save_List(Q_c); }
            admin_menu(Q_c);
        }
        else
        {
            if( i == 2 )
            {
                System.out.println("Which Question to remove?");
                int j = scan_int(0,(temp.length-1));
                Q_c.remove_question(j);
                admin_menu(Q_c);
            }
            else
            {
                first_screen(Q_c);
            }
        }
    }
    
    private void save_List(Q_collection Q_c) throws IOException
    {
        FileOutputStream FOS = new FileOutputStream("List.dat");
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        OOS.writeObject(Q_c);
    }
    
    private void user_menu(Q_collection Q_c) throws IOException
    {
        if( Q_c.is_Empty() )
        {   
            System.out.println("The Questions list is empty");
            first_screen(Q_c);
        }
        String [] temp = Q_c.get_subjects();
        for(int i=0; i<temp.length; i++)
        {
            System.out.println(i+")"+temp[i]);
        }
        System.out.println("pick a subject number");
        int j = scan_int(0,(temp.length-1));
        Question[] Q_t = Q_c.questions_from_subject(temp[j]);
        if( overused_subject(Q_t) )
        {
            System.out.println("all the Questions in this subjects are already solved");
            System.out.println("pick a different subject");
            user_menu(Q_c);
            return;
        }
        Random rand = new Random();
        int i = rand.nextInt(Q_t.length);
        while( Q_temp.Question_exists(Q_t[i]))
        {
            i = rand.nextInt(Q_t.length);
        }
        if( Q_t[i].answer_question() )
        {
            System.out.println("CORRECT!");
        }
        else
        {
            System.out.println("WRONG!!");
        }
        Q_temp.add_question(Q_t[i]);
        System.out.println("1 Go back to the first screen 2 for next question");
        int c = scan_int(1,2);
        if( c == 1 )
        {
            first_screen(Q_c);
            return;
        }
        user_menu(Q_c);
    }
        
    private boolean overused_subject(Question[] Q_t)
    {
        if( Q_temp.is_Empty() ){    return false;   }
        for(int i=0; i<Q_t.length; i++)
        {
            if( !Q_temp.Question_exists(Q_t[i]) )
            {   return false;   }
        }
        return true;
    }

}
