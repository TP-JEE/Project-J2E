package projetJEE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean (name="searchMB" )
@ViewScoped
public class SearchMB implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	public String dateDep ;
	public String lieuDep ;
	public String villeVisited ;
	public String transport ;
	public String maxPart ;
	//private Proposition prop = new Proposition();
    ArrayList<Proposition> PropositionsList = new ArrayList<>() ;
    
    public void setdateDep(String dateDep) {
    	this.dateDep = dateDep ;
    }
    public void setlieuDep(String lieuDep) {
    	this.lieuDep = lieuDep ;
    }
    public void setvilleVisited(String villeVisited) {
    	this.villeVisited = villeVisited ;
    }
    public void settransport(String transport) {
    	this.transport = transport ;
    }
    public void setmaxPart(String maxPart) {
    	this.maxPart = maxPart ;
    }
    
    
    public ArrayList<Proposition> getPropositions(){
    	return PropositionsList;
    }
 
    
	public void search() {
	   
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;user=mayssae;password=Mayssae1999;databaseName=siteVoyageDB";
		    Connection con= DriverManager.getConnection(url); 
		    String sql = "SELECT * FROM proposition WHERE dateDep=? OR lieuDep=? "
		    		+ "OR villesVisted=? OR maxParticipants=? OR transport=?";
		    PreparedStatement pst = con.prepareStatement(sql);
		    pst.setString(1, dateDep);
		    pst.setString(2, lieuDep);
		    pst.setString(3, villeVisited);
		    pst.setInt(4, Integer.parseInt(maxPart));
		    pst.setString(5, transport);
		    ResultSet res = pst.executeQuery();
		    Proposition propFound  = new Proposition();
		    while (res.next()) {
		    	 propFound.setProp(
	                        res.getString("titre"),
	                        res.getString("dateDep"),
	                        res.getString("lieuDep"),
	                        res.getString("villesVisited"),
	                        res.getString("transport"),
	                        res.getInt("maxParticipants")
	                        
	                );
	                 
	                PropositionsList.add(propFound);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
