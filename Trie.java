import java.util.HashMap;
import java.util.Map;

//class TrieNode
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String title) {
        // Implement the insertion logic here.
        TrieNode trieNode = root;
        for (char c: title.toCharArray()){
            TrieNode node = trieNode.children.get(c);
            if (node == null) {
                node = new TrieNode();
                trieNode.children.put(c, node);
            }
            trieNode = node;
        }
        trieNode.isEndOfWord = true;
    }

    public void delete(String title) {
        // Implement the deletion logic here.
    }

    public boolean search(String title) {
        // Implement the search logic here.
        return false;
    }

    //temp method to check
    public void printTrie() {
        printTrie(root, "");
    }

    //Temp method to check book titles
    public void printTrie(TrieNode node, String prefix) {
        if (node.isEndOfWord) {
            System.out.println(prefix);
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode child = entry.getValue();
            printTrie(child, prefix + ch);
        }
    }
}
