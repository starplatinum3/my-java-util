
排序的循环链表
力扣官方题解
21.8k
发布于 2022-06-17
未知归属地
方法一：一次遍历
markdown 数学公式
$\vec{a}$ 

 1. $\vec{a}$  向量 
 2. $\overline{a}$ 平均值 
 3. $\underline{a}$下横线 
 4. $\underset{min}{a}$ 正下方标记 
 5. $\hat{a}$ 窄 (线性回归，直线方程) y尖 
 6. $\tilde{a}$ 窄 颚化符号  等价无穷小
 7. $\widehat{a}$ (线性回归，直线方程) y尖 
 8. $\widetilde{a}$ 颚化符号  等价无穷小 
 9. $\dot{a}$一阶导数 
 10. $\ddot{a}$  二阶导数
 11. \mathbb E_{x\sim p(x)  数据期望



$$

如果循环链表为空，则插入一个新节点并将新节点的 \textit{next}next 指针指向自身，插入新节点之后得到只有一个节点的循环链表，该循环链表一定是有序的，将插入的新节点作为新的头节点返回。

如果循环链表的头节点的 \textit{next}next 指针指向自身，则循环链表中只有一个节点，在头节点之后插入新节点，将头节点的 \textit{next}next 指针指向新节点，将新节点的 \textit{next}next 指针指向头节点，此时循环链表中有两个节点且一定是有序的，返回头节点。

如果循环链表中的节点数大于 11，则需要从头节点开始遍历循环链表，寻找插入新节点的位置，使得插入新节点之后的循环链表仍然保持有序。

用 \textit{curr}curr 和 \textit{next}next 分别表示当前节点和下一个节点，初始时 \textit{curr}curr 位于 \textit{head}head，\textit{next}next 位于 \textit{head}head 的下一个节点，由于链表中的节点数大于 11，因此 \textit{curr} \ne \textit{next}curr 

​
 =next。遍历过程中，判断值为 \textit{insertVal}insertVal 的新节点是否可以在 \textit{curr}curr 和 \textit{next}next 之间插入，如果符合插入要求则在 \textit{curr}curr 和 \textit{next}next 之间插入新节点，否则将 \textit{curr}curr 和 \textit{next}next 同时向后移动，直到找到插入新节点的位置或者遍历完循环链表中的所有节点。

遍历过程中，如果找到插入新节点的位置，则有以下三种情况：

\textit{curr}.\textit{val} \le \textit{insertVal} \le \textit{next}.\textit{val}curr.val≤insertVal≤next.val，此时新节点的值介于循环链表中的两个节点值之间，在 \textit{curr}curr 和 \textit{next}next 之间插入新节点；

\textit{curr}.\textit{val} > \textit{next}.\textit{val}curr.val>next.val 且 \textit{insertVal} > \textit{curr}.\textit{val}insertVal>curr.val，此时 \textit{curr}curr 和 \textit{next}next 分别是循环链表中的值最大的节点和值最小的节点，\textit{insertVal}insertVal 大于 \textit{curr}curr 的节点值，因此新节点应该在 \textit{curr}curr 的后面插入，即在 \textit{curr}curr 和 \textit{next}next 之间插入新节点；

\textit{curr}.\textit{val} > \textit{next}.\textit{val}curr.val>next.val 且 \textit{insertVal} < \textit{next}.\textit{val}insertVal<next.val，此时 \textit{curr}curr 和 \textit{next}next 分别是循环链表中的值最大的节点和值最小的节点，\textit{insertVal}insertVal 小于 \textit{next}next 的节点值，因此新节点应该在 \textit{next}next 的前面插入，即在 \textit{curr}curr 和 \textit{next}next 之间插入新节点。

如果遍历完循环链表中的所有节点之后仍然没有遇到上述三种情况，则循环链表中的所有节点值都相同，因此新节点插入循环链表中的任何位置仍可以使循环链表保持有序，此时仍可在 \textit{curr}curr 和 \textit{next}next 之间插入新节点。

在 \textit{curr}curr 和 \textit{next}next 之间插入新节点的方法是：用 \textit{node}node 表示值为 \textit{insertVal}insertVal 的新节点，令 \textit{curr}.\textit{next}curr.next 指向 \textit{node}node，令 \textit{node}.\textit{next}node.next 指向 \textit{next}next，即完成插入新节点的操作。

插入新节点之后，返回循环链表的头节点。

$$

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        node = Node(insertVal)
        if head is None:
            node.next = node
            return node
        if head.next == head:
            head.next = node
            node.next = head
            return head
        curr = head
        next = head.next
        while next != head:
            if curr.val <= insertVal <= next.val:
                break
            if curr.val > next.val:
                if insertVal > curr.val or insertVal < next.val:
                    break
            curr = curr.next
            next = next.next
        curr.next = node
        node.next = next
        return head
复杂度分析

时间复杂度：O(n)O(n)，其中 nn 是链表的节点数。需要遍历链表一次寻找插入节点的位置，插入节点的时间是 O(1)O(1)。

空间复杂度：O(1)O(1)。

```java
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/4ueAj6/solution/pai-xu-de-xun-huan-lian-biao-by-leetcode-f566/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
