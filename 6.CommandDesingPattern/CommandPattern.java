// Command Interface
interface ICommand{
    void execute();
    void undo();
}

// Receivers
class Fan {
    public void on(){
        System.out.println("Fan turned ON");
    }
    public void off(){
        System.out.println("Fan turned OFF");
    }
}

class AC {
    public void on(){
        System.out.println("AC turned ON");
    }
    public void off(){
        System.out.println("AC turned OFF");
    }
}

// Concrete Commands
class FanCommand implements ICommand{
    private Fan fan;

    public FanCommand(Fan f){this.fan = f;}

    public void execute(){fan.on();}
    public void undo(){fan.off();}
}

class AcCommand implements ICommand{
    private AC ac;

    public AcCommand(AC ac){this.ac = ac;}

    public void execute(){ac.on();}
    public void undo(){ac.off();}
}

// Invoker : Remote controller with 4 buttons
class RemoteController{
    private static final int numButtons = 4;
    private ICommand[] buttons;
    private boolean[] buttonPressed;

    public RemoteController(){
        buttons = new ICommand[numButtons];
        buttonPressed = new boolean[numButtons];
    }

    public void setCommand(int index, ICommand cmd){
        if(index<0||index>3){return;}
        buttons[index] = cmd;
        buttonPressed[index] = false;
    }

    public void pressButton(int index){
        if(index<0||index>3){return;}
        if(!buttonPressed[index]){
            buttons[index].execute();
        }
        else{
            buttons[index].undo();
        }
        
        buttonPressed[index] = !buttonPressed[index];
    }
}

public class CommandPattern {
    public static void main(String[] args){
        Fan fan = new Fan();
        AC ac = new AC();

        RemoteController remote = new RemoteController();
        remote.setCommand(0, new FanCommand(fan));
        remote.setCommand(1, new AcCommand(ac));

        remote.pressButton(0);
        remote.pressButton(0);

        remote.pressButton(1);
        remote.pressButton(1);

    }
}
