class LaPersonne {
    protected LaDate naissance;
    protected String nom;

    public LaPersonne(String name, LaDate naiss) {
        this.nom = name;
        this.naissance = naiss;
    }

    public LaDate getNaissance() {
        return naissance;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return nom + " (" + naissance + ")";
    }
}
