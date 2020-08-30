package algorithms.before20200830;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;


public class Test {


    public void insert(String word) {
        TrieNode cur = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
    }


    private Test() {

    }


    /**
     * 指定ip和端口是否可达
     *
     * @param ip
     * @param port
     * @return
     */
    public boolean isSurvive(String ip, String port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, Integer.parseInt(port)), 100);
        } catch (SocketTimeoutException s) {
            s.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    Map<Integer, Long> hasN = new HashMap();


    long f(int n) {
        if (n == 1) return 1L;
        if (n == 2) return 2L;
        if (hasN.containsKey(n)) return hasN.get(n);
        long num = f(n - 1) + f(n - 2);
        hasN.put(n, num);
        return num;
    }

    /**
     * t
     *
     * @description:
     * @param: [args]
     * @return: void
     * @author: twt
     * @Date: 2020/03/12
     */
    public static void main(String[] args) {



        int[][] arr = new int[2][2];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[1][0]=3;
        arr[1][1]=4;
        System.out.println(Arrays.toString(arr));


        double a = 2 * 3 - 5 / 9 + 5;
        System.out.println(a);

        //System.out.println('9' + 0);

        /*Test test = new Test();
        long start = System.currentTimeMillis();
        System.out.println(test.f(99));
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/


        // Test test = new Test();
        //test.insert("teat");



       /* ArrayList<Student> list = new ArrayList<>();
        Student student = new Student();
        for (int i = 0; i < 10; i++) {
            student.setName("zhangsan"+i);
            list.add(student);
        }

        System.out.println(list.size());
        System.out.println(list);*/

        ArrayList<Student> students = new ArrayList<>();

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
    }
}

class Student {

    private String name;


    public String getName() {
        return name;
    }


    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
