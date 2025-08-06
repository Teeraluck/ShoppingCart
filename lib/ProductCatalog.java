package lib;

import java.util.ArrayList;


/**
 * คลาสทำหน้าที่เป็นแคตตาล็อกสินค้า (Repsitory)
 */
public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    // RI: products list is not null, contains no null elemants, and
    // AF: AF(products) = A catalog of all avaiable products.
    private void checkRep(){
        if (products == null) {
            throw new RuntimeException("RI violated : products list cannot be null.");
        }
        //Check for duplicate products
        for(int i = 0; i < products.size(); i++){
            for (int j = i + 1; j < products.size(); i++){
                if (products.get(i).equals(products.get(j))) {
                    throw new RuntimeException("RI violated : catalog contains duplicate products.");
                }
            }
        }
    }
    public ProductCatalog() {
        checkRep();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     * เพิ่มสินค้าใหม่เข้าสู่แคตตตาล็อก
     * @param productID รหัสสินค้าที่ต้องการค้นหา
     * @return อ็อบเจกต์ Product หากพบ, หรือ null
     */

     public Product findById(String productId){
        for(Product p : products){
            if (p.getproductId().equals(productId)) {
                return p ;
            }
        }
        return null;
     }
}
