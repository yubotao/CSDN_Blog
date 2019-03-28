package starbuzz;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:32 2019/2/22
 * @Modified By:
 */
public abstract class Beverage {
    public String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
