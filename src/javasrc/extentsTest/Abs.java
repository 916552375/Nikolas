package javasrc.extentsTest;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/25 17:37
 * @Modified by:
 */

/**
 * 抽象类不能直接实例化,但是可以通过子类实例化；
 */
public abstract class Abs {
    public void hobby(){};
    public String sex(){
        return "male";
    }
}
