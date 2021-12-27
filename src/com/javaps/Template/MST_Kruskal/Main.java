package com.javaps.Template.MST_Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/*

7
11
1 2 2
2 7 7
7 6 9
6 5 23
5 4 1
4 1 10
1 3 3
2 3 3
3 7 4
3 6 3
3 5 6

 */

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        super();
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    // Min Heap 을 만들기 위한 우선순위큐용 Comparable 메서드
    @Override
    public int compareTo(Node next) {
        return next.weight >= this.weight ? -1 : 1;
    }
}

public class Main {
    static int N;   // 정점의 개수
    static int E;   // 간선의 개수
    static PriorityQueue<Node> priorityQueue;   // 간선 값을 Min Heap 으로 하는 우선순위 큐
    static int[] parent;        // disjoint-set(union find) 에서 필요한 부모 노드를 저장하는 배열
    static boolean[] visited;   // 방문 여부 배열
    static int result;          // 결과 값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 정점의 개수 = 노드의 개수
        E = Integer.parseInt(br.readLine());    // 간선의 개수

        parent = new int[N + 1];    // Disjoint-set
        visited = new boolean[N + 1];
        result = 0;

        priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Node(start, end, weight));
        }   // 모든 간선에 대해 [시작, 끝, 비용] 을 가진 클래스로 우선순위 큐에 ADD

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }   // Union-find 의 초기화는 일단 자기 자신의 부모 노드는 자기 자신으로 설정

        for (int i = 0; i < E; i++) {   // 모든 간선에 대해서 확인
            Node node = priorityQueue.poll();   // 현재 큐에 있는 모든 인스턴스 중 비용이 가장 작은 간선이 poll 된다.
            int start = node.start;
            int end = node.end;
            int a = find(start);    // 만약 이 간선을 선택해서 연결한다고 했을 때 사이클이 생기면 안되므로
            int b = find(end);      // 양쪽의 루트(최상위 부모)노드가 무엇인지 확인하고
            if (a == b) continue;   // 만약 같으면 선택하지 않고 넘어간다.

            union(start, end);      // 두개의 루트 노드가 달랐다면 한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
            result += node.weight;  // 선택된 간선이므로 간선의 비용을 더한다.
        }

        System.out.println(result);
    }

    public static int find(int value) {
        if (value == parent[value]) return value;   // 초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
        parent[value] = find(parent[value]);        // find 할 때마다 부모는 최상위 부모로 설정 (성능 향상)
        return parent[value];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parent[aRoot] = b;
    }
}
