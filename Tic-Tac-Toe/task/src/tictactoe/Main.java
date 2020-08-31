package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String s = "         ";
        int i, j;

        System.out.println("---------");
        System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
        System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
        System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
        System.out.println("---------");

        int platerCounter = 2;
        do {
            String first = scanner.next();
            System.out.println(first);

            if (first.length() > 1) {
                System.out.println("You should enter numbers! between 1 and 3");
                scanner.next(); // πρεπει να βγαλω και το δευτερο input πριν ξανααρχισω
                continue;
            }
            
            char firstChar = first.charAt(0);
            int ascii = (int) firstChar;
            if ((firstChar < 49 || firstChar > 51)) {
                System.out.println("Coordinates should be from 1 to 3!");
                scanner.next();
                continue;
            }
            String second = scanner.next();

            if (second.length() > 1) {
                System.out.println("You should enter numbers! between 1 and 3");
                continue;
            }
            char firstChar2 = second.charAt(0);
            int ascii2 =  (int) firstChar2;
            if ((firstChar2 < 49 || firstChar2 > 51)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int a = Integer.valueOf(first);
            int b = Integer.valueOf(second);

            if (s.charAt((3 - b) * 3 + a - 1) != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            String subFirst = s.substring(0,(3 - b) * 3 + a -1 );
            String subSecond = s.substring((3 - b) * 3 + a  , s.length());
            String finalString = "";

            if(platerCounter % 2 == 0){
                finalString = subFirst + "X" + subSecond;
            } else {
                finalString = subFirst + "O" + subSecond;
            }

            s = finalString;
            System.out.println(s);
            System.out.println("---------");
            System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
            System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
            System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
            System.out.println("---------");

            int xSum = 0;
            int oSum = 0;
            boolean noFinish = false;
             for(i=0; i<s.length(); i++) {
                if (s.charAt(i) == 'X') {
                    xSum++;
                }
                if (s.charAt(i) == 'O') {
                    oSum++;
                }
            }
            if (Math.abs(xSum-oSum) > 1 || Math.abs(xSum-oSum) < 0) {
                System.out.println("Impossible");
                System.exit(0);
            }
            if(xSum+oSum < 9) {
                noFinish = true;
            }

            boolean checkX = false;
            boolean checkO = false;

            xSum = 0;
            oSum = 0;

            //horizotal
            for(i=0; i<3; i++) {
                for(j=0; j<3; j++) {

                    if (s.charAt(i*3+j) == 'X') {
                        xSum++;
                    }
                    if (s.charAt(i*3+j) == 'O') {
                        oSum++;
                    }
                }
                if (xSum == 3) {
                    checkX = true;
                }
                if (oSum == 3) {
                    checkO = true;
                }
                xSum = 0;
                oSum = 0;
            }

            xSum = 0;
            oSum = 0;

            //vertical
            for(i=0; i<3; i++) {
                for(j=0; j<3; j++) {
                    if (s.charAt(j*3+i) == 'X') {
                        xSum++;
                    }
                    if (s.charAt(j*3+i) == 'O') {
                        oSum++;
                    }
                }
                if (xSum == 3) {
                    checkX = true;
                }
                if (oSum == 3) {
                    checkO = true;
                }
                xSum = 0;
                oSum = 0;
            }

            xSum = 0;
            oSum = 0;

            //diagonals main
            for(i=0; i<3; i++) {
                for (j = 0; j < 3; j++) {
                    if (i == j){
                        if (s.charAt(i*3+j) == 'X') {
                            xSum++;
                        }
                        if (s.charAt(i*3+j) == 'O') {
                            oSum++;
                        }
                    }
                }
            }
            if (xSum == 3) {
                checkX = true;
            }
            if (oSum == 3) {
                checkO = true;
            }

            xSum = 0;
            oSum = 0;

            //diagonals reverse
            for(i=0; i<3; i++) {
                for (j = 0; j < 3; j++) {
                    if (i + j == 2){
                        if (s.charAt(i*3+j) == 'X') {
                            xSum++;
                        }
                        if (s.charAt(i*3+j) == 'O') {
                            oSum++;
                        }
                    }
                }
            }
            if (xSum == 3) {
                checkX = true;
            }
            if (oSum == 3) {
                checkO = true;
            }

            if (checkO == true && checkX == true) {
                System.out.println("Impossible");
                break;
            } else if (checkO == true) {
                System.out.println("O wins");
                break;

            } else if (checkX ==true) {
                System.out.println("X wins");
                break;
            } else if(noFinish == true){
                    System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
                break;
            }
        platerCounter++;
        } while(true);
    }
}
