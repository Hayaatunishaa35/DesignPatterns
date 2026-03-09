interface IDisplay{
    void display();
}

class RealDisplay implements IDisplay{
    private String imgPath;

    public RealDisplay(String path){
        this.imgPath = path;
        System.out.println("Loading image from disk...");
        System.out.println("Compressing the image...");
    }

    public void display(){
        System.out.println("Displaying the image : " + imgPath);
    }
}

class ProxyDisplay implements IDisplay{
    private RealDisplay realDisplay;
    private String imgPath;

    public ProxyDisplay(String path){
        this.imgPath = path;
        realDisplay = null;
    }

    public void display(){
        realDisplay = new RealDisplay(imgPath);
        // lazy loading
        realDisplay.display();
    }
}

public class VirtualProxy{
    public static void main(String[] args){
        IDisplay image = new ProxyDisplay("/folder/file");

        image.display();

    }
}