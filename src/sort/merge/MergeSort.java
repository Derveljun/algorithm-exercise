package sort.merge;

import java.util.Arrays;

public class MergeSort {

    private int[] sorted;

    public MergeSort(int len){
        this.sorted = new int[len];
    }

    private void merge ( int[] arrData, int startLen, int midLen, int endLen ) {

        System.out.println(Arrays.toString(arrData));

        int i = startLen;
        int j = midLen + 1;
        int k = startLen;

        // 병합 정렬
        while ( i <= midLen && j <= endLen ) {
            sorted[k++] = (arrData[i] <= arrData[j])
                    ? arrData[i++] : arrData[j++];
        }

        // 남은 값 복사
        if ( i > midLen )
            for(int l = j; l <= endLen; l++)
                sorted[k++] = arrData[l];
        else
            for(int l = i; l <= midLen; l++)
                sorted[k++] = arrData[l];

        // 임시 데이터를 리스트에 담기
        for(int l = startLen; l <= endLen; l++)
            arrData[l] = sorted[l];
    }

    public void mergeSort (int[] arrSortTarget, int startLen, int endLen) {

        if( startLen < endLen ) {
            int midLen = (startLen + endLen) / 2;
            mergeSort(arrSortTarget, startLen, midLen);
            mergeSort(arrSortTarget, midLen + 1, endLen);
            merge(arrSortTarget, startLen, midLen, endLen);
        }
    }


}
