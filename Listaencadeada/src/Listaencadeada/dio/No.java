package Listaencadeada.dio;

public class No <T> {
    private T contudo;
    private No proximono;

    public No() {
        this.proximono=null;
    }

    public No(T contudo) {
        this.proximono=null;
        this.contudo = contudo;
    }

    public No(T contudo, No proximono) {
        this.contudo = contudo;
        this.proximono = proximono;
    }


    public T getContudo() {
        return contudo;
    }

    public void setContudo(T contudo) {
        this.contudo = contudo;
    }

    public No getProximono() {
        return proximono;
    }

    public void setProximono(No proximono) {
        this.proximono = proximono;
    }

    @Override
    public String toString() {
        return "No{" +
                "contudo=" + contudo +
                '}';
    }

    public String toStringencadeado(){
        String str= "No{" +
                "contudo=" + contudo +
                '}';
         if( proximono != null){
             str += "->" + proximono.toString();
         } else{
             str +="->null";
         }
         return str;

    }


}
