// Complex subsystem
class PowerSupply{
    public void powerOn(){
        System.out.println("Power suppplied to the computer");
    }
}

class CoolingSystem{
    public void startFan(){
        System.out.println("Cooling system working");
    }
}

class CPU{
    public void init(){
        System.out.println("CPU initialized");
    }
}

class Memory{
    public void selfTest(){
        System.out.println("Memory: self test passed");
    }
}

class HardDrive{
    public void spinUp(){
        System.out.println("Hard drive: spinnig up");
    }
}

class BIOS{
    public void boot(CPU cpu, Memory memory){
        System.out.println("Booting the system");
        cpu.init();
        memory.selfTest();
    }
}

class OS{
    public void load(){
        System.out.println("Operating System: Loading into memory");
    }
}


// Compter facade decoupling complex subsystem from user
class ComputerFacade{
    private PowerSupply powerSupply = new PowerSupply();
    private CoolingSystem coolingSystem = new CoolingSystem();
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private BIOS bios = new BIOS();
    private OS os = new OS();
    public void startComputer(){
        System.out.println("Starting the Computer Ji");
        powerSupply.powerOn();
        coolingSystem.startFan();
        bios.boot(cpu, memory);
        hardDrive.spinUp();
        os.load();
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args){
        ComputerFacade facade = new ComputerFacade();
        facade.startComputer();
    }
}
