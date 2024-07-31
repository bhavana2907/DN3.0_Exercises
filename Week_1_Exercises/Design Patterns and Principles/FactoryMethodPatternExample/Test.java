package FactoryMethodPatternExample;

public class Test {
    public static void main(String[] args) {
        DocumentFactory doc =new DocumentFactory();
        doc.create("Pdf");
        doc.create("Word");
        doc.create("Excel");
    }
}
