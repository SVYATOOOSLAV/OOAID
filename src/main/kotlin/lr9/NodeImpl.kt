package lr9

import java.lang.IndexOutOfBoundsException
import javax.management.OperationsException

data class NodeImpl(var name: String) : Node {

    var children: ArrayList<TreeElement> = ArrayList()

    override fun showName(depth: Int) {
        println(" ".repeat(depth * 2) + name)
    }

    override fun addChild(child: TreeElement) {
        if (children.contains(child)) {
            throw OperationsException("Child node already exists in the children list")
        }
        children.add(child)
    }

    override fun removeChild(child: TreeElement) {
        if (!children.contains(child)) {
            throw OperationsException("Child node does not exist in the children list")
        }
        children.remove(child)
    }

    override fun getChild(index: Int): TreeElement {
        if (index < 0 || index >= children.size) {
            throw IndexOutOfBoundsException("Index is out of range")
        }
        return children[index]
    }

    fun showTree(){
        Printer.showToDisplay(this)
    }
}