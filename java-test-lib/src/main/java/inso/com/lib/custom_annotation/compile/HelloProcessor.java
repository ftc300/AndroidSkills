package inso.com.lib.custom_annotation.compile;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

/**
 * Comment:
 * Author: ftc300
 * Date: 2018/9/4
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public class HelloProcessor extends AbstractProcessor {

   //计数器, 用于计算 process() 方法运行了几次
    private int count = 1;

    // 用于写文件
    private Filer filer;
    private Types typeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.typeUtils = processingEnv.getTypeUtils();
        this.filer = processingEnv.getFiler();
    }

    /**
     * 源码级别
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    /**
     * 处理的注解类型
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Hello.class.getCanonicalName());
        return types;
    }

    // 处理编译时注解的方法
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("start process, count = " + count++);
        // 获得所有类
        Set<? extends Element> rootElements = roundEnv.getRootElements();
        System.out.println("all class:");
        // 输出类型
        for (Element rootElement : rootElements) {
            System.out.println("root：  " + rootElement.getSimpleName());
        }

        // 获得有注解的元素, 这里 Hello 只能修饰类, 所以只有类
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Hello.class);
        System.out.println("annotated class:");
        for (Element element : elementsAnnotatedWith) {
            TypeMirror elementType = element.asType();
            String name = typeUtils.erasure(elementType).toString();
            System.out.println("bf：  " + name);
            //
            String className = element.getSimpleName().toString();
            System.out.println("  " + className);

            String output = element.getAnnotation(Hello.class).name();
            // 产生的动态类的名字
            String newClassName = className + "_New";
            // 写 java 文件
            createFile(newClassName, output);
        }
        return true;
    }

    private void createFile(String className, String output) {
        StringBuilder cls = new StringBuilder();
        cls.append("package apt;\n\npublic class ")
                .append(className)
                .append(" {\n  public static void main(String[] args) {\n")
                .append("    System.out.println(\"")
                .append(output)
                .append("\");\n  }\n}");
        try {
            JavaFileObject sourceFile = filer.createSourceFile("apt." + className);
            Writer writer = sourceFile.openWriter();
            writer.write(cls.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
