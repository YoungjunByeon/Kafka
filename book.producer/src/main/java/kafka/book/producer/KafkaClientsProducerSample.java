package kafka.book.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.BasicConfigurator;

/**
 * Hello world!
 *
 */
public class KafkaClientsProducerSample {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "203.251.177.28:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		producer.send(
				new ProducerRecord<String, String>("peter-topic", "Apache Kafka is a distributed streaming platform"));

		producer.close();
	}
}
