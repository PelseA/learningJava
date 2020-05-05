package ru.pelse.syntax.io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
       // 1. Разбить файл (информацию из одного файла записать в n разных файлов)
        String fileName = "sources/io/file1.txt";
        File file = new File(fileName);

        try {
            FileSplitter fileSplitter = new FileSplitter();
            fileSplitter.splitFile(file, 4);
        } catch (IOException ex) {
            System.out.println("fileSplitter has a problem");
            ex.printStackTrace();
        }

        // 2. Склеить файл (информацию из нескольких файлов записать в один файл)
        // сделаю 2 конструктора:
        // важна последовательность склевивания
        // не важна
    }

}
