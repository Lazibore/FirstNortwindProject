package demo.northwindDemo.dataAccess.concretes;

import demo.northwindDemo.dataAccess.DBconnect;
import demo.northwindDemo.dataAccess.abstracts.CategoryDao;
import demo.northwindDemo.entities.concretes.Category;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CategoryRepo implements CategoryDao
{
    private final String query="select * from categories";

    public JSONArray getCategories() {
//        List<Category> categoryList= new ArrayList<Category>();
//            ResultSet rst=DBconnect.getConnect(query);
//        try {
//             while (rst.next()) {
//                    Category ctg =new Category();
//                    ctg.setCategoryName(rst.getString("category_name"));
//                    ctg.setCategoryId(rst.getInt("category_id"));
//                    categoryList.add(ctg);
//
//                }
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//
//        return categoryList;

        try {
            return DBconnect.getJsonList(this.query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
