import java.util.Scanner;

public class GameTest {
    int x1 = 5;
    int y1 = 5;
    String [][] map = new String[5][5];
    int kapal;
    public static void main(String[] args){
        GameTest game = new GameTest();
        game.setMap();
        game.saveKoordinatAmerika();
        game.saveKoordinatChina();
}
    public void setMap(){
        System.out.println("\n~~~~~Selamat Datang di Game Battleship~~~~~\n");
        System.out.print("  ");
        for(int i = 0; i < x1; i++)
            System.out.print(i + " ");
            System.out.println();

        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + map[i][j]);
                else if (j == map[i].length - 1)
                    System.out.print(map[i][j] + "    |" + i);
                else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < x1; i++)
            System.out.print(i + " ");
            System.out.println();
    }
    public void saveKoordinatAmerika() {
        Scanner sc = new Scanner(System.in);
        GameTest game = new GameTest();

        System.out.println("\n========================================================");
        System.out.println("                     KAPAL AMERIKA                      ");
        System.out.println("========================================================");
        game.kapal = 5;
        for (int i = 1; i <= game.kapal; ) {
            System.out.print("\nInput Koordinat Kapal x" + i + ":");
            int x = sc.nextInt();
            System.out.print("Input Koordinat Kapal y" + i + ":");
            int y = sc.nextInt();

            if ((x >= 0 && x < y1) && (y >= 0 && y < x1) && (map[x][y] == " ")) {
                map[x][y] = "@";
                i++;
                System.out.println("Input Koordinar Benar, Nilai Koordinat Belum Dipakai");
            } else if ((x >= 0 && x < y1) && (y >= 0 && y < x1) && map[x][y] == "@")
                System.out.println("Input Koordinar Benar, Nilai Koordinat Sudah Dipakai");
            else if ((x < 0 || x >= y1) || (y < 0 || y >= x1))
                System.out.println("Input Salah");
        }
    }
    public void saveKoordinatChina(){
        Scanner sc = new Scanner(System.in);
        GameTest game = new GameTest();

        System.out.println("\n\n========================================================");
        System.out.println("                       KAPAL CHINA                      ");
        System.out.println("========================================================");
        game.kapal = 5;
        for (int i = 1; i <= game.kapal; ) {
            System.out.print("\nInput Koordinat Kapal x" + i + ":");
            int x = sc.nextInt();
            System.out.print("Input Koordinat Kapal y" + i + ":");
            int y = sc.nextInt();

            if((x >= 0 && x < y1) && (y >= 0 && y < x1) && (map[x][y] == " "))
            {
                map[x][y] =   "@";
                i++;
                System.out.println("Input Koordinar Benar, Nilai Koordinat Belum Dipakai");
            }
            else if((x >= 0 && x < y1) && (y >= 0 && y < x1) && map[x][y] == "@")
                System.out.println("Input Koordinar Benar, Nilai Koordinat Sudah Dipakai");
            else if((x < 0 || x >= y1) || (y < 0 || y >= x1))
                System.out.println("Input Salah");
        }
    }
}