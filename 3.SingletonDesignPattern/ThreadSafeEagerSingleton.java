class SingletonClass {
    private static SingletonClass instance = new SingletonClass();
    private SingletonClass(){
        System.out.println("Constructo called, new object created");
    }

    public static SingletonClass getInstance(){
        return instance;
    }
}

public class ThreadSafeEagerSingleton {
    public static void main(String[] args){
        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        System.out.println(obj1==obj2);
    }
}
