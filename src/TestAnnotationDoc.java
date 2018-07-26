package bjyjf.com;


import java.lang.annotation.*;

/**
 * Author: Administrator
 * Despcription:My Annotation test
 * Date: Created in 2018/7/9 17:18
 * Modified by:
 */
@MyTestAnnotation()
public class TestAnnotationDoc {
    /**
     *
     * @param key  key
     * @param value value
     * @param corp   corpration
     */
    public static void print(String key,String value,String corp){
        System.out.println("Printing your information ...");
        System.out.println("property-->"+key+":"+value);
        System.out.println("property-->Companey:"+corp);
    }
    public static void main(String args[]){
        MyTestAnnotation myTestAnnotation = TestAnnotationDoc.class.getAnnotation(MyTestAnnotation.class);
        String key = myTestAnnotation.key();
        String value = myTestAnnotation.value();
        String corp = myTestAnnotation.corp();
        print(key,value,corp);
    }
}

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTestAnnotation{
    String key() default "name";
    String value() default "zdd";
    String corp() default "bjyjf";

}