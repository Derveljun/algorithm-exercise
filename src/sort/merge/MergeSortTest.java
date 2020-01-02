package sort.merge;

import java.util.Arrays;

public class MergeSortTest {

    public void TestCase1(){
        int[] targetData = new int[] { 10, 3, 4, 9, 6, 5, 7, 1};

        new MergeSort2().mergeSort(targetData, 0, targetData.length - 1);

        System.out.println(Arrays.toString(targetData));
    }

    public void TestCase2() {

    }

    public static void main(String[] args) {

    }

}
