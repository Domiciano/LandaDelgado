package appmoviles.com.landadelgado;

public class Hash {

    private String codigoHash;

    public Hash(String codigoHash) {
        this.codigoHash = codigoHash;
    }

    public Hash() {
    }

    public String getCodigoHash() {
        return codigoHash;
    }

    public void setCodigoHash(String codigoHash) {
        this.codigoHash = codigoHash;
    }

    public boolean equals(Hash hash) {
        return this.codigoHash.equals(hash.getCodigoHash());
    }
}
