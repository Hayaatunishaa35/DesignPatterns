// Product 1 -> Burger Interface
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



class BasicWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a basic wheat burger");
    }
}

class StandardWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a standard wheat burger");
    }
}

class PremiumWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("This is a premium wheat burger");
    }
}


// Product 2 -> Garlic bread 

interface GarlicBread{
    void prepare();
}

class BasicGarlicBread implements GarlicBread{
    @Override
    public void prepare(){
        System.out.println("This is a basic garlic bread");
    }
}

class WheatGarlicBread implements GarlicBread{
    @Override
    public void prepare(){
        System.out.println("This is a wheat garlic bread");
    }
}

// Abtract factory
interface MealFactory{
    Burger creatBurger(String type);
    GarlicBread creatGarlicBread(String type);
}

class NormalMealFactory implements MealFactory{
    public Burger creatBurger(String type){
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

    public GarlicBread creatGarlicBread(String type){
        if(type.equals("basic")){
            return new BasicGarlicBread();
        }
        else{
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

class WheatMealFactory implements MealFactory{
    public Burger creatBurger(String type){
        if(type.equals("basic")){
            return new BasicWheatBurger();
        }
        else if(type.equals("standard")){
            return new StandardWheatBurger();
        }
        else if(type.equals("premium")){
            return new PremiumWheatBurger();
        }
        else{
            System.out.println("Invalid burger type");
            return null;
        }
    }

    public GarlicBread creatGarlicBread(String type){
        if(type.equals("basic")){
            return new WheatGarlicBread();
        }
        else{
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

public class AbstractFactory {
    public static void main(String[] args){
        String burgerType = "premium";
        String breadType = "basic";

        MealFactory factory1 = new NormalMealFactory();
        MealFactory factory2 = new WheatMealFactory();

        Burger burger1 = factory1.creatBurger(burgerType);
        GarlicBread garlicBread1 = factory1.creatGarlicBread(breadType);

        Burger burger2 = factory2.creatBurger(burgerType);
        GarlicBread garlicBread2 = factory2.creatGarlicBread(breadType);

        burger1.prepare();
        garlicBread1.prepare();

        burger2.prepare();
        garlicBread2.prepare();
    }
}
