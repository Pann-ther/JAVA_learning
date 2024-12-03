public abstract class Volaille {
    protected double poids;
    protected int id;

    public Volaille(double poids, int id) throws EntreeInvalide {
        if (poids <= 0) {
            throw new EntreeInvalide("Le poids doit etre positif");
        }
        this.poids = poids;
        this.id = id;

    }

    public double getPoids() {
        return poids;
    }

    
    public abstract String getType();

    public int getId() {
        return id;
    }

    public void setPoids(double poids) throws EntreeInvalide {
        if (poids <= 0) {
            throw new EntreeInvalide("Le poids doit etre positif");
        }
        this.poids = poids;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "id: " + id + ", poids: " + poids;
    }

}
