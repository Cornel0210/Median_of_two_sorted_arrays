package check;

public class Solution {

    public static void main(String[] args) {
        /*int[] n = {0,0};
        int[] m = {0,0};*/

        /*int[] n = {1,2};
        int[] m = {3,4};*/

        /*int[] n = {1,3};
        int[] m = {2};*/

        /*int[] n = {1,3};
        int[] m = {2,7};*/

        int[] n = {2};
        int[] m = {};
        System.out.println(findMedianSortedArrays(n,m));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] third = new int[nums1.length+ nums2.length];
        int position = 0;
        int index1 = 0;
        int index2 = 0;

        while (position < third.length && index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] < nums2[index2]){
                third[position++] = nums1[index1++];
            } else {
                third[position++] = nums2[index2++];
            }
        }

        System.arraycopy(nums1, index1, third, position, nums1.length-index1);
        System.arraycopy(nums2, index2, third, position, nums2.length-index2);

        if (third.length == 1){
            return third[0];
        }

        if (third.length % 2 == 0){
            int first = third[third.length/2];
            int second = third[third.length/2-1];
            return (double)(first+second)/2;

        } else {
            return third[third.length/2];
        }

    }
}
