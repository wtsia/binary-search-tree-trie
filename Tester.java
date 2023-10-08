import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class Tester {

    public static void main(String[] args) {
        List<String> bookTitles = generateRandomBookTitles(10000);

        // Create BST and Trie instances
        BST<String> bst = new BST();
        Trie trie = new Trie();

        // Measure and compare insertion times
        Instant startTime = Instant.now();
        for (String title : bookTitles) {
            bst.insert(title);
        }
        Instant endTime = Instant.now();
        Duration bstInsertionTime = Duration.between(startTime, endTime);

        startTime = Instant.now();
        for (String title : bookTitles) {
            trie.insert(title);
        }
        endTime = Instant.now();
        Duration trieInsertionTime = Duration.between(startTime, endTime);

        // Measure and compare search times
        startTime = Instant.now();
        for (String title : bookTitles) {
            bst.search(title);
        }
        endTime = Instant.now();
        Duration bstSearchTime = Duration.between(startTime, endTime);

        startTime = Instant.now();
        for (String title : bookTitles) {
            trie.search(title);
        }
        endTime = Instant.now();
        Duration trieSearchTime = Duration.between(startTime, endTime);

        // Measure and compare deletion times
        startTime = Instant.now();
        for (String title : bookTitles) {
            bst.delete(title);
        }
        endTime = Instant.now();
        Duration bstDeletionTime = Duration.between(startTime, endTime);

        startTime = Instant.now();
        for (String title : bookTitles) {
            trie.delete(title);
        }
        endTime = Instant.now();
        Duration trieDeletionTime = Duration.between(startTime, endTime);

        // Display results
        System.out.println("** Measuring Insert Time **");
        System.out.println("BST Insertion Time : " + bstInsertionTime.toNanos() + " nanoseconds");
        System.out.println("Trie Insertion Time: " + trieInsertionTime.toNanos() + " nanoseconds\n");    
        System.out.println("** Measuring Search Time **");
        System.out.println("BST Search Time    : " + bstSearchTime.toNanos() + " nanoseconds");
        System.out.println("Trie Search Time   : " + trieSearchTime.toNanos() + " nanoseconds\n");   
        System.out.println("** Measuring Delete Time **");
        System.out.println("BST Deletion Time  : " + bstDeletionTime.toNanos() + " nanoseconds");
        System.out.println("Trie Deletion Time : " + trieDeletionTime.toNanos() + " nanoseconds\n");
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
