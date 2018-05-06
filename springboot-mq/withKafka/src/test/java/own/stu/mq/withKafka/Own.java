package own.stu.mq.withKafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by CHANEL on 2018/5/4.
 */
public class Own {

    @Test
    public void test() throws ExecutionException, InterruptedException {

        Properties properties= new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");

        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord producerRecord = new ProducerRecord("test2", 0, new Date().getTime(), "message", "hello 魅族");
        Future<RecordMetadata> metadataFuture = producer.send(producerRecord);
        RecordMetadata metadata = metadataFuture.get();
        System.out.println(metadata);
    }
}
