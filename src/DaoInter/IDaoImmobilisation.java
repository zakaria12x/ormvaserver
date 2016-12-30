package DaoInter;

import java.util.List;
import com.ws.model.Immobilisation;

public interface IDaoImmobilisation {
	   public Immobilisation getById(int id);
	   public List<Immobilisation> getByIdBureau(int idBureau);
	   public List<Immobilisation> getAllImmo();
	   public Immobilisation getbyBCode(String code);
	   public void modifier(Immobilisation immobilisation);
	   }
