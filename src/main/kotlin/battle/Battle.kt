package battle

import battle.command.Commander
import battle.exceptions.BattleNotSetUpException

class Battle(private val battlefield: Battlefield, private val commanders: Set<Commander>) {

    private val teams = commanders.map { it.team }
    private val troops = commanders.flatMap { it.troops }

    private var setup = false

    fun setup() {
        battlefield.setup(teams)

        setup = true
    }

    fun forward() {

        if (!setup) throw BattleNotSetUpException()

        commanders.forEach { it.getAction().apply() }
        troops.forEach { it.resetEngagements() }
        troops.forEach { it.resolveEngagements() }
    }
}
