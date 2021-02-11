package battle

import battle.exceptions.NotAvailableBattlefieldSettingForColumns
import battle.exceptions.NotAvailableBattlefieldSettingForRows

class Team(
    val id: Long,
    private val battlefieldSettings: Map<Int, Map<Int, BattlefieldSetting>>
) {
    fun getBattlefieldSetting(rows: Int, columns: Int): BattlefieldSetting {

        val battlefieldSettingOfRow = battlefieldSettings.getOrElse(rows) {
            battlefieldSettings[battlefieldSettings.keys.sortedDescending().firstOrNull { it < rows }]
        } ?: throw NotAvailableBattlefieldSettingForRows(this, rows)

        return battlefieldSettingOfRow.getOrElse(columns) {
            battlefieldSettingOfRow[battlefieldSettingOfRow.keys.sortedDescending().firstOrNull { it < columns }]
        } ?: throw NotAvailableBattlefieldSettingForColumns(this, columns)
    }
}
