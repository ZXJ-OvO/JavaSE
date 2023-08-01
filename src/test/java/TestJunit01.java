import com.zxj.day23.ArrayList;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestJunit01 {

    @Test
    public void testJUnit() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.forEach(System.out::println);
    }

    @Test
    public void testReflectInetAddress() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> reClass = Class.forName("java.net.InetAddress");
        Method method = reClass.getDeclaredMethod("getLocalHost");
        Object invoke = method.invoke(reClass);
        System.out.println(invoke);
    }

    @Test
    public void testInetAddress() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String address = localHost.getHostAddress();
        System.out.println(address);
    }


}