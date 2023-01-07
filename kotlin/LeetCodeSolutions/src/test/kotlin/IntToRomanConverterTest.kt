import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.comparables.shouldBeEqualComparingTo

class IntToRomanConverterTest : StringSpec(
    {
        val conv = IntToRomanConverter()
        "test int to roman" {
            forAll(
                row(1,"I"),
                row(2,"II"),
                row(3,"III"),
                row(4,"IV"),
                row(100,"C"),
                row(1000,"M"),
                row(1999,"MCMXCIX"),
                row(2999,"MMCMXCIX"),
                row(199,"CXCIX"),
                row(159,"CLIX"),
                row(169,"CLXIX"),
                row(181,"CLXXXI"),
                row(121,"CXXI"),
                row(999,"CMXCIX"),
                row(888,"DCCCLXXXVIII"),
                row(555,"DLV"),
                row(222,"CCXXII"),
                row(111,"CXI"),
                row(31,"XXXI"),
                row(314,"CCCXIV"),
                row(319,"CCCXIX"),
            ) { num, roman ->
                conv.intToRoman(num) shouldBeEqualComparingTo  roman
            }
        }
    })
