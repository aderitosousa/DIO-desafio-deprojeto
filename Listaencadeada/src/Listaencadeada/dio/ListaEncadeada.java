package Listaencadeada.dio;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteuddo) {
        No<T> novoNo = new No<>(conteuddo);
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximono();
        }
        noAuxiliar.setProximono(novoNo);

    }

    public T get(int index){
        return getNo(index).getContudo();

    }

    private No<T> getNo(int index) {
       validaIndice ( index );
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <=index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximono();
        }
        return noRetorno;

    }

    public T remove (int index){
        No<T> noPivor = this.getNo(index);
        if (index == 0){
            referenciaEntrada = noPivor.getProximono();
            return noPivor.getContudo();
        }
       No<T> noAnterior =getNo(index - 1);
        noAnterior.setProximono(noPivor.getProximono());
        return noPivor.getContudo();
    }


    public int size() {
        int tamanholista = 0;

        No<T> referenciaAux = referenciaEntrada;
        while (true) {
            if (referenciaAux != null) {
                tamanholista++;
                if (referenciaAux.getProximono() != null){
                    referenciaAux =referenciaAux.getProximono();

                }else{
                    break;
                }

            } else {
                break;
            }
        }
        return tamanholista;
    }

   private void validaIndice(int index){

       if (index > size()){
           throw new IndexOutOfBoundsException(" Não existe conteudo no indece " + index + " desta lista ");
       }

    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {

        String strRetorno = "" ;
        No<T> noAuxiliar = referenciaEntrada;
        for (int i= 0; i <size(); i++){
            strRetorno += "[No{ conteudo=" + noAuxiliar.getContudo() + "}]--->";
            noAuxiliar = noAuxiliar.getProximono();
        }
        strRetorno += "null";

        return strRetorno;
    }
}
