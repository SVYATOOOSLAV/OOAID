package lr9

fun main(){
    val root  = NodeImpl("Root")
    val nodeImpl1 = NodeImpl("Node 1")
    val nodeImpl2 = NodeImpl("Node 2")

    root.addChild(nodeImpl1)
    root.addChild(nodeImpl2)
    nodeImpl1.addChild(Leaf("Leaf 1"))
    nodeImpl1.addChild(Leaf("Leaf 2"))
    nodeImpl2.addChild(Leaf("Leaf 3"))

    println("Результирующее дерево:")
    Printer.showTreeToDisplay(root)
}