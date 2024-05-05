package lr9

class Printer {
    companion object{
        fun showTreeToDisplay(root: Node){
            showToDisplay(root, 0)
        }

        private fun showToDisplay(treeElement: TreeElement, depth:Int = 0){
            if(treeElement is Node){
                treeElement.showName(depth)
                for (i in 0 until treeElement.children.size) {
                    showToDisplay(treeElement.getChild(i), depth + 1)
                }
            }
            else{
                treeElement.showName(depth)
            }
        }
    }
}