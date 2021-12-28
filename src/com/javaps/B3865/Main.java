package com.javaps.B3865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static class Node {
        String key;
        HashSet<String> members = new HashSet<>();

        Node(String key, String[] members) {
            this.key = key;
            this.members.addAll(Arrays.asList(members));
        }
    }

    static HashMap<String, HashSet<String>> academyMap = new HashMap<>();
    static HashSet<String> rootMember = new HashSet<>();
    static HashSet<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) return;

            academyMap.clear();
            rootMember.clear();
            visited.clear();
            Node rootAcademy = null;
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                Node parsingResult = getInformation(line);
                if (i == 0) {
                    rootAcademy = parsingResult;
                    continue;
                }
                academyMap.put(parsingResult.key, parsingResult.members);
            }
            assert rootAcademy != null;
            for (String member : rootAcademy.members) {
                DFS(member);
            }
            System.out.println(rootMember.size());
        }
    }

    private static void DFS(String findMember) {
        if (!academyMap.containsKey(findMember)) {
            rootMember.add(findMember);
            return;
        }
        for (String member : academyMap.get(findMember)) {
            if (!visited.contains(member)) {
                DFS(member);
                visited.add(member);
            }
        }
    }

    private static Node getInformation(String line) {
        String[] tmp = line.split("[:,.]");
        String key = tmp[0];
        String[] values = Arrays.copyOfRange(tmp, 1, tmp.length);
        return new Node(key, values);
    }
}
