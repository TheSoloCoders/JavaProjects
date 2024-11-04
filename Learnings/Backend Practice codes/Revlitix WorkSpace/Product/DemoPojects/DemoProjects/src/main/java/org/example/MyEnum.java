package org.example;

public enum MyEnum {

    ONE(Days.SUN, "Sunday"),
    TWO(Days.MON, "Monday");
//    THREE(days), FOUR(days), FIVE(days), SIX(days), SEVEN(days);

    public final Days days;
    public final String name;

    MyEnum(Days days, String name) {
        this.days = days;
        this.name = name;
    }


//    MyEnum(final Days days, String name) {
//        this.days = days;
//        this.name = name;
//    }

//    MyEnum(){
//    }

}
