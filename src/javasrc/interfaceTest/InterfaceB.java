package javasrc.interfaceTest;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/26 17:01
 * @Modified by:
 */
public interface InterfaceB {
    int getB();
    default void ib(){
        System.out.println("This is ib() function test .");
    }
}