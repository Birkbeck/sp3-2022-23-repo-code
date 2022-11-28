package folderexample;

/* Example of the Fork/Join Framework which is based upon the work of Doug Lea */

/* This example searches for any files with a matching extension within
 * the current folder or its sub-folders.
 *
 * The code makes use of ForkJoinPool instead of ExecutorService as FJP
 * uses a work-stealing algorithm to balance the workload.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

class FolderProcessor extends RecursiveTask<List<String>> {
    private final String path;
    private final String extension;

    private final static int MAX_SIZE = 50;

    public FolderProcessor(String path, String extension){
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        System.out.format("Task: %s%n", Thread.currentThread().getName());

        List<String> list = new ArrayList<>(); // files stored in folder
        List<FolderProcessor> tasks = new ArrayList<>(); // list of tasks to perform

        var file = new File(path); // The contents of the current folder
        File[] content = file.listFiles(); // files in the folder
        if (content != null){
            for (var i=0; i < content.length; i++){
                //System.out.format("Looking at %s%n", content[i]);
                if (content[i].isDirectory()){
                    System.out.format("Examining directory %s%n", content[i]);
                    var task = new FolderProcessor(content[i].getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                }
                else {
                    if (check(content[i].getName())){
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
        }
        if (tasks.size() > MAX_SIZE){
            System.out.format("%s: %d tasks%n", file.getAbsolutePath(), tasks.size());
        }
        addToResults(list,tasks);
        return list;
    }

    void addToResults(List<String> list, List<FolderProcessor> tasks){
        for (var task: tasks){
            list.addAll(task.join());
        }
    }
    boolean check(String fileName){
        System.out.format("Examining %s%n", fileName);
        return fileName.endsWith(extension);
    }
}
