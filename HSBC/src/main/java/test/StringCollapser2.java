package test;

public class StringCollapser2 {
    public static String collapseString(String s) {
        // 递归基本情况：如果字符串为空或长度小于3，则直接返回
        if (s.length() < 3) {
            return s;
        }

        // 创建一个新的字符串以存储处理后的结果
        StringBuilder sb = new StringBuilder();

        // 用于记录上一个字符及其出现次数
        char prevChar = s.charAt(0);
        int count = 1;

        // 遍历字符串
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                count++; // 增加计数器
            } else {
                // 将之前的字符按规则替换后加入到StringBuilder
                appendReplacedChars(sb, prevChar, count);
                prevChar = currentChar;
                count = 1; // 重置计数器
            }
        }

        // 处理最后一个字符或连续字符序列
        appendReplacedChars(sb, prevChar, count);

        // 获取处理后的字符串
        String result = sb.toString();

        // 如果新字符串与原字符串相同，则递归终止
        if (result.equals(s)) {
            return result;
        }

        // 递归调用自身处理新字符串
        return collapseString(result);
    }

    private static void appendReplacedChars(StringBuilder sb, char ch, int count) {
        if (count < 3) {
            // 如果连续字符的数量少于3个，则直接加入
            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        } else {
            // 如果连续字符的数量等于3，则用前一个字符替换两次
            if (count == 3) {
                if (ch == 'a') {
                    // 特殊处理'a'的情况，用空字符串替换
                } else {
                    sb.append((char)(ch - 1));
                    sb.append((char)(ch - 1));
                }
            } else {
                // 如果连续字符的数量大于3，则用前两个字符替换
                if (ch == 'a') {
                    // 特殊处理'a'的情况，用空字符串替换
                } else {
                    sb.append((char)(ch - 1));
                    sb.append((char)(ch - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        String input = "aabcccbbad";
        System.out.println(collapseString(input)); // 输出应为 "bbbccc"
    }
}
