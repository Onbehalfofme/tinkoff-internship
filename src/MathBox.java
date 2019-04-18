import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class MathBox extends ObjectBox{
    private ArrayList<Number> array;


    public MathBox(Number[] array) {
        super(array);
        this.array = new ArrayList<Number>();
        for (int i = 0; i < array.length; i++) {
            this.array.add((Number) super.getArray().get(i));
        }
    }

   public Number summator() {
        Number sum = 0;

        for (int i = 0; i < array.size(); i++) {
            sum = new BigDecimal(sum.toString()).add(new BigDecimal(array.get(i).toString()));
        }
        return sum;
    }

    public void splitter(Number divisor) {
        for (int i = 0; i < array.size(); i++) {
            if (divisor.doubleValue() == 0) {
                throw new IllegalArgumentException();
            }
            array.set(i, new BigDecimal(array.get(i).toString()).divide(new BigDecimal(divisor.toString())));
        }
    }

    public void deleteNumber(Integer integer){
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) instanceof Integer && array.get(i).intValue() == integer){
                array.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < array.size(); i++) {
            result += array.get(i).toString() + " ";
        }
        return result.trim();
    }

    @Override
    public boolean equals(Object object) {
        MathBox arr = (MathBox) object;
        if (arr.array.size() != array.size()) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            if (!new BigDecimal(arr.array.get(i).toString()).equals(new BigDecimal(array.get(i).toString()))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < array.size(); i ++){
            hash += i*array.get(i).hashCode();
        }
        return hash;
    }

}
