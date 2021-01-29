package battle.troop.impl

import battle.UnitType
import battle.troop.Stance
import battle.troop.Troop

class TroopImpl(private val unitType: UnitType, var stance: Stance) : Troop {

    override val health get() = unitType.health
    override val attack get() = stance.calculateAttack(unitType)
    override val endurance get() = stance.calculateEndurance(unitType)

    override fun turnStance(stance: Stance) {
        this.stance = stance
    }
}
