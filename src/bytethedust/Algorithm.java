package bytethedust;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

//Algorithms are all the same:
//Only Input is the InputDataSet
//return OutputDataSet

public class Algorithm {

    public static HashSet<Integer> alreadyScanned = new HashSet<Integer>();
    private List<Library> libraries;
    private int N_DAYS_FOR_SCANNING;

    public Algorithm(List<Library> libraries, int N_DAYS_FOR_SCANNING) {
        this.libraries = libraries;
        this.N_DAYS_FOR_SCANNING = N_DAYS_FOR_SCANNING;
    }

    /*bekommt eine Liste von Libraries,
    arbeitet alle libraries sequenziell ab und berechnet den score.
    gibt einen int-Score zurück.
     */
    public int calculateScore(List<Library> ls, int maxTime){

        //der berechnete Score der Abfolge;
        int score = 0;
        //Gibt an, wie viel Zeit noch übrig ist
        int timeRemaining = maxTime;
        //Gibt an, wie lange der Verifizierungsvorgang noch dauert
        int daysOccupied = 0;
        List<Library> scanning = new ArrayList<>();

        //arbeite sequenziell alle Libraries ab
        for(int i =0; i< ls.size(); i++){

            //brich ab, wenn die Zeit abgelaufen ist.
            if (timeRemaining == 0){
                break;
            }

            //wenn die Anmeldung gerade frei ist, melde eine Library an
            if (daysOccupied == 0){
                //melde am nächsten Tag die nächste Lib an
                scanning.add(ls.get(i));
                i++;
            }

            //iteriere alle derzeit aktiven Librarys und "hole von jeder eine Lieferung"
            for (int x = 0; x < scanning.size(); x++) {
                Library lib = scanning.get(x);
                //ordne den Stack der Library so, wie wir ihn brauchen
                scanning.get(x).map(alreadyScanned);
                List<Integer> shipment = lib.score_per_book.pop();

                int temp_score = 0;
                //iteriere alle Bücher der letzten Lieferung
                for(int z = 0; z < shipment.size(); z++){
                    if ( !alreadyScanned.contains(shipment.get(z))){
                                temp_score = temp_score + shipment.get(z);
                                alreadyScanned.add(shipment.get(z));
                    }
                }
                //addiere die berechneten Scores der Lieferung zum gesamtScore
                score = score + temp_score;

                //wenn der Stack nach den oben genannten operationen leer ist, entferne die Library
                if (lib.score_per_book.isEmpty()){
                    scanning.remove(lib);
                    x--;
                }
            }

            timeRemaining--;
            daysOccupied--;
        }

        return score;
    }

    boolean sumOfSignupTimes_biggerThanDeadline(List<Library> list) {
        int a = 0;
        for (Library lib: list) {
            a += lib.SIGNUP_TIME;
        }
        return a > N_DAYS_FOR_SCANNING;
    }
}
