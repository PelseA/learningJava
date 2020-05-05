package ru.pelse.syntax.io;

import java.io.*;
import java.sql.Timestamp;

public class FileSplitter {
    protected Timestamp timeStamp;

    public FileSplitter() {
        timeStamp = new Timestamp(System.currentTimeMillis());
    }

    private byte[] readAllToByteArray(File file) throws IOException {
        int currentByte;
        byte[] b;
        File temp;
        try {
            temp = File.createTempFile("file-splitter-", ".tmp");
        } catch (IOException e){
            System.out.println("Неудалось создать временный файл");
            throw new IllegalStateException("Сообщите разработчику причину остановки программы: 'readAllToByteArray'");
        }

        try(FileOutputStream outputStream= new FileOutputStream(temp);
            FileInputStream inputStream = new FileInputStream(file)) {
            while ((currentByte = inputStream.read()) != -1) {
                outputStream.write(currentByte);
            }
            double bytes = 0;
            if(temp.exists()) {
                bytes = temp.length();
            }
            try(FileInputStream inputStreamTemp = new FileInputStream(temp)) {
                b = new byte[(int)bytes];
                int read;
                for (int i = 0; i < b.length; i++) {
                    if ((read = inputStreamTemp.read()) != -1) {
                        b[i] = (byte)(short)read;
                    }
                }
            }
        }
        return b;
    }

    public void splitFile(File file, int countFiles) throws IOException {
        String postfix = file.getName().split("\\.")[file.getName().split("\\.").length-1];
        String pathname = file.getParent();
        byte[] forSplit = readAllToByteArray(file);
        int length = forSplit.length;
        int lengthFutureFile = length / countFiles;
        int lengthLastFile = length - (lengthFutureFile * (countFiles - 1));
        FileOutputStream fileOutputStream;
        long fileName = timeStamp.getTime();
        int k = 0;
        for(int i = 0; i < countFiles; i++) {
            if (i == countFiles - 1) {
                lengthFutureFile = lengthLastFile;
            }
            fileOutputStream = new FileOutputStream(pathname + "new-" + fileName + "-" + i + "." + postfix);
            for (int j = 0; j < lengthFutureFile && k < length; j++, k++) {
                fileOutputStream.write(forSplit[k]);
            }
            fileOutputStream.close();
        }
    }
}
