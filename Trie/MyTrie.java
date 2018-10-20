import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Abbas Hadizadeh on 10/20/2018.
 */
public class MyTrie {
    TrieNode root;

    public MyTrie(TrieNode root){
        this.root = root;
    }

    public void addWord(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++)
            node = node.addEdge(word.charAt(i));
        node.isWord = true;
    }

    public String toString(){   //printing the tree
        StringBuilder out = new StringBuilder();
        Stack<TrieNode> stack = new Stack();
        for(char c : root.edges.keySet())
            stack.push(root.edges.get(c));
        TrieNode node;
        char[] emptySpace;
        boolean newLine = false;
        while(!stack.isEmpty()){
            node = stack.pop();
            if(newLine) {
                emptySpace = new char[(node.getDepth()-1) * 2];
                Arrays.fill(emptySpace, ' ');
                out.append(emptySpace);
            }
            out.append(node.incomingEdge);
            if(node.edges.size() == 0) {
                out.append('\n');
                newLine = true;
            }
            else{
                out.append(' ');
                newLine = false;
                for(char c : node.edges.keySet())
                    stack.push(node.edges.get(c));
            }
        }
        if(out.charAt(out.length()-1) == '\n')
            out.deleteCharAt(out.length() - 1);
        return out.toString();
    }

}
