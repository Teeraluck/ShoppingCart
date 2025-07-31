package lib;

/**
 * ADT  ที่เปลี่ยนแปลงได้ (Mutable) สำหรับเก็บข้อมูลสินค้า 1 รายการในตะกร้า
 */
public class CartItem {
    private final Product product;
    private int quantity;

    // Rap Invariant (RI);
    // - product is not null.
    // - quantity > 0.
    //
    // Abstration Function (AF);
    // - AF(product, quantity) = An item in a shopping
    //   with the specified 'quantity'.

    /**
     *  ตรวจสอบว่า Rap Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if (product == null) {
            throw new RuntimeException("RI violated : product Error");
        }
        if (quantity <= 0) {
            throw new RuntimeException("RI violated : quantity Error");
        }
    }
    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    /**
     * @return อ็อบเจกต์ Product
     */
    public Product getProduct() {return product;}
    
    public int getQuantity() {return quantity;}

    /**
     * เพิ่มจำนวนสินค้าในรายการนี้
     * @param amount จำนวนที่ต้องการเพิ่ม (ต้องเป็นค่าบวก)
     */
    public void increaseQuantity(int amount){
        if (amount > 0) {
            this.quantity += amount;
        }
        checkRep(); //ตรวจหหลังการเปลี่ยนแปลงสถานะ
    }
}
