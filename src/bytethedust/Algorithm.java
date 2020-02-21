package bytethedust;
import java.util.*;

//Algorithms are all the same:
//Only Input is the InputDataSet
//return OutputDataSet

public class Algorithm {

    public static HashSet<Integer> alreadyScanned = new HashSet<Integer>();
    private List<Library> libraries;
    private int N_DAYS_FOR_SCANNING;
    public int maxTime;

    public Algorithm(List<Library> libraries, int N_DAYS_FOR_SCANNING) {
        this.libraries = libraries;
        this.maxTime = N_DAYS_FOR_SCANNING;
    }

    /*bekommt eine Liste von Libraries,
    arbeitet alle libraries sequenziell ab und berechnet den score.
    gibt einen int-Score zurück.
     */
    public int calculateScore(List<Library> ls){

        System.out.println("Alg aufgerufen mit #lib: " + ls.size() );

        //der berechnete Score der Abfolge;
        int score = 0;
        //Gibt an, wie viel Zeit noch übrig ist
        int timeRemaining = maxTime;
        //Gibt an, wie lange der Verifizierungsvorgang noch dauert
        int daysOccupied = 0;
        List<Library> scanning = new ArrayList<>();

        //arbeite sequenziell alle Libraries ab
        for(Library library: ls){
            System.out.println("Time remaining: " + timeRemaining);

            //brich ab, wenn die Zeit abgelaufen ist.
            if (timeRemaining == 0){
                break;
            }

            //wenn die Anmeldung gerade frei ist, melde eine Library an
            if (daysOccupied == 0){
                //melde am nächsten Tag die nächste Lib an
                scanning.add(library);
                daysOccupied = library.SIGNUP_TIME;
            }

            //iteriere alle derzeit aktiven Librarys und "hole von jeder eine Lieferung an Büchern"
            for (Library aktiv: scanning) {
                System.out.println("Score computed: " + score);


                //bestimme, die günstigste nächste Bücherlieferung
                aktiv.map(alreadyScanned);
                List<Integer> shipment = Collections.emptyList();
                if(!(aktiv.score_per_book.isEmpty())) {
                    shipment = aktiv.score_per_book.pop();
                }

                int temp_score = 0;
                //iteriere alle Bücher der aktuellen letzten Lieferung
                for(int lieferungBuch: shipment){
                    if ( !alreadyScanned.contains(lieferungBuch)){
                                temp_score = temp_score + lieferungBuch;
                                alreadyScanned.add(lieferungBuch);
                    }
                }
                //addiere die berechneten Scores der Lieferung zum gesamtScore
                score = score + temp_score;
            }
            System.out.println("Loop verlassen, Zeit dekrementiert");
            timeRemaining--;
            daysOccupied--;
        }
        System.out.println("Score computed: " + score);
        return score;
    }

    public List<Library> mapping(List<Integer> list) {
        List<Library> libraries2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
//            libraries.get(list.get(i)).ID = list.get(i);
            libraries2.add(libraries.get(list.get(i)));
        }

        return libraries2;
    }

    public boolean sumOfSignupTimes_biggerThanDeadline(List<Library> list) {
        int a = 0;
        for (Library lib: list) {
            a += lib.SIGNUP_TIME;
        }
        return a > N_DAYS_FOR_SCANNING;
    }

    public List<Schedule> generateSchedulers(List<Integer> ints) {
        List<Schedule> schedules = new ArrayList<>();
        for (int i = 0; i < ints.size(); i++) {
            Library lib = libraries.get(ints.get(i));
            Schedule schedule = new Schedule();
            schedule.N_BOOKS_FOR_SCANNING = lib.N_BOOKS;
            schedule.sendBooks = lib.books;
            schedule.id = ints.get(i);

            schedules.add(schedule);
        }

        return schedules;
    }
}
