import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        List<String> bookTitles = generateRandomBookTitles(10000);

        // Create BST and Trie instances
        BST bst = new BST();
        Trie trie = new Trie();

        // Measure and compare insertion times
        long startTime = System.nanoTime();
        for (String title : bookTitles) {
         //   bst.insert(title);
        }
        long endTime = System.nanoTime();
        long bstInsertionTime = endTime - startTime;

        startTime = System.nanoTime();
        for (String title : bookTitles) {
            trie.insert(title);
        }
        endTime = System.nanoTime();
        long trieInsertionTime = endTime - startTime;

        // Measure and compare deletion times
        startTime = System.nanoTime();
        for (String title : bookTitles) {
         //   bst.delete(title);
        }
        endTime = System.nanoTime();
        long bstDeletionTime = endTime - startTime;
        startTime = System.nanoTime();
        for (String title : bookTitles) {
            trie.delete(title);
        }
        endTime = System.nanoTime();
        long trieDeletionTime = endTime - startTime;


        // Measure and compare search times
        startTime = System.nanoTime();
        for (String title : bookTitles) {
         //   bst.search(title);
        }
        endTime = System.nanoTime();
        long bstSearchTime = endTime - startTime;

        startTime = System.nanoTime();
        for (String title : bookTitles) {
            trie.search(title);
        }
        endTime = System.nanoTime();
        long trieSearchTime = endTime - startTime;

        // Display results
        System.out.println("BST Insertion Time: " + bstInsertionTime + " nanoseconds");
        System.out.println("Trie Insertion Time: " + trieInsertionTime + " nanoseconds");
        System.out.println("BST Deletion Time: " + bstDeletionTime + " nanoseconds");
        System.out.println("Trie Deletion Time: " + trieDeletionTime + " nanoseconds");
        System.out.println("BST Search Time: " + bstSearchTime + " nanoseconds");
        System.out.println("Trie Search Time: " + trieSearchTime + " nanoseconds");
    }

    // Helper method to generate random book titles
    private static List<String> generateRandomBookTitles(int count) {
        List<String> bookTitles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            StringBuilder title = new StringBuilder();
            int length = random.nextInt(10) + 5; // Random title length between 5 and 14 characters
            for (int j = 0; j < length; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a'); // Random lowercase letter
                title.append(randomChar);
            }
            bookTitles.add(title.toString());
        }
        return bookTitles;
    }
}
