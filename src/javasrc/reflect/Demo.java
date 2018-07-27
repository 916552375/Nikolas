package javasrc.reflect;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/27 14:04
 * @Modified by:
 */
class Demo{}
class Hello{
    public static void main(String args[]){
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        Class<?> demo4 = null;
        try{

        demo1=Class.forName("javasrc.reflect.Demo");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        demo2=new Demo().getClass();
        demo3=Demo.class;
        demo4=new Hello().getClass();
        System.out.println("类名称："+demo1.getName());
        System.out.println("类名称："+demo2.getName());
        System.out.println("类名称："+demo3.getName());
        System.out.println("类名称："+demo4.getName());
    }
}