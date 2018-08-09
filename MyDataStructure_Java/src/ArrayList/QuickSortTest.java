package ArrayList;
//快速排序测试
public class QuickSortTest {
    private static int[] testArray = {50,10,90,30,70,40,80,60,20};

    public static void main(String[] args){
        QuickSortTest quickSortTest = new QuickSortTest();
        quickSortTest.sort(testArray,0,testArray.length-1);
    }

    public void sort(int[] testArray,int low,int high){
        int pivot;
        System.out.println("low: " + low);
        System.out.println("high: " + high);
        //int length = testArray.length;
        while(low<high){
            pivot = partition(testArray,low,high);
            System.out.println("pivot: " + pivot);

            print(testArray);
            sort(testArray,low,pivot-1);
            System.out.println("执行右侧------");
            low =pivot + 1;
        }
    }

    public int partition(int[] testArray,int low,int high){
        //优化性能
        testArray = chosePivotKey(testArray,low,high);
        int pivotKey = testArray[low];
        while (low<high){
            while (low<high && testArray[high]>= pivotKey){ high--;}
            swap(testArray,low,high);
            while (low<high && testArray[low] <= pivotKey){ low++; }
            swap(testArray,low,high);
        }
        return low;
    }

    //交换数组中两个元素的位置
    private int[] swap(int[] testArray,int index1,int index2){
        int temp = testArray[index1];
        testArray[index1]= testArray[index2];
        testArray[index2] = temp;
        return testArray;
    }

    //打印方法
    protected static void print(int[] test){
        for(int a:test){
            System.out.println(a);
        }
        System.out.println("---------------------------------------");
    }

    //性能改进：三数取中(median-of-three)法
    public int[] chosePivotKey(int[] testArray,int low,int high){
        int median = low + (high-low)/2;
        if(testArray[low]>testArray[high]){
            swap(testArray,low,high);
        }
        if(testArray[low]>testArray[median]){
            swap(testArray,low,median);
        }
        if(testArray[median]>testArray[high]){
            swap(testArray,median,high);
        }
        return testArray;
    }
}
