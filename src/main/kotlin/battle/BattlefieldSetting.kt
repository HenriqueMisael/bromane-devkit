package battle

import battle.troop.Troop

class BattlefieldSetting(private val content: List<List<Troop?>>) {
    fun forEachIndexed(action: (index: Int, List<Troop?>) -> Unit) {
        content.forEachIndexed(action)
    }
}
