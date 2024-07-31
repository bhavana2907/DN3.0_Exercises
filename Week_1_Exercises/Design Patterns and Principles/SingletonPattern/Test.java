public class Test {
    public static void main(String args[]){
        Logger user1=Logger.getInstance();
        Logger user2=Logger.getInstance();
        if(user1==user2){
            System.out.println("Both the users are same");

        }
        else{
        System.out.println("Both are not same");
        }

    }
}
