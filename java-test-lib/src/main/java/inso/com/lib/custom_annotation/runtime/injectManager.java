package inso.com.lib.custom_annotation.runtime;

/**
 * Comment:
 * Author: ftc300
 * Date: 2018/9/4
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public class injectManager {
    static public void parentInject() throws ClassNotFoundException {
        //注解解析
        Class<?> clz = Class.forName("inso.com.lib.custom_annotation.runtime.Parent");
        InjectValue annotation = clz.getAnnotation(InjectValue.class);
        if (annotation != null) {
            try {
                int value = annotation.value();
                System.out.println("@Retention(RetentionPolicy.RUNTIME) " +
                        "@Target({ElementType.TYPE})  " +
                        "inject ===>" + value);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        parentInject();
    }
}
