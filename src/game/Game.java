package game;

import java.util.Scanner;

public class Game {
	public static int numRows = 10;
    public static int numCols = 10;
    public static int playerShips;
    public static int computerShips;
    public static String[][] grid = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];
    
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

    public static void saveKoordinat(String namaKapal,String simbol){
        Scanner input = new Scanner(System.in);
        //Deploying five ships for player
        Game.playerShips = 5;
        for (int i = 1; i <= Game.playerShips; ) {
            System.out.print("masukkan koordinat x kapal " + i + ":");
            int x = input.nextInt();
            System.out.print("masukkan koordinat y kapal " + i + ":");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] = simbol;
                i++;
                System.out.println("oke kapal sudah siap");
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == simbol)
                System.out.println("koordinat telah terisi");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("anda tidak dapat menempatkan kapal diluar koordinat");
        }

    }
    
    public static void deployComputerShips(String namaKapal,String simbol){
    	
        //Deploying five ships for computer
        Game.computerShips = 5;
        for (int i = 1; i <= Game.computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] =   simbol;
                System.out.println(i + " OKE , KAPAL SUDAH READY");
                i++;
            }
        }
    }
    
    public static void gameOver(){
        System.out.println("Your ships: " + Game.playerShips + " | Computer ships: " + Game.computerShips);
        if(Game.playerShips > 0 && Game.computerShips <= 0)
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
