package streamapi;

import java.util.*;
import java.util.stream.Collectors;

class Book{
    private String author;
    private String title;
    private int pages;
    private Type type;

    public Book(String title, String author, int pages, Type type) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
enum Type{
    NOVEL,FICTION,HISTORY,THRILLER,PHILISOPHY
}
public class StreamWithObjects {
    public static void main(String[] args) {
        List<Book> books=new ArrayList<>();
        books.add(new Book("Being and Time","Heidegger",560,Type.PHILISOPHY));
        books.add(new Book("The Trail","Franz kafka",240,Type.NOVEL));
        books.add(new Book("Death on Nile","Agatha Christie",370,Type.THRILLER));
        books.add(new Book("Ancient Greece","Robert F",860,Type.HISTORY));
        books.add(new Book("Ancient Rome","Hermann Broch",435,Type.HISTORY));
        books.add(new Book("Death of Virgil","Albert Camus",560,Type.NOVEL));
        books.add(new Book("The Stranger","Heidegger",890,Type.NOVEL));
        System.out.println("Printing all books....");
        books.stream().forEach(System.out::println);

        List<Book> novels = books.stream().filter(t -> t.getType().equals(Type.NOVEL))
                .sorted(Comparator.comparing(Book::getAuthor))
                .collect(Collectors.toList());
        System.out.println("Printing only novels...");
        novels.forEach(System.out::println);
        System.out.println("Printing titles of books which are of type NOVEL on ascending order of author");
        List<String> titles = books.stream().filter(t -> t.getType().equals(Type.NOVEL))
                .sorted(Comparator.comparing(Book::getAuthor))
                .map(Book::getTitle)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);
        //////////////////////// grouping by type

        Map<Type,List<Book>> map=books.stream()
                .collect(Collectors.groupingBy(Book::getType));
        System.out.println("Grouping by type.....");
        map.entrySet().forEach(e-> System.out.println(e));
        // finding 2 longest books number of pages
        System.out.println("Finding longest books titles...");
        List<String> longest=books.stream()
                .sorted(Comparator.comparing(Book::getPages).reversed())

                .map(Book::getTitle)
                .limit(2)
               .collect(Collectors.toList());
        longest.forEach(System.out::println);
        //select all books where title is made up of exactly 2 words
        System.out.println("title is made up of exactly 2 words...");
        List<Book> twoWordBooks= books.stream()

                .filter(
                //   t-> Arrays.stream(t.getTitle().split(" ")).count()==2)
                t->t.getTitle().split(" ").length==2)
                .collect(Collectors.toList());
        System.out.println(twoWordBooks);



    }
}
