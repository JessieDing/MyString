package class12.jessie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class MyString {
    private char[] data;

    MyString() {
        data = new char[1024];
    }

    MyString(char[] arr) {
        data = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
    }

    //    查找某个字符第一次出现的位置
    public int indexOf(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;//没查找到
    }

    //    查找某个字符串第一次出现的位置
    public int indexOf(MyString str) {
        for (int i = 0; i < data.length; i++) {
            char[] strArr = str.getData();
            if (data[i] == strArr[0]) {
                return i;
            }
        }
        return -1;//没查找到
    }

    //取子字符串
    public MyString subString(int start, int end) {
        if (start >= end) {
            return null;
        }

        int length = end - start;
        char[] newString = new char[length];
        int j = 0;
        for (int i = start; i < start + length; i++) {
            newString[j] = data[i];
            j++;
        }
        return new MyString(newString);
    }

    //字符串替换
    public MyString replace(MyString oldString, MyString newString) {
        int len = this.getData().length;
        int oldPosition = 0;
        char[] temp = this.data;
        char[] newArr = newString.getData();


//        oldString.length() <= len
        if (isSubset(this.data, oldString.getData())) {
            for (int i = 0; i < len; i++) {
                if (data[i] == oldString.getData()[0]) {
                    oldPosition = i;
                    break;
                }
            }
            System.arraycopy(newArr, 0, temp, oldPosition, newArr.length);
//            int copylens = oldPosition + newArr.length;
//            while(i < newArr.length) {
//                while (oldPosition < copylens) {
//                    temp[oldPosition] = newArr[i];
//                    oldPosition++;
//                }
//                i++;
//            }
            return new MyString(temp);


        } else {
            //oldString数组不是原字符数组的子数组，直接返回原字符数组
            return this;
        }
    }


    public MyString replace1(MyString oldString, MyString newString) {
        int startIndex = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldString.data[0] && data.length - i >= oldString.length()) {
                int count = 0;
                for (int j = 0; j < oldString.length(); j++) {
                    if (data[i + j] == oldString.data[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == oldString.length()) {
                    startIndex = i;
                    break;
                }
            }
        }
        if (startIndex > -1) {
            char[] newData = new char[newString.length() - oldString.length() + data.length];
            System.arraycopy(data, 0, newData, 0, startIndex);
            System.arraycopy(newString.data, 0, newData, startIndex, newString.length());
            System.arraycopy(data, startIndex + oldString.length(), newData, startIndex + newString.length(), data.length - startIndex - oldString.length());
            return new MyString(newData);
        } else {
            return this;
        }
    }

    public MyString replace2(MyString oldString, MyString newString) {

        List<Integer> startIndexes = new ArrayList<>();
        for (int
             i = 0; i < data.length;
             i++) {
            if (data[i] == oldString.data[0]
                    && data.length - i >= oldString.length()) {

                int count = 0;

                for (int j = 0; j <
                        oldString.length(); j++) {

                    if (data[i + j] == oldString.data[j]) {

                        count++;
                    } else {
                        break;

                    }
                }
                if (count == oldString.length()) {

                    startIndexes.add(i);
                    //break;

                }
            }
        }

        if (startIndexes.size() > 0) {
            int count = startIndexes.size();
            int
                    offset = newString.length() - oldString.length();

            char[] newData = new char[offset
                    * count + data.length];

            char[] tempData = data;
            for (int i = 0; i < startIndexes.size(); i++) {
                int index = startIndexes.get(i) + i * offset;
                System.arraycopy(tempData, 0, newData, 0, index);
                System.arraycopy(newString.data, 0, newData, index, newString.length());

                if (index + oldString.length() + 1 < tempData.length) {

                    //index = startIndexes.get(i) + (i +1)*offset;

                    System.arraycopy(data, startIndexes.get(i) + oldString.length(), newData, index + newString.length(), data.length - startIndexes.get(i) -
                            oldString.length());
                }
                tempData =
                        newData;
            }
            return new MyString(newData);

        }
        return
                this;
    }


    public int length() {
        return getData().length;
    }

    public boolean isSubset(char[] originCharArr, char[] changableArr) {
        char[] tmp = new char[changableArr.length];
        for (int i = 0; i < originCharArr.length; i++) {
            if (changableArr[0] == originCharArr[i] && (originCharArr.length - i) >= changableArr.length) {
                System.arraycopy(originCharArr, i, tmp, 0, changableArr.length);
                break;
            }
        }
        boolean flag = true;
        for (int j = 0; j < changableArr.length; j++) {
            if (changableArr[j] != tmp[j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);

    }
}
