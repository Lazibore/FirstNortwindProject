package demo.northwindDemo.business.abstracts;
import java.util.List;
import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.core.Result;
import demo.northwindDemo.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getProducts();

	DataResult<Integer> deleteByProductName(String productName);

	Result addProduct(Product product);

	DataResult<List<Product>> getProductByPage(int pageNumber,int pageSize);

	Result deleteProductById(int productId);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory_categoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory_categoryId(String productName,int categoryId);

	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
}
