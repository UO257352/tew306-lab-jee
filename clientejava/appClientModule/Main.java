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
		WebTarget target = client.target("http://localhost:8080/gestioneitorv4_0/pisos.json");
		String result = target.request().get().readEntity(String.class);
		System.out.println(result);
		
		//Imprimimos todo el flujo JSON recibido en formato cadena.
		 System.out.println("-----------TODOS----------------");
		 System.out.println(result);
		 //Procesamos el texto JSON y lo pasamos a formato SIMPLE-JSON
		 Object obj=JSONValue.parse(result);
		 JSONArray pisos = (JSONArray)obj;
		 //Imprimimos el contacto tercero (2) transform�ndolo a formato cadena.
		System.out.println("----------- PISO ----------------");
		 System.out.println(pisos.get(2).toString());
		 System.out.println("----------- CIUDAD DE UN PISO ----------------");
		 JSONObject unPiso = (JSONObject) JSONValue.parse(pisos.get(2).toString());
		 String ciudad = (String)unPiso.get("Ciudad");
		 System.out.println(ciudad);

	}

}