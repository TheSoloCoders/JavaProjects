package org.example;

public enum Month {

    JAN("01"),
    FAB ("aman"),
    MAR ("03"),
    APR("04");

    public static Month getByValue(String value) {
        for (Month month : Month.values()) {
            if (month.name().equals(value)) {
                return month;
            }
        }
        System.out.println("Nhi mila bhai");
        return null;
    }

    public final String value;

    Month(String value) {
        this.value = value;
    }

}
