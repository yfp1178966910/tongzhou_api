package com.combanc.cas.client.springboot;

import com.combanc.cas.client.springboot.utils.Commons;
import org.junit.Test;

public class CommonsTest {
    @Test
    public void testEncryption() {
        String org = "912133283";

        String encryption1 = Commons.encryption(org);
        String encryption2 = Commons.encryption(encryption1 + org);

        System.out.println(encryption2);
    }
}
