/* import java.util.*;

class SimpledotCom
{
    private int[] locationCells ;
    private String result = null ;
    private int hitCount = 0;
    void setLocations(int[] locs)
    {
        locationCells = locs ;
    }
    String checkYourself(String userGuess)
    {
        int guess = Integer.parseInt(userGuess);
        result = "miss";
        for(int i : locationCells)
        {
            if( guess == i)
            {
                result = "hit" ;
                ++hitCount     ;
                
            }
            if( hitCount == locationCells.length)
            {
                result = "kill" ;
                break           ;
            }
        }
        return result;
    }
}

class SimpledotComGame
{
    void startGame()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Start Game");
        int[] locs = new int[4] ;
        int number = (((int) (Math.random() * 10)) % 6) + 1 ;
        for(int i = 0 ; i < locs.length ; i++)
        {
            locs[i] = number++ ;
        }
        SimpledotCom game = new SimpledotCom() ;
        game.setLocations(locs);
        int guessCount = 0;
        while( true )
        {
            System.out.println("Enter a Number: ");
            String userGuess = scanner.nextLine();
            String result = game.checkYourself(userGuess) ;
            System.out.println(result);
            guessCount++;
            if( result.equals("kill"))
            {
                System.out.println("Congrats!!!... Game Over!!! and Total Guess Count " + guessCount );
                break;
            }
        }
        scanner.close() ;
    }
}



public class SimpledotComMain {
    public static void main(String[] args) {
       SimpledotComGame game = new SimpledotComGame() ;
       game.startGame();
    }
}

*/

import java.io.*;

class SimpledotCom
{
    private int[] locationCells ;
    private int hitCount = 0;
    void setLocations(int[] locs)
    {
        locationCells = locs ;
    }
    String checkYourself(String userGuess)
    {
        int guess = Integer.parseInt(userGuess);
        String result = "miss";
        for(int i : locationCells)
        {
            if( guess == i)
            {
                result = "hit" ;
                ++hitCount     ;

            }
            if( hitCount == locationCells.length)
            {
                result = "kill" ;
                break           ;
            }
        }
        return result;
    }
}

class GameHelper
{
    public String getUserInput(String prompt)
    {
        String inputLine = null ;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader( new InputStreamReader(System.in)) ;
            inputLine = is.readLine() ;
            if (inputLine.length() == 0 ) return null ;
        } catch (IOException e) {
            System.out.println("IOException: " + e );
        }
        return inputLine ;
        }
    }




public class SimpledotComMain {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper() ;

        SimpledotCom theDotCom = new SimpledotCom() ;
        int randomNum = (int) (Math.random() * 5 ) ;

        int[] locations = {randomNum , randomNum+1 , randomNum+2} ;
        theDotCom.setLocations(locations);
        boolean isAlive = true ;

        while (isAlive)
        {
            String guess = helper.getUserInput("Enter a Number: ") ;
            String result = theDotCom.checkYourself(guess) ;
            numOfGuesses++;
            System.out.println(result);
            if(result.equals("kill"))
            {
                isAlive = false ;
                System.out.println("You Took " + numOfGuesses + " Guesses");
            }
        }
    }
}
