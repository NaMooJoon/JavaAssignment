package org.example;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapHashTest {
    Map<String, Integer> map;

    @BeforeEach
    void before() {
        map = new MapHash<>();
    }

    @Test
    @DisplayName("MapHash의 삽입이 잘 되는가?")
    void put() {
        map.put("first", 3);
        map.put("first", 1);
        map.put("second", 2);
        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("삽입된 값을 key값에 따라 정상적으로 읽어올 수 있는가?")
    void get() {
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        assertThat(map.get("second")).isEqualTo(2);
        assertThat(map.get("first")).isEqualTo(1);
        assertThat(map.get("없는 값")).isEqualTo(null);
    }
    
    @Test
    @DisplayName("정상적으로 삭제를 할 수 있는가?")
    void remove() {
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        map.put("fourth", 4);
        map.put("fifth", 5);

        Integer deletedValue = map.remove("second");
        assertThat(deletedValue).isEqualTo(2);

        deletedValue = map.remove("없는 값");
        assertThat(deletedValue).isEqualTo(null);
        
        map.remove("first");
        map.remove("fifth");
        assertThat(map.size()).isEqualTo(2);

        assertThat(map.toString()).isEqualTo(
                "MapHash{size= 2\n" +
                        "\tNode{ key=fourth, value=4 }\n" +
                        "\tNode{ key=third, value=3 }\n" +
                        "}"
        );
    }
}