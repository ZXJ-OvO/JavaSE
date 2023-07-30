import com.zxj.day23.ArrayList;
import org.junit.Test;

public class TestJunit01 {

    @Test
    public void testJUnit() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.forEach(System.out::println);
    }
}
