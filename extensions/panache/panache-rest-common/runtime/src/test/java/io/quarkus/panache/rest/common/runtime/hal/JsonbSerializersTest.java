package io.quarkus.panache.rest.common.runtime.hal;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.BeforeEach;

class JsonbSerializersTest extends AbstractSerializersTest {

    private Jsonb jsonb;

    @BeforeEach
    void setup() {
        JsonbConfig config = new JsonbConfig();
        config.withSerializers(new HalEntityWrapperJsonbSerializer(new BookHalLinksExtractor()));
        config.withSerializers(new HalCollectionWrapperJsonbSerializer(new BookHalLinksExtractor()));
        jsonb = JsonbBuilder.create(config);
    }

    @Override
    String toJson(Object object) {
        return jsonb.toJson(object);
    }
}