package game;

public class BattleShip {
//class utama
	public static void main(String[] args) {
		//Membuat map/peta lautan dan menampilkan map/peta awal
		Game.createOceanMap();
		//Membuat objek Player dengan menggunakan konstruktor yang menerima dua parameter, yaitu # dan false 
		Player player = new Player("@",true);
		//Memanggil metode setnamaKapal() pada objek player dan memberikan nilai "INDONESIA" sebagai parameter
		player.setnamaKapal("INDONESIA");
		//Memanggil metode setKoordinat() pada objek player
		player.setKoordinat();
		//Membuat objek Player dengan menggunakan konstruktor yang menerima dua parameter, yaitu # dan false 
		Player komputer = new Player("#",false);
		//Memanggil metode setnamaKapal() pada objek komputer dan memberikan nilai "ISRAEL" sebagai parameter
		komputer.setnamaKapal("ISRAEL");
		//Memanggil metode setKoordinat() pada objek komputer
		komputer.setKoordinat();

		//Cetak peta lautan
		Game.printOceanMap();
		//Melakukan loop untuk aksi tembak antara player dan komputer
		do { 
			// Menampilkan informasi tentang kapal player
			System.out.println("=========="+ player.getnamaKapal() +"==========");
			// Player melakukan tembakan ke koordinat komputer
			player.tembak("#");
			
			// Cetak informasi tentang kapal komputer
			System.out.println("==========" + komputer.getnamaKapal() + "==========");
			// Komputer melakukan tembakan ke koordinat player
            		// Simbol "@" digunakan sebagai parameter dalam pemanggilan metode tembak()
			komputer.tembak("@");
			
			// Menampilkan peta lautan saat ini setelah aksi tembak
			Game.printOceanMap();

		//Perulangan ini akan terus berjalan hingga salah satu dari kondisi Game.playerShips
        	//Atau Game.computerShips bernilai 0
        	//Menandakan bahwa salah satu pihak telah kehilangan semua kapalnya
		} while (Game.playerShips != 0 && Game.computerShips != 0);
		
		// Menampilkan pesan game over
		Game.gameOver();
	}

}
