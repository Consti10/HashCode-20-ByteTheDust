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

    public void sort_books() {
        books = books.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
    }
    
    public void map( HashSet<Integer> x) {
        List<Integer> result = new ArrayList<>();
        List<Integer> newBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (x.contains(score.get(books.get(i)))) {
                continue;
            }
            newBooks.add(books.get(i));
            result.add(score.get(books.get(i)));
        }


        result = result.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < newBooks.size(); i = i + SHIPPED_BOOKS_PER_DAY) {
            List<Integer> list = new ArrayList<>();
            if (i + SHIPPED_BOOKS_PER_DAY > newBooks.size()) {
                for (int j = i; j < newBooks.size(); j++) {
                    System.out.println("resultSize: " + result.size() + ", index: " + j);
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

    public static void main(String[] args) {
        List<Integer> list = List.of(0, 1, 2, 3, 4);
        List<Integer> scores = List.of(1, 2, 3, 6, 5, 4);
        Library library = new Library();
        library.books = list;
        library.score = scores;
        library.SHIPPED_BOOKS_PER_DAY = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        library.map(set);
        System.out.println(library.score_per_book);

    }
}