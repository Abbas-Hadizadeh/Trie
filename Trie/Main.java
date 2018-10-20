
public class Main {

    public static void main(String[] args) {
        MyTrie trie = new MyTrie(new TrieNode(null, '0'));
        trie.addWord("karma");
        trie.addWord("love");
        trie.addWord("low");
        trie.addWord("lower");
        trie.addWord("laughter");
        trie.addWord("karate");
        System.out.println(trie);
    }

}
