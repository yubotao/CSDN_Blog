package hook;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:38 2019/3/6
 * @Modified By:
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        System.out.println("\nMaking coffee...");
        coffeeWithHook.prepareRecipe();
    }
}
