package com.company;

import java.util.Objects;
import java.util.function.*;

public class Main {

    public static  void testOnLesson(){
        // write your code here
        Action action = new Action() {
            @Override
            public void act(String s) {
                System.out.println(s);
            }
        };
        Action lambda = s -> System.out.println(s);
        Action lambda1 = (String s) -> System.out.println(s);
        Action lambda2 = s -> {
            System.out.println(s);
            System.out.println(s + "/b");
        };
        Sum sum = (a, b) -> a + b;
        System.out.println(sum.sum(12,23));
        // Math
        Action act = x -> System.out.println(x);
        Action act1 = System.out::println;
        act1.act("quarty");
        // setter
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("12");

        Consumer<String> consumer1 = s -> System.out.println(1+" "+s);
        Consumer<String> consumer2 = s -> System.out.println(2+" "+s);
        Consumer<String> consumer3 = s -> System.out.println(3+" "+s);

        Consumer<String> consumer0 = consumer1.andThen(consumer2).andThen(consumer3);
        consumer0.accept("пипец");
        // geter
        Supplier<Integer> sint =() -> (int)(Math.random()+5);
        System.out.println(sint.get());
        IntSupplier intSupplier=() -> (int)(Math.random()+5);
        System.out.println(intSupplier.getAsInt());
        // check
        Predicate<String> predicate1 = Objects::nonNull;
        Predicate<String> predicate2 = s -> s.length() > 0;
        Predicate<String> predicate3 = s -> s.matches("^[A-Za-z]+$");
        Predicate<String> predicate = predicate1.and(predicate2).and(predicate3).negate();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("z"));
        System.out.println(predicate.test("z1"));
        System.out.println(predicate.test("zz"));
        //
        UnaryOperator<Float> uf = f -> (float)Math.round(f);
        System.out.println(uf.apply(3.5f));
        UnaryOperator<String> identity = UnaryOperator.identity();
        System.out.println(identity.apply("qwerty"));
        // converter
        Function<String, Integer> function = s -> Integer.parseInt(s);
        int n = function.apply("123");
        System.out.println(n);
        Function<Integer, Double> function1 = Integer::doubleValue;
        System.out.println(function.andThen(function1).apply("2456"));

        Function<Integer, String> f3 = String::valueOf;
        Integer compose = function.compose(f3).apply(12345);
        System.out.println(compose);
        //
        BinaryOperator<String> b = (a1, a2) -> a1 + a2;
        System.out.println(b.apply("a", "b"));
        BinaryOperator<String> minBy =
                BinaryOperator.minBy((o1, o2) -> o1.length() <= o2.length() ? -1 : 1);
        System.out.println(minBy.apply("qwerty","qwe"));
        BinaryOperator<String> maxBy =
                BinaryOperator.maxBy((o1, o2) -> o1.length() <= o2.length() ? -1 : 1);
        System.out.println(maxBy.apply("qwerty","qwe"));
    }


    public static void main(String[] args) {
	    Fraction f1 = new Fraction(2,5);
        Fraction f2 = new Fraction(3,7);
//        f1.setFlag.accept(20);
        System.out.println("f1 = " + f1.toString.get()); // распечатать дробь
        System.out.println("fraction " + f1 + " has flag = " + f1.getFlag.getAsInt()); //получить числитель дроби



        // 2/5 div 3/7 = (2*7)/(5*3) = 14/15
        Fraction resultDiv1 = f1.div.apply(f2); //   f1/f2
        System.out.println(f1 + "  /  " + f2 + " = " + resultDiv1.toString.get()); //    14/15
        Fraction resultDiv2 = Fraction.divStatic.apply(f1, f2);
        System.out.println(f1 + "  /  " + f2 + " = " + resultDiv2.toString.get()); //    14/15


        // 2/5 mul 3/7 = (2*3)/(5*7) = 6/35
        Fraction resultMul1 = f1.mul.apply(f2); //   f1*f2
        System.out.println(f1 + " * " + f2 + " = " + resultMul1.toString.get()); //   "6/35"
        Fraction resultMul2 = Fraction.mulStatic.apply(f1, f2); // f1*f2
        System.out.println(f1 + " * " + f2 + " = " + resultMul2.toString.get()); //    "6/35"





        // Equals
        Fraction f3 = new Fraction(2,9);
        Fraction f4 = new Fraction(20,90);
//        Fraction f5 = f4;
//        System.out.println(f3);
//        System.out.println(f4);
//        System.out.println(f3 == f4); // false
//        System.out.println(f5 == f4); // true
        System.out.println(f3 + " = " + f4 + " => " +  f3.equals.test(f4)); // true

        // преобразование строки в дробь. "5/8" = Fraction(5,8)
        Fraction result = Fraction.parse.apply("5/8");
        System.out.println(result.toString.get() + " = " + result.convertToDouble.get());


        Fraction f5 = new Fraction(3,5);
        Fraction f6 = new Fraction(3,10);
        System.out.println(f5 + " > " + f6 + " = " + f5.biggerThan.test(f6));
        System.out.println(f5 + " > " + f6 + " = " + Fraction.biggerThanStatic.test(f5, f6));


    }
}
