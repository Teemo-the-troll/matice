
    fun main(args : Array<String>) {
        val one:Matrix = Matrix(2,4).fillRandom();
        val two:Matrix = Matrix(4,2).fillRandom();

        one.print();
        println("")
        two.print();
        println()
        one.times(two).print();
    }

