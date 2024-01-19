import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class hangman_copy {

    public static void main(String[] args) {

        String cont = "Y";
        Scanner sc = new Scanner(System.in);
        do {
            String alpha = "";
            String answer = getName();
            String guessedPart = "";
            // guessedPart = answer.replaceAll("\\s+", System.lineSeparator());
            guessedPart = answer.replaceAll("[A-Za-z]", "_");
            int tries = 5;
            System.out.println("-------------------------------------------------");
            System.out.println("Guess the Movie Name Below. You Have " + tries + " Tries.");
            System.out.println("-------------------------------------------------");
            System.out.println(printArr(guessedPart));
            System.out.println("-------------------------------------------------");
            List<String> chosenList = new ArrayList<String>();
            int attemptCount = 1;
            while (attemptCount <= tries) {
                System.out.println("Attempts Left :: " + (tries - attemptCount + 1));
                Collections.sort(chosenList);
                System.out.println("Alphabets Chosen as of now:: " + chosenList);
                System.out.println("Choose An Alphabet :: ");
                alpha = sc.next().toUpperCase();
                if (alpha.matches("[A-Za-z]{1}")) {
                    if (!chosenList.contains(alpha)) {
                        chosenList.add(alpha);
                        if (answer.contains(alpha)) {
                            System.out.println("-------------------------------------------------");
                            guessedPart = fillGuesses(answer, guessedPart, alpha);
                            System.out.println(printArr(guessedPart));
                            System.out.println("-------------------------------------------------");
                            if (answer.equalsIgnoreCase(guessedPart)) {
                                System.out.println("You are a true Movie Buff. You Guessed the movie right.");
                                break;
                            }
                        } else {
                            System.out.println("Character Not in the Movie Name.");
                            attemptCount++;
                        }
                    } else {
                        System.out.println("Alphabet already chosen.");
                    }
                } else {
                    System.out.println("Incorect Input. Only one alphanumeric character allowed");
                }
            }

            if (!answer.equalsIgnoreCase(guessedPart)) {
                System.out.println("You are noobmaster. You Guessed the movie wrong..");
                System.out.println("Correct Answer is.." + answer);
            }

            System.out.println("Do you want to Try Again? (Y/N) : ");
            cont = sc.next();
        } while (cont.equalsIgnoreCase("Y"));
        System.out.println("Thank you For Playing!!!");

        sc.close();
    }

    private static String fillGuesses(String answer, String guessedPart, String alpha) {
        StringBuilder sb = new StringBuilder(guessedPart);

        for (int i = 0; i < answer.length(); i++) {
            if (alpha.equalsIgnoreCase(answer.charAt(i) + "")) {
                sb.setCharAt(i, answer.charAt(i));
            }
        }

        return sb.toString();

    }

    private static String printArr(String guessedPart) {
        char[] charArr = guessedPart.toCharArray();
        String printedVal = "";
        for (char charVal : charArr) {
            printedVal = printedVal + charVal + " ";
        }
        return printedVal;
    }

    public static String getName() {

        String[] names = { "The Shawshank Redemption", "The Godfather", "The Dark Knight", "Schindler's List",
                "The Lord of the Rings: The Return of the King", "The Godfather Part II", "12 Angry Men",
                "Pulp Fiction",
                "The Lord of the Rings: The Fellowship of the Ring", "Inception", "Fight Club", "Forrest Gump",
                "The Lord of the Rings: The Two Towers", "The Good, the Bad and the Ugly", "Goodfellas", "The Matrix",
                "One Flew Over the Cuckoo's Nest", "Star Wars: Episode V - The Empire Strikes Back", "Interstellar",
                "The Silence of the Lambs", "Se7en", "The Green Mile", "Saving Private Ryan",
                "Star Wars: Episode IV - A New Hope",
                "Terminator 2: Judgment Day", "Spirited Away", "City of God", "Life Is Beautiful",
                "It's a Wonderful Life",
                "Seven Samurai", "Harakiri", "Whiplash", "Parasite", "Back to the Future", "Gladiator", "The Departed",
                "The Prestige",
                "Apocalypse Now", "Leon: The Professional", "Alien", "The Usual Suspects", "The Lion King",
                "American History X", "The Pianist",
                "The Intouchables", "Once Upon a Time in the West", "Casablanca", "Psycho", "Grave of the Fireflies",
                "Cinema Paradiso" };
        int i = new Random().nextInt(50);
        return names[i].toUpperCase();
    }

}
