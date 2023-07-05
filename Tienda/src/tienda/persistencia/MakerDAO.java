package tienda.persistencia;

import tienda.entidades.Maker;

public final class MakerDAO extends DAO {
    
    public void saveMaker(Maker maker) throws Exception {
        
        try {
            
            if (maker == null) {
                throw new Exception("You must indcate the maker");
            }
            
            String sql = "INSERT INTO fabricante (codigo, nombre) "
                    + "VALUES ('" + maker.getCode() + "' , '" 
                    + maker.getName() + "');";
            
            insertModifyEliminate(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
