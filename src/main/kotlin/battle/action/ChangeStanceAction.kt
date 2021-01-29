package battle.action

import battle.Battle
import battle.troop.Stance
import battle.troop.Troop

class ChangeStanceAction(private val stance: Stance, val troop: Troop) : Action {
    override fun apply(battle: Battle) {
        troop.turnStance(stance)
    }
}
