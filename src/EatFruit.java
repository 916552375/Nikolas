/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/25 17:25
 * @Modified by:
 */
public class EatFruit implements IFruit{

    @Override
    public void eat() {
        System.out.println("我们都爱吃水果!");
    }
    public static void main(String args[]){
        new EatFruit().eat();
    }
}
