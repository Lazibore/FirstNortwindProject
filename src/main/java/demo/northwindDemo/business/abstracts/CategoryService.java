package demo.northwindDemo.business.abstracts;

import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.core.Result;
import demo.northwindDemo.entities.concretes.Category;
import org.json.JSONArray;

import java.util.List;

public interface CategoryService {

   JSONArray getCagetories();
//   DataResult<Category> addCategory(String CategoryName);


}
