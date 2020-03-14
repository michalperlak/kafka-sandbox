package basics

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.*

data class KafkaConsumerConfig<K : Any, V : Any>(
    private val bootstrapServers: String,
    private val groupId: String,
    private val topic: String,
    private val keyDeserializerClass: Class<*>,
    private val valueDeserializerClass: Class<*>
) {

    fun configure(): KafkaConsumer<K, V> =
        KafkaConsumer<K, V>(consumerProperties())
            .apply { subscribe(listOf(topic)) }

    private fun consumerProperties(): Properties =
        Properties()
            .apply {
                setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
                setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializerClass.name)
                setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializerClass.name)
                setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId)
                setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
            }
}