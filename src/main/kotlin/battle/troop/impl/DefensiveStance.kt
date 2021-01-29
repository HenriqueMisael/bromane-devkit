package battle.troop.impl

import battle.UnitType
import battle.troop.Stance

class DefensiveStance : Stance {
    override fun calculateAttack(unitType: UnitType): Int {
        return unitType.attack / 2
    }

    override fun calculateEndurance(unitType: UnitType): Int {
        return unitType.endurance * 2
    }
}
