package dawish.leet.Solution.baseModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHandle {

    /**
     * 字符串数组去重
     * @param strings
     * @return
     */
    public static Object[] unique(Object[] strings){
        List<Object> uniqueList = new ArrayList<Object>();

        for(Object s: strings){
            if(!uniqueList.contains(s)){
                uniqueList.add(s);
            }
        }
        return uniqueList.toArray();
    }

    /**
     * list 加 set去重
     * @param strings
     * @return
     */
    public static Object[] unique2(Object[] strings){
        List<Object> stringList = Arrays.asList(strings);
        Set<Object> stringSet = new HashSet<Object>();
        // set会自动去重
        stringSet.addAll(stringList);
        return stringSet.toArray();
    }

    /**
     * 两个数组去重合并成一个新的
     * @param strings1
     * @param strings2
     * @return
     */
    public static Object[] unique3(Object[] strings1, Object[] strings2){
        Set<Object> set = new HashSet<>();
        set.addAll(Arrays.asList(strings1));
        set.addAll(Arrays.asList(strings2));
        return set.toArray();
    }

    /**
     * Java数组中找出两个相加等于某个值的数据下标
     */
    public static int[] findIndex(int target, int[] array){
        int[] index = {0, 0};
        if(array == null || array.length < 2){
            return index;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int count = array.length;
        for(int i=0; i<count; i++){
            // 值为key， 坐标index为value
            hashMap.put(array[i], i);
        }

        for(int j=0; j<count; j++){
            // 计算当前数据与目标和的差值
            int gap = target - array[j];
            // 存在目标差值 且 找到的差值不是同一个数据
            if(hashMap.containsKey(gap) && target != 2*gap){
                index[0] = j;
                index[1] = hashMap.get(gap);
                break;
            }
        }
        return index;
    }


}
