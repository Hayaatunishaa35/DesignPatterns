import java.util.*;

// Observale interface
interface IChannel{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

// Observer interface
interface ISubscriber{
    void update();
}

// Observale concrete class
class Channel implements IChannel{
    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name){
        this.subscribers = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void subscribe(ISubscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(){
        for(ISubscriber subscriber: subscribers){
            subscriber.update();
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscribers();
    }

    public String getVideoData() {
        return "\nChannel: " + name + "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

// Observale concrete class
class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;
    public Subscriber(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update(){
        System.out.println("Username : " + name);
        System.out.println(channel.getVideoData());
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args){
        Channel channel1 = new Channel("SampleChannel1");
        Channel channel2 = new Channel("SampleChannel2");

        Subscriber subscriber1 = new Subscriber("Subscriber1", channel1);
        Subscriber subscriber2 = new Subscriber("Subscriber2", channel1);

        channel2.subscribe(subscriber1);
        channel2.subscribe(subscriber2);

        channel1.uploadVideo("title1");
        channel2.uploadVideo("title2");
    }
}
