import java.util.ArrayList;
import java.util.Arrays;

public class ObjectBox {
    private ArrayList<Object> array;

    public ObjectBox(Object[] array){
        this.array = new ArrayList<Object>(Arrays.asList(array));
    }

    public void addObject(Object object){
        array.add(object);
    }

    public void deleteObject(Object object){
        if (array.contains(object)){
            array.remove(object);
        }
    }
}
