package solidprinciples.interfacesegregation;

interface Printable{
    void print(String document);
}
interface Scannable{
    void scan(String document);
}
interface Faxable{
    void fax(String docuemnt);
}
class BasicPrinter1 implements Printable {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}
class MultiFunctionPrinter1 implements Printable, Scannable, Faxable {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("Faxing: " + document);
    }
}
public class ISPExample {
}
/*
There’s no need to provide meaningless or unsupported method implementations.
Extensibility: Adding new functionalities (e.g., copying) requires creating a new interface, not modifying existing ones.
Design smaller, specific interfaces based on functionality.
Ensure that classes only implement the interfaces they require.
Avoid forcing classes to implement methods they don’t use.
 */
