package com.javaps.P신규아이디추천;

public class Main {
    class Solution {
        public String solution(String new_id) {
            String id = new_id.toLowerCase();
            id = id.replaceAll("[^-_.a-z0-9]", "");
            id = id.replaceAll("[.]{2,}", ".");
            id = id.replaceAll("^[.]|[.]$", "");

            if (id.length() == 0) {
                id += "a";
            }

            if (id.length() >= 16) {
                id = id.substring(0, 15);
                id = id.replaceAll("^[.]|[.]$", "");
            }

            if (id.length() <= 2) {
                while (id.length() < 3) {
                    id += id.charAt(id.length() - 1);
                }
            }
            return id;
        }
    }
}
