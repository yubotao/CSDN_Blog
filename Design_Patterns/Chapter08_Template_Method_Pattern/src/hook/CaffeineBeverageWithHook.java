package hook;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:31 2019/3/6
 * @Modified By:
 */
public abstract class CaffeineBeverageWithHook {

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }

    boolean customerWantsCondiments(){ // 钩子
        return true;
    }

}
