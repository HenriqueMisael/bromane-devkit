package battle.command.impl

import battle.Battle
import battle.action.Action
import battle.command.AspiringAction
import battle.command.Commander
import battle.command.exceptions.CommanderWithNoAspiringActionsException
import battle.troop.Troop

class CommanderImpl(val troops: Set<Troop>, private val aspiringActions: List<AspiringAction>) : Commander {
    override fun getAction(battle: Battle): Action {

        if (aspiringActions.isEmpty()) throw CommanderWithNoAspiringActionsException()

        return aspiringActions.first { it.checkDoability(battle) }.getAction(battle)
    }
}
