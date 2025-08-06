package lib;
import lib.Discount.*;
import java.util.ArrayList;
/**
 * ตลาดสำหรับจัดการโปรโมชันและคำนวณราคา
 */
public class PricingService {
    private record  StrategyRule(String sku, DiscountStrategy strategy) {}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaultStrategy = new DefaultPricingStrategy() {};

    /**
     * ลงทะเบียนกลยุทธ์ส่วนลดสำหรับ SKU ที่กำหนด
     * หากมีโปรโมชันสำหรับ SKU นี้ จะถูกแทนด้วยอันใหม่
     * @param sku รหัสสินคเาที่ต้องการผูกกับโปรโมชัน
     * @param strategy กลยุทธ์ส่วนลดที่จะใช้
     */
    public void addStrategy(String sku, DiscountStrategy strategy) {
        StrategyRule ruleToRemove = null;
        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) {
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
        
        
    }  

    /**
     * คำนวณราคาสุทธิของสินค้า 1 รายการโดยไใช้กลยุทธ์ส่วนลดที่เหมาะสม
     * @param item รหัสสินค้าที่ต้องการคำนวณราคา
     * @return ราคาสุทธิหลังหักส่วนลด
     */
    public double calculateItemPrice(CartItem item) {
        String sku = item.getProduct().getproductId();
        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                return rule.strategy().calculatePrice(item);
            }
        }
        return defaultStrategy.calculatePrice(item);
    }
}
