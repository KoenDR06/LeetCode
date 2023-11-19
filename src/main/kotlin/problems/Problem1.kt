package problems

import java.lang.Exception

class Problem1 {
    fun twoSum(nums: IntArray, target: Int) : IntArray {
        val arr = sortArray(nums)

        for(index1 in arr.indices) {
            val index2 = binarySearch(arr, target - arr[index1])
            if(index2 != null) {
                return intArrayOf(index1, index2.toInt())
            }
        }

        throw Exception("Leetcode was wrong")
    }

    private fun binarySearch(arr: IntArray, target: Int, left : Int = 0, right: Int = arr.size - 1) : Int? {
        val pivot = (left + right) / 2


        if(arr[pivot] == target) {
            return pivot
        }
        else if(arr[pivot] < target) {
            return binarySearch(arr, target, pivot + 1, right)
        }
        else if(arr[pivot] > target) {
            return binarySearch(arr, target, left, pivot - 1)
        }
        return null
    }

    private fun sortArray(arr: IntArray) : IntArray {
        if (arr.size > 1) {
            val pivot = mutableListOf(arr[(Math.random() * arr.size).toInt()], arr[(Math.random() * arr.size).toInt()], arr[(Math.random() * arr.size).toInt()]).sorted()[1]
            val lower = mutableListOf<Int>()
            val higher = mutableListOf<Int>()
            for(item in arr) {
                if (item < pivot) {
                    lower.add(item)
                }
                else if (item > pivot) {
                    higher.add(item)
                }
            }

            return (sortArray(lower.toIntArray()) + intArrayOf(pivot) + sortArray(higher.toIntArray()))
        }
        else {
            return arr
        }
    }
}