剑指 Offer II 073. 狒狒吃香蕉
狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。

狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。  

狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。

 

示例 1：

输入：piles = [3,6,7,11], h = 8
输出：4
示例 2：

输入：piles = [30,11,23,4,20], h = 5
输出：30
示例 3：

输入：piles = [30,11,23,4,20], h = 6
输出：23
 

提示：

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 

注意：本题与主站 875 题相同： https://leetcode-cn.com/problems/koko-eating-bananas/

通过次数17,917提交次数33,854


狒狒吃香蕉
力扣官方题解
5.3k
发布于 2022-06-06
未知归属地
方法一：二分查找
如果狒狒在 hh 小时内吃掉所有香蕉的最小速度是每小时 kk 个香蕉，则当吃香蕉的速度大于每小时 kk 个香蕉时一定可以在 hh 小时内吃掉所有香蕉，当吃香蕉的速度小于每小时 kk 个香蕉时一定不能在 hh 小时内吃掉所有香蕉。

由于吃香蕉的速度和是否可以在规定时间内吃掉所有香蕉之间存在单调性，因此可以使用二分查找的方法得到最小速度 kk。

由于每小时都要吃香蕉，即每小时至少吃 11 个香蕉，因此二分查找的下界是 11；由于每小时最多吃一堆香蕉，即每小时吃的香蕉数目不会超过最多的一堆中的香蕉数目，因此二分查找的上界是最多的一堆中的香蕉数目。

假设吃香蕉的速度是 \textit{speed}speed，则当一堆香蕉的个数是 \textit{pile}pile 时，吃掉这堆香蕉需要 \Big\lceil \dfrac{\textit{pile}}{\textit{speed}} \Big\rceil⌈ 
speed
pile
​
 ⌉ 小时，由此可以计算出吃掉所有香蕉需要的时间。如果在速度 \textit{speed}speed 下可以在 hh 小时内吃掉所有香蕉，则最小速度一定小于或等于 \textit{speed}speed，因此将上界调整为 \textit{speed}speed；否则，最小速度一定大于 \textit{speed}speed，因此将下界调整为 \textit{speed} + 1speed+1。

二分查找结束之后，即可得到在 hh 小时内吃掉所有香蕉的最小速度 kk。

实现方面，在计算吃掉每一对香蕉的时间时，由于 \textit{pile}pile 和 \textit{speed}speed 都大于 00，因此 \Big\lceil \dfrac{\textit{pile}}{\textit{speed}} \Big\rceil⌈ 
speed
pile
​
 ⌉ 等价于 \Big\lfloor \dfrac{\textit{pile} + \textit{speed} - 1}{\textit{speed}} \Big\rfloor⌊ 
speed
pile+speed−1
​
 ⌋。

看不懂
方括号是向下取整吗
方括号是向下取整。
取整的意思就是:例如13除以5=2...3,取整后得到的值为2。 当然还有向上取整,得到值为3,向下取整得到值为2。 上取整,不管四舍五入的规则,只要后面有小数前面的整数就加1。下取整 ,不管四舍五入的规则,只要后面有... 更多 >

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        return bisect_left(range(max(piles)), -h, 1, key=lambda k: -sum((pile + k - 1) // k for pile in piles))
复杂度分析
```java

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/nZZqjQ/solution/fei-fei-chi-xiang-jiao-by-leetcode-solut-0jge/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

时间复杂度：O(n \log m)O(nlogm)，其中 nn 是数组 \textit{piles}piles 的长度，mm 是数组 \textit{piles}piles 中的最大值。需要 O(n)O(n) 的时间遍历数组找到最大值 mm，二分查找需要执行 O(\log m)O(logm) 轮，每一轮二分查找需要 O(n)O(n) 的时间，因此总时间复杂度是 O(n \log m)O(nlogm)。

空间复杂度：O(1)O(1)。
