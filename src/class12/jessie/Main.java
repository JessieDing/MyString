package class12.jessie;


public class Main {

    /**
     * indexOf         求字符、字符串出现的第一个位置
     * equals          字符串内容比较
     * ==                字符串对象地址比较
     * subString     求子字符串
     * charAt         返回指定位置的字符
     * startWith     判断字符串是否以某个字符串开头
     * StringBuilder
     * StringBuffer
     */

    public static void main(String args[]) {

        char[] myStr1Data = new char[]{'1', '2', 'a', 'b', 'c', '4', '5', '6'};
        char[] myStr2Data = new char[]{'2', 'a'};
        MyString myStr1 = new MyString(myStr1Data);
        MyString myStr2 = new MyString(myStr2Data);

        //查找字符b出现的第一个位置
        System.out.println(myStr1.indexOf('b'));

        //查找MyString myStr2出现的第一个位置
        System.out.println(myStr1.indexOf(myStr2));

        //取2~4位置的子字符串
        MyString subString = myStr1.subString(2, 6);
        System.out.println(subString);

        //oldString数组不是原字符数组的子数组，直接返回原字符数组
//        char[] oldData = new char[]{'1', '2', 'a', 'b', '4'};
        char[] oldData = new char[]{'b', 'c'};
        char[] newData = new char[]{'x', 'y', 'z'};
        MyString oldString = new MyString(oldData);
        MyString newString = new MyString(newData);
        System.out.println("原数组：");
        System.out.println(myStr1);
//        myStr1.replace1(oldString, newString);
        System.out.println("替换后：");
        System.out.println(myStr1.replace1(oldString, newString));


//        String str = "123abcz";
//
//        System.out.println(str.replace("123", "abcd"));
//        System.out.println(str.indexOf('w'));
//        System.out.println(str.replace("123abcze", "123abcz"));

        //StringBuffer
//        StringBuffer sBuffer = new StringBuffer("qwertyui1254");
//        sBuffer.setCharAt(3,'M');
//        System.out.println(sBuffer);
//        sBuffer.deleteCharAt(8);
//        System.out.println(sBuffer);


        //StringBuilder
//        StringBuilder strBuilder = new StringBuilder("123");
//        StringBuilder temp1 = strBuilder;
//        strBuilder.append("xyz");
//        StringBuilder temp2 = strBuilder;
//        System.out.println(temp1 == temp2);
//
//
//        strBuilder.insert(0, "efg");
//        System.out.println(strBuilder);
//        strBuilder.delete(1, 3);
//        System.out.println(strBuilder);
//        strBuilder.reverse();
//        System.out.println(strBuilder);
//        strBuilder.append("abc").append("opq").append(852);
//        System.out.println(strBuilder);


        //求字符、字符串出现的第一个位置
//        int position1 = str.indexOf('a');
//        int position2 = str.indexOf("123");
//        System.out.println(position1);
//        System.out.println(position2);

        //字符串内容比较、字符串对象地址比较
//        String a = new String("123");
//        String b = new String("123");
//        System.out.println(a.equals(b));
//        System.out.println(a == b);

        //求子字符串
//        String str1 = new String("  111zzz 234 abd o0");
//        String subStr1 = str1.substring(3, 6);
//        System.out.println(subStr1);

        //返回指定位置的字符
//        String str2 = new String("2587abc34");
//        System.out.println(str2.charAt(4));

        //判断字符串是否以某个字符串开头
//        String accountNo = "6222024402123547896";
//        if (accountNo.startsWith("622202")) {
//            System.out.println("是本行卡号");
//        } else {
//            System.out.println("不是本行卡号");
//        }

        //其他类型转换为字符串 .valueOf()
//        double pi = 3.1415926;
//        String strPi = String.valueOf(pi);
//        System.out.println(strPi);
//
//        int i = 54321;
//        System.out.println(String.valueOf(i));
//
//        boolean g = false;
//        System.out.println(String.valueOf(g));
//
//        char[] arr = new char[]{'a', 'v', 'y', '2'};
//        System.out.println(String.valueOf(arr));
    }
}

