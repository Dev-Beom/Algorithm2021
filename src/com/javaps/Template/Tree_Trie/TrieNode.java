package com.javaps.Template.Tree_Trie;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastCharacter;

    public HashMap<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastCharacter() {
        return isLastCharacter;
    }

    public void setIsLastCharacter(boolean isLastCharacter) {
        this.isLastCharacter = isLastCharacter;
    }
}
