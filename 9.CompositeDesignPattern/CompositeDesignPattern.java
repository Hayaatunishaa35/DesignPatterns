import java.util.*;

// Contract
// Implementing a file system
interface FileSystemItem{
    FileSystemItem cd(String directory);
    void ls(int indent);
    void openAll(int indent);
    String getName();
    int getSize();
    boolean isFolder();
}

// Leaf Node
class File implements FileSystemItem{
    private String fileName;
    private int size;

    public File(String name, int size){
        this.fileName = name;
        this.size = size;
    }


    @Override
    public FileSystemItem cd(String directory){
        return null;
    }

    @Override
    public void ls(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces+fileName);
    }

    @Override
    public void openAll(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces+fileName);
    }

    @Override
    public String getName(){
        return fileName;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isFolder(){
        return false;
    }
}

// Composite Node
class Folder implements FileSystemItem{
    private String folderName;
    private List<FileSystemItem> subDirectories;

    public Folder(String name){
        this.folderName = name;
        this.subDirectories = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        subDirectories.add(item);
    }

    @Override
    public FileSystemItem cd(String directory){
        for(FileSystemItem it : subDirectories){
            if(it.isFolder() && it.getName().equals(directory)){
                return it;
            }
        }

        return null;
    }

    @Override
    public void ls(int indent){
        for(FileSystemItem it : subDirectories){
            System.out.println(" ".repeat(indent)+it.getName());
        }
    }

    @Override
    public void openAll(int indent){
        System.out.println(" ".repeat(indent) + folderName);
        for(FileSystemItem it : subDirectories){
            it.openAll(indent+4);
        }
    }

    @Override
    public String getName(){
        return folderName;
    }

    @Override
    public int getSize(){
        int size = 0;
        for(FileSystemItem it : subDirectories){
            size += it.getSize();
        }

        return size;
    }

    @Override
    public boolean isFolder(){
        return true;
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args){
        Folder root = new Folder("root");
        root.add(new File("file1.txt", 1));
        root.add(new File("file2.txt", 3));

        Folder home = new Folder("home");
        home.add(new File("home1.txt", 2));
        home.add(new File("home2.txt", 1));

        Folder user = new Folder("user");
        user.add(new File("user1.txt", 12));
        user.add(new File("user2.txt", 11));

        root.add(home);
        root.add(user);
        
        System.out.println("------------------------------------------------------");
        root.ls(0);

        System.out.println("------------------------------------------------------");
        FileSystemItem current = root.cd("home");
        current.ls(1);


        System.out.println("------------------------------------------------------");
        home.ls(1);

        System.out.println("------------------------------------------------------");
        root.openAll(0);

        System.out.println("------------------------------------------------------");
        System.out.println(root.getSize());

    }
}
