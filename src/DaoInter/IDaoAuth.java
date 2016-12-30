package DaoInter;
import java.util.List;

import com.ws.model.*;


public interface IDaoAuth {
   public List<CommissionInventaire> getAllcom();
   public CommissionInventaire getByIdcom(int id);
   }
