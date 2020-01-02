package sort.merge;

public class MergeSort2 {

    public void mergeSort(int[] data, int startLen, int endLen) {

        if ( startLen < endLen ) {
            int midLen = (startLen + endLen) / 2;
            mergeSort(data, startLen, midLen);
            mergeSort(data, midLen + 1, endLen);
            merge(data, startLen, midLen, endLen);
        }
    }

    private int[] tmpData;
    private void merge(int[] data, int startLen, int midLen, int endLen) {

        tmpData = new int[endLen + 1];

        int i, j, k;
        i = startLen;
        j = midLen + 1;
        k = startLen;

        while ( i <= midLen && j <= endLen )
            tmpData[k++] = (data[i] < data[j]) ? data[i++] : data[j++];

        while ( i <= midLen )
            tmpData[k++] = data[i++];

        while ( j <= endLen )
            tmpData[k++] = data[j++];

        // 임시 데이터를 리스트에 담기
        for(int idx = startLen; idx <= endLen; idx++)
            data[idx] = tmpData[idx];

    }

}
