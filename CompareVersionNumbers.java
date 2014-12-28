/***
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 */

public class CompareVersionNumbers {
// solution 1
    public int compareVersion(String version1, String version2) {
//        System.out.printf("version1: %s, version2: %s \n", version1, version2);
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
//        System.out.printf("type of v1: %s \n", v1.getClass().getName());

        int ver1, ver2;
        int v1l = v1.length;
        int v2l = v2.length;
        int maxl = Math.max(v1l, v2l);
//        System.out.printf("v1l : %d, v2l : %d\n", v1l, v2l);
//        System.out.printf("v1 : %s, v2: %s \n", v1[0], v2[0]);
        if (v1l == 0) ver1 = Integer.parseInt(version1);
        if (v2l == 0) ver2 = Integer.parseInt(version2);

        for (int i = 0; i < maxl; i++) {
            ver1 = 0;
            if (i < v1l) 
                ver1 = Integer.parseInt(v1[i]);
            ver2 = 0;
            if (i < v2l)
                ver2 = Integer.parseInt(v2[i]);
            if (ver1 < ver2)
                return -1;
            if(ver1 > ver2)
                return 1;
        }
        return 0;
    }
// solution 2
/*    public int compareVersion(String version1, String version2) {
        long a = 0, b =0;
        int v1len = version1.length(), v2len = version2.length();
        int i = 0, j = 0;
        while (i < v1len || j < v2len) {
            a = 0; b =0;
            while (i < v1len && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i) - '0';
                ++i;
            }
            ++i;
            while (j < v2len && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j) - '0';
                ++j;
            } 
            ++j;
            if (a > b) return 1;
            if (a < b) return -1;
        }
        return 0;
    }
*/
    public static void main (String args[]) {

        String v1 = "1.0";
        String v2 = "1.1";

        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.printf("Compare 1.0 and 1.1 : %d", cvn.compareVersion(v1, v2));

    }

}
