package battle.command

import battle.Battle
import battle.action.Action

interface Commander {
    fun getAction(battle: Battle): Action
}
