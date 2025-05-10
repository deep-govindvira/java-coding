package org.example;

import org.junit.jupiter.api.Test;

public class StringVsStringBuilder {

    @Test
    public void testWithStringBuffer() {
        StringBuffer s3 = new StringBuffer("value1");
        String s2 = "value2";
        for (int i = 0; i < 100000; i++) {
            s3.append(s2);
        }
        System.out.println(s3);
    }

    @Test
    public void testWithString() {
        String s3 = new String("value1");
        String s2 = new String("value1");
        for (int i = 0; i < 100000; i++) {
            s3 = s3 + s2;
        }
        System.out.println(s3);
    }
}
