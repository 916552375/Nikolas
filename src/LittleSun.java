/**
 * @Author:zdd
 * @Despcription:
 * @Date: Created in 2018/7/25 17:40
 * @Modified by:
 */
public class LittleSun extends Abs{
    @Override
    public void hobby(){
        System.out.println("My hobby is hiking .");
    }
    public static void main(String args[]){
        System.out.println("你的性别是"+new LittleSun().sex());
        LittleSun littleSun = new LittleSun();
        littleSun.hobby();
    }
}
