package problems

import java.lang.Exception

// Beat 8.13% of Kotlin players
// Beat 5.02% of Kotlin players

class Problem1 {
    fun twoSum(nums: IntArray, target: Int) : IntArray {
        val indexedArray = nums.withIndex().toList()
        val sortedArray = indexedArray.sortedBy { it.value }
        val arr = sortedArray.map { it.value }.toIntArray()
        val indices = sortedArray.map { it.index }.toIntArray()

        for(index1 in arr.indices) {
            val index2 = binarySearch(arr, target - arr[index1])
            if(index2 != null && index1 != index2) {
                return intArrayOf(indices[index1], indices[index2])
            }
        }

        throw Exception("Leetcode was wrong")
    }

    private fun binarySearch(arr: IntArray, target: Int, left : Int = 0, right: Int = arr.size - 1) : Int? {
        val pivot = (left + right) / 2

        if(!arr.contains(target)) {
            return null
        }
        else if(arr[pivot] == target) {
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
}