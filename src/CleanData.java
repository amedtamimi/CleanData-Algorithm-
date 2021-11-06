import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CleanData {
    public static void main(String[] args) throws Exception {
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        Reader.init(System.in);
        System.out.println("Please Enter the size of list");
        int n = Reader.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> sp = new ArrayList<>();
        System.out.println("Please Enter the data in list");
        for (int i = 0; i <n ; i++) {
            arr.add(Reader.nextInt());
        }
        if(n%2==0){
            System.out.println("How many split you want?");
            for ( int i=2; i <n ; i++) {
                if(n%i==0){
                    sp.add(i);
                }
            }
            System.out.println(sp);
            int spl = Reader.nextInt();
            ArrayList<Integer>[] d = (ArrayList<Integer>[]) new ArrayList[spl];
            for (int i = 0; i <spl ; i++) {
                d[i] = new ArrayList<>();
            }
            int counter = 0;
            for (int i = 0; i <spl ; i++) {
                for ( int j =0; j <n/spl ; j++) {
                    d[i].add(arr.get(counter));
                    counter++;
                }
            }
            System.out.println(Arrays.toString(d));
            System.out.println("Chose the method");
            System.out.println("1-Mean \n2-Median \nChose 1 oR 2");
            int algo = Reader.nextInt();
            switch (algo){
                case 1: {
                    for (int i = 0; i <spl ; i++) {
                        int val = mean(d[i]);
                        for ( int j =0; j <n/spl ; j++) {
                            d[i].set(j,val);
                        }
                    }
                    System.out.println(Arrays.toString(d));
                }break;
                case 2:{

                    for (int i = 0; i <spl ; i++) {
                        int val = median(d[i]);
                        for ( int j =0; j <n/spl ; j++) {
                            d[i].set(j,val);
                        }
                    }
                    System.out.println(Arrays.toString(d));
                }break;
                default:
                    System.out.println("Error in Enter Data");
            }
            List<Integer>result = new ArrayList<>();
            int counter1 = 0;
            for (int i = 0; i <spl ; i++) {
                for ( int j =0; j <n/spl ; j++) {
                    result.add(d[i].get(j));
                }
            }
            System.out.println("The Final result");
            System.out.println(result);
        }

    }
    static int median(List<Integer>arr){
        int avg =0;
        int sum =0;
        for (int i = 0; i <arr.size() ; i++) {
            sum+=arr.get(i);
        }
        avg = sum/arr.size();
        return avg;
    }
    static int mean(List<Integer>arr){
        int first = 0;
        int second = 0;
        int mean = 0;
        if(arr.size()%2==0){
            first = arr.get(arr.size()/2);
            second = arr.get((arr.size()/2)-1);
            mean = (first+second)/2;
        }
        else{
            first = arr.get(arr.size()/2);
            mean = first;
        }
        return mean;
    }
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
