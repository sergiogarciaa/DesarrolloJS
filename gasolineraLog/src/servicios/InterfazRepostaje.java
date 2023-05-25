package servicios;

import java.util.List;
import entidades.Repostaje;

public interface InterfazRepostaje {

	void repostajeNormal(List<Repostaje>baseDatosNormal);
	
	void repostajeFactura(List<Repostaje>baseDatosFactura);
	
	void verRepostajes(List<Repostaje>baseDatosNormal,List<Repostaje>baseDatosFactura);
	
	void eliminarRepostaje (List<Repostaje>baseDatosNormal,List<Repostaje>baseDatosFactura);
	
	void modificarRepostaje(List<Repostaje>baseDatosNormal,List<Repostaje> baseDatosFactura);
}
