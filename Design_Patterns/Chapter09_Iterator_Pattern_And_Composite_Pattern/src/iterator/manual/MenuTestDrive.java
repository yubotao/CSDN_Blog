package iterator.manual;


/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:35 2019/3/12
 * @Modified By:
 */
public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

        waitress.printMenu();
    }
}
