package test;


public class StringCollapser {
    public static String collapseString(String s) {
        // 递归基本情况：如果字符串为空或长度小于3，则直接返回
        if (s.length() < 3) {
            return s;
        }

        // 创建一个StringBuilder用于构建新的字符串
        StringBuilder sb = new StringBuilder();

        // 遍历字符串，检查是否有三个或更多的连续重复字符
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // 当遇到不同的字符时，将之前的字符加入StringBuilder
                addChars(sb, s, i - count, count);
                count = 1; // 重置计数器
            }
        }

        // 处理最后一个字符或连续字符序列
        addChars(sb, s, s.length() - count, count);

        // 如果新字符串与原字符串相同，则递归终止
        String result = sb.toString();
        if (result.equals(s)) {
            return result;
        }

        // 递归调用自身处理新字符串
        return collapseString(result);
    }

    private static void addChars(StringBuilder sb, String s, int start, int length) {
        if (length < 3) {
            // 如果连续字符的数量少于3个，则加入到StringBuilder中
            for (int j = start; j < start + length; j++) {
                sb.append(s.charAt(j));
            }
        }
    }

    public static void main(String[] args) {
        String input = "aabcccbbad";
        System.out.println(collapseString(input));
    }
}
