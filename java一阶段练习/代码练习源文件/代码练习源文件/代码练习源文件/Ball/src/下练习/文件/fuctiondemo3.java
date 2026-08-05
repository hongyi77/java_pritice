package 下练习.文件;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class fuctiondemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"雷伊","盖亚","卡修斯","布莱克","米瑞斯");
       /* list.stream().filter(s->s.startsWith("雷")).filter(s -> s.length()==2).forEach(s-> System.out.println(s));*/
     /* list.stream().filter(new Predicate<String>() {
          @Override
          public boolean test(String s) {
              return s.startsWith("雷") &&s.length()==2;
          }
      }).forEach(s -> System.out.println(s));*/
        f3 f3 = new f3();
   list.stream().filter(new fuctiondemo3()::Stringjuge).forEach(s -> System.out.println(s));



    }
    public boolean Stringjuge(String s){
        return s.startsWith("卡") && s.length() == 3;
    }
}
