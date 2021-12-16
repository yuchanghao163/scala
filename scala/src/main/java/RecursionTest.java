import org.junit.Test;

import java.util.ArrayList;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(reMethod(3));
        System.out.println(reMethod1(3));
        System.out.println(String.class);

        int [] ints= {1,2};
        int [] int1= new int[]{1,2};
        int[] ints1 = new int[2];

    }

    public static int reMethod(int a){
        if(a==1){
            return 1;
        }else {
            return a* reMethod (a-1);
        }

    }

    /*第一个人10岁，第2个比第1个人大2岁，以此类推，请用递归方式计算出第8个人多大？*/
    public static int reMethod1(int a){

        if(a==1){
            return 10;
        }else {
           return reMethod1(a-1)+2;
        }
    }



    @Test
    public void test1(){
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add("sd");
        System.out.println(list1.get(1));
    }

    }


