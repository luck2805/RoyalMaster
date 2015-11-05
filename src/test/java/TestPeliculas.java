/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.royalmaster.royalmaster.controller.Controller;
import com.royalmaster.royalmaster.entities.Peliculas;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luciano
 */
public class TestPeliculas {
    
    public TestPeliculas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         List<Peliculas> peliculas = new ArrayList<Peliculas>();
         Controller<Peliculas> cp = new Controller(Peliculas.class);
         peliculas = cp.all();
         for(Peliculas unaPeli:peliculas){
             System.out.println(unaPeli.getCategorias().getIdCategoria());
         }
     }
}
