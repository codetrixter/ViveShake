import java.util.*;
/* 

Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses and takes only a string S as its only argument.
Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.


For string 11211 the IP address possible are 
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1

Example 1:

Input:
S = 1111
Output: 1.1.1.1
Example 2:

Input:
S = 55
Output: -1

Your Task:

Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses or -1 if no such IP address could be generated through the input string S, the only argument to the function.

Expected Time Complexity: O(N * N * N * N)
Expected Auxiliary Space: O(N * N * N * N)

Constraints:
1<=N<=16
here, N = length of S.
S only contains digits(i.e. 0-9)

 */

public class GenerateIpAddresses {

    public static void main(String[] args) {
        String str = "11211";
        for (String s : new GenerateIpAddresses().genIp(str)) {
            System.out.println(s);
        }
        System.out.println();

        for (String s : new GenerateIpAddresses().genIp("1111")) {
            System.out.println(s);
        }
        System.out.println();

        for (String s : new GenerateIpAddresses().genIp("55")) {
            System.out.println(s);
        }
    }

    public ArrayList<String> genIp(String s) {

        ArrayList<String> list = new ArrayList<>();
        findIp("", "", s, list, 0);
        return list;
    }

    private boolean isValid(String s) {
        int num = Integer.parseInt(s);
        return num >= 0 && num < 256;
    }

    private boolean isZeroPrefix(String s1) {
        return s1.length() > 1 && String.valueOf(Integer.parseInt(s1)).length() != s1.length();
    }

    private void findIp(String ip, String s1, String s, ArrayList<String> list, int count) {

        if (isZeroPrefix(s1))
            return;

        if (count >= 1 && count < 4 && isValid(s1)) {
            ip = ip + s1 + ".";
        } else if (count == 4 && isValid(s1) && s.length() == 0) {
            ip = ip + s1;
            list.add(ip);
        } else if (count != 0) {
            return;
        }

        if (s.length() >= 1) {
            findIp(ip, s.substring(0, 1), s.substring(1, s.length()), list, count + 1);
        } else {
            return;
        }

        if (s.length() >= 2) {
            findIp(ip, s.substring(0, 2), s.substring(2, s.length()), list, count + 1);
        } else {
            return;
        }

        if (s.length() >= 3) {
            findIp(ip, s.substring(0, 3), s.substring(3, s.length()), list, count + 1);
        } else {
            return;
        }
    }
}
