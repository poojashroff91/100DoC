import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

public class Journal {

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry (String text) {
        entries.add (" " + (++count) + ": " + text);
    }

    public void removeEntry (int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join (System.lineSeparator(), entries);
    }

}

class Persistence {
    public void saveToFile (Journal journal, String filename, boolean overwrite) throws FileNotFoundException {

        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }

    }
    public void load (String filename) {}

    public void load (URL url) {}
}

class DemoJournal {
    public static void main (String [] args) throws Exception{
        Journal journal = new Journal();
        journal.addEntry("I cried today.");
        journal.addEntry("I ate a bug.");
        System.out.println(journal);

        Persistence persistence = new Persistence();
        String filename = "/Users/poshroff/Documents/Work/100DoC/JavaDesignPatterns/journal.txt";
        persistence.saveToFile(journal, filename, true );


    }


}


