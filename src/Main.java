import java.util.*;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] slangs = {"kifik", "kifak", "mniha", "akide", "hayda", "hayde", "merci", "tkram", "ismak", "ismik",
                "bhbak", "bhbik", "walaw", "yalla", "badde", "tekol", "tekle", "shway", "bkafe", "meche",
                "taybe", "afwan", "kheir", "aamal", "wadee", "sahra"};
        Random rnd = new Random();
        int randomInt = rnd.nextInt(slangs.length);
        String word = slangs[randomInt];

        // Welcome message
        String message = "Ahla w Sahla to LebSlang: A Wordle with Lebanese Slang!"
                + "\n The rules are simple, you have 6 guesses to guess a Lebanese slang formed of 5 letters."
                + "\n On each attempt you will have 3 possibilities: either you got a letter in its right place,"
                + "\n or you got it in a wrong place, or you didn't get it at all."
                + "\n Thank you for playing, enjoy!";
        String title = "Welcome to LebSlang!";
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

        // Game
        Scanner scan = new Scanner(System.in);
        String guess;
        char[] num={'1','2','3','4','5','6','7','8','9','0'};
        int counter=0;
        for (int i = 1; i <= 6; i++) {
            do {
                System.out.print("Guess #" + i + ": ");
                guess = scan.nextLine();
                guess = guess.toLowerCase();

                for (int j = 0; j < guess.length(); j++) {
                    char letter = guess.charAt(j);
                    for (int k = 0; k < num.length; k++) {
                        if (num[k]==letter) {
                            counter++;

                        }
                    }
                }

                if (counter > 0) {
                    System.out.println("Word does not contain numbers, try again!");

                }

                if (guess.length() != 5) {
                    System.out.println("It's a 5 letter word, try again!");

                }

            } while (guess.length() != 5 || counter > 0);

            // Check the guess
            if (guess.length() == 5 && counter == 0) {
                int greenCounter = 0;
                ArrayList<Character> wordChar = new ArrayList<>();

                for (int j = 0; j < guess.length(); j++) {
                    char letter = word.charAt(j);
                    wordChar.add(letter);
                }

                for (int j = 0; j < guess.length(); j++) {
                    if (guess.charAt(j) == word.charAt(j)) {
                        System.out.println(guess.charAt(j) + " is in the right spot.");
                        greenCounter++;
                    } else if (wordChar.contains(guess.charAt(j))) {
                        System.out.println("The slang does contain the letter " + guess.charAt(j) +
                                ", but it's not in its right spot.");
                    } else {
                        System.out.println(guess.charAt(j) + " is not in the slang");
                    }
                }

                if (greenCounter == 5) {
                    System.out.println("You won! The slang is " + word);
                    break; // Exit the loop if the user wins
                } else if (i == 6) {
                    System.out.println("You lost! The slang was: " + word);
                }
            }
        }

    }
}


