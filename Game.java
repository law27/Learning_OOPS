// Lets Improve Object Oriented Skills using a Object Oriented Language called Java

/** 
   The principles and practices of Object Oriented Software development is Different.
   The main property of Object Orientation is Interaction between the Objects a.k.a Instances.
   This property indirectly states that the using of static main() method for creating objects is not really in Objectville.
   So In true OO application one must need objects to be talking with other objects , as opposed to a static main() object creation.
   So the below program demonstrates the Interaction of Objects.
*/

/**
 * Main
 */

class guessingGame {
    player p1 ;
    player p2 ;
    player p3 ;
    void startGame()
    {
        p1 = new player() ;
        p2 = new player() ;
        p3 = new player() ;

        int Try = 1 ;

        int target = (int) ( Math.random() * 10 ) ;
        System.out.println("I Guessed a Number between 1 to 9...");
        System.out.println("The target Number is : " + target);
        while( true ) {

        int p1Guess = p1.guess() ;
        int p2Guess = p2.guess() ;
        int p3Guess = p3.guess() ;

        if ( p1Guess == target)
            p1.iAmRight = true ;
        if ( p2Guess == target)
            p2.iAmRight = true ;
        if ( p3Guess == target)
            p3.iAmRight = true ;
        
        if( p1.iAmRight || p2.iAmRight || p3.iAmRight)
        {
            System.out.println("We have a Winner here in the " + Try + " Try");
            System.out.println("Player 1 got it Right??! " + p1.iAmRight);
            System.out.println("Player 2 got it Right??! " + p2.iAmRight);
            System.out.println("Player 3 got it Right??! " + p3.iAmRight);
            System.out.println("Game Over!!!");
            break ;
        }
        else
        {
            System.out.println( Try + " Try");
            System.out.println("Try Again!!!");
            ++Try ;
        }
        
    }
}
}

class player {
    int number = 0;
    boolean iAmRight = false ;
    int guess() {
     number = (int) ( Math.random() * 10 );
     return number ;
    }
}

/**
 * Main
 */
public class Game {
    public static void main(String[] args)
    {
        guessingGame Game = new guessingGame() ;
        Game.startGame();
    }
}
