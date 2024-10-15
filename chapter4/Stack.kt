package chapter4

fun main(args: Array<String>) {
    val stack = StackImpl()
    stack.push("sak")
    stack.push("asd")
    stack.push("asda")
    println(stack.print())
    println(stack.pop())
    println(stack.peek())
    println(stack.size())
    println(stack.isEmpty())
}
abstract class Stack {
    abstract fun isEmpty(): Boolean
    abstract fun size(): Int
    abstract fun push(value: String)
    abstract fun pop(): String
    abstract fun peek(): String
    abstract fun print(): String
}
class StackImpl : Stack() {
    private val items: MutableList<String> = mutableListOf()

    override fun isEmpty(): Boolean = items.isEmpty()

    override fun size(): Int = items.size

    override fun push(value: String) {
        items.add(value)
    }

    override fun pop(): String {
        if (items.isEmpty()) throw NoSuchElementException()
        return items.removeAt(items.size - 1)
    }

    override fun peek(): String {
        if (isEmpty()) throw NoSuchElementException()
        return items.last()
    }

    override fun print(): String {
        return items.joinToString { "," }
    }
}