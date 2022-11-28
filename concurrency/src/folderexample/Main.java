package folderexample;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        var pool = new ForkJoinPool();
        var tmp = new FolderProcessor("/tmp","swift");
        var usr = new FolderProcessor("/usr","swift");
        var theLot = new FolderProcessor("/","swift");
        pool.execute(tmp);
        pool.execute(usr);
        pool.execute(theLot);
        System.out.format("Number of processors: %s%n", pool.getParallelism());
        System.out.format("Thread count %d%n", pool.getActiveThreadCount());
        System.out.format("Queued tasks: %d%n", pool.getQueuedTaskCount());
        System.out.format("Stole? %d%n", pool.getStealCount());
        pool.shutdown();
        List<String> results = tmp.join();
        System.out.format("The number of matching entries is %d%n",
            results.size());
        for (var s: results){
            System.out.format("Matching: %s%n", s);
        }
    }
}
