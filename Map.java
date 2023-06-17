import java.util.Random;
import java.util.Scanner;

public class Map {

    char[][] mapPlay = new char[5][5];
    int jumlahship = 3;
    int jumlahShipA = jumlahship;
    int jumlahShipC = jumlahship;
    int loop = 0;
    Scanner scanner = new Scanner(System.in);
    int x1, y1, u1, v1, t1, z1, p1, q1;
    Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("|---Game BattleShip mini ----|");
        System.out.println("|---Cara bermain  -----------|");
        System.out.println("|---Cara bermain  -----------|");
        System.out.println("|---Cara bermain  -----------|");
        System.out.println("|---Cara bermain  -----------|");

        // Create an instance of the Map class
        Map obj = new Map();
        obj.saveKordinat();
    }

    public void saveKordinat() {
        // Input coordinates for America
        for (int i = 1; i <= jumlahship; i++) {
            System.out.println("Please input x1: ");
            x1 = scanner.nextInt();
            System.out.println("Please input y1: ");
            y1 = scanner.nextInt();
            if (isValidCoordinate(x1, y1)) {
                mapPlay[x1][y1] = 'A'; // Mark the coordinate as America's ship
                System.out.println("Coordinate (" + x1 + ", " + y1 + ") for America ship has been set.");
            } else {
                i--; // Invalid coordinate, repeat the loop iteration
                System.out.println("Invalid coordinate. Please try again.");
            }
        }

        // Input coordinates for China
        for (int i = 1; i <= jumlahship; i++) {
            u1 = rand.nextInt(5);
            v1 = rand.nextInt(5);
            if (isValidCoordinate(u1, v1) && mapPlay[u1][v1] != 'A') {
                mapPlay[u1][v1] = 'C'; // Mark the coordinate as China's ship
                System.out.println("Coordinate (" + u1 + ", " + v1 + ") for China ship has been set.");
            } else {
                i--; // Invalid coordinate or already occupied, repeat the loop iteration
            }
        }
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && mapPlay[x][y] == 0;
    }

    public void menembakTarget() {
        System.out.println("|----3. !!!! >> P L A Y I N G  --------------|");
        System.out.println("|---- You're Guessing CPU ship position ----------|");

        while (jumlahShipA >= 1 || jumlahShipC >= 1) {
            loop++;
            System.out.println(">>>>>>> Turn " + loop + " start <<<<<<<<<<<");

            try {
                System.out.println("Masukkan koordinat X: ");
                t1 = scanner.nextInt();
                System.out.println("Masukkan koordinat Y: ");
                z1 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Inputan salah. Gunakan index array yang benar!");
                continue;
            }

            if (isValidCoordinate(t1, z1)) {
                System.out.println("... Lagi menembak... Input benar ...");
                // Process the shot here
                // ...
            } else {
                System.out.println("Invalid coordinate or already used. Please try again.");
            }
        }
    }
}
