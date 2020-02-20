package bytethedust;

import java.util.ArrayList;
import java.util.List;

public class TestScoreCalc {




    public static void main( String[] args ){

        int max_days = 5;

        Library a = new Library();
        Library b = new Library();
        Library c = new Library();

        a.books = List.of(1, 2);
        b.books = List.of(3, 4);
        c.books = List.of(5, 6);

        a.N_BOOKS = 2;
        b.N_BOOKS = 2;
        c.N_BOOKS = 2;

        a.score = List.of(1, 2, 3, 4, 5, 6);
        b.score = List.of(1, 2, 3, 4, 5, 6);
        c.score = List.of(1, 2, 3, 4, 5, 6);

        a.SIGNUP_TIME = 1;
        b.SIGNUP_TIME = 2;
        c.SIGNUP_TIME = 3;

        a.SHIPPED_BOOKS_PER_DAY = 1;
        b.SHIPPED_BOOKS_PER_DAY = 1;
        c.SHIPPED_BOOKS_PER_DAY = 1;

        List<Library> x = List.of(a, b, c);
        Algorithm alg = new Algorithm(x, 5);
        int score = alg.calculateScore(x);
        System.out.println(score);

    }





}
