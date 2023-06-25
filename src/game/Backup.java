import java.util.Scanner;

    public class BattleShips {
        public static int numRows = 10;
        public static int numCols = 10;
        public static int playerShips;
        public static int computerShips;
        public static String[][] grid = new String[numRows][numCols];
        public static int[][] missedGuesses = new int[numRows][numCols];

        public static void main(String[] args){
            System.out.println("** Welcome to Battle Ships game **");
            System.out.println("Right now, sea is empty\n");
            //menampilkan map game
            createOceanMap();
            //menginput koordinat player
            saveKoordinat();
            //input koordinat kapal boot (komputer)
            deployComputerShips();
            do {
                Battle();
            }while(BattleShips.playerShips != 0 && BattleShips.computerShips != 0); 
            gameOver();
        }
       
       public static void createOceanMap(){
            System.out.print("  ");
            for(int i = 0; i < numCols; i++)
                System.out.print(i);
            System.out.println();
            for(int i = 0; i < grid.length; i++) { 
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = " ";
                    if (j == 0)
                        System.out.print(i + "|" + grid[i][j]);
                    else if (j == grid[i].length - 1)
                        System.out.print(grid[i][j] + "|" + i);
                    else
                        System.out.print(grid[i][j]);
                }
                System.out.println();
            }
       }
    
           public static void saveKoordinat(){
            Scanner input = new Scanner(System.in);

            System.out.println("\nDeploy your ships:");
            System.out.println("==============[KAPAL CHINA]=====================");
            //Deploying five ships for player
            BattleShips.playerShips = 5;
            for (int i = 1; i <= BattleShips.playerShips; ) {
                System.out.print("masukkan koordinat kapal " + i + ":");
                int x = input.nextInt();
                System.out.print("masukkan koordinat kapal " + i + ":");
                int y = input.nextInt();

                if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "@";
                    i++;
                    System.out.println("oke kapal sudah siap");
                }
                else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                    System.out.println("koordinat telah terisi");
                else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                    System.out.println("anda tidak dapat menempatkan kapal diluar koordinat");
            }

        }

       public static void deployComputerShips(){
            System.out.println("\nComputer is deploying ships");
            //Deploying five ships for computer
            BattleShips.computerShips = 5;
            for (int i = 1; i <= BattleShips.computerShips; ) {
                int x = (int)(Math.random() * 10);
                int y = (int)(Math.random() * 10);

                if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "x";
                    System.out.println(i + "OKAI , KAPAL SUDAH READY");
                    i++;
                }
            }
        }

       public static void Battle(){
    	   	printOceanMap();
    	   	playerTurn();
            System.out.println("");
            for(int a = 0; a < 500000; a++);
            computerTurn();
            printOceanMap();

            System.out.println();
            System.out.println("kapal Player : " + BattleShips.playerShips + " | Kapal Boot : " + BattleShips.computerShips);
            System.out.println();
        }

        public static void playerTurn(){
            System.out.println("\nYOUR TURN");
            int x = -1, y = -1;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter X coordinate: ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate: ");
                y = input.nextInt();

                if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
                {
                    if (grid[x][y] == "x") //if computer ship is already there; computer loses ship
                    {
                    	System.out.println("Boom! You sunk the ship!");
                        grid[x][y] = "!"; //Hit mark
                        --BattleShips.computerShips;
                    }
                    else if (grid[x][y] == "@") {
                        System.out.println("Oh no, you sunk your own ship :(");
                        grid[x][y] = "x";
                        --BattleShips.playerShips;
                    }
                    else if (grid[x][y] == " ") {
                        System.out.println("Sorry, you missed");
                        grid[x][y] = "-";
                    }
                }
               else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                    System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
            }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
        }

        public static void computerTurn(){
            System.out.println("\nCOMPUTER'S TURN");
            //Guess co-ordinates
            int x = -1, y = -1;
            do {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);

                if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
                {
                    if (grid[x][y] == "@") //if player ship is already there; player loses ship
                    {
                        System.out.println("The Computer sunk one of your ships!");
                        grid[x][y] = "x";
                        --BattleShips.playerShips;
                    }
                    else if (grid[x][y] == "x") {
                        System.out.println("The Computer sunk one of its own ships");
                        grid[x][y] = "!";
                        --BattleShips.computerShips;
                    }
                    else if (grid[x][y] == " ") {
                        System.out.println("Computer missed");
                        grid[x][y] = "*";
                        //Saving missed guesses for computer a
                        if(missedGuesses[x][y] != 1)
                            missedGuesses[x][y] = 1;
                    }
                }
            }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
        }

        public static void gameOver(){
            System.out.println("Your ships: " + BattleShips.playerShips + " | Computer ships: " + BattleShips.computerShips);
            if(BattleShips.playerShips > 0 && BattleShips.computerShips <= 0)
                System.out.println("Hooray! You won the battle :)");
            else
                System.out.println("Sorry, you lost the battle");
            System.out.println();
        }

        public static void printOceanMap(){
            System.out.println();
            //First section of Ocean Map
            System.out.print("  ");
            for(int i = 0; i < numCols; i++)
                System.out.print(i);
            System.out.println();

            //Middle section of Ocean Map
            for(int x = 0; x < grid.length; x++) {
                System.out.print(x + "|");

                for (int y = 0; y < grid[x].length; y++){
                    System.out.print(grid[x][y]);
                }

                System.out.println("|" + x);
            }

            //Last section of Ocean Map
            System.out.print("  ");
            for(int i = 0; i < numCols; i++)
                System.out.print(i);
            System.out.println();
        }
    }
    