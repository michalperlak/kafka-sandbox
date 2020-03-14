package basics

import mu.KLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration

class BasicKafkaConsumer<K : Any, V : Any>(
    private val consumer: KafkaConsumer<K, V>
) {

    fun start() {
        while (true) {
            val records = consumer.poll(Duration.ofSeconds(1))
            records.forEach(this::logRecord)
        }
    }

    private fun logRecord(record: ConsumerRecord<K, V>) =
        logger.info {
            "Key: ${record.key()}, value: ${record.value()}, partition: ${record.partition()}, offset: ${record.offset()}"
        }

    companion object : KLogging()
}