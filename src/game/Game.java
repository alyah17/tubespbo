import java.util.Scanner;

//buat class Game dengan access modifier public
public class Game {
    // Mendefinisikan variabel numRows dengan tipe data int dengan nilai 10
    // Variabel ini digunakan untuk menyimpan jumlah baris pada peta permainan
    public static int numRows = 10;
    // Mendefinisikan variabel numCols dengan tipe data int dengan nilai 10
    // Variabel ini digunakan untuk menyimpan jumlah kolom pada peta permainan
    public static int numCols = 10;
    // Mendefinisikan variabel playerShips dengan tipe data int
    // Variabel ini digunakan untuk menyimpan jumlah kapal pemain
    public static int playerShips;
    // Mendefinisikan variabel computerShips dengan tipe data int
    // Variabel ini digunakan untuk menyimpan jumlah kapal komputer
    public static int computerShips;
    // Mendefinisikan array grid dengan tipe data String dimensi dua
    // Setiap elemen pada array merepresentasikan suatu sel pada peta
    public static String[][] grid = new String[numRows][numCols];
    // Mendefinisikan array missedGuesses dengan tipe data int dimensi dua
    // Array ini digunakan untuk tebakan yang salah pada peta permainan
    public static int[][] missedGuesses = new int[numRows][numCols];
    
    // Membuat peta lautan dengan ukuran numRows x numCols
    public static void createOceanMap(){
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
	    // Menampilkan nomor kolom pada peta
            System.out.print(i); 
        System.out.println();
        
        for(int i = 0; i < grid.length; i++) { 
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " "; // Mengisi setiap sel dengan spasi kosong
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]); // Menampilkan nomor baris dan isi sel
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i); // Menampilkan isi sel dan nomor baris
                else
                    System.out.print(grid[i][j]); // Menampilkan isi sel
            }
            System.out.println();
        }
    }

    // Menyimpan koordinat kapal pemain ke dalam peta lautan
    public static void saveKoordinat(String namaKapal,String simbol){
        Scanner input = new Scanner(System.in);
        Game.playerShips = 5; // Menentukan jumlah kapal pemain

	// Pada blok for, kita melakukan iterasi untuk mengambil input koordinat kapal sebanyak playerShips kali
	// Dalam setiap iterasi, kita meminta pengguna untuk memasukkan koordinat x dan y dari kapal tersebut menggunakan input.nextInt()
        for (int i = 1; i <= Game.playerShips; ) {
            System.out.print("masukkan koordinat x kapal " + i + ":");
            int x = input.nextInt(); // Membaca input koordinat x
            
            System.out.print("masukkan koordinat y kapal " + i + ":");
            int y = input.nextInt(); // Membaca input koordinat y

	    // Koordinat x dan y harus berada dalam rentang yang valid (0 hingga numRows-1 untuk x, 0 hingga numCols-1 untuk y)
            // Sel pada koordinat tersebut di peta harus kosong, ditandai dengan nilai " ".
            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] = simbol; // Menyimpan simbol kapal pada koordinat yang benar
                i++;
                System.out.println("oke kapal sudah siap"); 
            }
	    // else if yang digunakan untuk melakukan pengecekan kondisi terkait penempatan kapal pada koordinat yang dimasukkan oleh pemain
	    // kondisi ini memeriksa apakah nilai x berada dalam rentang dari 0 hingga numRows, dan nilai y berada dalam rentang dari 0 hingga numCols
	    // juga diperiksa apakah sel pada koordinat di peta (grid[x][y]) sudah terisi dengan simbol kapal yang sama dengan simbol yang sedang ditempatkan
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == simbol)
                System.out.println("koordinat telah terisi"); // Pesan jika koordinat sudah terisi dengan kapal
	    // Pada kondisi dibawah, dilakukan pengecekan apakah nilai x < 0 atau >= numRows, atau nilai y < 0 atau >= numCols
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
		// jika salah satu kondisi terpenuhi, menandakan bahwa pemain mencoba menempatkan kapal di luar batas koordinat yang benar pada peta permainan
                System.out.println("anda tidak dapat menempatkan kapal diluar koordinat"); // Pesan jika koordinat di luar peta
        }

    }
    
    // Menempatkan kapal-kapal musuh (komputer) pada peta lautan secara acak
    public static void deployComputerShips(String namaKapal,String simbol){
        Game.computerShips = 5; // Menentukan jumlah kapal komputer

	// loop for yang digunakan untuk menempatkan kapal-kapal komputer secara acak di peta permainan
	// Dalam loop for, variabel i digunakan untuk menghitung jumlah kapal komputer yang sudah ditempatkan
	// Loop akan berjalan selama i kurang dari atau sama dengan jumlah kapal komputer (Game.computerShips)
        for (int i = 1; i <= Game.computerShips; ) {
            int x = (int)(Math.random() * 10); // Menghasilkan angka acak untuk koordinat x
            int y = (int)(Math.random() * 10); // Menghasilkan angka acak untuk koordinat y

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
		// Menyimpan simbol kapal pada koordinat yang valid
                grid[x][y] = simbol; 
                System.out.println(i + " OKE , KAPAL SUDAH READY");
                i++;
            }
        }
    }
    
    // Menampilkan pesan game over dan hasil pertempuran
    public static void gameOver(){
        System.out.println("Your ships: " + Game.playerShips + " | Computer ships: " + Game.computerShips);
        if(Game.playerShips > 0 && Game.computerShips <= 0)
	    // Pesan jika pemain menang
            System.out.println("Hooray! You won the battle :)"); 
        else
	    // Pesan jika pemain kalah
            System.out.println("Sorry, you lost the battle"); 
        System.out.println();
    }
    
    // Menampilkan peta lautan beserta kapal-kapal yang telah ditempatkan
    public static void printOceanMap(){
        System.out.println();
        
        // Bagian pertama dari peta lautan
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
	    // Menampilkan nomor kolom pada peta
            System.out.print(i); 
        System.out.println();

        // Bagian tengah dari peta lautan
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
		// Menampilkan isi sel pada peta
                System.out.print(grid[x][y]); 
            }

            System.out.println("|" + x);
        }

        // Bagian terakhir dari peta lautan
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i); // Menampilkan nomor kolom pada peta
        System.out.println();
    }
}
