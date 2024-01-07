package org.example.school.student.inputdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderCSV implements Reader {

    private String filePath;
    private BufferedReader bufferedReader;
    private List<String[]> readData;

    private int index;

    public ReaderCSV(String filePath) throws IOException {
        this.filePath = filePath;
        this.bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath), "utf-8"));
        this.readData = new ArrayList<>();
        this.index = 0;
        this.read();
    }

    public void read() throws IOException {
        final String DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineContents = line.split(DELIMITER, -1);
            readData.add(lineContents);
        }
    }

    public String[] nextRead() {
        if (readData.size() == index) {
            return null;
        }
        return readData.get(index++);
    }
}

