public class LaPersonneLieu extends LaPersonne{
    private String lieuNaissance;

    public LaPersonneLieu(String name, LaDate naissance, String lieuNaissance){
        super(name,naissance);
        this.lieuNaissance = lieuNaissance;
    }

    public String getLieuNaissance(){
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance){
        this.lieuNaissance = lieuNaissance;
    }
    
    public String toString(){
        return nom+" née le "+naissance+ " à "+lieuNaissance;
    }
}
