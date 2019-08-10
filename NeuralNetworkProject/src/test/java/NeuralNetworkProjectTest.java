/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.neu.edu.nnproject.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asthasharma
 */
public class NeuralNetworkProjectTest {
    
    @Test
    public void test0(){
       Matrix m=new Matrix();
       double high = 1.0;
        double low = 0.7;
       //sigmoid calculation
       double sig = m.sigmoid(2);
  
        assertTrue("Error, random is too high", high >= sig);
        assertTrue("Error, random is too low",  low  <= sig);
                
    }
    
    @Test
    public void test1(){
         Matrix m=new Matrix();
          double high = 1.0;
        double low = 0.0;
       //random no. generation
       double ran = m.random(0.0,1.0);
  
        assertTrue("Error, random is too high", high >= ran);
        assertTrue("Error, random is too low",  low  <= ran);
        
    }
    @Test
    public void test2(){
       Matrix m=new Matrix();
       //calculating derivative of sigmoid
        assertEquals(-2.0, m.dsigmoid(2), -2.0);
                
    }
    
    @Test
    public void test3(){
       Matrix m=new Matrix();
       double high = 1.0;
        double low = 0.9;
       //sigmoid calculation
       double sig = m.sigmoid(5);
  
        assertTrue("Error, random is too high", high >= sig);
        assertTrue("Error, random is too low",  low  <= sig);
                
    }
    @Test
    public void test4(){
       Matrix m=new Matrix();
       //calculating derivative of sigmoid
        assertEquals(-6.0, m.dsigmoid(3), -6.0);
                
    }
    
    @Test
    public void test5(){
         Matrix m=new Matrix();
          double high = 1.0;
        double low = -1.0;
       //random no. generation
       double ran = m.random(-1.0,1.0);
  
        assertTrue("Error, random is too high", high >= ran);
        assertTrue("Error, random is too low",  low  <= ran);
        
    }
}
