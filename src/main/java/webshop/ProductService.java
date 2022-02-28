package webshop;

public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product product = productRepository.findProductById(id);
        if (productRepository.findProductById(id).getStock() >= amount) {
            productRepository.updateProductStock(id, amount);
        } else {
            throw new IllegalArgumentException("cant sell this many required: " + amount + " we have : " + product.getStock());
        }
    }
}
