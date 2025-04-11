package org.example;

public class Endereco{
    private String Estado;
    private String Cidade;
    private String Bairro;
    private String Rua;
    private String Complemento;
    private String CEP;

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        if (estado != "") {
            Estado = estado;
        }else{
            throw new IllegalArgumentException("Estado inválido!");
        }
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        if (cidade != "") {
            Cidade = cidade;
        }else{
            throw  new IllegalArgumentException("Cidade inválida!");
        }
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        if (bairro != "") {
            Bairro = bairro;
        }else{
            throw new IllegalArgumentException("Bairro inválido!");
        }
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        if (rua != "") {
            Rua = rua;
        }else{throw new IllegalArgumentException("Rua inválida!");}
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
            this.CEP = CEP;
    }
    public String GetEnderecoCompleto(){
        StringBuilder sb = new StringBuilder();
        sb.append(Estado);
        sb.append(", ");
        sb.append(Cidade);
        sb.append(", ");
        sb.append(Rua);
        sb.append(", ");
        sb.append(Bairro);
        if(Complemento != null){
            sb.append(", ");
            sb.append(Complemento);
        }
        if(CEP!=null){
            sb.append(", ");
            sb.append(CEP);
        }
        return sb.toString();
    }
    public Endereco(String estado, String cidade, String bairro, String rua) {
    setEstado(estado);
    setCidade(cidade);
    setBairro(bairro);
    setRua(rua);
    }
}
