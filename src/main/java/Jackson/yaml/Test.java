package Jackson.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import java.io.File;
import java.io.IOException;

public class Test {
  public static void main(String[] args) throws IOException {

    String fieldPath = "./src/main/java/Jackson/yaml/test.yaml";
    OrderObject oldOrderObject = new OrderObject();

    ObjectMapper writeMapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
    writeMapper.writeValue(new File(fieldPath), oldOrderObject);

    ObjectMapper readMapper = new ObjectMapper(new YAMLFactory());
    readMapper.findAndRegisterModules();
    OrderObject newOrderObject = readMapper.readValue(new File(fieldPath), OrderObject.class);
  }
}
