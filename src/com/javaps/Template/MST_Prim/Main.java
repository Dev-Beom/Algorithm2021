package com.javaps.Template.MST_Prim;

/*

7                  <-- 정점의 개수
11                 <-- 간선의 개수
1 2 2              <-- 1번 정점과 2번 정점이 2의 비용으로 연결됨
2 3 5                  2번 정점과 3번 정점이 5의 비용으로 연결됨..
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {    // 각 노드 정점을 클래스로 표현
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Comp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.weight > o2.weight ? 1 : -1;
    }
}

public class Main {
    static int N;   // 정점의 개수
    static int E;   // 간선의 개수

    static ArrayList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];   // 방문 체크용 배열
        graph = new ArrayList[N + 1];   // 각 노드의 연결상태를 저장하는 어레이리스트

        // 각 배열 초기화
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<Node>();

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(start, end, weight));
            graph[end].add(new Node(end, start, weight));
        }
        System.out.println(MST(1));
    }

    // answer : 최종 최소 비용 출력을 위한 변수
    public static int MST(int startVertex) {
        int answer = 0;         // 최종 최소 비용 출력을 위한 변수
        Comp comp = new Comp(); // 우선순위 큐를 활용해서 Min Heap 을 구현

        // 비용이 가장 작은 간선을 바로 뽑기 위한 우선순위 큐
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comp);

        // 정점 모두를 방문하는데 쓸 큐
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex); // 시작점을 지정

        ArrayList<Node> tempList;
        Node tempNode;

        while (!queue.isEmpty()) {
            // 큐에서 하나 빼서 주변의 노드를 다 넣음
            int currentNode = queue.poll(); // 최초 currentNode 는 1
            visited[currentNode] = true;    // 해당 노드 방문처리해서 한 번 방문해서 간선이 연결된 노드는 다시 처리하지 않음
            tempList = graph[currentNode];  // nodeList[1] = tempList = [2번노드, 3번노드, 4번노드]
            for (Node node : tempList) {
                if (!visited[node.end]) {
                    priorityQueue.add(node); //  현재 노드에 연결된 모든 간선을 우선순위큐에 추가
                }
            }

            // 가장 작은 간선을 빼서 값은 답으로 출력, 노드는 방문처리
            // 만약 이미 방문한 것 중 작은 값이 나왔을 경우 한번 더 빼서 또 확인
            while (!priorityQueue.isEmpty()) {
                tempNode = priorityQueue.poll();
                if (!visited[tempNode.end]) {
                    // 선택할 간선에 연결된 정점이 이미 방문한 곳이면 아무것도 하지 않고,
                    // 첫 방문이면 정점을 연결하고 연결된 간선이 최소 신장트리를 이루는 간선이므로
                    // 결과값에 더해준다
                    visited[tempNode.end] = true;
                    answer += tempNode.weight;
                    queue.offer(tempNode.end);              // 연결된 노드를 큐에 넣어준다
                    break;
                }
                // 이미 선택되어 방문된 노드에서 최소값이 나왔을 경우 아무것도 안한다
            }
        }
        return answer;
    }
}
