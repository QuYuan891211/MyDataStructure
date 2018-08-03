package ArrayList;

public class TestArrayList {
    //直接插入排序
    public static void main(String[] arg){
        int[] testArray = {4,2,1,6,3,8,9,1};
        int length = testArray.length;
        for(int i=1;i<length;i++){
            int temp = testArray[i];
            int j;
            for(j = i-1; j >= 0 && temp <= testArray[j];j--){
                testArray[j+1] =testArray[j];
            }
            testArray[j+1] = temp;
        }
        for(int a:testArray){
            System.out.println(a);
        }

    }
}
