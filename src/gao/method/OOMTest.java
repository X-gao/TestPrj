package gao.method;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * <b>测试</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/2 23:42
 */
public class OOMTest extends ClassLoader {
    private OOMTest tets;
    public static void main(String[] args) {
        OOMTest test = new OOMTest();
        int j = 0;
        try {
            for (int i=0;i<10000;i++){
                //用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名 包名。父类 ，接口
                classWriter.visit(Opcodes.V1_6,Opcodes.ACC_PUBLIC,"class"+i,null,"java/lang/Object",null);
                byte[] bytes = classWriter.toByteArray();
                test.defineClass("class"+i,bytes,0,bytes.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }

    }
}
