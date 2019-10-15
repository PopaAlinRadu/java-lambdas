package ro.nila.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ProjectExample {

    static Function<List<String>, List<String>> function = strings -> {
        List<String> returnList = new ArrayList<>();
        strings.forEach(s->{
            returnList.add(s.toUpperCase());
        });
        return returnList;
    };

    public static void main(String[] args) {

        List<String> test = new ArrayList<>(Arrays.asList("alin", "test", "popa"));
        List<String> upperCaseList = function.apply(test);
        System.out.println(upperCaseList);
    }
}
