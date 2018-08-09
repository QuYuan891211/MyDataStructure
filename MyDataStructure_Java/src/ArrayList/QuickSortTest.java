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
        if(low<high){
            pivot = partition(testArray,low,high);
            System.out.println("pivot: " + pivot);

            print(testArray);
            sort(testArray,low,pivot-1);
            System.out.println("执行右边:-------- " );
            sort(testArray,pivot+1,high);
        }
    }

    public int partition(int[] testArray,int low,int high){
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

}
