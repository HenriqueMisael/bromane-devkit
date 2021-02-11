package battle.exceptions

import battle.Team

class NotAvailableBattlefieldSettingForColumns(team: Team, columns: Int) :
    Exception("Team ${team.id} does not have any suitable battlefield setting for $columns columns")
