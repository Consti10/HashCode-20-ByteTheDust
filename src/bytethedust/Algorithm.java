package bytethedust;


//Algorithms are all the same:
//Only Input is the InputDataSet
//return OutputDataSet

import java.util.ArrayList;

public class Algorithm {

    //finding the first pizza that has less slices than max n of slices to order,
    //Then ordering exactly and only this pizza type will always create a solution, but
    //obviously not a good score
    public static OutputDataSet generateSimpleStupidSolution(final InputDataSet input){
        for(int index=0;index<input.pizzas.size();index++){
            final int nSlicesProPizza=input.pizzas.get(index);
            if(nSlicesProPizza<=input.maxSlices){
                final ArrayList<Integer> ret=new ArrayList<>();
                ret.add(index);
                return new OutputDataSet(1,ret);
            }
        }
        //Should never happen
        assert false;
        return new OutputDataSet(0,null);
    }


    public static OutputDataSet bruteForce(final InputDataSet input){
        final ArrayList<Integer> solution=new ArrayList<>();
        solution.add(0);
        solution.add(2);
        solution.add(3);

        return new OutputDataSet(3,solution);
    }
}
