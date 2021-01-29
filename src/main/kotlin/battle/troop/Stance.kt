package battle.troop

import battle.UnitType

interface Stance {
    fun calculateAttack(unitType: UnitType): Int
    fun calculateEndurance(unitType: UnitType): Int
}
