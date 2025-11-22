// package DesignPatterns.StrategyDesignPattern;

// interface for walk
interface WalkableRobot{
    public void walk();
}

class NormalWalk implements WalkableRobot{
    @Override
    public void walk(){
        System.out.println("Robot is walking");
    }
}

class NoWalk implements WalkableRobot{
    @Override
    public void walk(){
        System.out.println("Robot Do not walk");
    }
}

// interface for talkable
interface TalkableRobot{
    public void talk();
}

class NormalTalk implements TalkableRobot{
    @Override
    public void talk(){
        System.out.println("Robot is talking");
    }
}

class NoTalk implements TalkableRobot{
    @Override
    public void talk(){
        System.out.println("Robot Do not talk");
    }
}

// interface for fly
interface FlyableRobot{
    public void fly();
}

class NormalFly implements FlyableRobot{
    @Override
    public void fly(){
        System.out.println("Robot is flying");
    }
}

class NoFly implements FlyableRobot{
    @Override
    public void fly(){
        System.out.println("Robot Do not fly");
    }
}

// robot base class
abstract class Robot{
    private WalkableRobot walkBehavior;
    private TalkableRobot talkBehavior;
    private FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk(){
        walkBehavior.walk();
    }


    public void talk(){
        talkBehavior.talk();
    }

    public void fly(){
        flyBehavior.fly();
    }
    
    public abstract void projection();
}


// Concrete robot types
class CompanionRobot extends Robot{
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w,t,f);
    }

    public void projection(){
        System.out.println("Projecton of companion type robot");
    }
}

class WorkerRobot extends Robot{
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w,t,f);
    }

    public void projection(){
        System.out.println("Projecton of worker type robot");
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args){
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();


        Robot robot2 = new CompanionRobot(new NormalWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
    }
}
