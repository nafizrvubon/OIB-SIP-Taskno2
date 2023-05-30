//K M Nafiz Rahman Vubon
import java.util.*;

class Number_Guessing_Game {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        Number_Guessing_Game methodChange = new Number_Guessing_Game();
        methodChange.menu(scoreBoard);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        Number_Guessing_Game methodChange = new Number_Guessing_Game();
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Number Guessing Game");
        System.out.println("1) Play");
        System.out.println("2) Score Board");
        System.out.println("3) Exit");
        System.out.println("-------------------------");
        try {
            System.out.print("Enter your choice: ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n" + "Enter the range of number ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n" + "Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number. Please try again later");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter the number you have guessed : ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You guessed the right number in " + guess + "st attempt!");
        } else {
            System.out.println("You guessed the right number in " + guess + " attempts!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    public void displayScoreBoard() {
        System.out.println("-------------------------");
        System.out.println("Score Board");
        System.out.println("-------------------------");
        System.out.println("Your fastest run today in guessing out of all tries is: " + "\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("You finished the number guissing game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}