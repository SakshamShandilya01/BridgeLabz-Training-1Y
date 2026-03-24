package com.access.two;

import com.access.one.Base;

public class Derived extends Base {

    public void testAccess() {

        publicMethod();
        protectedMethod();
    }

    public static void main(String[] args) {

        Derived d = new Derived();
        d.testAccess();
    }
}
