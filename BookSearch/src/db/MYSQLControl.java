package db;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;

import model.MyModel;
public class MYSQLControl {
	
    static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://127.0.0.1:3306/books");
    static QueryRunner qr = new QueryRunner(ds);
    
    public static void executeUpdate(String sql){
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void executeInsert(List<MyModel> doubanData) throws SQLException {
      
        Object[][] params = new Object[doubanData.size()][3];
        for ( int i=0; i<params.length; i++ ){
            params[i][0] = doubanData.get(i).getBookName();
            params[i][1] = doubanData.get(i).getBookScore();
            params[i][2] = doubanData.get(i).getBookComments();
        }
        qr.batch("insert into codingBooks (bookName, bookScore, bookComments)"
                + "values (?,?,?)", params);
        System.out.println("finish"+"insert amount"+doubanData.size());

    }
}
