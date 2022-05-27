import tester.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

class ProvidedStackTests_Sanity {
    void testPush(Tester t) {
        ArrayList<Integer> test_array = new ArrayList(Arrays.asList(1,3,3,8));
        Stack<Integer> q = new Stack(test_array, new IntCompare_Sanity());
        q.push(1);
    }

   void testPop(Tester t) {
        ArrayList<Integer> test_array = new ArrayList(Arrays.asList(1,3,3,8));
        Stack<Integer> q = new Stack(test_array, new IntCompare_Sanity());
        q.push(2);
        q.push(1);
        
        t.checkExpect(q.pop(), 1);
        t.checkExpect(q.pop(), 2);
    }

    void testFindDuplicate(Tester t) {
        ArrayList<Integer> test_array = new ArrayList(Arrays.asList(1,3,3,8));
        Stack<Integer> q = new Stack(test_array, new IntCompare_Sanity());
        q.push(1);

        t.checkExpect(q.findDuplicates(1),1);
        t.checkExpect(q.findDuplicates(8), 0);
    }
    
    void testRemoveDuplicates(Tester t) {
        ArrayList<Integer> test_array = new ArrayList(Arrays.asList(1,3,3,8));
        Stack<Integer> q = new Stack(test_array, new IntCompare_Sanity());
        q.push(3);
        q.push(1);
        

        t.checkExpect(q.removeDuplicates(3,3), true);
        t.checkExpect(q.removeDuplicates(8,0), false);
        t.checkException(new NoSuchElementException(), q, "removeElements", 9,1);
        //t.checkExpect(q.removeDuplicates(5,2), false);
    }

}

class IntCompare_Sanity implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}
