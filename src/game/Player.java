package game;

import java.util.Scanner;

public class Player extends Game{
	protected String simbol;
	protected String namaKapal;
	protected boolean isPlayer; //membedakan komputer dan player

	
	public Player(String simbol,boolean isPlayer) {
		this.simbol = simbol;
		this.isPlayer = isPlayer;
		
	}
	
	public void setnamaKapal(String namaKapal) {
		this.namaKapal = namaKapal;
	}
	
	public void setKoordinat() {
		if(this.isPlayer) {
			saveKoordinat(this.namaKapal,this.simbol);
		}
		else 
		{
			deployComputerShips(this.namaKapal,this.simbol);
		}
	}
	
	public String getnamaKapal() {
		return this.namaKapal;
	}
	public void tembak(String target) {
		int x = -1, y = -1;
        do {
        	if(this.isPlayer) {
        		Scanner input = new Scanner(System.in);
                System.out.print("Enter X coordinate: ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate: ");
                y = input.nextInt();
        	}
        	else {
        		x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);
        	}
 

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == target) //if computer ship is already there; computer loses ship
                {
                	if(this.isPlayer) {
                		System.out.println("Boom! kapal komputer tertembak");
                        grid[x][y] = "!"; //Hit mark
                        --Game.computerShips;
                	}
                	else {
                		System.out.println("kapal player tertembak");
                        grid[x][y] = "x";
                        --Game.playerShips;
                	}
                }
                else {
                    System.out.println("Sorry missed");
                    grid[x][y] = "-";
                }
            }
           else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
        	   System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
           }  //invalid guess
            if(this.isPlayer) {
            	System.out.println(this.namaKapal +" " + Game.playerShips + " | enemy : " + Game.computerShips); 
            }else {
            	System.out.println(this.namaKapal +" " + Game.computerShips + " | enemy : " + Game.playerShips); 
            }
             
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }
}
