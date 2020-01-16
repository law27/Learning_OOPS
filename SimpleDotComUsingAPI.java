import java.util.ArrayList;
import java.io.*;

class DotCom
{
    private ArrayList<String> locationCells ;
    
    public void setLocationCells( ArrayList<String> locs)
    {
        locationCells = locs ;
    }

    public String checkYourSelf(String userInput)
    {
        String result = "miss" ;

        if(locationCells.contains(userInput))
        {
            result = "hit" ;
            locationCells.remove(userInput) ;

            if(locationCells.isEmpty())
            {
                result = "kill" ;
            }
        }
        return result;
    }
    
}


class GameHelper
{
    private String inputLine = null ;
    public String userInput(String prompt)
    {
        System.out.print(prompt + " ");
        try {
         BufferedReader is = new BufferedReader( new InputStreamReader(System.in) ) ;
         inputLine  = is.readLine() ;
         if(inputLine.length() == 0) return null ;
        } catch (IOException e) {
            System.out.println("IOException : " + e) ;
        }
        return inputLine ;
    }
}

public class SimpleDotComUsingAPI {

    public static void main(String[] args) 
    {

    String prompt = "Enter the Number: " ;
    GameHelper helper = new GameHelper() ;
    DotCom game = new DotCom() ;
    
    int randomNum = (int) ( Math.random() * 5 ) ;
    ArrayList<String> locs = new ArrayList<String>() ;
    locs.add((Integer.toString(randomNum))) ;
    locs.add(Integer.toString(randomNum+1)) ;
    locs.add(Integer.toString(randomNum+2)) ;
    
    game.setLocationCells(locs);

    boolean isAlive = true ;
    int numberOfGuesses = 0;
    while(isAlive)
    {
    numberOfGuesses++;
    String userInput = helper.userInput(prompt) ;
    String result = game.checkYourSelf(userInput);
    System.out.println(result);

    if(result.equals("kill"))
    {
        isAlive = false ;
        System.out.println("You Took " + numberOfGuesses + " Guesses");
    }
    }
}
}