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

    void map() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            result.add(score.get(books.get(i)));
        }
        result = result.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < books.size(); i=i+SHIPPED_BOOKS_PER_DAY) {
            List<Integer> list = new ArrayList<>();
            if(i+SHIPPED_BOOKS_PER_DAY > books.size()) {
                for (int j = i; j < books.size(); j++) {
                    list.add(result.get(j));
                }
                score_per_book.add(list);
                break;
            }
            for (int j = i; j < SHIPPED_BOOKS_PER_DAY+i; j++) {
                list.add(result.get(j));
            }
            score_per_book.push(list);
        }
    }

    public static void main(String[] args) {
        List<Integer> books = List.of(1, 2, 3, 4, 0, 6, 7, 8);
        List<Integer> scores = List.of(7, 2, 1, 3, 4, 34, 9, 5, 0, 14, 9);
        Library library = new Library();
        library.score = scores;
        library.books = books;
        library.SHIPPED_BOOKS_PER_DAY = 2;
        library.map();
        System.out.println(library.score_per_book);
    }
}
