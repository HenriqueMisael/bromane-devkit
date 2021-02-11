package battle

class Battlefield(private val rows: Int, private val columns: Int) {

    private val grid: List<List<FieldCell>> = List(rows) { x -> List(columns) { y -> FieldCell() } }

    operator fun get(rowIndex: Int): List<FieldCell> {
        return grid[rowIndex]
    }

    fun setup(teams: List<Team>) {
        val midRow = rows / 2
        teams[0].getBattlefieldSetting(midRow, columns)
            .forEachIndexed { i, row -> row.forEachIndexed { j, it -> grid[i + midRow][j].content = it } }
        teams[1].getBattlefieldSetting(midRow, columns)
            .forEachIndexed { i, row -> row.forEachIndexed { j, it -> grid.asReversed()[i + midRow][j].content = it } }
    }

    fun isEmpty(): Boolean {
        return grid.all { row -> row.all { it.isEmpty() } }
    }
}
