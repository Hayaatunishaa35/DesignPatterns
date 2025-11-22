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



interface BurgerFactory{
    Burger createBurger(String type);
}

class NormalBurgerFactory implements BurgerFactory{
    @Override
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

class WheatBurgerFactory implements BurgerFactory{
    @Override
    public Burger createBurger(String type){
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
}

public class FactoryMethod {
    public static void main(String[] args){
        String type1 = "basic";
        String type2 = "premium";

        BurgerFactory factory1 = new NormalBurgerFactory();
        BurgerFactory factory2 = new WheatBurgerFactory();

        Burger burger1 = factory1.createBurger(type1);
        Burger burger2 = factory2.createBurger(type2);

        if(burger1!=null){
            burger1.prepare();
        }

        if(burger2!=null){
            burger2.prepare();
        }
    }
}
