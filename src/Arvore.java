package arvores;

public class Arvore<T> {
	private NoArvore<T> raiz;
	
	public Arvore() {
		super();
		this.raiz = null;
	}

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		if (raiz != null) {
			this.raiz = raiz;
		}
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}
	
	public NoArvore<T> pertence(T procurado){
		if (this.vazia()) {
			return null;
		} else {
			return this.raiz.pertence(procurado);
		}
	}

	public int getAltura() {
		return raiz.getAlturaNo(0);
	}

	/*
	public int getAltura() {
        NoArvore<T> altura = this.getRaiz();

        int count = 0;
        int maior = 0;

        if (altura == null) {
            return -1;
        }
        while (altura != null) {
            System.out.println(altura);

            if (altura.getFilho() != null) {
                count++;
                altura = altura.getFilho();
            } else {
                if (altura.getIrmao() != null) {
                    altura = altura.getIrmao();
                } else {
                    altura = altura.getPai().getIrmao();
                    if (count > maior) {
                        maior = count;
                        count = 0;
                    }
                }
            }
        }
        return maior;

    }
	*/


}
