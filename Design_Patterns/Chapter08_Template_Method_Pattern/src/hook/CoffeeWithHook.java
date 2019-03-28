package hook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:32 2019/3/6
 * @Modified By:
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook{
    public void brew(){
        System.out.println("Dripping Coffee through filter");
    }

    public void addCondiments(){
        System.out.println("Adding Sugar and Milk");
    }

    public boolean customerWantsCondiments(){
        String answer = null;

        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        }catch (IOException e){
            System.err.println("IO error trying to read your answer");
        }

        if ("y".equals(answer)){
            return true;
        }else {
            return false;
        }
    }
}
