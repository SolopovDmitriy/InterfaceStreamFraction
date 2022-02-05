package com.company;

import java.util.Objects;
import java.util.function.*;

public class Fraction {
    private int flag;   // числитель
    private int dig;    // знаменатель

    public Fraction() { // конструктор по умолчанию, конструктор без параметров
    }



    public Fraction(int flag, int dig) { // конструктор с двумя параметрами, создание дроби
        this.flag = flag;
        this.dig = dig;
    }


    // ==============================================================================
    //    Supplier<Integer>, IntSuplier – геттеры
    public final IntSupplier getFlag = () -> flag;

//    public int getFlag() {
//        return flag;
//    }




    // ==============================================================================
    // Consumer<Integer>, IntConsumer – сеттеры
    public final Consumer<Integer> setFlag = flag -> this.flag = flag;

//    public void setFlag(int flag) {
//        this.flag = flag;
//    }

//    public final Consumer<Integer> setFlag = flag -> {
//        this.flag = flag;
//    };

    // ==============================================================================
    public final IntSupplier getDig = () -> dig;

    public int getDig() {
        return dig;
    }
// ==============================================================================

    public final Consumer<Integer> setDig = dig -> this.dig = dig;

    public void setDig(int dig) {
        this.dig = dig;
    }
    // ==============================================================================

    // Supplier<String> – преобразование дроби в строку "1/2"
    public final Supplier<String> toString = () ->  flag +  "/" + dig;   //     "2/5"

    @Override
    public String toString() {
        return flag +  "/" + dig;
    }

    // ==============================================================================
    // UnaryOperator<Fraction> – умножение этой дроби на другую
    public final UnaryOperator<Fraction> mul = f2 -> new Fraction(f2.flag * flag, f2.dig * dig);

    public Fraction mul_(Fraction f2){
        return new Fraction(this.flag * f2.flag, f2.dig * dig); // f1 == this
    }

    // ==============================================================================
    // UnaryOperator<Fraction> – деление этой дроби на другую
    public final UnaryOperator<Fraction> div = f2 -> new Fraction(flag * f2.dig, dig *  f2.flag);
    // f1.div(f2) //    f1 == this                                       2  *   7   ,      5  *    3
    // 2/5 div 3/7 = (2*7)/(5*3) = 14/15

// ==============================================================================


    // 2/5 mul 3/7 = (2*3)/(5*7) = 6/35
    public final static BinaryOperator<Fraction> mulStatic = (f1, f2) ->
            new Fraction(f1.flag * f2.flag, f1.dig * f2.dig);


    public static Fraction mulStatic2(Fraction f1, Fraction f2){
        return new Fraction(f1.flag * f2.flag, f1.dig * f2.dig);
    }



    // ==============================================================================
    // 2/5 div 3/7 = 2/5 mul 7/3  = (2*7)/(5*3)
    public final static BinaryOperator<Fraction> divStatic = (f1, f2) ->
            new Fraction(f1.flag * f2.dig, f1.dig * f2.flag);


    public static Fraction divStatic2(Fraction f1, Fraction f2){
        return new Fraction(f1.flag * f2.dig, f1.dig * f2.flag);
    }

    // ==============================================================================
    // лябда для конвертации обычной дроби в десятичную 2/5 = 0.4
    // Supplier<Double> – преобразование дроби в десятичную 1/2 –> 0.5
    public final Supplier<Double> convertToDouble = () -> (double)flag / dig;

    public Double convertToDouble2(){
        return (double)flag / dig;
    }


    // ==============================================================================
    // преобразование строки в дробь. "2/5" = new Fraction(2,5)
    public final static Function<String, Fraction> parse = s -> {
        String[] parts = s.split("/");
        int flag = Integer.parseInt(parts[0]);
        int dig = Integer.parseInt(parts[1]);
        return new Fraction(flag, dig);
    };

    public Fraction parse2(String s){   //  s = "2/5"
        String[] parts = s.split("/");  //  parts = String[]{"2", "5"}
        int flag = Integer.parseInt(parts[0]); // parts[0] = "2"; int flag = 2
        int dig = Integer.parseInt(parts[1]);
        return new Fraction(flag, dig); //  return new Fraction(2, 5);
    }



    // ==============================================================================


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Fraction fraction = (Fraction) o;
//        return flag == fraction.flag && dig == fraction.dig;
//    }

    public final Predicate<Object> equals = o -> {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
//        return flag == fraction.flag && dig == fraction.dig;   //    2/5  == 20/50 false
        return flag * fraction.dig == dig * fraction.flag  ;   //    2/5  == 20/50 true
    };

    // public final Predicate<Fraction> equals = f2 -> flag == f2.flag && dig == f2.dig;

// ======================================================================================

    // Predicate<Fraction> – сравнение этой дроби с другой
    // 2/3 > 4/5 = false
    // 2*5 > 4*3 = false
    public final Predicate<Fraction> biggerThan  = f2 -> flag * f2.dig > dig * f2.flag;

    // ==================================================================================

    // BiPredicate<Fraction, Fraction> – сравнение двух дробей
    public final static BiPredicate<Fraction, Fraction> biggerThanStatic = (f1, f2) -> f1.flag * f2.dig > f1.dig * f2.flag;


}
