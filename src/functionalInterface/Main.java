package functionalInterface;

public class Main {
    public static void main(String[] args) {

        Func1 sqrt1 = x -> Math.sqrt(x); // input -> output (return)
//        System.out.println(sqrt1.calculate(9));
//        System.out.println(sqrt1(9)); // 3

        FuncString replace1 = s->s.replace(" ", "");


        FuncString replace2 = new FuncString() {
            @Override
            public String change(String s) {
                return s.replace(" ", "");
            }
        };

        System.out.println(deleteSpaces("hello world ok good "));
        System.out.println(replace1.change("hello world ok good "));
        System.out.println(replace2.change("hello world ok good "));

    }

    static double sqrt1(double x){ // x = 9
        return Math.sqrt(x); // return 3
    }

    static String deleteSpaces(String s){
        return s.replace(" ", "");
    }


}
