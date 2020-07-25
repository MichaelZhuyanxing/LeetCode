import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args){
        List<List<Integer>> result = new LinkedList<>();
        //result.add(new LinkedList<>(Arrays.asList(1, 2, 3, 6)));
        //result.add(new LinkedList<>(Arrays.asList(2, 3, 4)));
        //result.add(new LinkedList<>(Arrays.asList(3, 6)));
        //result.add(new LinkedList<>(Arrays.asList(4, 5)));
        result.add(new LinkedList<>(Arrays.asList(1)));
        result.add(new LinkedList<>(Arrays.asList(4, 5)));
        int n = result.size();
        answer an = new answer();
        int min = an.minimumTotal(result);
        List<Integer> L1 = result.get(0);
        //System.out.println("output is: "+ n +"\n"+
        //                   "the first one is: "+ L1);
        System.out.println("the min is: "+min);

    }
}
