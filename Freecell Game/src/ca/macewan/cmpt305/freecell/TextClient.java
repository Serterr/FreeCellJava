package ca.macewan.cmpt305.freecell;

import java.util.Scanner;

/**
 * Text-based freecell game client
 */
public class TextClient {
    public static void main(String[] args) {
        FreecellGame game = new FreecellGame();
        Scanner console = new Scanner(System.in);
        //game.deck.shuffle();

        printGameState(game);
        while (!game.isGameOver()) {
            System.out.print("Your move <from to> (0 to exit): ");
            String userInput = console.nextLine();
            String[] token = parseUserInput(userInput);

            if (token.length > 0 && token[0].equals("0")) {
                System.out.println("Thanks for playing... bye!");
                System.exit(0);
            }

            // Move a card if it's a valid move
            if (token.length > 1) {
                String fromPile = token[0];
                String toPile = token[1];
                if (game.isLegalMove(fromPile, toPile)) {
                    game.moveCard(fromPile, toPile);
                    printGameState(game);
                } else {
                    System.out.println("Oops, invalid move: " + fromPile + " " + toPile);
                }
            }
        }
        System.out.println("Congratulations, you win!");
    }

    private static String[] parseUserInput(String userInput) {
        Scanner tokenizer = new Scanner(userInput);
        String[] token = new String[2];
        for (int i=0; i < token.length && tokenizer.hasNext(); i++) {
            token[i] = tokenizer.next();
        }
        return token;
    }

    private static void printGameState(FreecellGame game) {
        String results = "";

        // freecell piles (F0-F3)
        for (int i=0; i < 4; i++) {
            results += "Freecell " + i + ": " + game.getPileContents("F"+i) + "\n";
        }
        results += "\n";

        // homecell piles (H0-H3)
        for (int i=0; i < 4; i++) {
            results += "Homecell " + i + ": " + game.getPileContents("H"+i) + "\n";
        }
        results += "\n";

        // tableau piles (T0-T7)
        for (int i=0; i < 8; i++) {
            results += "Tableau " + i + ": " + game.getPileContents("T"+i) + "\n";
        }
        System.out.println(results);
    }

}

