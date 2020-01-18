import java.util.Scanner;

public class XO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] field = new char[3][3];
        int turn = 1;                                           // determines and counts the turns: odd for X, even for O
        for (int i = 0; i < 3; i++) {                           // creates an empty field
            for (int j = 0; j < 3; j++)
                field[i][j] = ' ';
        }
        while (true) {                                          // runs until the game is finished
            int column;
            int row;
            printField(field);                                  // prints field :o
            switchField(field);                                 // switch the standard indexes of an array as required 
            System.out.println("Enter the coordinates: ");
            while (true) {                                      // runs until the input is correct
                column = sc.nextInt();
                row = sc.nextInt();
                if (column > 0 && column < 4 && row > 0 && row < 4) {
                    column = column - 1;                        // dark witchcraft forced by the problem's requirements
                    switch (row) {
                        case 1 :
                            row = 2;
                            break;
                        case  2 :
                            row = 1;
                            break;
                        default :
                            row = 0;
                            break;
                    }
                    if (field[column][row] == 'X' || field[column][row] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                }
                else if (column < 1 || column > 3 || row < 1 || row > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
            }
            if (turn % 2 == 1) {                                // odd for X
                field[column][row] = 'X';
                turn++;
            }
            else {                                              // even for O
                field[column][row] = 'O';
                turn++;
            }
            switchField(field);                                 // switching indexes back (why did we even have to do it?)
            if (checkField(field, 'X')) {                       // prints that X won (if it did)
                printField(field);
                System.out.println("X wins");
                break;
            }
            else if (checkField(field, 'O')) {                  // prints that O won (if it did)
                printField(field);
                System.out.println("O wins");
                break;
            }
            else if (turn > 9) {                                // if 9th turn happened and no one won, the game is a draw
                printField(field);
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void printField(char arr[][]) {               // prining the field is art c:
            System.out.println("---------");
            System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
            System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
            System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
            System.out.println("---------");
        }

    public static boolean checkField(char arr[][], char key) {  // checks the field if someone accidently won
        if (arr[0][0] == key && arr[0][1] == key && arr[0][2] == key
         || arr[1][0] == key && arr[1][1] == key && arr[1][2] == key
         || arr[2][0] == key && arr[2][1] == key && arr[2][2] == key

         || arr[0][0] == key && arr[1][0] == key && arr[2][0] == key
         || arr[0][1] == key && arr[1][1] == key && arr[2][1] == key
         || arr[0][2] == key && arr[1][2] == key && arr[2][2] == key

         || arr[0][0] == key && arr[1][1] == key && arr[2][2] == key
         || arr[2][0] == key && arr[1][1] == key && arr[0][2] == key) 
            return true;
        else
            return false;
    }

    public static void switchField(char arr[][]) {              // transposes matrix
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                char t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
            }
        }
    }    
}


