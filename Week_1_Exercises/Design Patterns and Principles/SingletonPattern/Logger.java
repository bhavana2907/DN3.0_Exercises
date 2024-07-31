public class Logger {
    private static Logger l;
    private Logger(){
    }
    public static Logger getInstance(){
        if(l==null){
            l=new Logger();
        }
        return l;
    } 
}
