package battle.troop.impl

import battle.UnitType
import battle.troop.Stance

class AggressiveStance : Stance {
    override fun calculateAttack(unitType: UnitType): Int {
        return unitType.attack
    }

    override fun calculateEndurance(unitType: UnitType): Int {
        return unitType.endurance / 2
    }
}
