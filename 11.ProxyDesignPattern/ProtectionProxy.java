interface IVideoStreamer{
    void playVideo();
}

class VideoStreamer implements IVideoStreamer{
    @Override
    public void playVideo(){
        System.out.println("Streaming video");
    }

    public void playVideoWithoutAd(){
        System.out.println("Streaming video without ad.");
    }
}


class ProxyVideoStreamer implements IVideoStreamer{
    private VideoStreamer videoStreamer;
    private User user;
    public ProxyVideoStreamer(User user){
        this.user = user;
        videoStreamer = new VideoStreamer();
    }

    public void playVideo(){
        if(user.isPremiumUser){
            videoStreamer.playVideoWithoutAd();
        }
        else{
            videoStreamer.playVideo();
        }
    }
}

class User{
    String userName;
    boolean isPremiumUser;

    public User(String userName, boolean isPremiumUser){
        this.userName = userName;
        this.isPremiumUser = isPremiumUser;
    }
}

public class ProtectionProxy {
    public static void main(String[] args){
        User user1 = new User("abc", true);
        User user2 = new User("xyz", false);

        IVideoStreamer videoStreamer1 = new ProxyVideoStreamer(user1);
        videoStreamer1.playVideo();

        IVideoStreamer videoStreamer2 = new ProxyVideoStreamer(user2);
        videoStreamer2.playVideo();
    }
}
