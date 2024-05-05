package lr9

interface TreeElement {
    fun showName(depth: Int = 0)
    fun addChild(child: TreeElement)
    fun removeChild(child: TreeElement)
    fun getChild(index: Int): TreeElement
}
