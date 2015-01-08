/***
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
import java.util.ArrayList;
public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayList<String> stk = new ArrayList<String>();
        String dir;
        int j;
        for (int i = 0; i < path.length(); i++) {
            j = path.indexOf('/', i);
            if (j == -1) {
                j = path.length();
                dir = path.substring(i, j);
            } else if( j == i) {
                dir = new String();
            } else 
                dir = path.substring(i, j);
            if (dir.length() != 0 && !dir.equals(".")) {
                System.out.printf("dir %s\n", dir);
                if (dir.equals("..")){
                    if (stk.size() > 0)
                        stk.remove(stk.size() - 1);
                } else 
                    stk.add(dir);
            }
            i = j;
        }
        if (stk.size() == 0)    
            return "/";
        StringBuffer sb = new StringBuffer();
        for (String s: stk) {
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main (String args[]) {
        SimplifyPath sp = new SimplifyPath();
        String s = sp.simplifyPath("/...");
        System.out.printf("Simplified path of /... is %s\n", s);
    }
}
