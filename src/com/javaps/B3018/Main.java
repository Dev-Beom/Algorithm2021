package com.javaps.B3018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, E, K;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> musicList = new ArrayList<>();
    final static int SUNYOUNG = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) map.put(i, new ArrayList<Integer>());

        for (int i = 0; i < E; i++) {
            int songID = i;
            List<Integer> todayJoinList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                todayJoinList.add(Integer.parseInt(st.nextToken()));
            }

            if (todayJoinList.contains(SUNYOUNG)) {
                musicList.add(songID);
                todayJoinList.forEach(user -> {
                    map.get(user).add(songID);
                });
            } else {
                HashSet<Integer> sharedMusicList = new HashSet<>();
                todayJoinList.forEach(user -> {
                    sharedMusicList.addAll(map.get(user));
                });
                todayJoinList.forEach(user -> {
                    map.put(user, new ArrayList<>(sharedMusicList));
                });
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == musicList.size()) {
                System.out.println(key);
            }
        }
    }
}
