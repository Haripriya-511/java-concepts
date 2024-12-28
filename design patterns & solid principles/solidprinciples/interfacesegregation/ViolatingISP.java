package solidprinciples.interfacesegregation;
interface Printer {
    void print(String document);
    void scan(String document);
    void fax(String document);
}
class BasicPrinter implements Printer {

    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException("Scan not supported");
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("Fax not supported");
    }
}
class MultiFunctionPrinter implements Printer {
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
public class ViolatingISP {
    public static void main(String[] args) {

    }
}
