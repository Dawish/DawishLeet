package dawish.leet.Solution.baseModule;

public class Search {


    /**
     * @param key  9
     * @param array  int[] array ={1,2,3,4,6,7,8,9,10};
     *循环实现二分算法
     */
    public static int binSearch(int key, int[] array) {
        // 第一个下标
        int low = 0;
        // 最后一个下标
        int high = array.length - 1;
        int middle = 0;
        // 防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            //middle = (low + high) / 2;
            //middle = low + (high - low) / 2;
            middle = (low + high) >>> 1;

            if (key == array[middle]) {
                return middle;
            } else if (key > array[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

}
