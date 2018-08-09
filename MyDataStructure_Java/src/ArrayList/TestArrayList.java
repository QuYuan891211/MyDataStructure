package ArrayList;

public class TestArrayList {
    //简单选择排序
    public void selectionSort(int[] testArray){
        int length = testArray.length;
        for(int i = 0; i<length-1;i++){
            int minData = testArray[i];
            int minIndex = i;
            for(int j = i+1;j<length;j++){
                if(testArray[i] > testArray[j]){
                    minData = testArray[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){swap(testArray,i,minIndex);}


        }
        print(testArray);
    }
    //直接插入排序
    public void insertSort(int[] testArray){
        int length = testArray.length;
        for(int i = 1; i<length;i++){
            for(int j=i;j>0 && testArray[j]>testArray[j-1];j++){
                swap(testArray,j,j-1);
            }
        }
        print(testArray);
    }
    //冒泡排序
    public void bubbleSort(int[] test){
        int length = test.length;

        for(int i= 0; i<length;i++){
            boolean flag = false;
            for(int j = length-1; j>i;j--){
                if(test[j]<test[j-1]){
                    test = swap(test,j,j-1);
                    flag = true;
                }
            }
            if(!flag){break;}
        }
        print(test);
    }

    //shell sort
    public void shellSort(int[] testArray){
        int length = testArray.length;
        int increasement = length/3+1;
        while (increasement>=1){
            int i = 0;
            for(int j = i+increasement;j<length;j++){
                if(testArray[i] > testArray [j]){
                    swap(testArray,i,j);
                }
                i++;
            }
            increasement = increasement/2;
        }

    print(testArray);


    }
    //交换数组中两个数的位置
    protected int[] swap(int[] test,int index1, int index2){
        int temp = test[index1];
        test[index1] = test[index2];
        test[index2] = temp;
        return test;
    }
    //打印方法
    protected static void print(int[] test){
        for(int a:test){
            System.out.println(a);
        }
    }

    public static void main(String[] arg){
        int[] testArray = {4,2,1,6,3,8,9,1,43,62};
        TestArrayList testArrayList = new TestArrayList();
//        testArrayList.insertSort(testArray);

        //testArrayList.bubbleSort(testArray);
        //testArrayList.selectionSort(testArray);
        //testArrayList.shellSort(testArray);
        testArrayList.mergeSort(testArray);
    }
    // 归并排序
    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        System.out.println("对左边数组进行递归");
        System.out.println("参数： "+left + " "+ center + " " + right);
        sort(data, left, center);
        System.out.println("对右边数组进行递归");
        System.out.println("参数： "+left + " "+ center + " " + right);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
        print(data);
        System.out.println("----------------");
        System.out.println(left + " "+ center + " " + right);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }



}
