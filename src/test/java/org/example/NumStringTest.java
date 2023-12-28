package org.example;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumStringTest {

    @Test
    void getCountNumberInString() {
        NumString numString = new NumString(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
                        + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
                        + "when an unknown printer took a galley of type and scrambled it to make a type "
                        + "specimen book. It has survived not only five centuries, but also the leap into"
                        + " electronic typesetting, remaining essentially unchanged. It was popularised i"
                        + "n the 1960s with the release of Letraset sheets containing Lorem Ipsum passage"
                        + "s, and more recently with desktop publishing software like Aldus PageMaker inc"
                        + "luding versions of Lorem Ipsum");
        assertThat(numString.getCountNumberInString()).isEqualTo(8);
    }

    @Test
    void testToString() {
        NumString numString = new NumString("asbd1234abdff4321");
        assertThat(numString.toString()).isEqualTo(
                "NumString{\n"
                        + "\tstr='asbd1234abdff4321'\n"
                        + "\tthe number of numbers: 8\n"
                        + "\t==>12344321\n"
                        + "}"
        );
    }
}