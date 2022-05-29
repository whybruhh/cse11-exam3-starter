import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

// Task 1.0 Make Stack generic
// Edit the following class declaration

class Stack<E> {
  List<E> contents;
  Comparator<E> comp;

  // Task 1.0: Set up Fields
  public Stack(List<E> contents, Comparator<E> comp) {
    this.contents = contents;
    this.comp = comp;
  }

  // Task 1.1: push() method
  public void push(E element) {
    this.contents.add(0, element);
  }

  // Task 1.2: pop() method
  public E pop() {
    this.contents.remove(0);
    E removed = (E) contents.get(0);
    return removed;
  }

  // Task 1.3: findElements() method
  public int findElements(E element) {
    int total = 0;
    for (E ele : contents) {
      if (ele.equals(element)) {
        total += 1;
      }
    }
    if (!contents.contains(element) || contents.size() <= 1) {
      return 0;
    }
    return total;
  }

  // Task 1.4: removeElements() method
  public boolean removeElements(E element, int number) {
    if (!contents.contains(element)) {
      throw new NoSuchElementException();
    }
    if (number <= contents.size()) {
      for (int i = 0; i < number;) {
        contents.remove(0);
        i++;
        break;
      }
    }
    contents.clear();
    return false;
    /**
     * if (contents.size() < number) {
      contents.clear();
      return false;
    }
     */
  }
}
