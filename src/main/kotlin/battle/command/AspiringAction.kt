package battle.command

import battle.action.Action

interface AspiringAction {
    val isDoable: Boolean
    val action: Action
}
