/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Emplacement;
import Utilities.DataSource;
import java.util.logging.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fares
 */
public class emplacementService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement prepste;
    
    public emplacementService()
    {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public void insertEmplacement(Emplacement e)
    {
        String req = "insert into emplacement(code,Saison) values('"+e.getCode()+"','"+e.getSaison()+"')";
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(emplacementService.class.getName()).log(Level.SEVERE,null,exception);
        }
        
    }
    
    public void showEmplacement()
    {
        String req = "select * from emplacement";
        try
        {
            ste = cnx.createStatement();
            ResultSet result = ste.executeQuery(req);
            while(result.next())
            {
                String code = result.getString("CODE");
                String saison = result.getString("SAISON");
                System.out.println(code+"\t"+saison);
            }
        }
        catch(SQLException exception)
        {
            Logger.getLogger(emplacementService.class.getName()).log(Level.SEVERE,null,exception);
        }
    }
    
    public void deleteEmplacement(String code)
    {
        String req = "delete from emplacement where code = '"+code+"'";
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(emplacementService.class.getName()).log(Level.SEVERE,null,exception);
        }
    }
    
    public List<Emplacement> getAll()
    {
        String req = "select * from emplacement";
        List<Emplacement> le = new ArrayList<Emplacement>();
        try
        {
            ste = cnx.createStatement();
            ResultSet result = ste.executeQuery(req);
            while(result.next())
            {
                String code = result.getString("CODE");
                String saison = result.getString("SAISON");
                Emplacement e = new Emplacement(code,saison);
                le.add(e);
            }
            return le;
        }
        catch(SQLException exception)
        {
            Logger.getLogger(emplacementService.class.getName()).log(Level.SEVERE,null,exception);
        }
        return le;
    }
    
    public void updateEmplacement(Emplacement e)
    {
        String req = "update emplacement set saison = '"+e.getSaison()+"' where code = '"+e.getCode()+"'";
        
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(emplacementService.class.getName()).log(Level.SEVERE,null,exception);
        }
        
    }
}
