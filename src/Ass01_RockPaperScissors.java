import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Rock Paper Scissors - Player A vs Player B");
        boolean keepPlaying = true;

        while (keepPlaying) {
            char a = getValidMove(in, "Player A");
            char b = getValidMove(in, "Player B");

            String moveA = moveName(a);
            String moveB = moveName(b);

            // Display matchup
            System.out.println();
            System.out.printf("%s vs %s%n", moveA, moveB);

            // Determine winner or tie and display the accepted phrase
            if (moveA.equals(moveB)) {
                System.out.printf("%s vs %s it's a Tie!%n", moveA, moveB);
            } else {
                // Evaluate outcomes (A wins or B wins)
                String phrase = "";
                String winner = "";
                if (moveA.equals("Rock") && moveB.equals("Scissors")) {
                    phrase = "Rock breaks Scissors";
                    winner = "Player A wins";
                } else if (moveA.equals("Scissors") && moveB.equals("Rock")) {
                    phrase = "Rock breaks Scissors";
                    winner = "Player B wins";
                } else if (moveA.equals("Paper") && moveB.equals("Rock")) {
                    phrase = "Paper covers Rock";
                    winner = "Player A wins";
                } else if (moveA.equals("Rock") && moveB.equals("Paper")) {
                    phrase = "Paper covers Rock";
                    winner = "Player B wins";
                } else if (moveA.equals("Scissors") && moveB.equals("Paper")) {
                    phrase = "Scissors cuts Paper";
                    winner = "Player A wins";
                } else if (moveA.equals("Paper") && moveB.equals("Scissors")) {
                    phrase = "Scissors cuts Paper";
                    winner = "Player B wins";
                }

                System.out.println(phrase);
                System.out.println(winner);
            }

            // Copyright line per instructions
            System.out.println("\nCopyright © 2024-present, University of Cincinnati, Ohio. All rights reserved.");

            // Play again prompt
            System.out.print("\nPlay again? [Y/N]: ");
            String resp = in.nextLine().trim();
            if (resp.length() == 0 || !(resp.charAt(0) == 'Y' || resp.charAt(0) == 'y')) {
                keepPlaying = false;
                System.out.println("Thanks for playing. Program terminating.");
            }
            System.out.println(); // spacer between rounds
        }

        in.close();
    }

    private static char getValidMove(Scanner in, String playerName) {
        while (true) {
            System.out.print(playerName + " - Enter move (R/P/S): ");
            String line = in.nextLine().trim();
            if (line.length() == 0) {
                System.out.println("Invalid input. Please enter R, P, or S.");
                continue;
            }
            char c = line.charAt(0);
            if (c == 'R' || c == 'r' || c == 'P' || c == 'p' || c == 'S' || c == 's') {
                return c;
            } else {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        }
    }

    private static String moveName(char c) {
        switch (Character.toUpperCase(c)) {
            case 'R': return "Rock";
            case 'P': return "Paper";
            case 'S': return "Scissors";
            default:  return "Unknown";
        }
    }
}
