package battle.action

import battle.Battle

interface Action {
    fun apply(battle: Battle)
}
