package FactoryMethodPatternExample;

public class FactoryPdfDocument extends DocumentFactory {
    public Document createDocument(){
        return new PdfDocument();
    }
    
}
