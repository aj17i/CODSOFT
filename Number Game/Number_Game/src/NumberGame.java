
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NumberGame {

    public static void main(String[] args) {
        Scanner aj = new Scanner(System.in);

        Random random = new Random();

        //creates and fills an array of size 100 from 1 to 100;
        int[] numbers = IntStream.range(1, 100).toArray();

        //selects a random number based on the array length;
        int randomElement = numbers[random.nextInt(numbers.length)];

        int tries = 3;
        int score = 0;
        //the score is based on games won;

        String playing = "yes";
        //incase the player wanted to play again

        System.out.println("Guess a random number between 1 and 100");

        while ("yes".equals(playing)) {

            int maxTries;
            for (maxTries = 1; maxTries <= tries; maxTries++) {
                System.out.println("Enter your guess You have " + (tries - maxTries + 1) + " tries, guess carefully:");

                int userGuess = aj.nextInt();

                if (userGuess == randomElement) {

                    System.out.println("Correct");
                    score++;
                    System.out.println("Your score is now " + score);
                    break;
                } else if (userGuess > randomElement) {

                    System.out.println("Your Guess was too high guess again");
                } else if (userGuess < randomElement) {

                    System.out.println("Your Guess was too low guess again");
                }
            }
            //in case the maximum tries have been exceeded
            if (maxTries > tries) {
                System.out.println("You've used all your tries. The correct number was " + randomElement);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playing = aj.next();

        }
        System.out.println("Your highscore is: " + score);
        System.out.println("Thanks for playing!");
        aj.close();

    }

}
