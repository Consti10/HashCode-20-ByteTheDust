package bytethedust;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    int N_BOOKS;
    int SIGNUP_TIME;
    int SHIPPED_BOOKS_PER_DAY;
    List<Integer> books = new ArrayList<>();
    List<Integer> score = new ArrayList<>();
    Stack<Integer> score_per_book = new Stack<>();

    void map() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            result.add(score.get(books.get(i)));
        }
        result = result.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            score_per_book.push(result.get(i));
        }
    }

}
