package lr9

fun main(){
    val root  = NodeImpl("Root")
    val nodeImpl1 = NodeImpl("Node 1")
    val nodeImpl2 = NodeImpl("Node 2")
    val nodeImpl3 = NodeImpl("Node 3")

    root.addChild(nodeImpl1)
    root.addChild(nodeImpl2)
    nodeImpl1.addChild(Leaf("Leaf 1"))
    nodeImpl1.addChild(Leaf("Leaf 2"))
    nodeImpl2.addChild(nodeImpl3)
    nodeImpl3.addChild(Leaf("Leaf 3"))

    println("Результирующее дерево:")
    root.showTree()
}