package main;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import db.MYSQLControl;
import model.MyModel;
import util.URLFecter;
public class MyMain {
	
    static final Log logger = LogFactory.getLog(MyMain.class);
    public static void main(String[] args) throws Exception {
        
        HttpClient client = new DefaultHttpClient();
        
        String url="https://book.douban.com/tag/%E7%BC%96%E7%A8%8B";
        
        List<MyModel> bookdatas=URLFecter.URLParser(client, url);
        
        for (MyModel douban:bookdatas) {
            logger.info("bookName:"+douban.getBookName()+"\t"+"bookScore:"+douban.getBookScore()+"\t"+"bookComments:"+douban.getBookComments());
        }
        
        MYSQLControl.executeInsert(bookdatas);
    }
}
