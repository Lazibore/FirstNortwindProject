package demo.northwindDemo.api.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import demo.northwindDemo.business.abstracts.ProductService;
import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;
	
	@Autowired	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){		
		return productService.getByProductName(productName);		
	}
	
	@GetMapping("/getproducts")
	public DataResult<List<Product>> getProducts(){		
		return this.productService.getProducts();		
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){		
		return this.productService.getByProductNameAndCategory_categoryId(productName, categoryId);		
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){		
		return this.productService.getByProductNameContains(productName);		
	}
	
		
}
