import java.util.HashMap;
import java.util.Map;

//class TrieNode
class TrieNode {
    Map<Character, TrieNode> children;     // A map to store child nodes
    boolean endOfTitle;  //flag indicating whether this node marks the end of a word

    //Constructs a new TrieNode.
    public TrieNode() {
        children = new HashMap<>();  //Initialize
        endOfTitle = false;
    }
}

public class Trie {

    TrieNode root;

    //constructor 
    public Trie() {
        root = new TrieNode();    //Constructs a new trie.
    }

    

    /**
     * Inserts a new string (title) into the Trie data structure.
     *
     * @param title The title to insert into the Trie.
     * @return The TrieNode representing the end of the inserted string.
    */
    public TrieNode insert(String title) {
        TrieNode trieNode = root;      // Start at the root Trie node
        for (char character : title.toCharArray()) {           // Iterate over each character 
            if (!trieNode.children.containsKey(character)) {
                TrieNode newNode = new TrieNode();             
                trieNode.children.put(character, newNode);    // create a new TrieNode for it If the character is not in the children.
            }            
            trieNode = trieNode.children.get(character);      // Move to the child TrieNode.
        }
        if (!trieNode.children.containsKey('0')) {
            TrieNode newNode = new TrieNode(); 
            trieNode.children.put('0', newNode); // After successfully inserting, create a note and insert 0
        }
        // Return the TrieNode corresponding to the end of the inserted string.
        return trieNode.children.get('0');
    }
 

    /**
     * Deletes the given title from the trie.
     *
     * @param title the title to delete.
     * @return true if the title is deleted, false otherwise.
     */
    public boolean delete(String title) {
        return deleteRecursive(root, title, 0);
    }

    /**
     * Deletes the given title from the trie recursively.
     *
     * @param node the current node in the trie.
     * @param string the title to delete.
     * @param charIndex the current character index in the title.
     * @return true if the title is deleted, false otherwise.
     */
    private boolean deleteRecursive(TrieNode node, String string, int charIndex) {
        // If we have reached the end of the title, check if the node is the end of a complete word.
        // If it is, remove the node from the children of its parent node and return true.
        if (charIndex == string.length()) {
            if (node.children.containsKey('0')) {
                node.children.remove('0');
                return true;
            }
            return false; // String not found
        }

        // Get the character at the current index in the title.
        char character = string.charAt(charIndex);

        if (!node.children.containsKey(character)) {     // If the node does not have a child node for the current character, the title is not in the trie.
            return false;
        }

        // Get the child node for the current character.
        TrieNode child = node.children.get(character);

        // Recursively delete the title from the child node.
        boolean removed = deleteRecursive(child, string, charIndex + 1);

        // If the child node is empty, remove it from the children of its parent node.
        if (child.children.isEmpty()) {
            node.children.remove(character);
        }

        
        return removed;                        // Return true if the title was deleted
    }

    
    /**
     * Searches for a specific title in the Trie and returns the corresponding TrieNode.
     *
     * @param title The title to search for.
     * @return The TrieNode that represents the end of the searched title, or null if not found.
     */
    public TrieNode search(String title) {
        TrieNode trieNode = root;        // Start at the root trie node 


        for (char character : title.toCharArray()) {   // Iterate over each character in the input title.

            if (!trieNode.children.containsKey(character)) { //check if exists
                return null;
            }

            trieNode = trieNode.children.get(character);  // Move corresponding to the current character.

        }

        if (trieNode.children.containsKey('0')) {
            // If '0' is found, return last node.
            return trieNode.children.get('0');
        }

        // If '0' is not found title is not in the Trie.
        return null;
    }

}
