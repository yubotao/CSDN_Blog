package com.yubotao.test.copy;

import com.yubotao.test.copy.domain.Address;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import com.yubotao.test.copy.util.CopyUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: yubt
 * @description:
 * @date: Created in 11:48 2021/05/19
 * @modified By:
 */
public class CopyTest {

    public static void totalTest(CopyUtil copyUtil) {
//        STW(30);
        UserDO userDO1 = getDO();
        UserDO userDO2 = copyUtil.copyDO(userDO1);
        compare(userDO1, userDO2, copyUtil);
        try {
            UserVO userVO = copyUtil.copyVO(userDO1);
            copyVO(userDO1, userVO, copyUtil);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(copyUtil.getName() + "无法复制DO为VO");
        }
        loopTime(copyUtil, 1);
        loopTime(copyUtil, 100);
        loopTime(copyUtil, 10000);
//        STW(5);
    }

    private static void copyVO(UserDO userDO, UserVO userVO, CopyUtil copyUtil){
        System.out.println(copyUtil.getName() + "复制VO结果：");
        System.out.println(userDO);
        System.out.println(userVO);
    }

    private static void compare(UserDO userDO1, UserDO userDO2, CopyUtil copyUtil){
        System.out.println(copyUtil.getName() + "复制DO结果：");
        System.out.println(userDO1);
        System.out.println(userDO2);
        if (userDO1.equals(userDO2)){
            System.out.println(copyUtil.getName() + "是浅拷贝");
            return;
        }
        if (userDO1.getAddress().equals(userDO2.getAddress())){
            System.out.println(copyUtil.getName() + "是浅拷贝");
            return;
        }
        userDO1.setName("迪迦");
        if (userDO1.getName().equals(userDO2.getName())){
            System.out.println(copyUtil.getName() + "是浅拷贝");
            return;
        }
        userDO1.getAddress().setAddress("赛博坦");
        if (userDO1.getAddress().getAddress().equals(userDO2.getAddress().getAddress())){
            System.out.println(copyUtil.getName() + "是浅拷贝");
            return;
        }
        System.out.println(copyUtil.getName() + "是深拷贝");
        System.out.println(userDO1);
        System.out.println(userDO2);
    }

    public static UserDO getDO(){
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("赛文");
        userDO.setRealName("大古");
        userDO.setBirthday(new Date());
        userDO.setCardNo(112233);
        userDO.setAge(100);
        Address address = new Address();
        address.setAddress("M78星云");
        userDO.setAddress(address);
        return userDO;
    }

    private static void loopTime(CopyUtil copyUtil, int times){
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++){
            copyUtil.copyDO(getDO());
        }
        long loopTime = System.currentTimeMillis() - start;
        System.out.println(copyUtil.getName() + "循环复制" + times + "次，共耗时：" + loopTime + "ms");
    }

    private static void STW(int s){
        try {
            TimeUnit.SECONDS.sleep(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
