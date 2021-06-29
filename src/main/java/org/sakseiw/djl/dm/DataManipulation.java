package org.sakseiw.djl.dm;

import ai.djl.Device;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.index.NDIndex;
import ai.djl.ndarray.types.DataType;
import ai.djl.ndarray.types.Shape;

public class DataManipulation {

    public static void main(String[] args) {

        try(NDManager manager = NDManager.newBaseManager()){
            var x = manager.arange(12);

            System.out.println(x.getShape());
            System.out.println(x.size());
            System.out.println(x);

            x  = x.reshape(3,4);

            System.out.println(x);

            var y = manager.zeros(new Shape(2,3,4));
            System.out.println(y);

            var z = manager.randomNormal(0f, 1f, new Shape(3, 4), DataType.FLOAT32, Device.defaultDevice());
            System.out.println(z);

            //Operations
            var a = manager.create(new double[] {1.0, 2.0, 4.0, 8.0});
            var b = manager.create(new double[] {2.0, 2.0, 2.0, 2.0});

            System.out.println(a.add(b));
            System.out.println(a.mul(b));
            System.out.println(a.div(b));
            System.out.println(a.pow(b));

            // broadcasting: operations with matrix with shapes does not match
            var e  = manager.create(new float[] {0f,1f, 2f}).reshape(3,1);
            var f = manager.create(new float[] {0f, 1f}).reshape(1,2);

            System.out.println(e.add(f));

            //indexing and slicing
            System.out.println(x.get(":-1"));
            System.out.println(x.get("1:3"));
            x.set(new NDIndex("1, 2"), 9);
            System.out.println(x);

            //inplace operations
            var original = manager.zeros(y.getShape());
            var actual = original.addi(x);
            System.out.println(original == actual);


        }



    }
}
