package battle.troop

interface Troop {
    val health: Int
    val attack: Int
    val endurance: Int

    fun turnStance(stance: Stance)
}
