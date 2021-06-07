package com.javaps.B10814;

import java.io.*;
import java.util.*;

class User {
    final int id;
    final int age;
    final String name;

    User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        LinkedList<User> users = new LinkedList<>();

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User(i, age, name));
        }

        users.sort(((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.id - o2.id;
            } else {
                return o1.age - o2.age;
            }
        }));

        for (User user : users) {
            System.out.println(user.age + " " + user.name);
        }
    }
}
