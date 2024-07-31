package FactoryMethodPatternExample;

public class FactoryWordDocument extends DocumentFactory {
    public Document createDocument(){
        return new WordDocument();
    }
}
