var turn = 'X'
var win = '-'

val table : Array<Array<Char>> = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)

fun table(){
    for (row in table){
        for (col in row){
            print("$col ")
        }
        println()
    }
}

fun showTurn(){
    println("$turn turn")
}

fun showWin(){
    println("$win Win!")
}

fun input(){
    try {
        print("please input numbers R C: ")
        val input = readLine()
        val rcList: List<String>? = input?.split(" ")
        if(rcList?.size != 2){
            println("Error : Must input 2 numbers R C {Ex: 1 2}")
            input()
        } else {
            val rowInt = rcList[0].toInt()
            val colInt = rcList[1].toInt()
            if(rowInt !in 1..3 || colInt !in 1..3){
                println("Error: Must input numbers R = 1 or 2 or 3, numbers C = 1 or 2 or 3")
                input()
            } else {
                for (i in table.indices){
                    for (j in table[i].indices){
                        if (i == rowInt && j == colInt){
                            if(!table[i][j].equals('-')){
                                println("Error: Must input in R = '-' and C = '-'")
                                input()
                            } else {
                                table[i][j] = turn
                                if (turn == 'X'){
                                    turn = 'O'
                                } else {
                                    turn = 'X'
                                }
                            }

                        }
                    }
                }
            }
        }
    } catch (t: Throwable){
        print("Error: ${t.message} ")
        input()
    }

}

fun checkWin(): Boolean{
    if (table[1][1].equals('X') && table[1][2].equals('X') && table[1][3].equals('X')
        || table[2][1].equals('X') && table[2][2].equals('X') && table[2][3].equals('X')
        || table[3][1].equals('X') && table[3][2].equals('X') && table[3][3].equals('X')
        || table[1][1].equals('X') && table[2][1].equals('X') && table[3][1].equals('X')
        || table[1][2].equals('X') && table[2][2].equals('X') && table[3][2].equals('X')
        || table[1][3].equals('X') && table[2][3].equals('X') && table[3][3].equals('X')
        || table[1][1].equals('X') && table[2][2].equals('X') && table[3][3].equals('X')
        || table[1][3].equals('X') && table[2][2].equals('X') && table[3][1].equals('X')){
        win = 'X'
        return true
    }
    if (table[1][1].equals('O') && table[1][2].equals('O') && table[1][3].equals('O')
        || table[2][1].equals('O') && table[2][2].equals('O') && table[2][3].equals('O')
        || table[3][1].equals('O') && table[3][2].equals('O') && table[3][3].equals('O')
        || table[1][1].equals('O') && table[2][1].equals('O') && table[3][1].equals('O')
        || table[1][2].equals('O') && table[2][2].equals('O') && table[3][2].equals('O')
        || table[1][3].equals('O') && table[2][3].equals('O') && table[3][3].equals('O')
        || table[1][1].equals('O') && table[2][2].equals('O') && table[3][3].equals('O')
        || table[1][3].equals('O') && table[2][2].equals('O') && table[3][1].equals('O')){
        win = 'O'
        return true
    }
    if(table[1][1].equals('X') && table[2][2].equals('X') && table[3][3].equals('X')
        || table[1][3].equals('X') && table[2][2].equals('X') && table[3][1].equals('X')){
        win = 'X'
        return true
    }
    if(table[1][1].equals('O') && table[2][2].equals('O') && table[3][3].equals('O')
        || table[1][3].equals('O') && table[2][2].equals('O') && table[3][1].equals('O')){
        win = 'O'
        return true
    }
    return false
}

fun main() {
    println("Welcome to OX Game")
    for(i in 1..9){
        table()
        showTurn()
        input()
        if(checkWin() == true){
            table()
            showWin()
            break
        }
        if (i == 9){
            table()
            println("Draw!")
        }
    }
}