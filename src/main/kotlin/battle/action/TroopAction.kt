package battle.action

import battle.troop.Troop

abstract class TroopAction(val troop: Troop) : Action {
    override fun equals(other: Any?): Boolean {
        if (other === null) return false
        if (this === other) return true

        other as TroopAction

        if (troop != other.troop) return false

        return true
    }

    override fun hashCode(): Int {
        return troop.hashCode()
    }
}
