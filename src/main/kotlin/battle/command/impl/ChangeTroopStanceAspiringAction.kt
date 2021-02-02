package battle.command.impl

import battle.action.ChangeTroopStanceAction
import battle.command.AspiringTroopAction
import battle.troop.Stance
import battle.troop.Troop

class ChangeTroopStanceAspiringAction(val stance: Stance, troop: Troop) : AspiringTroopAction(troop) {
    override val isDoable = true
    override val action get() = ChangeTroopStanceAction(stance, troop)
}
