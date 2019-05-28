package array_compare;

import java.util.Arrays;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:44 2019/3/6
 * @Modified By:
 */
public class DuckSortTestDrive {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };

        System.out.println("Before sorting:");
        display(ducks);

        Arrays.sort(ducks);

        System.out.println("\nAfter sorting:");
        display(ducks);
    }

    public static void display(Duck[] ducks){
        for (Duck duck : ducks){
            System.out.println(duck);
        }
    }
}
