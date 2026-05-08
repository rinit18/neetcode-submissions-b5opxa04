class Solution {
    public int[] sortArray(int[] nums) {

        mergesort(nums, 0, nums.length-1);
        return nums;

    }

    public void mergesort(int [] arr, int left, int right){
        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid+1, right);
        merge(arr, left, mid, right);

    }

    public void merge(int [] arr, int left, int mid, int right){
        int [] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        for(int p = 0; p < temp.length; p++){
            arr[left + p] = temp[p];
        }
    }
}