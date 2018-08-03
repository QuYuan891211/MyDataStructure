package ArrayList;

public class TestArrayList {
    //直接插入排序
    public void insertSort(int[] testArray){
        int length = testArray.length;
        for(int i=1;i<length;i++){
            int temp = testArray[i];
            int j;
            for(j = i-1; j >= 0 && temp <= testArray[j];j--){
                testArray[j+1] =testArray[j];
            }
            testArray[j+1] = temp;
        }
        print(testArray);
    }
    //冒泡排序
    public void bubbleSort(int[] test){
        int length = test.length;

        for(int i= length-1; i>0;i--){
            boolean flag = false;
            for(int j = 0; j<i;j++){
                if(test[j]>test[j+1]){
                    test = swap(test,j,j+1);
                    flag = true;
                }
            }
            if(!flag){break;}
        }
        print(test);
    }

    //交换数组中两个数的位置
    protected int[] swap(int[] test,int index1, int index2){
        int temp = test[index1];
        test[index1] = test[index2];
        test[index2] = temp;
        return test;
    }
    //打印方法
    protected void print(int[] test){
        for(int a:test){
            System.out.println(a);
        }
    }

    public static void main(String[] arg){
        int[] testArray = {4,2,1,6,3,8,9,1,43,62};
        TestArrayList testArrayList = new TestArrayList();
//        testArrayList.insertSort(testArray);
        System.out.println("排序结束");
        testArrayList.bubbleSort(testArray);


    }
}
