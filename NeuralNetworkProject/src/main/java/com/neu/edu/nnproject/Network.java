/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.nnproject;
import java.util.Arrays;


public class Network {
    public static void main(String[] args) {
        
  
        double[][] X = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        double[][] Y = {{0}, {1}, {1}, {0}};

        int m = 4;
        int nodes = 400;

        X = Matrix.T(X);
        Y = Matrix.T(Y);

        double[][] W1 = Matrix.random(nodes, 2);
        double[][] b1 = new double[nodes][m];

        double[][] W2 = Matrix.random(1, nodes);
        double[][] b2 = new double[1][m];

        for (int i = 0; i < 4000; i++) {
            // feedforward
            // LAYER 1
            double[][] Z1 = Matrix.add(Matrix.dot(W1, X), b1);
            double[][] A1 = Matrix.sigmoid(Z1);

            //LAYER 2
            double[][] Z2 = Matrix.add(Matrix.dot(W2, A1), b2);
            double[][] A2 = Matrix.sigmoid(Z2);

            double cost = Matrix.cross_entropy(m, Y, A2);
            
         
            // Back Propagation
            //LAYER 2
            double[][] dZ2 = Matrix.subtract(A2, Y);
            double[][] dW2 = Matrix.divide(Matrix.dot(dZ2, Matrix.T(A1)), m);
            double[][] db2 = Matrix.divide(dZ2, m);

            //LAYER 1
            double[][] dZ1 = Matrix.multiply(Matrix.dot(Matrix.T(W2), dZ2), Matrix.subtract(1.0, Matrix.power(A1, 2)));
            double[][] dW1 = Matrix.divide(Matrix.dot(dZ1, Matrix.T(X)), m);
            double[][] db1 = Matrix.divide(dZ1, m);

            // Gradient
            W1 = Matrix.subtract(W1, Matrix.multiply(0.01, dW1));
            b1 = Matrix.subtract(b1, Matrix.multiply(0.01, db1));

            W2 = Matrix.subtract(W2, Matrix.multiply(0.01, dW2));
            b2 = Matrix.subtract(b2, Matrix.multiply(0.01, db2));

            if (i % 400 == 0) {
                System.out.println("======RESULTS========");
                System.out.println("Error = " + cost);
                System.out.println("Predictions = " + Arrays.deepToString(A2));
            }
        }
    }
}

    
