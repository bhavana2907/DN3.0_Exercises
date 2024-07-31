package BuilderPatternExample;

public class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private String Processor;
    Computer(Builder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.Storage=builder.Storage;
        this.Processor=builder.Processor;
    }
    public void getDetails(){
        System.out.println("RAM:"+this.RAM);
        System.out.println("CPU:"+this.CPU);
        System.out.println("Storage:"+this.Storage);
        System.out.println("Processor:"+this.Processor);
    }
    
}
