package lr9

fun main(){
    val root  = Node("Root")
    val node1 = Node("Node 1")
    val node2 = Node("Node 2")

    root.addChild(node1)
    root.addChild(node2)
    node1.addChild(Leaf("Leaf 1"))
    node1.addChild(Leaf("Leaf 2"))
    node2.addChild(Leaf("Leaf 3"))

    println("Результирующее дерево:")
    Printer.showTreeToDisplay(root)
}