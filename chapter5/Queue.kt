package chapter5

fun main() {
    val queue = QueueItem<Int>(5)
    queue.enqueue(1213)
    queue.enqueue(214)
    queue.enqueue(3124)
    queue.enqueue(1234)
    queue.enqueue(124)
    queue.print()
    queue.print()
    queue.enqueue(1236)
    queue.enqueue(7123)
    queue.print()

    println("${queue.front()}")
    println("${queue.rear()}")
    println("${queue.size()}")
    println("${queue.isEmpty()}")
    println("${queue.isFull()}")
}
abstract class Queue<T> {
    abstract fun enqueue(item:T)
    abstract fun dequeue():T
    abstract fun isEmpty(): Boolean
    abstract fun isFull(): Boolean
    abstract fun front():T
    abstract fun rear():T
    abstract fun size(): Int
    abstract fun setDebugFlag(boolean: Boolean)
    abstract fun print()
}

 class QueueItem<T>(private val capacity:Int) : Queue<T>() {
    private val queue: Array<Any?> = arrayOfNulls(capacity)
    private var front: Int = 0
    private var rear: Int = 0
     override fun enqueue(item: T) {
         if (isFull()) throw Exception()
         rear = (rear+1)%capacity
         queue[rear] = item
     }

     override fun dequeue(): T {
         if (isEmpty()) throw Exception()
         val item = queue[front]
         queue[front] = null
         if (front==rear) {
             front =0
             rear = 0
         } else {
             front =( front+1) % capacity
         }
        return item as T
     }

     override fun isEmpty(): Boolean = rear == 0

     override fun isFull(): Boolean = (rear + 1) % capacity == front && !isEmpty()
     override fun front(): T {
         if (isEmpty()) throw Exception()
         return queue[front] as T
     }

     override fun rear(): T {
         if (isEmpty()) throw Exception()
         return queue[rear] as T
     }
     override fun size(): Int {
         if (isEmpty()) return 0
         return if (rear >= front) rear - front + 1 else capacity - front + rear + 1
     }

     override fun setDebugFlag(boolean: Boolean) {
         TODO("Not yet implemented")
     }

     override fun print() {
         if (isEmpty()) return
         var index = front
         val count = size()
         repeat(count) {
             print("${queue[index]} ")
             index = (index + 1) % capacity
         }
         println()
     }
 }