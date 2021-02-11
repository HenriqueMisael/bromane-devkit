package battle

import battle.troop.Troop

class FieldCell(var content: Troop? = null) {
    fun isEmpty(): Boolean = content === null
}
