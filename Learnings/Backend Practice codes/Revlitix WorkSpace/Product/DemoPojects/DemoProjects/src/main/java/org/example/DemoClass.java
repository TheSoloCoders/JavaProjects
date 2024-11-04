package org.example;

import java.util.Objects;

public class DemoClass {

   int num ;
   String name;

   DemoClass(String name, Integer num){
       this.name=name;
       this.num = num;

   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemoClass demoClass)) return false;
        return Objects.equals(name, demoClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
