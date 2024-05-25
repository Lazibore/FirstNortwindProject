package demo.northwindDemo.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.northwindDemo.business.abstracts.ProductService;
import demo.northwindDemo.core.DataResult;
import demo.northwindDemo.core.Result;
import demo.northwindDemo.core.SuccesResult;
import demo.northwindDemo.core.SuccessDataResult;
import demo.northwindDemo.dataAccess.abstracts.ProductDao;
import demo.northwindDemo.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	private ProductDao productDao;		

	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Result addProduct(Product product) {
		this.productDao.save(product);		
		return new SuccesResult("Ekleme basarili");
	}

	@Override
	public Result deleteProduct(Product product) {
		this.productDao.delete(product);		
		return new SuccesResult("Silme islemi basarili");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		("Urun bulundu",this.productDao.getByProductName(productName));
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_categoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		("Urun bulundu",this.productDao.getByProductNameAndCategory_categoryId(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_categoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		("Urunler bulundu",this.productDao.getByProductNameOrCategory_categoryId
				(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		("Urunler bulundu",this.productDao.getByProductNameContains
				(productName));
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		("Urunler bulundu",this.productDao.getByProductNameStartsWith
				(productName));
	}

	@Override
	public DataResult<List<Product>> getProducts() {		
		return new SuccessDataResult<List<Product>>
		("Urunler listelendi",this.productDao.findAll()
				);				
	}


}
