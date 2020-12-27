package projetJEE;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;


public class Proposition {
	private String title ;
	private String dateDep ;
	private String lieuDep ;
	private String villeVisited ;
	private String transport ;
	private int maxPart ;

	public void setProp(String title ,String dateDep,String lieuDep,String villeVisited,String transport,int maxPart){
        this.dateDep = dateDep;
        this.title= title;
        this.lieuDep = lieuDep;
        this.villeVisited = villeVisited;
        this.transport = transport;
        this.maxPart = maxPart;
        
    }
    
	public void setMaxPart(String maxPart) {
		int max = Integer.parseInt(maxPart);
		this.maxPart = max;
	}
	
	public String getDateDep() {
		return this.dateDep ;
	}
	public String getLieuDep() {
		return this.lieuDep ;
	}
	
	public String getVisite() {
		return this.villeVisited ;
	}
	
	public String getTransport() {
		return this.transport ;
	}
	
	public int getMaxPart() {
		return this.maxPart ;
	}


}
