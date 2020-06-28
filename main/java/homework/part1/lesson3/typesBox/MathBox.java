package homework.part1.lesson3.typesBox;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Сlass operating with collection data
 *
 * @author Nail
 * */
public class MathBox<T extends Number> extends ObjectBox<T> {

    public MathBox(T[] number) {
        super(number, new HashSet<>());
    }

    //Finding the sum of the items in the collection
    public double summator() {
        double sum = 0.0;
        Set<T> collect = (Set<T>) getCollection();
        for (T element: collect) {
            sum+= element.doubleValue();
        }
        return sum;
    }

    //Dividing all the elements stored in the object by a divider
    public void splitter(int divider) {
        Set<Double> elems = getCollection().stream()
                .map(x -> x.doubleValue() / divider)
                .collect(Collectors.toSet());

        getCollection().clear();
        for (Double element: elems) {
            addObject((T)element);
        }

    }
}
