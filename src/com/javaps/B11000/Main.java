package com.javaps.B11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Lecture {
        int startAt, endAt;

        Lecture(int startAt, int endAt) {
            this.startAt = startAt;
            this.endAt = endAt;
        }
    }

    static class ClassRoom {
        ArrayList<Lecture> lectureList;

        ClassRoom(ArrayList<Lecture> classes) {
            this.lectureList = classes;
        }

        int getLastClassTime() {
            return this.lectureList.get(this.lectureList.size() - 1).endAt;
        }
    }

    static PriorityQueue<Lecture> lecturePriorityQueue = new PriorityQueue<>((o1, o2) -> {
        if (o1.startAt == o2.startAt) {
            return o1.endAt - o2.endAt;
        }
        return o1.startAt - o2.startAt;
    });
    static PriorityQueue<ClassRoom> classRoomPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(ClassRoom::getLastClassTime));

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            lecturePriorityQueue.offer(new Lecture(S, T));
        }
        while (!lecturePriorityQueue.isEmpty()) {
            Lecture lecture = lecturePriorityQueue.poll();
            if (classRoomPriorityQueue.isEmpty()) {
                createNewClassRoom(lecture);
                continue;
            }
            ClassRoom classRoom = classRoomPriorityQueue.poll();
            if (classRoom.getLastClassTime() <= lecture.startAt) {
                classRoom.lectureList.add(lecture);
            } else {
                createNewClassRoom(lecture);
            }
            classRoomPriorityQueue.offer(classRoom);
        }
        System.out.println(classRoomPriorityQueue.size());
    }

    static private void createNewClassRoom(Lecture lecture) {
        ClassRoom newClassRoom = new ClassRoom(new ArrayList<>());
        newClassRoom.lectureList.add(lecture);
        classRoomPriorityQueue.offer(newClassRoom);
    }
}