package lib;

public final class Product {
    private final String productId;
    private final String productName;
    private final Double price;

    // Rap Invariant (RI);
    // - productId and productName are not null or blank.
    // - price >= 0.
    //
    // Abstration Function (AF);
    // - AF(productId, productName, price) = A product with the

    /**
     *  ตรวจสอบว่า Rap Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if (productId == null || productId.isBlank()) {
            throw new RuntimeException("RI violated : productId Error");
        }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated : productName Error");
        }
        if (price < 0) {
            throw new RuntimeException("RI violated : price Error");
        }
    }
    /**
     * สร้างอ็อบเจกต์ product
     * @param productId รหัสสินค้า ห้ามเป็นคำว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นคำว่าง
     * @param price ราคา ต้องไม่ติดลบ
     * @throws IllegalArgumentException หากคุณสมบัติ
     */
    public Product(String productId, String productName, Double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
    }

    /**
     * @return รหัสสินค้า
     */
    public String getproductId() { return productId; }

    /**
     * @return ชื่อสินค้า
     */
    public String getproductName() { return productName; }
    /**
     * @return ราคาของสินค้า
     */
    public double getprice() { return price; }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return false;
    }
}


