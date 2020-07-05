package dawish.leet.Solution.baseModule;

/**
 * 手写算法检查
 */
public class CheckHand {

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

    // 快速排序 时间复杂度O(nlogn)
    public static int[] quickSort(int[] array, int left, int right){
        if(left > right){
            return array;
        }
        int i = left;
        int j = right;
        // 左边为基准值
        int base = array[left];
        // i和j没有指向同一个元素就继续交换
        while(i != j){
            while(base <= array[j] && i < j){
                j--;
            }
            while(base >= array[i] && i < j){
                i++;
            }
            // 两边找完了说明找到i和j需要交换的值了
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // 到这一步说明一次递归完成，i和j指向了同一个位置，
        // 把base值与此位置交换
        array[left] = array[i];
        array[i] = base;

        // 对左边排序
        quickSort(array, left, i-1);
        // 对右边排序
        quickSort(array, i+1, right);
        return array;

    }


}
