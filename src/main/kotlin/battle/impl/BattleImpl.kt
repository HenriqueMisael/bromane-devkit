package battle.impl

import battle.Battle
import battle.command.Commander
import battle.exceptions.BattleNotSetUpException

class BattleImpl(private val commanders: Set<Commander>) : Battle {

    private var setup = false

    override fun setup() {
        setup = true
    }

    override fun forward() {

        if (!setup) throw BattleNotSetUpException()

        commanders.forEach { it.getAction(this).apply(this) }
    }
}
