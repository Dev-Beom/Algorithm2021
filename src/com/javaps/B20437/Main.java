package com.javaps.B20437;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1").append("\n");
                continue;
            }

            int[] alphaCount = new int[26];
            int inputLen = W.length();

            for (int i = 0; i < inputLen; i++) {
                char c = W.charAt(i);
                alphaCount[c - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i <= inputLen - K; i++) {
                char start = W.charAt(i);
                if (alphaCount[start - 'a'] >= K) {
                    int tmpCount = 1;
                    for (int j = i + 1; j < inputLen; j++) {
                        char cur = W.charAt(j);
                        if (start == cur) {
                            tmpCount++;

                            if (tmpCount == K) {
                                int len = (j - i) + 1;
                                min = Math.min(min, len);
                                max = Math.max(max, len);
                                break;
                            }
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append("-1");
            } else {
                sb.append(min).append(" ").append(max);
            }
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}


// 첫 풀이
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        while (T-- > 0) {
//            String string = br.readLine();
//            int K = Integer.parseInt(br.readLine());
//            execute(string, K);
//        }
//    }
//
//    public static void execute(String string, int K) {
//        if (K == 1) {
//            System.out.println(1);
//            return;
//        }
//        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
//        char[] charArray = string.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            Character ch = charArray[i];
//            map.computeIfAbsent(ch, k -> new ArrayList<>());
//            map.get(ch).add(i);
//        }
//        int firstCondition = firstCondition(map, K);
//        int secondCondition = secondCondition(map, K);
//        if (firstCondition == -1 || secondCondition == -1) {
//            System.out.println(-1);
//        } else {
//            System.out.println(firstCondition + " " + secondCondition);
//        }
//    }
//
//
//    //  어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
//    public static int firstCondition(HashMap<Character, ArrayList<Integer>> map, int K) {
//        List<ArrayList<Integer>> targets = map.values().stream().filter(list -> list.size() >= K).collect(Collectors.toList());
//        if (targets.isEmpty()) return -1;
//        int min = Integer.MAX_VALUE;
//        for (ArrayList<Integer> target : targets) {
//            min = Math.min(getMinByItemCount(target, K), min);
//        }
//        return min == Integer.MAX_VALUE ? -1 : min + 1;
//    }
//
//    public static int getMinByItemCount(ArrayList<Integer> target, int itemCount) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i <= target.size() - itemCount; i++) {
//            int length = target.get(i + itemCount - 1) - target.get(i);
//            min = Math.min(min, length);
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//
//    //  어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.
//    public static int secondCondition(HashMap<Character, ArrayList<Integer>> map, int K) {
//        List<ArrayList<Integer>> targets = map.values().stream().filter(list -> list.size() >= K).collect(Collectors.toList());
//        System.out.println(targets);
//        if (targets.isEmpty()) return -1;
//        int max = -1;
//        for (ArrayList<Integer> target : targets) {
//            max = Math.max(getMaxByItemCount(target, K), max);
//        }
//        return max == -1 ? -1 : max + 1;
//    }
//
//    public static int getMaxByItemCount(ArrayList<Integer> target, int itemCount) {
//        int max = -1;
//        for (int i = 0; i <= target.size() - itemCount; i++) {
//            int length = target.get(i + itemCount - 1) - target.get(i);
//            System.out.println("diff : " + length);
//            max = Math.max(max, length);
//        }
//        System.out.println(max);
//        return max;
//    }
//}
//
