package FactoryMethodPatternExample;

public class DocumentFactory {
    public Document create(String s){
        if(s.equals("Word")){
             new WordDocument().Writing();;
        }
        if(s.equals("Pdf")){
             new PdfDocument().Writing();
        }
        if(s.equals("Excel")){
             new ExcelDocument().Writing();;
        }
        return new WordDocument();
        
    }
    
}
