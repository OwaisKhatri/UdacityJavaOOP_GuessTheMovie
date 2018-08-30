import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<String> moviesList = new ArrayList<>();
    private int randomNumber;
    private int numberOfGuesses = 10;

    public Game(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        if (file.exists()) {
            while (fileScanner.hasNextLine()) {
                moviesList.add(fileScanner.nextLine());
            }
        }

        randomNumber = new Random().nextInt(moviesList.size());
    }

    public ArrayList<String> getMoviesList() {
        return moviesList;
    }

    public String getRandomMovie() {
        return moviesList.get(randomNumber);
    }

    public String chooseLetter() {
        String guessLetter = letterInput();
        if (guessLetter.length() == 1) {
            return guessLetter;
        } else {
            System.out.println("Single Letter required, choose again");
            chooseLetter();
        }
        return null;
    }

    public String letterInput() {
        System.out.println("Your Letter: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }

    public void letterExists(String movieName, String hiddenMovieName) {
        StringBuilder builder = new StringBuilder(hiddenMovieName);

        System.out.println("Guess the movie: " + hiddenMovieName);
        String guessLetter = chooseLetter();
        for (int numberOfGuesses = 9; numberOfGuesses >= 0; numberOfGuesses--) {

            if (movieName.indexOf(guessLetter) != -1) {
                for (int i = 0; i < movieName.length(); i++) {
                    int atIndex = movieName.indexOf(guessLetter, i);
                    if (atIndex == -1) break;
                    builder.replace(atIndex, atIndex + 1, guessLetter);
                }
                if (builder.toString().equalsIgnoreCase(movieName)) {
                    System.out.println("YOU WON! CONGO.....");
                    System.out.println("Movie Name is: " + hiddenMovieName);
                    break;
                }
                System.out.println("Guess the movie: " + builder.toString());
                guessLetter = chooseLetter();
                numberOfGuesses++;
            } else {
                if (numberOfGuesses > 0) {
                    System.out.println("\nYou have guessed a wrong letter: " + guessLetter);
                    System.out.println("You have left " + numberOfGuesses + " guesses.");
                    System.out.println("Guess the movie: " + builder.toString());
                    guessLetter = chooseLetter();
                } else {
                    System.out.println("Game over.");
                    System.out.println("Movie Name is: " + movieName);
                }
            }
        }
    }
}
