package BuilderPatternExample;

public class Builder {
    public String CPU;
    public String RAM;
    public String Storage;
    public String Processor;

    public Builder(String s){
        this.CPU=s;
    }
    public Builder setRAM(String s){
        this.RAM=s;
        return this;
    }
    public Builder setStorage(String s){
        this.Storage=s;
        return this;
    }
    public Builder setProcessor(String s){
        this.Processor=s;
        return this;
    }
    public Computer build(){
        return new Computer(this);
    }
    
}
