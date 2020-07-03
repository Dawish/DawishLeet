package dawish.leet.Solution.baseModule;

/**
 * 手写算法检查
 */
public class HandCheck {

    // 冒泡排序
    // 时间复杂度log(n^2)
    public static int[] bubbleSort(int[] array){
        if(array == null){
            return array;
        }
        int length = array.length;

        for(int i=0; i<length-1; i++){
            for(int j=0; j<length-i-1; j++){
                // 大的交换到后面去
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[i] = temp;
                }
            }
        }
        return array;
    }




    // 二分查找
    // 时间负责的 log(2n)
    public static int search(int key, int[] array){

        if(array == null){
            return -1;
        }

        int low = 0;
        int middle;
        int high = array.length - 1;
        // 防止越界
        if(key < array[low] || key > array[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high ) >>> 1;
            if(key == array[middle]){
                return middle;
            }else if(key > array[middle]){
                low = middle + 1;
            }else{
                high = middle -1;
            }
        }
        return -1;
    }


}
