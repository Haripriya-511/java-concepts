package designpatterns.creational;

interface Document{
    void open();
}
class WordDocument implements Document{

    @Override
    public void open() {
        System.out.println("Opening a word...");
    }
}
class PdfDocument implements Document{

    @Override
    public void open() {
        System.out.println("Opening a pdf...");
    }
}
abstract class DocumentFactory{
    public abstract Document createDocument();
}
class WordDocuemntFactory extends DocumentFactory{

    @Override
    public Document createDocument() {
        return  new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
public class FactoryMethodExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory=new WordDocuemntFactory();
        Document doc=wordFactory.createDocument();
        doc.open();


        DocumentFactory pdfFactory=new PdfDocumentFactory();
        Document doc1=pdfFactory.createDocument();
        doc1.open();;

    }
}
/*
but lets subclasses decide which class to instantiate.
It follows the Open/Closed Principle by allowing new types without modifying existing code.
How it Works:
Instead of calling a constructor directly, the client calls a factory method in an abstract class or interface.
Subclasses override the factory method to provide specific object creation.
Promotes extensibility: Adding a new type requires creating a new factory class.
The client code remains unchanged.
 */

/*
java.util.Collection has an abstract method called iterator()
 this is example of factory method
 */

