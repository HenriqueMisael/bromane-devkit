package battle.command

import battle.Battle
import battle.action.Action

interface AspiringAction {
    fun checkDoability(anyObject: Battle): Boolean
    fun getAction(battle: Battle): Action
}
