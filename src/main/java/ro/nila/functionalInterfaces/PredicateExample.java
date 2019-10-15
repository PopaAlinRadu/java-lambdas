package ro.nila.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> checkDivisionByTwo = i -> i % 2 == 0;
    static Predicate<Integer> checkDivisionByFive = i -> i % 5 == 0;

    static void predicateAnd(int number){
        System.out.println(checkDivisionByFive.and(checkDivisionByTwo).test(number));
    }

    static void predicateOr(int number){
        System.out.println(checkDivisionByFive.or(checkDivisionByTwo).test(number));
    }

    static void predicateNegate(int number){
        System.out.println(checkDivisionByFive.or(checkDivisionByTwo).negate().test(number));
    }

    public static void main(String[] args) {

        predicateAnd(7);
        predicateOr(8);
        predicateNegate(8);

    }
}
