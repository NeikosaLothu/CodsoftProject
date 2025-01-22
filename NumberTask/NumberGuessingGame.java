import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int attemptsAllowed = 5;
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Guess a number between " + min + " and " + max + ":");
            
            while (attempts < attemptsAllowed && !guessedCorrectly) {
                System.out.print("Your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    System.out.println("Correct! You guessed it in " + attempts + " tries.");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, the number was: " + targetNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your score: " + score);
        scanner.close();
    }
}
