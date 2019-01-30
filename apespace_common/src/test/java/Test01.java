import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
    *@ClassName Test01
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 15:41
    *@Version 1.0
**/
public class Test01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
    }
}
