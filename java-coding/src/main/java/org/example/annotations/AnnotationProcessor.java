package org.example.annotations;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("Method " + method.getName() + " has annotation with description: " + annotation.description());
            }
        }

        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}

@ParentAnnotation(
    value = {
        @MyCustomAnnotation(description = "First annotation"),
        @MyCustomAnnotation(description = "Second annotation")
    },
    author = "Jane Doe",
    revision = 2
)

class MyClass {
    @MyCustomAnnotation(description = "This is a custom annotation")
    public void myMethod() {
        System.out.println("Implemented : ");
    }
}
