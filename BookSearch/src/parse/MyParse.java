package parse;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import model.MyModel;

public class MyParse {
	 public static List<MyModel> getData (String html) throws Exception{
	        
	        List<MyModel> data = new ArrayList<MyModel>();
	        
	        Document doc = Jsoup.parse(html);
	        
	        Elements elements=doc.select("ul[class=subject-list]").select("li[class=subject-item]").select("div[class=info]");
	        
	        for (Element ele:elements) {
	            String bookName=ele.select("h2").select("a").attr("title");
	            String bookScore=ele.select("div[class=star clearfix]").select("span[class=rating_nums]").text();
	            String bookComments=ele.select("div[class=star clearfix]").select("span[class=pl]").text();
	            
	            MyModel doubanModel=new MyModel();
	            
	            doubanModel.setBookName(bookName);
	            doubanModel.setBookScore(bookScore);
	            doubanModel.setBookComments(bookComments);
	            
	            data.add(doubanModel);
	        }
	        
	        return data;
	    }
}
