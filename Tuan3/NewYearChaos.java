package Tuan3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

class Result3 {
    public static void minimumBribes(List<Integer> arr) {
        int n = arr.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) - i - 1 > 2) {
                ans = -1;
                break;
            } else {
                for (int j = Math.max(0, arr.get(i) - 3); j < i; j++) {
                    if (arr.get(j) > arr.get(i)) {
                        ans++;
                    }
                }
            }
        }
        if (ans == -1) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(ans);
        }
    }
}

    public class NewYearChaos {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    Result3.minimumBribes(q);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
        }
    }