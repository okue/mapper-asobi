import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.linecorp.bot.model.message.FlexMessage

val objectMapper: ObjectMapper = ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
fun <T> writeValueAsString(x: T) = objectMapper.writeValueAsString(x).let { println("${it}\n-----") }
data class Data(val x: List<FlexMessage>)
data class Data2(val x: List<Any>)
data class Data3<T>(val x: List<T>)
class Empty

fun main() {
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
    objectMapper.writeValueAsString(Empty()).let { println(it) }
    objectMapper.writeValueAsString(Empty2()).let { println(it) }
    objectMapper.writeValueAsString(Empty1()).let { println(it) }
}

fun f1() {
    val m = FlexMessage.builder().build()
    val lst: List<FlexMessage> = listOf(m)
    writeValueAsString(m)
    writeValueAsString(lst)
    writeValueAsString(Data(x = lst))
    writeValueAsString(Data2(x = lst))
    writeValueAsString(Data3(x = lst))
}
