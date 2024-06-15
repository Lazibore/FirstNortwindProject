package demo.northwindDemo.api.controllers;
import demo.northwindDemo.business.abstracts.CategoryService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getcategories")
    public JSONArray getCategories()
    {
        return this.categoryService.getCagetories();
    }
}
