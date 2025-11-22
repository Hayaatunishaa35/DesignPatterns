// Burger Interface
interface Burger{
    public void prepare();
}

// Concrete Burger Implementation
class BasicBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a basic burger");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a standard burger");
    }
}

class PremiumBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a premium burger");
    }
}

// Factory for object creation logic
class BurgerFactory{
    public Burger createBurger(String type){
        if(type.equals("basic")){
            return new BasicBurger();
        }
        else if(type.equals("standard")){
            return new StandardBurger();
        }
        else if(type.equals("premium")){
            return new PremiumBurger();
        }
        else{
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args){
        String type = "standard";

        BurgerFactory burgerFactory = new BurgerFactory();
        
        Burger burger = burgerFactory.createBurger(type);

        if(burger!=null){
            burger.prepare();
        }
    }
}
