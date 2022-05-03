package com.haibin.jvm;

import com.haibin.jvm.enchanceclass.Base;
import javassist.*;

import java.io.IOException;

public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.haibin.jvm.enchanceclass.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("../jvm");
        Base h = (Base)c.newInstance();
        h.process();
    }
}
