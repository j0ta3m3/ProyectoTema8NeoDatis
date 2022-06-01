package cliente;


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
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Cliente {

	private String email;
	
	private String profesion;
        
        private Integer edad;
	
	public Cliente(String email, String profesion, Integer edad) {
		this.email = email;
		this.profesion = profesion;
                this.edad = edad;
	}
	
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
               
		public String getProfesion() {
			return profesion;
		}
		
		public void setProfesion(String profesion) {
			this.profesion = profesion; 
		}
		
		public Integer getEdad(){
                    return edad;
                }
                
                public void setEdad(Integer edad){
                    this.edad = edad;
                }
	
                       
                public static void updateClientePorEmail(String antiguo, String nuevo){
            ODB odb= null;
                     try{
            odb= ODBFactory.open("CLIENTES_.DB");
            ICriterion criterio = Where.equal("email", antiguo);
            IQuery query = new CriteriaQuery(Cliente.class,criterio);
            Objects<Cliente> clientess = odb.getObjects(query);
            Cliente actualizado = (Cliente) clientess.getFirst();
            actualizado.setEmail(nuevo);
            odb.store(actualizado);

        }finally {
            if(odb != null) {
                odb.close();
            }
        }
                }
                
                
      public static void displayClientes() {
        ODB odb= null;
        try{
            odb= ODBFactory.open("CLIENTES_.DB");
            Objects<Cliente> clientitos = odb.getObjects(Cliente.class);
            
           Cliente aux2 = null;
            while (clientitos.hasNext()) {
                aux2 = clientitos.next(); 
                System.out.println(aux2.getEmail());
                System.out.println(aux2.getProfesion());
                System.out.println(aux2.getEdad());
                System.out.println("==============================");
            }
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }
      
      public static void deleteClientePorEmail(String email){
            ODB odb =null;
        try{
            odb= ODBFactory.open("CLIENTES_.DB");
            ICriterion criterio = Where.equal("email", email);
            IQuery query = new CriteriaQuery(Cliente.class,criterio);
            Objects<Cliente> clientes = odb.getObjects(query);
            Cliente cliente = (Cliente) clientes.getFirst();
            odb.delete(cliente);
        }finally {
            if(odb != null) {
                odb.close();
            }
        }

        }
}
