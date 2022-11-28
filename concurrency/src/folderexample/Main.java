package folderexample;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        var pool = new ForkJoinPool(); // to show that the process management is handled automatically

        var tmp = new FolderProcessor("/tmp", "swift"); // search through various directories
        var usr = new FolderProcessor("/usr", "swift");
        var theLot = new FolderProcessor("/", "swift");

        pool.execute(tmp);
        pool.execute(usr);
        pool.execute(theLot); // add them to the pool
        System.err.println();

        // get some stats
        System.err.format("Number of processors: %s%n", pool.getParallelism());
        System.err.format("Thread count %d%n", pool.getActiveThreadCount());
        System.err.format("Queued tasks: %d%n", pool.getQueuedTaskCount());
        System.err.format("Stole? %d%n", pool.getStealCount());
        System.out.println();

        pool.shutdown(); // make sure we close them down

        results(tmp.join()); // get the results for the first one as an example
        results(usr.join());
        results(theLot.join());
    }

    static void results(List<String> results) {
        System.err.format("The number of matching entries is %d%n", results.size());
        results.forEach(s -> System.err.format("Matching: %s%n%n", s));
    }
}
