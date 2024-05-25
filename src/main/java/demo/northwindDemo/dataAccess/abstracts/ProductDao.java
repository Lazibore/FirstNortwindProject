package demo.northwindDemo.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.northwindDemo.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_categoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_categoryId(String productName,int categoryId);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
}

