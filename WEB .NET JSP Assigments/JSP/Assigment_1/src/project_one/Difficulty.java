
package project_one;

import java.io.*;

class Difficulty implements Serializable
{
    String diff;    int d;
    
    public Difficulty(int level_1_to_3)
    {
        d = level_1_to_3;
        if( d <= 1 )
        {
            d =1;   diff = "Easy";
        }
        else
        {
            if( d>1 && d<3)
            {
                d =2;   diff = "Medium";
            }
            else
            {
                d =3;   diff = "Hard";
            }
        }
    }
    
    @Override
    public String toString()
    {
        return diff;
    }
}
