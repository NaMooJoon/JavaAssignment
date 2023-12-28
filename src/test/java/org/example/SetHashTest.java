package org.example;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetHashTest {

    Set<String> set;

    @BeforeEach
    void before() {
        set = new SetHash<>();
    }

    @Test
    @DisplayName("Set에 삽입이 잘 되는가?")
    void add() {
        set.add("안녕하세요");
        set.add("반갑습니다");
        set.add("반갑습니다");
        set.add("Hello, world!");
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set에 collection으로 삽입 할 수 있는가?")
    void addList() {
        List<String> list = List.of("AAA", "AAA", "AAA", "BBB", "BBB");

        set.addAll(list);
        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("삽입된 데이터 유무를 잘 확인할 수 있는가?")
    void contains() {
        set.add("안녕하세요");
        set.add("반갑습니다");
        set.add("Hello, world!");

        assertThat(set.contains("ㅎㅎ")).isEqualTo(false);
        assertThat(set.contains("반갑습니다")).isEqualTo(true);
    }

    @Test
    @DisplayName("삭제를 정상적으로 수행하는가?")
    void remove() {
        set.add("안녕하세요");
        set.add("반갑습니다");
        set.add("Hello, world!");

        set.remove("안녕하세요");
        assertThat(set.size()).isEqualTo(2);
        assertThat(set.contains("안녕하세요")).isEqualTo(false);
    }

    @Test
    @DisplayName("Iterator을 수행할 수 있는가?")
    void iterator() {
        set.addAll(List.of("Never", "you", "meet", "to", "you", "nice", ",", "Hello", "Hello"));
        set.remove("Never");
        String s = "";
        for (String element : set) {
            s += element + ' ';
        }
        assertThat(s).isEqualTo(
                "Hello , nice to meet you "
        );
    }


}