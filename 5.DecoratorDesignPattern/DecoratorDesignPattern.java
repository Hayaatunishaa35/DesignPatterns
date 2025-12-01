//Component Interface
interface ICharacter{
    String getAbilities();
}

//Concrete component of ICharacter
class Mario implements ICharacter{
    @Override
    public String getAbilities(){
        return "Mario";
    }
}

//Abstract decorator - is-a and has-a relationship with ICharacter
abstract class CharacterDecorator implements ICharacter{//is a
    protected ICharacter character;//has a

    public CharacterDecorator(ICharacter character){
        this.character = character;
    }
}

//Concrete Decorator - Height Up
class HeightUp extends CharacterDecorator{
    public HeightUp(ICharacter character){
        super(character);
    }

    @Override
    public String getAbilities(){
        return character.getAbilities() + " with height up";
    }
}

//Concrete Decorator - GunPowerUp
class GunPowerUp extends CharacterDecorator{
    public GunPowerUp(ICharacter character){
        super(character);
    }

    @Override
    public String getAbilities(){
        return character.getAbilities() + " with gun power up";
    }
}

//Concrete Decorator - StarPowerUp
class StarPowerUp extends CharacterDecorator{
    public StarPowerUp(ICharacter character){
        super(character);
    }

    @Override
    public String getAbilities(){
        return character.getAbilities() + " with star power up";
    }
}

public class DecoratorDesignPattern{
    public static void main(String[] args){
        ICharacter mario = new Mario();
        System.out.println("Basic Character: "+ mario.getAbilities());

        // wrapping height-up decorator
        mario = new HeightUp(mario);
        System.out.println("Height-up Character: "+ mario.getAbilities());

        // wrapping height-up decorator
        mario = new GunPowerUp(mario);
        System.out.println("Height-up and GunPower-up Character: "+ mario.getAbilities());

        // wrapping height-up decorator
        mario = new StarPowerUp(mario);
        System.out.println("Height up, GunPower-up and StarPower-up Character: "+ mario.getAbilities());


    }
}