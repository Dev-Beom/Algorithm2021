package com.javaps.B2250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int parent, num, left, right;

    Node(int num, int left, int right) {
        this.parent = -1;
        this.num = num;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    private static int nodeIndex = 1;

    private static int[] minOfLevel, maxOfLevel;
    private static Node[] tree;

    private static final int NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = 0;

        tree = new Node[N + 1];
        minOfLevel = new int[N + 1];
        maxOfLevel = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new Node(i, -1, -1);
            minOfLevel[i] = N;
            maxOfLevel[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int leftChildNodeNum = Integer.parseInt(st.nextToken());
            int rightChildNodeNum = Integer.parseInt(st.nextToken());

            tree[nodeNum].left = leftChildNodeNum;
            tree[nodeNum].right = rightChildNodeNum;

            if (leftChildNodeNum != NOT_EXIST) tree[leftChildNodeNum].parent = nodeNum;
            if (rightChildNodeNum != NOT_EXIST) tree[rightChildNodeNum].parent = nodeNum;
        }


        for (Node node : tree) {
            if (node.parent == NOT_EXIST) {
                root = node.num;
            }
        }

        inOrder(root, 1);

        int level = 1;
        int width = 0;
        for (int i = 0; i <= N; i++) {
            int tmp = maxOfLevel[i] - minOfLevel[i];
            if (width < tmp) {
                level = i;
                width = tmp;
            }
        }
        System.out.println(level + " " + (width + 1));
    }

    private static void inOrder(int root, int level) {
        Node currentNode = tree[root];
        if (currentNode.left != NOT_EXIST) inOrder(currentNode.left, level + 1);

        minOfLevel[level] = Math.min(minOfLevel[level], nodeIndex);
        maxOfLevel[level] = Math.max(maxOfLevel[level], nodeIndex);
        nodeIndex++;

        if (currentNode.right != NOT_EXIST) inOrder(currentNode.right, level + 1);
    }
}
