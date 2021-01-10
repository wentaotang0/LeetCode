package algorithms.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author twt
 * @description 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * <p>
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * <p>
 * 示例 1:
 * 输入:
 * ["9001 discuss.leetcode.com"]
 * 输出:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * 说明:
 * 例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 * 示例 2
 * 输入:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 说明:
 * 按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
 * 而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
 * 注意事项：
 * <p>
 *  cpdomains 的长度小于 100。
 * 每个域名的长度小于100。
 * 每个域名地址包含一个或两个"."符号。
 * 输入中任意一个域名的访问次数都小于10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/01/08
 */
public class SubdomainVisits {


    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < cpdomains.length; i++) {
            String[] str = cpdomains[i].split(" ");
            int num = Integer.parseInt(str[0]);
            addDN(str[1], num, map);

            String[] subDN = str[1].split("\\.");
            for (int j = 1; j < subDN.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < subDN.length; k++) {
                    if (k == subDN.length - 1) {
                        sb.append(subDN[k]);
                        break;
                    }
                    sb.append(subDN[j]).append(".");
                }
                addDN(sb.toString(), num, map);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }

        return ans;

    }


    /**
     * 添加域名/子域名
     *
     * @param dn  域名/子域名
     * @param num 访问次数
     * @param map
     */
    private void addDN(String dn, int num, Map<String, Integer> map) {
        if (map.containsKey(dn)) {
            map.put(dn, map.get(dn) + num);
        } else {
            map.put(dn, num);
        }
    }


    public static void main(String[] args) {
        String[] arr = {"9001 discuss.leetcode.com"};
        System.out.println(new SubdomainVisits().subdomainVisits(arr));
    }


}
