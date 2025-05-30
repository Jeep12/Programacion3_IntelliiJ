package Tema_5.Varios.GPT3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(2, 5, 6, 7, 1,3,4);


        Integer objetivo = 7;
        Back b = new Back(conjunto);

        System.out.println(b.resolver(objetivo));
    }
}
