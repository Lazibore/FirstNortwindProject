package demo.northwindDemo.business.concretes;
import demo.northwindDemo.business.abstracts.CategoryService;
import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.core.SuccessDataResult;
import demo.northwindDemo.dataAccess.abstracts.CategoryDao;
import demo.northwindDemo.entities.concretes.Category;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {

@Autowired
 private CategoryDao categoryDao;

    @Override
    public JSONArray getCagetories() {
        return categoryDao.getCategories();

    }
}