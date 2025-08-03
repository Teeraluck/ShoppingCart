package lib.Discount;
import lib.*;
/**
 *  กลยุทธ์การคำนวณราคาสินค้าแบบปกติ (ไม่มีส่วนลด)
 */
public class DefaultPricingStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
        return item.getProduct().getprice() * item.getQuantity();
    }
    
}
