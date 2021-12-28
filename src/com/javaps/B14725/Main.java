package com.javaps.B14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static class Node {
        TreeMap<String, Node> children = new TreeMap<>();
        boolean isLastNode;
    }

    static class Trie {
        private final Node root = new Node();

        public void insert(String[] words) {
            Node thisNode = this.root;
            for (String word : words) {
                thisNode = thisNode.children.computeIfAbsent(word, e -> new Node());
            }
            thisNode.isLastNode = true;
        }

        public void display() {
            display(root, 0);
        }

        public void display(Node thisNode, int depth) {
            Set<String> set = thisNode.children.keySet();
            for (String str : set) {
                Node childNode = thisNode.children.get(str);
                for (int i = 0; i < depth; i++)
                    System.out.print("--");
                System.out.println(str);
                display(childNode, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] strings = new String[K];
            for (int i = 0; i < K; i++) {
                strings[i] = st.nextToken();
            }
            trie.insert(strings);
        }
        trie.display();
    }
}
