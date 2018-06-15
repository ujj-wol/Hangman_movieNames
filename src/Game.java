import java.util.Scanner;

public class Game {
    public static char getInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("\n\nEnter a letter: ");
        char letter = userInput.next().charAt(0);

        return letter;
    }

    public static boolean check(char x, char y) {
        if(x == y)
            return true;
        else return false;
    }
}
