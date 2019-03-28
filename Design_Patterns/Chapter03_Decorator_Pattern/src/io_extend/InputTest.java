package io_extend;

import java.io.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:56 2019/2/22
 * @Modified By:
 */
public class InputTest {
    // 相对于整个项目的文件路径
    private static String file = "/io_extend/test.txt";
    public static void main(String[] args) {
        int c;
        try {
//            System.out.println(new File(".").getAbsolutePath());
            //当前类的绝对路径
//            System.out.println(InputTest.class.getResource("/").getFile());
            //指定CLASSPATH文件的绝对路径
//            System.out.println(InputTest.class.getResource(file).getFile());
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(InputTest.class.getResource(file).getFile())));

            while ((c = in.read()) >= 0){
                System.out.print((char) c);
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
