package designpatterns.creational.structural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class File{

    private String name;
    public File(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void ls();
    public abstract void addFile(File file);
    public abstract File[] getFiles();
    public abstract boolean removeFile(File file);
}
//leaf node in composite pattern
class BinaryFile extends File{
    private long size;
    public BinaryFile(String name,long size){
        super(name);
        this.size=size;
    }

    @Override
    public void ls() {
        System.out.println(getName()+"\t"+size);
    }

    @Override
    public void addFile(File file) {
        throw new UnsupportedOperationException("Leaf node does not support add operation");
    }

    @Override
    public File[] getFiles() {
        throw new UnsupportedOperationException("Leaf node does not support get operation");

    }

    @Override
    public boolean removeFile(File file) {
        throw new UnsupportedOperationException("Leaf node does not support remove operation");

    }
}

class Directory extends File{
    private List<File> children=new ArrayList<>();
    public Directory(String name){
        super(name);
    }

    @Override
    public void ls() {
        System.out.println(getName());
        children.forEach(File::ls);
    }


    @Override
    public void addFile(File file) {
children.add(file);
    }

    @Override
    public File[] getFiles() {
        return children.toArray(new File[children.size()]);
    }

    @Override
    public boolean removeFile(File file) {
        return children.remove(file);
    }
}
public class CompositeDesignPattern
{
    private static File createTreeOne(){
        File file1=new BinaryFile("File1",1000);
        Directory dir1=new Directory("dir1");
        dir1.addFile(file1);
        File file2=new BinaryFile("File2",2000);
        File file3=new BinaryFile("File3",150);
        Directory dir2=new Directory("dir2");
        dir2.addFile(file2);
        dir2.addFile(file3);
        dir2.addFile(dir1);
        return dir2;
    }
    private static File createTreeTwo(){
        return new BinaryFile("Another file",200);
    }
    public static void main(String[] args) {
File root1=createTreeOne();
root1.ls();
        System.out.println("**************");
        File[] files = root1.getFiles();
        Arrays.stream(files).forEach(File::ls);
File root2=createTreeTwo();
        System.out.println("**************");
root2.ls();




    }
}
