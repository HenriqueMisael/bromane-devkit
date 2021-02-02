package battle.command

import battle.Team
import battle.action.Action
import battle.command.exceptions.CommanderWithNoAspiringActionsException
import battle.troop.Troop

class Commander(val team: Team, val troops: Set<Troop>, private val aspiringActions: List<AspiringAction>) {
    fun getAction(): Action {

        if (aspiringActions.isEmpty()) throw CommanderWithNoAspiringActionsException()

        return aspiringActions.first { it.isDoable }.action
    }
}
