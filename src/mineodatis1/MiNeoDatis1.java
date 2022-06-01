/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mineodatis1;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import cliente.Cliente;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
/**
 *
 * @author JMSJ
 */
public class MiNeoDatis1 {

	public static void main(String[] args) {
            
            // CREANDO BASE DE DATOS "CLIENTES_.DB" E INSERTAMOS UN CLIENTE
                boolean continuar = true;
		cliente.Cliente c = new cliente.Cliente("javier_jimenez@gmail.com", "Camarero", 27);
		ODB odb = ODBFactory.open("CLIENTES_.DB");
                
                Objects<Cliente> clientes_ = odb.getObjects(Cliente.class);  
                Cliente aux_ = null;
                while(clientes_.hasNext()&& continuar ){
                    aux_ = clientes_.next();
                       if(aux_.getEmail().equalsIgnoreCase(c.getEmail())){
                           continuar = false;
                       }  
                }
                // LO ALMACENAMOS SI NO ESTÁ REPETIDO
                if(continuar ){
                    odb.store(c);
		odb.close();
                }
                else{
                    System.out.println("No se pueden insertar duplicados");
                    System.out.println("++++++++++++++++++++++++++++++++++++");
                    odb.close();
                }
                
		
		ODB odb_ = ODBFactory.open("CLIENTES_.DB");
		
		Objects<Cliente> clientes = odb_.getObjects(Cliente.class);
	    // MOSTRAMOS LOS CLIENTES EXISTENTES
		Cliente aux = null;
            System.out.println("Clientes en la base de datos:");
            System.out.println("*******************************");
	while(clientes.hasNext())
	{
		aux = clientes.next();
		System.out.println("Correo => " + aux.getEmail());
		System.out.println("Profesion => " + aux.getProfesion());
                System.out.println("Edad => " + aux.getEdad());
                System.out.println("==========================");
	}
	odb_.close();
        
        
         // ACTUALIZAMOS EL EMAIL DE UN CLIENTE (PRIMERO EL CORREO ACTUAL Y DESPUÉS EL CORREO POR EL CUAL LO QUIERES CAMBIAR)
       //   Cliente.updateClientePorEmail("jms.sanchez@gmail.com", "aaaaaaaaaaaa@hotmail.com");
         //IMPRIMIMOS LOS CLIENTES   
       //    Cliente.displayClientes();
           
         // BORRAMOS UN CLIENTE INDICANDO SU EMAIL
       //    Cliente.deleteClientePorEmail("awitafreska@gmail.com");
          
           //IMPRIMIMOS LOS CLIENTES
       //    Cliente.displayClientes();
           
        }
        
        
    }
        
        
        
           
	
 
 
        





 