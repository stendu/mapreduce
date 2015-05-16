import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.io.Text;

/**
 * Created by stendu on 2/3/2015.
 */
public class Test {
    private static Integer count;

    public static void setCount(Integer count) {
        System.out.println("Inside class, count = " + count);
        Test.count = count;
    }

    public Integer getCount()
    {
        return Test.count;
    }


    public static void main(String[] args)
    {
        Test counter = new Test();

        Integer i = counter.getCount();
        if (i == null) {
            i = 0;
            System.out.println("Start of counter, i = " + i);
        }
        System.out.println("Update of counter-1, i = " + i);

        counter.setCount(i + 1);
        i = counter.getCount();
        System.out.println("Update of counter-2, i = " + i);

        Integer j = counter.getCount();
        if (j == null) {
            j = 0;
            System.out.println("Start of counter, j = " + j);
        }
        System.out.println("Update of counter-3, j = " + j);
        j=j+1;
        counter.setCount(j);
        j = counter.getCount();
        System.out.println("Update of counter-4, j = " + j);
        Test counter2 = new Test();
        Integer f = counter2.getCount();
        System.out.println("Update of counter-4, f = " + f);
    }

}