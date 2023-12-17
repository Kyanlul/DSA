package Tuan3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> result = new ArrayList<Integer>();
        int min = 1000000000;
        for (int i = 1; i < (int) arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) < min) {
                min = arr.get(i) - arr.get(i - 1);
            }
        }

        for (int i = 1; i < (int) arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) == min) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }

        return result;

    }
}
public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}