
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static int N = 0;   // 행
    static int M = 0;   // 열
    static int[][] arr;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                isVisited[i][j] = false;
            }
        }

        isVisited[0][0] = true;
        bfs();
    }

    public static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(0, 0));

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];
                if(checkLocation(x, y)) {
                    queue.add(new Location(x, y));
                    isVisited[x][y] = true;
                }
            }
        }
    }

    public static boolean checkLocation(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > M) return false;
        if (isVisited[row][col] || arr[row][col] == 0) return false;
        return true;
    }
}
