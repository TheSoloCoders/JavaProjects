package org.example;

public enum Days {
    SUN, MON, TUE, WED, FRI, SAT;

    public static void PRINT(){
        Days [] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Days operatorType = var0[var2];
            System.out.println(operatorType);
        }

    }

}
