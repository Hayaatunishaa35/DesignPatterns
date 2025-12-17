
// Report expected by the client
interface IReport{
    void getJsonData(XmlData xmlData);
}

// Adaptee
class XmlData{
    public void getXmlData(){
        System.out.println("This is the xml data");
    }
}

// Adapter
class JsonData implements IReport{
    public void getJsonData(XmlData xmlData){
        xmlData.getXmlData();
        xmlToJSonConverter(xmlData);
        System.out.println("This is the Json data");
    }

    public void xmlToJSonConverter(XmlData xmlData){
        System.out.println("Xml data converted to Json data");
    }

}

// client dealing directly with the Json report
class Client{
    public void getReport(IReport report, XmlData xmlData){
        report.getJsonData(xmlData);
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args){
        XmlData xmlData = new XmlData();

        IReport report = new JsonData();

        Client client = new Client();
        client.getReport(report,xmlData);
    }
}
