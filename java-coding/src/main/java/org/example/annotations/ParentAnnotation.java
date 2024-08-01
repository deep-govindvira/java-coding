package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the parent annotation with additional variables
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ParentAnnotation {
    MyCustomAnnotation[] value(); // Array of nested annotations
    String author() default "Unknown"; // Additional variable
    int revision() default 1; // Additional variable
}

