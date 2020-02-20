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
    Stack<List<Integer>> score_per_book = new Stack<>();

    public void map( HashSet<Integer> x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (x.contains(score.get(books.get(i)))) {
                continue;
            }
            result.add(score.get(books.get(i)));
        }


        result = result.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < books.size(); i = i + SHIPPED_BOOKS_PER_DAY) {
            List<Integer> list = new ArrayList<>();
            if (i + SHIPPED_BOOKS_PER_DAY > books.size()) {
                for (int j = i; j < books.size(); j++) {
                    list.add(result.get(j));
                }
                score_per_book.add(list);
                break;
            }
            for (int j = i; j < SHIPPED_BOOKS_PER_DAY + i; j++) {
                list.add(result.get(j));
            }
            score_per_book.push(list);
        }
    }
}
