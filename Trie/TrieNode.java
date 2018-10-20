package com.company.Tree.Trie;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Abbas Hadizadeh on 10/20/2018.
 */
public class TrieNode {
    char incomingEdge;
    TreeMap<Character, TrieNode> edges;
    TrieNode parent;
    String label;
    boolean isWord;

    public TrieNode(TrieNode parent, char incomingEdge){
        this.incomingEdge = incomingEdge;
        this.parent = parent;
        this.label = parent==null ? "" : parent.label + incomingEdge;
        isWord = false;
        edges = new TreeMap(new Comparator<Character>() {   //in order to store children lexicographically.
            @Override
            public int compare(Character c1, Character c2) {
                return c2.compareTo(c1);
            }
        });
    }

    public TrieNode addEdge(char child){
        if(edges.containsKey(child))
            return edges.get(child);
        TrieNode newChild = new TrieNode(this, child);
        edges.put(child, newChild);
        return newChild;
    }

    public int getDepth(){
        return label.length();
    }
}
