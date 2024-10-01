import java.util.Random;
import java.util.Scanner;

public class ProjectOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final String CANCEL_CODE = "1234";

        while (true) {

            int distanceFromSurface = 10;
            int xTilt = random.nextInt(21) - 10; // Random between -10 and 10
            int yTilt = random.nextInt(21) - 10; // Random between -10 and 10
            boolean selfDestruct = false;
            boolean gameOver = false;

            System.out.println("Lunar Lander Simulator");

            while (distanceFromSurface > 0 && !gameOver) {
                System.out.println("\nCurrent status:");
                System.out.println("Distance from surface: " + distanceFromSurface);
                System.out.println("X axis tilt: " + xTilt);
                System.out.println("Y axis tilt: " + yTilt);


                if (selfDestruct) {
                    System.out.println("Self-destruct activated! Enter cancelation code to abort:");
                    String input = scanner.nextLine();
                    if (input.equals(CANCEL_CODE)) {
                        System.out.println("Self-destruct sequence canceled.");
                        selfDestruct = false;
                        continue;
                    } else {
                        System.out.println("Invalid cancelation code.");
                        continue;
                    }
                }

                System.out.println("Enter command (Press 1 for x+1, press 2 for x-1, press 3 for y+1, press 4 for 4-1, thruster, do nothing, self-destruct):");
                String command = scanner.nextLine();


                switch (command) {
                    case "1":
                        xTilt++;
                        break;
                    case "2":
                        xTilt--;
                        break;
                    case "3":
                        yTilt++;
                        break;
                    case "4":
                        yTilt--;
                        break;
                    case "thruster":
                        distanceFromSurface += 2;
                        break;
                    case "do nothing":
                        break;
                    case "self-destruct":
                        selfDestruct = true;
                        break;
                    default:
                        System.out.println("Invalid command! Valid commands are: x+1, x-1, y+1, y-1, thruster, do nothing, self-destruct.");
                        continue;
                }


                distanceFromSurface--;


                if (distanceFromSurface <= 0) {
                    if (xTilt != 0 || yTilt != 0) {
                        System.out.println("You've landed, but the lander broke due to tilt! Game Over.");
                        gameOver = true;
                    } else {
                        System.out.println("Congratulations! You have successfully landed the lunar lander!");
                    }
                }
            }


            System.out.println("\nDo you want to play again? (yes/no):");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
