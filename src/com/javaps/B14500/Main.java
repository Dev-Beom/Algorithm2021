package com.javaps.B14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Shape {
    private ArrayList<int[]> shapesX = new ArrayList<>();
    private ArrayList<int[]> shapesY = new ArrayList<>();

    Shape() {
        shapesX.add(new int[]{0, 1, 0, 1});
        shapesY.add(new int[]{0, 0, 1, 1});


        shapesX.add(new int[]{0, 1, 2, 3});
        shapesY.add(new int[]{0, 0, 0, 0});

        shapesX.add(new int[]{0, 0, 0, 0});
        shapesY.add(new int[]{0, 1, 2, 3});


        shapesX.add(new int[]{0, 0, 1, 1});
        shapesY.add(new int[]{0, 1, 1, 2});

        shapesX.add(new int[]{0, 1, 1, 2});
        shapesY.add(new int[]{1, 1, 0, 0});

        shapesX.add(new int[]{0, 0, 1, 1});
        shapesY.add(new int[]{1, 2, 1, 0});

        shapesX.add(new int[]{0, 1, 1, 2});
        shapesY.add(new int[]{0, 0, 1, 1});


        shapesX.add(new int[]{0, 1, 2, 1});
        shapesY.add(new int[]{0, 0, 0, 1});

        shapesX.add(new int[]{1, 1, 1, 0});
        shapesY.add(new int[]{0, 1, 2, 1});

        shapesX.add(new int[]{0, 1, 2, 1});
        shapesY.add(new int[]{1, 1, 1, 0});

        shapesX.add(new int[]{0, 0, 0, 1});
        shapesY.add(new int[]{0, 1, 2, 1});


        shapesX.add(new int[]{0, 0, 0, 1});
        shapesY.add(new int[]{0, 1, 2, 2});

        shapesX.add(new int[]{0, 1, 2, 0});
        shapesY.add(new int[]{0, 0, 0, 1});

        shapesX.add(new int[]{0, 1, 1, 1});
        shapesY.add(new int[]{0, 0, 1, 2});

        shapesX.add(new int[]{0, 1, 2, 2});
        shapesY.add(new int[]{1, 1, 1, 0});

        shapesX.add(new int[]{1, 1, 1, 0});
        shapesY.add(new int[]{0, 1, 2, 2});

        shapesX.add(new int[]{0, 0, 1, 2});
        shapesY.add(new int[]{0, 1, 1, 1});

        shapesX.add(new int[]{0, 1, 0, 0});
        shapesY.add(new int[]{0, 0, 1, 2});

        shapesX.add(new int[]{0, 1, 2, 2});
        shapesY.add(new int[]{0, 0, 0, 1});
    }

    public int getSize() {
        return this.shapesX.size();
    }

    public ArrayList<int[]> getShapesX() {
        return this.shapesX;
    }

    public ArrayList<int[]> getShapesY() {
        return this.shapesY;
    }
}

public class Main {
    static int N, M;
    static int map[][];
    static int max = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Shape shape = new Shape();

        N = Integer.parseInt(st.nextToken());   // 세로 크기
        M = Integer.parseInt(st.nextToken());   // 가로 크기
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int tc = 0; tc < shape.getSize(); tc++) {
            int[] xArr = shape.getShapesX().get(tc);
            int[] yArr = shape.getShapesY().get(tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    boolean canDraw = true;
                    for (int di = 0; di < xArr.length; di++) {
                        int dx = i + xArr[di];
                        int dy = j + yArr[di];
                        if (!isRange(dx, dy)) {
                            canDraw = false;
                            break;
                        }
                    }
                    if (canDraw) {
                        int sum = 0;
                        for (int di = 0; di < xArr.length; di++) {
                            int dx = i + xArr[di];
                            int dy = j + yArr[di];
                            sum += map[dx][dy];
                        }
                        max = Math.max(sum, max);
                    }

                }
            }
        }
        System.out.println(max);

    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
