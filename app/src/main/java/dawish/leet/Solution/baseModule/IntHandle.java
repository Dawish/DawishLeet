package dawish.leet.Solution.baseModule;

public class IntHandle {

    /**
     * 十进制数对应二进制数 1 的个数
     * @param num
     * @return
     */
    public static int getOneCount(int num){
        int count = 0;
        while(num != 0){
            if((num&1) == 1){
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }

}
