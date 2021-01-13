import java.lang.Exception
import kotlin.random.Random

class Matrix() {
    var body: ArrayList<ArrayList<Int>> = arrayListOf<ArrayList<Int>>(ArrayList<Int>());
    val width: Int
        get() = this.body[0].size;

    val height: Int
        get() = this.body.size;

    constructor(height: Int, width: Int) : this() {
        val body = arrayListOf<ArrayList<Int>>();
        for (i in 1..height){
            val tempArrayList:ArrayList<Int> = ArrayList();
            for (j in 1..width)
                tempArrayList.add(0)
            body.add(tempArrayList);
        }
        this.body = body;
    }

    /*
    * [1  2]   [5  6]  ====   [19  22]
    * [3  4]   [7  8]  ====   [43  50]
    * 1 · 5 + 2 · 7 = 19
    * 1 · 6 + 2 · 8 = 22
    * 3 · 5 + 4 · 7 = 43
    * 3 · 6 + 4 · 8 = 50
    *
    *
    *  {1, 2, 3}    {10, 11, 12}  {84  90  96}
    *  {4, 5, 6}    {13, 14, 15}  {201 216 231}
    *  {7, 8, 9}    {16, 17, 18}  {318 342 366}
    *
    * {00,01,02,03}
    * {10,11,12,13}
    * {20,21,22,23}
    * {30,31,32,33}
    * 1*10 + 2*13 + 3*16  1*11 + 2*14 + 3*17  1*12 + 2*15 + 3*18
    * 4*10 + 5*13 + 6*16  4*11 + 5*14 + 6*17  4*12 + 5*15 + 6*18
    * 7*10 + 8*13 + 9*16  7*11 + 8*14 + 9*17  7*12 + 8*15 + 9*18
    *
    * 00*00 + 01*10 + 02*20  00*01 + 01*11 + 02*21  00*02 + 01*12 + 02*22
    * 10*00 + 11*10 + 12*20  10*01 + 11*11 + 12*21  10*02 + 11*12 + 12*22
    * 20*00 + 21*10 + 22*20  20*01 + 21*11 + 22*21  20*02 + 21*12 + 22*22
    * 30*00 + 31*10 + 32*20  30*01 + 31*11 + 32*21  30*02 + 31*12 + 32*22
    *
    *
    *  {1, 2, 3}    {10, 11, 12}  {84  90  96}
    *  {4, 5, 6}    {13, 14, 15}  {201 216 231}
    *  {7, 8, 9}    {16, 17, 18}  {318 342 366}
    *
    *
    *
    * kolika radkova a kolika sloupcova je ktera matrice
    *
    * final matice = [vyska 1., sirka 2.]
    * e.x.  [7,8] = [vyska 7 sirka 8]
    *
    *
    * {00,01,02,03}
    * {10,11,12,13}
    * {20,21,22,23}
    * {30,31,32,33}
    *
    * {00,10,20,30}
    * {01,11,21,31}
    * {02,12,22,32}
    * {03,13,23,33}
    *
    * */

    fun fillRandom():Matrix {
    val temp:Matrix = this;
        var x = 1;
        for (i in 0 until this.height)
            for (j in 0 until this.width){
                x++;
                temp.body[i][j] = (x+i*j)+x
            }
                return temp;

    }

    fun twist():Matrix {
        val tempMatrix: Matrix = Matrix(this.width, this.height);
        for (i in 0 until tempMatrix.height)
            for (j in 0 until tempMatrix.width)
                tempMatrix.body[i][j] = this.body[j][i];
        return tempMatrix
    }

    fun print() {
        for (i in 0 until this.height){
            for (j in 0 until this.width){
                print(""+this.body[i][j] + "  ")
            }
            println("")
        }
    }

    fun checkFormatTimes(matrix1: Matrix){
        if (matrix1.width != this.height){
            throw Exception("Matrixes cant be multiplied, invalid format")
        }
    }


    fun times( matrix1: Matrix): Matrix {
        this.checkFormatTimes(matrix1);
        val tempMatrix = matrix1.twist();
        val resultMatrix = Matrix(this.height, matrix1.width);
        for (i in 0 until this.height){
            for (j in 0 until matrix1.width){
                var x = 0;
                for (k in 0 until matrix1.height){
                    x += this.body[i][k] * tempMatrix.body[j][k]
                }
                resultMatrix.body[i][j] = x;
            }
        }
     return resultMatrix
    }
}
