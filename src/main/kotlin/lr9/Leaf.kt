package lr9


class Leaf(private var name:String) : TreeElement {
    override fun showName(depth: Int) {
        println(" ".repeat(depth * 2) + name)
    }
}