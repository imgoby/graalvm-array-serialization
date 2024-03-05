import sun.reflect.ReflectionFactory;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
public class HelloWorld {
     public static void main(String[] args) throws Exception{

        Class clazz= float[].class;
        Constructor c = java.lang.Object.class.getDeclaredConstructor((Class[]) null);
        c = ReflectionFactory.getReflectionFactory().newConstructorForSerialization(clazz, c);
         System.out.println("Hello, Native World!");
     }
 }
