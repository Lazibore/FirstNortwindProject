package demo.northwindDemo.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Result deleteProductById(int productId) {
		this.productDao.deleteById(productId);
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

	@Override
	public DataResult<Integer> deleteByProductName(String ProductName) {
		return new SuccessDataResult<>(this.productDao.deleteByProductName(ProductName));
	}

	public DataResult<List<Product>> getProductByPage(int pageNumber,int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		return new SuccessDataResult<List<Product>>
				("Urunler listelendi", this.productDao.findAll(pageable).getContent()
				);
	}

}
