package javasrc.reflect;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/27 16:24
 * @Modified by:
 */
public class TestException {
    public static void main(String args[]){
        try{

        Class.forName("javasrc.reflect.Haha");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
