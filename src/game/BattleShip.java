package game;

public class BattleShip {
//class utama
	public static void main(String[] args) {
		Game.createOceanMap();
		Player player = new Player("@",true);
		player.setnamaKapal("INDONESIA");
		player.setKoordinat();
		Player komputer = new Player("#",false);
		komputer.setnamaKapal("ISRAEL");
		komputer.setKoordinat();
		Game.printOceanMap();
		do { 
			System.out.println("=========="+ player.getnamaKapal() +"==========");
			player.tembak("#");
			System.out.println("=========="+ komputer.getnamaKapal() +"==========");
			komputer.tembak("@");
			Game.printOceanMap();
        	}while(Game.playerShips != 0 && Game.computerShips != 0); 
        	Game.gameOver();
	}

}
