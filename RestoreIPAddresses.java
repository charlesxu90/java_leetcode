/***
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
    // Solution: O(n^4) O(n)
    // DFS
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuffer ip = new StringBuffer();
        dfs(s, 0, 0, ip, ret);
        return ret;
    }

    private void dfs(String s, int start, int step, StringBuffer ip, List<String> ret) {
        if (start == s.length() && step == 4) {
            StringBuffer sb = new StringBuffer(ip.toString());
            sb.setLength(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }
        System.out.printf("start %d, step %d\n", start, step);
        if (s.length() - start > (4 - step) * 3)
            return;
        if (s.length() - start < (4 - step))
            return;
        System.out.printf("start %d, step %d\n", start, step);

        int num = 0;
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            System.out.printf("ip %s, i %d\n", ip.toString(), i);
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= 255) {
                ip.append(s.charAt(i));
                ip.append('.');
                dfs(s, i + 1, step + 1, ip, ret);
                ip.setLength(ip.length() - 1);
            }
            if (num == 0) break; // Allow single 0, but do not allow prefix 0.
        }
    }

    public static void main (String args[]) {
        RestoreIPAddresses rsip = new RestoreIPAddresses();
        List<String> result = rsip.restoreIpAddresses("010010");

        for (int i = 0; i < result.size(); i++)
            System.out.printf("%s\n", result.get(i));
    }
}
