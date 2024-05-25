package demo.northwindDemo.business.abstracts;
import java.util.List;
import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.core.Result;
import demo.northwindDemo.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getProducts();
	
	Result addProduct(Product product);
	
	Result deleteProduct(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory_categoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory_categoryId(String productName,int categoryId);

	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
}
