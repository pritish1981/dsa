package binarysearch;
/*
Given that there are N books and M students. Also given are the number of pages in each book in ascending order.
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum,
with the condition that every student is assigned to read some consecutive books. Print that minimum number of pages.

Examples:

Input: N = 4, pages[] = {12, 34, 67, 90}, M = 2
Output: 113
Explanation: There are 2 students. Books can be distributed in following combinations:


{12} and {34, 67, 90} -> Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
{12, 34} and {67, 90} -> Max number of pages is allocated to student 2 with 67 + 90 = 157
{12, 34, 67} and {90} -> Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
The third combination has the minimum pages assigned to a student = 113.

 */
public class AllocateMinNumberOfPages {
//Utility method to check if the current minimum value is possible or not
    static boolean isPossible(int[] arr, int n, int m, int curr_min) {
        int studentsRequired = 1;
        int curr_sum = 0;
        //Iterate over all books
        for (int i = 0; i < n; i++) {
           curr_sum += arr[i];
              //if current number of pages are greater than curr_min then
            if(curr_sum > curr_min) {
                studentsRequired++; //increment student count
                //if students required becomes greater than given number of students, return false
                if(studentsRequired > m) {
                    return false;
                }
                curr_sum = arr[i];//update curr_sum
            }
        }
        return true;
    }

    //Method to find minimum number of pages
    static int findPages(int[] arr, int n, int m) {
        long sum = 0;
        // return -1 if no. of books is less than no. of students
        if (n < m) {
            return -1;
        }
        // Count total number of pages
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int start = 0, end = (int) sum, result = Integer.MAX_VALUE;
        //Binary search to find minimum number of pages
        while (start <= end) {
            int mid = (start + end) / 2;
            //If it is possible to assign books to students in mid pages
            if (isPossible(arr, n, m, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = { 12, 34, 67,90 }; // Number of pages in books
        int m = 2; // No. of students
        System.out.println("Minimum number of pages = " + findPages(arr, arr.length, m));
    }
}
