import java.util.Scanner;
import java.io.File;

public class GuessTheMovie extends Game {

    public static void main(String[] args) throws Exception {

        // Read the movie list

        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        int i = 0;
        String[] movie = new String[500];

        // Scan the movie list line by line and display each lines
        while(scanner.hasNextLine()) {
            movie[i] = scanner.nextLine();
            //System.out.println(movie[i]);
            i++;
        }

        // Randomly pick one movie and save to pickedMovie
        int randomNum = (int) (Math.random() * i);

        String pickedMovie = movie[randomNum];
        System.out.println("");

        // Display the picked movie
        /*System.out.println(pickedMovie);*/

        /* Create a character array to keep the correctly
        guessed letters and underscore for not-guessed letters
        */
        char[] guessedText = new char[pickedMovie.length()];
        int countSpaces = 0; // To count number of spaces in the movie name

        // Convert letters of chosen movie to underscores and save to guessedText
        for (int j = 0; j < pickedMovie.length(); j++) {
            if(check(' ', pickedMovie.charAt(j) )) {
                guessedText[j] = ' ';
                countSpaces++;
                System.out.print(' ');
            } else {
                guessedText[j] = '_';
                System.out.print("_ ");
            }
        }

        // Initialize a character array to keep wrong letters
        char[] wrongLetters = new char[10];
        int a = 0; // To count number of wrong guesses
        int b = 0; /* To count the number of correct letters guessed out of number of
                      number of letters in chosen movie name */


        for (int k = 0; k < (pickedMovie.length() - countSpaces + 5); k++) {
            char letter = getInput(); // Call getInput from class "Game" to get user's input letter

            int n = 0; // To use the condition in case of zero matches
            int p = 0; /* To avoid double addition for already guessed letter while
                          calculating for b */
            for (int j = 0; j < pickedMovie.length(); j++) {

                // Get a boolean by testing user's current input to user's already made guesses
                if(check(letter, guessedText[j]) )
                    p++;

                // Get a boolean by testing user's current input to letters in pickedMovie
                if(check(letter, pickedMovie.charAt(j)) ) {
                    guessedText[j] = letter;
                    //System.out.print(letter);
                    n++;
                }
            }

            if (n == 0) {
                wrongLetters[a] = letter;
                System.out.println("");
                System.out.print("The wrong letters you entered are: ");
                for (int j = 0; j < wrongLetters.length; j++) {
                    System.out.print(wrongLetters[j] + " ");
                }
                a++;
                if (a == 5) {
                    System.out.println("\nYou Lose!");
                    System.exit(0);
                }
            }

            System.out.println(" ");
            for(int j = 0; j < pickedMovie.length(); j++) {
                System.out.print( guessedText[j] + " ");
            }

            b = b + n - p;
            /*System.out.println("\nb = " + b);
            System.out.println("\nn = " + n);
            System.out.println("\np = " + p);*/


            if (b >= (pickedMovie.length() - countSpaces)) {
                System.out.println("\nYou WIN!!");
                System.exit(0);
            }
        }
        System.out.println("\nYou Lose!!");

        /*
        String[] words = pickedMovie.split(" ");
        int numWords = pickedMovie.split(" ").length;
        int numLetters = 0;
        for (int j = 0; j < numWords; j++) {
            System.out.println(words[j]);
            String[] letters = words[j].split("");

            for (int k = 0; k < words[j].length(); k++)
                System.out.println(letters[k]);

            numLetters += words[j].length();
        }
        for (int j = 0; j < )
        String[] letters = words[0].split("");
        int numLetters = pickedMovie.length();
        System.out.println(numLetters);
        System.out.println(words[0]);
        System.out.println(letters[0]);
        String  a = "HEllo";
        */



    }
}

