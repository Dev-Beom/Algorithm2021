package com.javaps.B1406;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();

        int M = Integer.parseInt(reader.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

//        str.chars().forEach(x -> left.push(String.valueOf((char) x)));

        for (int i = 0; i < str.length(); i++)
            left.push(str.substring(i, i+1));

        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            String element = stringTokenizer.nextToken();
            switch (element) {
                case "L":
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case "P":
                    left.push(stringTokenizer.nextToken());
                    break;
            }
        }

        while (!left.isEmpty())
            right.push(left.pop());
        while (!right.isEmpty())
            writer.write(right.pop());

        writer.flush();
        writer.close();
    }
}

