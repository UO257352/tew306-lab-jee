import javax.ws.rs.client.Client;
import org.json.simple.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://datos.gijon.es/doc/transporte/busgijontr.json");
		String result = target.request().get().readEntity(String.class);
		System.out.println(result);
		
		//Imprimimos todo el flujo JSON recibido en formato cadena.
		 System.out.println("-----------TODOS----------------");
		 System.out.println(result);
		 //Procesamos el texto JSON y lo pasamos a formato SIMPLE-JSON
		 Object obj=JSONValue.parse(result);
		 JSONArray autobuses = (JSONArray)obj;
		 for(Object o : autobuses) {
			 JSONObject autobus = (JSONObject) JSONValue.parse(o.toString());
			 System.out.print(autobus.toString());
			 
		 }
	}

}