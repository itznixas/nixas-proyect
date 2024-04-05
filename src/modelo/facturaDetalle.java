
package modelo;


public class facturaDetalle {
    protected int idDetFact,cantProd ;
    protected float predUnitario,total;
    protected String numFact, producto;

    public facturaDetalle(int idDetFact, int cantProd, float predUnitario, float total, String numFact, String producto) {
        this.idDetFact = idDetFact;
        this.cantProd = cantProd;
        this.predUnitario = predUnitario;
        this.total = total;
        this.numFact = numFact;
        this.producto = producto;
    }

    public facturaDetalle() {
    }

    public int getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(int idDetFact) {
        this.idDetFact = idDetFact;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public float getPredUnitario() {
        return predUnitario;
    }

    public void setPredUnitario(float predUnitario) {
        this.predUnitario = predUnitario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNumFact() {
        return numFact;
    }

    public void setNumFact(String numFact) {
        this.numFact = numFact;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
}
