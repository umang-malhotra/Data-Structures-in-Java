package Arrays;
import java.util.List;

public class ArrayListTrial {
    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<String>();

        list.add("Umang");
        list.add("Test");
        list.add("Kevin");
        list.add("Peters");
        list.add("Pochinki");

        list.remove(1);
        for(String s: list) {
            //System.out.println(s);
        }
        System.out.println(list.get(1));
        if(list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.println("List Not Empty");
        }

        Object[] arryaObj = list.toArray();
        for(Object s: arryaObj) {
            System.out.println(s);
        }

    }
}
