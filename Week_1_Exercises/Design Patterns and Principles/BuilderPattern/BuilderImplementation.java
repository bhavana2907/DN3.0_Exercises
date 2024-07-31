package BuilderPatternExample;

public class BuilderImplementation {
    public static void main(String args[]){
        Computer c=new Builder("Intel")
                    .setProcessor("i7")
                    .setRAM("32")
                    .setStorage("512")
                    .build();
        c.getDetails();

    }
}
