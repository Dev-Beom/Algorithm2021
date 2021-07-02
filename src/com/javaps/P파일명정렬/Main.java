package com.javaps.P파일명정렬;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static class File {
        String head;
        String number;
        String tail;

        File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

   static class Solution {
        static ArrayList<File> fileList = new ArrayList<File>();

        public String[] solution(String[] files) {
            // Slice and Add to FileList
            for (String item : files) {
                fileList.add(dividString(item));
            }

            // Sort
            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    int result = o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
                    if ( result == 0 ) {
                        result = Integer.parseInt(o1.number)-Integer.parseInt(o2.number);
                    }
                    return result;
                }
            });
            String[] answer = new String[fileList.size()];
            int idx = 0;
            for (File e : fileList) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.head).append(e.number).append(e.tail);
                answer[idx++] = sb.toString();
            }
            return answer;
        }

        public static File dividString(String str) {
            Pattern p = Pattern.compile("([a-zA-Z\\s\\.\\-]+)([0-9]{1,5})(.*)");
            Matcher m = p.matcher(str);
            while(m.find()) {
                if(m.group(3).isEmpty())
                    return new File(m.group(1), m.group(2), "");
                else
                    return new File(m.group(1), m.group(2), m.group(3));
            }
            return new File("", "", "");
        }

        public static boolean isNumber(int value) {
            if (value >= 48 && value <= 57) return true;
            return false;
        }
    }
}
