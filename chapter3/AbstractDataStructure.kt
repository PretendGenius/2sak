package chapter3

/*
 # 문자열 ADT
코틀린 문자열(immutable)
- 개별인덱스로 문자 접근 가능
- +와 같은 기호로 연결 가능 및 == 동등성 비교 가능
- length,trim,toLowerCase,concat등 다양한 확장 함수 보유
Abstract Data Structure(추상 자료 구조)는 데이터와 그 데이터를 다루는 연산들을 하나의 단위로 묶어 표현한 것입니다. 이는 프로그래밍에서 중요한 개념으로, 다음과 같은 특징을 가집니다:
추상화
캡슐화: 데이터와 연산을 하나의 단위로 묶어 관리
정보 은닉: 내부 구현을 외부로부터 숨겨 데이터의 안전성
재사용성: 다양한 상황에서 동일한 인터페이스로 사용
* */
fun main(args: Array<String>) {
    val test = SakStringImpl("sa sa sa sasada asd wq asd aaasda asd")
    println(SakStringImpl("sak").SakString())
    println(test.find("asd"))
    val new = test.copy()
    println(new.SakString())
    println(test.isEqual("sa"))
    println(test.insert("sakkkk",1).SakString())
    println(test.subStr(0,4).SakString())
    println(test.concat(new).SakString())
}
abstract class SakString{
    //생성자 fun
    abstract fun SakString():String
    // find
    abstract fun find(txt:String):Int
    // copy
    abstract fun copy():SakString
    //isEqual
    abstract fun isEqual(txt:String):Boolean
    //insert
    abstract fun insert(txt:String, index:Int):SakString
    //subStr()
    abstract fun subStr(start:Int,end:Int):SakString
    //Concat
    abstract fun concat(txt:SakString):SakString
}

class SakStringImpl(private val sakString:String):SakString(){
    override fun SakString(): String = sakString

    override fun find(txt: String): Int =
        sakString.indexOf(txt)

    override fun copy(): SakString =
        SakStringImpl(sakString)

    override fun isEqual(txt: String): Boolean =
        sakString==txt

    override fun insert(txt: String, targetIdx: Int): SakString {
        sakString.forEachIndexed { index, c ->
            if (targetIdx==index){
                return SakStringImpl(StringBuilder(sakString).insert(targetIdx,txt).toString())
            }
        }
        return this
    }

    override fun subStr(start:Int,end:Int): SakString {
        var temp = ""
        for (i in start until end) {
            temp+=sakString[i]
        }
        return SakStringImpl(temp)
    }

    override fun concat(txt: SakString): SakString =
        SakStringImpl(sakString+txt.SakString())
}

