package org.sakseiw.djl.dm;

import ai.djl.ndarray.NDManager;
import tech.tablesaw.api.Table;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DataProcesing {

    public static void main(String[] args) {
        try(NDManager manager = NDManager.newBaseManager()){
            URL resource = DataProcesing.class.getClassLoader().getResource("data/house_tiny.csv");
            var data = Table.read().file(new File(resource.toURI()));

            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
