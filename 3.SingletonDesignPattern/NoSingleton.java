public class NoSingleton{
    public NoSingleton(){
        System.out.println("Constructo called, new object created");
    }
    public static void main(String[] args){
        NoSingleton obj1 = new NoSingleton();
        NoSingleton obj2 = new NoSingleton();
        System.out.println(obj1==obj2);
    }
}