package battle.exceptions

import battle.Team

class NotAvailableBattlefieldSettingForRows(team: Team, rows: Int) :
    Exception("Team ${team.id} does not have any suitable battlefield setting for $rows rows")
