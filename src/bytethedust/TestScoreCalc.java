package bytethedust;

import java.util.ArrayList;
import java.util.List;

public class TestScoreCalc {




    public static void main( String[] args ){

        int max_days = 5;

        Library a = new Library();
        Library b = new Library();

        a.score = List.of(1, 2, 3, 6, 5, 4);
        b.score = List.of(1, 2, 3, 6, 5, 4);


        a.books = List.of(0, 1, 2, 3, 4);
        b.books = List.of(0, 2, 3, 5);

        a.N_BOOKS = 2;
        b.N_BOOKS = 2;


        a.SIGNUP_TIME = 1;
        b.SIGNUP_TIME = 2;

        a.SHIPPED_BOOKS_PER_DAY = 1;
        b.SHIPPED_BOOKS_PER_DAY = 1;

        List<Library> x = List.of(a, b);
        Algorithm alg = new Algorithm(x, 5);
        int score = alg.calculateScore(x);
        System.out.println(score);

    }





}
