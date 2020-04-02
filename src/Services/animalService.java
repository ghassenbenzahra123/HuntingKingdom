/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Animal;
import Utilities.DataSource;
import java.util.logging.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fares
 */
public class animalService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement prepste;
    
    public animalService()
    {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public void insertAnimal(Animal a)
    {
        String req = "insert into animal(id,region,Etat,QteEstim,Saison,Type,Description) values('"+a.getId()+"','"+a.getRegion()+"','"+a.getEtat()+"','"+a.getQteEstim()+"','"+a.getSaison()+"','"+a.getType()+"','"+a.getDesc()+"')";
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(animalService.class.getName()).log(Level.SEVERE,null,exception);
        }
        
    }
    
    public void showAnimal()
    {
        String req = "select * from animal";
        try
        {
            ste = cnx.createStatement();
            ResultSet result = ste.executeQuery(req);
            while(result.next())
            {
                int id = result.getInt("ID");
                String region = result.getString("REGION");
                String etat = result.getString("ETAT");
                int qteEstim = result.getInt("QTEESTIM");
                String saison = result.getString("SAISON");
                String type = result.getString("TYPE");
                String desc = result.getString("DESCRIPTION");
                System.out.println(id+"\t"+region+"\t"+etat+"\t"+qteEstim+"\t"+saison+"\t"+type+"\t"+desc);
            }
        }
        catch(SQLException exception)
        {
            Logger.getLogger(animalService.class.getName()).log(Level.SEVERE,null,exception);
        }
    }
    
    public void deleteAnimal(String id)
    {
        String req = "delete from animal where id = "+id;
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(animalService.class.getName()).log(Level.SEVERE,null,exception);
        }
    }
    
    public List<Animal> getAll()
    {
        String req = "select * from animal";
        List<Animal> la = new ArrayList<Animal>();
        try
        {
            ste = cnx.createStatement();
            ResultSet result = ste.executeQuery(req);
            while(result.next())
            {
                int id = result.getInt("ID");
                String region = result.getString("REGION");
                String etat = result.getString("ETAT");
                int qteEstim = result.getInt("QTEESTIM");
                String saison = result.getString("SAISON");
                String type = result.getString("TYPE");
                String desc = result.getString("DESCRIPTION");
                Animal a = new Animal(id,region,etat,qteEstim,saison,type,desc);
                la.add(a);
            }
            return la;
        }
        catch(SQLException exception)
        {
            Logger.getLogger(animalService.class.getName()).log(Level.SEVERE,null,exception);
        }
        return la;
    }
    
    public void updateAnimal(Animal a)
    {
        String req = "update animal set region = '"+a.getRegion()+"', etat = '"+a.getEtat()+"', qteEstim = '"+a.getQteEstim()+"', saison = '"+a.getSaison()+"', type = '"+a.getType()+"', Description = '"+a.getDesc()+"' where id = '"+a.getId()+"'";
        try
        {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(animalService.class.getName()).log(Level.SEVERE,null,exception);
        }
        
    }
}
