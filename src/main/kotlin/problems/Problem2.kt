package problems

import additionalClasses.ListNode

// Beat 10.44% of Kotlin players
// Beat 9.52% of Kotlin players

class Problem2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): MutableList<Int> {
        var current1: ListNode?
        var current2: ListNode?

        if(getSize(l1) >= getSize(l2)) {
            current1 = l1
            current2 = l2
        }
        else {
            current1 = l2
            current2 = l1
        }
        val result = mutableListOf<Int>()

        var carry = 0
        while(current1 != null) {
            if(current2 != null) {
                val res = current1.`val` + current2.`val`
                carry = if(res > 9) {
                    result.add(res - 10 + carry)
                    1
                } else {
                    if(res + carry >= 10) {
                        result.add(0)
                        1
                    }
                    else {
                        result.add(res + carry)
                        0
                    }
                }
                current1 = current1.next
                current2 = current2.next
            }
            else {
                val res = current1.`val`
                carry = if(res > 9) {
                    result.add(res - 10 + carry)
                    1
                } else {
                    if(res + carry >= 10) {
                        result.add(0)
                        1
                    }
                    else {
                        result.add(res + carry)
                        0
                    }
                }
                current1 = current1.next
            }
        }
    if(carry == 1) { result.add(1) }
        return result
    }

    private fun getSize(head: ListNode?): Int {
        var size = 0
        var current: ListNode? = head

        while (current != null) {
            size++
            current = current.next
        }

        return size
    }
}

