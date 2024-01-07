package org.example.school.student.inputdata;

import java.io.IOException;

public interface Reader {
    public void read() throws IOException;
    public String[] nextRead();
}
