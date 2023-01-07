import java.lang.RuntimeException

class IntToRomanConverter {
    private fun notWithinRange(num: Int): Boolean{
        return num < 1 || num > 3999
    }

    private fun findRoman(num: Int, pos: Int): String {
       return when(pos){
           1 -> findRomanWith(num,"I","V","X")
           10 -> findRomanWith(num,"X","L","C")
           100 -> findRomanWith(num,"C","D","M")
           1000 -> findRomanWith(num,"M","","")
           else -> {
               throw RuntimeException("Only up to 1000s are supported")
           }
       }
    }
    private fun findRomanWith(
        num: Int,
        curr: String,
        middle: String,
        next: String
    ): String{
        var res = ""
        if(num == 0){
            return res
        }
        if(num < 5 ){
            if(num == 4){
                return "$curr$middle"
            }
            for (i in 1..num){
                res += curr
            }
        }else if(num > 5){
            if(num == 9){
                return "$curr$next"
            }
            res = middle
            for (i in 6..num){
                res += curr
            }
        }else{
            return middle
        }
        return res
    }


    fun intToRoman(num: Int): String{
        if(notWithinRange(num) ){
            throw RuntimeException("Out of Range $num. Expected range is 1 <= x <= 3999")
        }
        fun rv(v: Int, s: Int,res: String): String{
            if(v == 0){
                return res
            }
            return rv(v/10,s*10,findRoman(v%10,s)) + res
        }
        return  rv(num,1,"")
    }
}
fun main(args: Array<String>){
    val conv = IntToRomanConverter()
    println(conv.intToRoman(3999))
}