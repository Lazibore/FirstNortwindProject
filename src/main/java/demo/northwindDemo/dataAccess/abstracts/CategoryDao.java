package demo.northwindDemo.dataAccess.abstracts;

import demo.northwindDemo.entities.concretes.Category;
import org.json.JSONArray;

import java.util.List;

public interface CategoryDao {
   JSONArray getCategories();
//   Category addCategory(String CategoryName);
}
