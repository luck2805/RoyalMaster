/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.royalmaster.royalmaster.controller.Controller;
import com.royalmaster.royalmaster.entities.Categorias;

/**
 *
 * @author luciano
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
         Controller cs = new Controller(Categorias.class);
         Categorias unaCategoria = new Categorias();
         unaCategoria.setIdCategoria(1);
         unaCategoria.setDescripcionCategoria("Esta es una descripcion de pelis de tipo drama");
         unaCategoria.setNombreCategoria("Drama");
         cs.add(unaCategoria);
    }
         
     
     
}
