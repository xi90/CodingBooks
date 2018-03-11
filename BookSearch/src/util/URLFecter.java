package util;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import model.MyModel;
import parse.MyParse;
public class URLFecter {
	public static List<MyModel> URLParser (HttpClient client, String url) throws Exception {
       
        List<MyModel> doubanData = new ArrayList<MyModel>();
       
        HttpResponse response = HTTPUtils.getRawHtml(client, url);      
     
        int StatusCode = response.getStatusLine().getStatusCode();
        
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
            doubanData = MyParse.getData(entity);
            EntityUtils.consume(response.getEntity());
        }else {
            
            EntityUtils.consume(response.getEntity());
        }
        return doubanData;
    }
}
