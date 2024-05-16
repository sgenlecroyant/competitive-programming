package com.sgenlecroyant.app.hashmaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppHashMapTest {

    private AppHashMap<String,String> countriesContinents;

    @BeforeEach
    void setUp() {
        this.countriesContinents = new AppHashMap<>(2);
    }

    @Test
    void shouldPutNew() {
        String key = "burundi";
        String value = "Africa";
        this.countriesContinents.put(key, value);

        String retrievedValue = this.countriesContinents.get(key);
        assertThat(retrievedValue)
                .isEqualTo(value);
    }

    @Test
    void shouldUpdateExisting() {
        String key = "burundi";
        String value = "Africa";
        this.countriesContinents.put(key, value);
        String newValue = "africa";

        this.countriesContinents.put(key,newValue);
        String retrievedValue = this.countriesContinents.get(key);
        assertThat(retrievedValue)
                .isNotEqualTo(value)
                .isEqualTo(newValue);
    }


    @Test
    void shouldReturnSize() {
        this.countriesContinents = new AppHashMap<>(2);
        this.countriesContinents.put("key1", "value1");
        this.countriesContinents.put("key2", "value2");
        this.countriesContinents.put("key3", "value3");

        assertThat(this.countriesContinents.size())
                .isEqualTo(3);

    }

    @Test
    void shouldActualSizeEvenWhenElementIsUpdated() {
        this.countriesContinents = new AppHashMap<>(2);
        this.countriesContinents.put("key1", "value1");
        this.countriesContinents.put("key2", "value2");
        this.countriesContinents.put("key3", "value3");

        this.countriesContinents.put("key1", "Another Value");
        assertThat(this.countriesContinents.size())
                .isEqualTo(3);
        assertThat(this.countriesContinents.get("key1"))
                .isNotEqualTo("value3")
                .isEqualTo("Another Value");
    }

    @Test
    void shouldGetByKeyOrReturnDefaultValue() {

        this.countriesContinents.put("key", "value");
        String defaultValue = "DEFAULT VALUE";
        assertThat(this.countriesContinents.getOrDefault("KEY", defaultValue))
                .isEqualTo(defaultValue);
    }
}