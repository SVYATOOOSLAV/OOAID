package lr9

import javax.management.OperationsException

class Leaf(private var name:String) : TreeElement {
    override fun showName(depth: Int) {
        println(" ".repeat(depth * 2) + name)
    }

    override fun addChild(child: TreeElement) {
        throw OperationsException("Cannot add child to leaf node");
    }

    override fun removeChild(child: TreeElement) {
        throw OperationsException("Cannot remove child from leaf node");
    }

    override fun getChild(index: Int): TreeElement {
        throw OperationsException("Leaf node does not have children");
    }
}