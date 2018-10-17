public class Document {
}


interface Machine {
    void print (Document d);
    void fax (Document d) throws Exception;
    void scan (Document d);

}

class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
        //Of no use to OldFashionedPrinter
        throw new Exception("Unsupported action");
    }

    @Override
    public void scan(Document d) {
        //Of no use to OldFashionedPrinter
    }
}


interface Printer {
    void print (Document d);
}

interface Scanner {
    void scan (Document d);
}

//YAGNI - You ain't going to need it

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner{
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}