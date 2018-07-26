package javasrc.interfaceTest;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/26 17:06
 * @Modified by:
 */
public class IntImpl implements InterfaceA,InterfaceB {

    @Override
    public int getA() {
        return 1024;
    }

    @Override
    public int getB() {
        return 512;
    }
    public static void main(String args[]){
       IntImpl il = new IntImpl();
        Integer sum;
        sum = il.getA()+il.getB();
        System.out.println("总和="+sum.toString());
    }
}