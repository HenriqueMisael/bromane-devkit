package battle.troop

import battle.UnitType

class Troop(private val unitType: UnitType, var stance: Stance) {

    val health get() = unitType.health
    val attack get() = stance.calculateAttack(unitType)
    val endurance get() = stance.calculateEndurance(unitType)

    fun turnStance(stance: Stance) {
        this.stance = stance
    }

    fun resolveEngagements() {
        TODO("Not yet implemented")
    }

    fun resetEngagements() {
        TODO("Not yet implemented")
    }
}
