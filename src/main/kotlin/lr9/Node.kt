package lr9

interface Node : TreeElement {
    fun addChild(child: TreeElement)
    fun removeChild(child: TreeElement)
    fun getChild(index: Int): TreeElement
}
