package own.stu.mq.withKafka.serializer;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * Created by CHANEL on 2018/5/4.
 */
public class ObjectSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {

        System.out.println(" topic : " + topic + " , serialize object :" + data);

        byte[] dataArray = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);

            dataArray = outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return dataArray;
    }

    @Override
    public void close() {

    }
}
