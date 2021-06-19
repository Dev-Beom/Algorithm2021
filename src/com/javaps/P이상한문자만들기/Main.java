package com.javaps.P이상한문자만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] contents = s.split(" ", -1);

        int idx = 0;

        for (String e : contents) {
            for (int i = 0; i < e.length(); i++) {
                char ch = e.charAt(i);
                if (i == 0 || i % 2 == 0){
                    sb.append(Character.toUpperCase(ch));
                }
                else if (i == 1|| i % 2 == 1){
                    sb.append(Character.toLowerCase(ch));
                }
            }
            contents[idx] = sb.toString();
            sb.setLength(0);
            idx++;
        }
        for (int i = 0; i < contents.length; i++) {
            sb.append(contents[i]);
            if (i != contents.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}