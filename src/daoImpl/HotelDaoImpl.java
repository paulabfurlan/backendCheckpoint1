package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Hotel;

public class HotelDaoImpl implements IDao<Hotel>{
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(HotelDaoImpl.class);

    public HotelDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }
	
	@Override
	public Hotel salvar(Hotel hotel) {		
		Connection connection = configuracaoJDBC.conectarBD();
		Statement statement = null;
		String query = String.format("INSERT INTO hoteis(nome_filial,rua,numero,cidade,estado,e5estrelas) VALUES('%s','%s','%s','%s','%s','%s')",
				hotel.getNomeFilial(), hotel.getRua(), hotel.getNumero(), hotel.getCidade(), hotel.getEstado(), hotel.getE5estrelas());
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                hotel.setId(resultSet.getInt(1));
            
            connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		log.debug("Salvando nova filial: " + hotel.toString());

		return hotel;
	}

	@Override
	public List<Hotel> buscarTodos() {
		Connection connection = configuracaoJDBC.conectarBD();
		
	    Statement statement = null;
	    String query = "SELECT * FROM hoteis";
	    List<Hotel> hoteis = new ArrayList<>();
	    Hotel hotel;
	    
	    try {
	    	statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(query);
	        while (result.next()) {
	        	hotel = new Hotel();
	        	hotel.setId(result.getInt("id"));
	        	hotel.setNomeFilial(result.getString("nome_filial"));
	        	hotel.setRua(result.getString("rua"));
	        	hotel.setNumero(result.getInt("numero"));
	        	hotel.setCidade("cidade");
	        	hotel.setEstado("estado");
	        	hotel.setE5estrelas(result.getBoolean("e5estrelas"));
	        	hoteis.add(hotel);
	        }

	        statement.close();
	    } 
	    catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return hoteis;
	}

}
