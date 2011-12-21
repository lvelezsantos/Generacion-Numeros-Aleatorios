/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.ArrayList;


public class UsuarioMetodos {

    public static ArrayList<Usuario> CrearUsuarios(){
        MetodoMoore serie1 = new MetodoMoore(40);
        MetodoMoore serie2= new MetodoMoore(60);
        ArrayList<Usuario> User = new ArrayList<Usuario>();
        for (int i = 0; i < 40; i++) {
            int TLlegada= (int) (((((-Math.log(serie1.siguienteMoore())) / 2)) * 10));
            Usuario U = new Usuario(TLlegada, serie2.siguiente(), 0.0, 0.0);
            User.add(U);
             }
        return User;
    }

}
