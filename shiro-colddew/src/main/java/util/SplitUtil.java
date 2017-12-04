package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubotao on 2017/11/09.
 */
public class SplitUtil {
    public List<Integer> stringToIntegerList(String s){
        String[] arr = s.split(",");
        System.out.println(arr.toString());
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            System.out.println(Integer.parseInt(arr[i]));
            intList.add(Integer.parseInt(arr[i]));
        }
        return  intList;
    }
    
    public String intListToString(List<Integer> intArr){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(intArr.get(0) + "");
        for (int i = 1; i < intArr.size(); i++){
            stringBuffer.append(","); 
            stringBuffer.append(intArr.get(i) + "");
        }
        return stringBuffer.toString();
    }
}
