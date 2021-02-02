package battle.action

import battle.troop.Stance
import battle.troop.Troop

class ChangeTroopStanceAction(private val stance: Stance, troop: Troop) : TroopAction(troop) {
    override fun apply() {
        troop.turnStance(stance)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (!super.equals(other)) return false

        other as ChangeTroopStanceAction

        if (stance != other.stance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + stance.hashCode()
        return result
    }
}
