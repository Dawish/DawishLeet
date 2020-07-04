package dawish.leet.Solution.baseModule;

public class Sort {

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public int[] insertSort(int[] arr){

        int outer, inner;
        // 第一个作为本来就有的数据，第二个作为插入的数据
        for (outer = 1; outer < arr.length; outer++){
            // current sort value
            int temp = arr[outer];
            inner = outer;
            // //前面的大就想后面移动
            while (inner > 0 && arr[inner - 1] >= temp) {
                arr[inner] = arr[inner - 1];
                --inner;
            }
            arr[inner] = temp;

        }
        return arr;
    }


    /**
     * 冒泡排序
     * int score[] = { 5,3,8,6,2,7 };
     * @param score
     */
    public int[] bubbleSort(int[] score){
        // 最多做n-1趟排序
        for (int i = 0; i < score.length - 1; i++) {
            // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
            for (int j = 0; j < score.length - i - 1; j++) {
                // 把大的值交换到后面
                if (score[j] > score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }
        return score;
    }


    /**
     * 快速排序
     * 时间复杂度:
     * 　　O(nlogn)
     *
     * 快速排序原理:
     * 1. 定义一个基准元素base(我这里定义的是最左面的元素定位基准元素)
     * 2. 定义两个变量i和j
     * 3. j先从右向左遍历,找到第一个比base小的数就停止
     * 4. i再从左向右便利找到第一个比base大的数停止
     * 5. 交换i和j指向的元素
     * 6. 直到i和j指向同一个元素,将这个元素与基准元素交换
     * 7. 递归求解即可
     * @return
     */
    public static int[] quickSort(int[] arr, int left, int right) {

        //数组最左边小于最右边不合法,直接退出
        if (left > right) {
            return arr;
        }

        //定义变量i指向最左边
        int i = left;

        //定义变量j指向最右边
        int j = right;

        //定义左边为基准元素base
        int base = arr[left];

        //只要i和j没有指向同一个元素,就继续交换
        while (i != j) {

            //从右向左寻找第一个小于基准元素的数
            while (arr[j] >= base && i < j) {
                j--;
            }

            //从左向右寻找第一个大于基准元素的数
            while (arr[i] <= base && i < j) {
                i++;
            }

            //执行到这里证明找到了i和j指向的元素
            //交换i和j指向的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //将i和j共同指向的元素与基准元素交换
        arr[left] = arr[i];
        arr[i] = base;

        //对左边进行快速排序
        quickSort(arr, left, i - 1);

        //对右边进行快速排序
        quickSort(arr, i + 1, right);

        return arr;
    }

}
