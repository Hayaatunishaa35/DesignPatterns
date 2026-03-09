interface IDataServer{
    void fetchData();
}

class RealDataServer implements IDataServer{

    public RealDataServer(){
        System.out.println("Connecting to the datasource...");
    }

    public void fetchData(){
        System.out.println("Fetching data from server");
    }
}

class ProxyDataServer implements IDataServer{
    private RealDataServer realDataServer;

    public ProxyDataServer(){
        realDataServer = new RealDataServer();
    }

    public void fetchData(){
        realDataServer.fetchData();
    }
}

public class RemoteProxy{
    public static void main(String[] args){
        IDataServer proxyDataServer = new ProxyDataServer();

        proxyDataServer.fetchData();
    }
}