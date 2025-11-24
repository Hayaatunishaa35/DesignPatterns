class SingletonClass {
    private static SingletonClass instance = null;
    private SingletonClass(){
        System.out.println("Constructo called, new object created");
    }

    public static SingletonClass getInstance(){
        if(instance==null){
            synchronized(SingletonClass.class){
                if(instance==null){
                    instance = new SingletonClass();
                }
            }
        }


        return instance;
    }
}


public class ThreadSafeDoubleLockingSingleton {
    public static void main(String[] args){
        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        System.out.println(obj1==obj2);
    }
}