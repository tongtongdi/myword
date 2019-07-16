package jvm;

import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/10
 * @Author 王通
 * @Version 1.0
 */

public class JvmTest {

    public JvmTest(){
        byte[] bytes = new byte[128 * 1024];
    }

    public static void main(String[] args)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testmeth(100);
    }

    private static void testmeth(int n){
        List<JvmTest> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new JvmTest());
        }
    }
}
