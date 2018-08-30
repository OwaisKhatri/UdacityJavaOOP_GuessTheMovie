import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Game game = new Game("movies.txt");
            String movieName = game.getRandomMovie();
            String hiddenMovieName = movieName.replaceAll("[a-zA-Z]", "_");



//            for (int i = 9; i >= 0; i--) {
//                System.out.println("Guess the movie: " + hiddenMovieName);
//                String guessLetter = game.chooseLetter();
                game.letterExists(movieName, hiddenMovieName);
//            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

//        File file = new File("movies.txt");
//        if (file.exists()){
//            ArrayList<String> movies = new ArrayList<>();
//
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                movies.add(scanner.nextLine());
//            }
//
//            int randomMovieNumber = new Random().nextInt(movies.size());
//            String movieName = movies.get(randomMovieNumber);
//            String hiddenMovieName = movies.get(randomMovieNumber).replaceAll("[a-zA-Z]", "_");
//
//            System.out.println("Guess the hidden movie name: " + hiddenMovieName);
//            System.out.println("You have 10 guess remaining");
//            System.out.println("Guess a letter: ");
//            Scanner letterScanner = new Scanner(System.in);
//            String letter = letterScanner.nextLine();
//
//            System.out.println(movieName.indexOf(letter));
//            System.out.println(movieName);
//
////            for (int i = 9; i >= 0; i--) {
////                movieName.charAt(movieName.indexOf(letter));
////            }
//
//
//            System.out.println(movies.get(randomMovieNumber));
//
//        }
    }
}
