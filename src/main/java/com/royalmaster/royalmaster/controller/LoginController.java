/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.royalmaster.royalmaster.controller;

import com.royalmaster.royalmaster.entities.Usuarios;
import com.royalmaster.royalmaster.util.HibernateUtil;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author luciano
 */
public class LoginController extends AbstractController<Usuarios> {
    
    public static Usuarios login(String username, String password){
            return (Usuarios)HibernateUtil.getSessionFactory().openSession().createCriteria(Usuarios.class).add(Restrictions.eq("nombreUsuario", username)).add(Restrictions.eq("contrasenaUsuario", password)).setMaxResults(1).uniqueResult();
    }

    @Override
    public Class<Usuarios> classResult() {
        return Usuarios.class;
    }
}
