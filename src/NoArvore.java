package src;

public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;
    private NoArvore<T> pai;

	private static int altura = 0;
    private static int buscadoAltura = -1;

    private static int maior = 0;
    private static int segundaAltura = 999;

    public NoArvore(T info) {
        super();
        this.info = info;
        this.filho = null;
        this.irmao = null;
        this.pai = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String imprimePre() {
        String impressao = "<" + this.info;
        if (this.filho != null) {
            impressao += filho.imprimePre();
        }
        impressao += ">";
        if (this.irmao != null) {
            impressao += irmao.imprimePre();
        }
        return impressao;
    }

    public void inserirFilho(NoArvore<T> no) {

        if (no != null) {
            no.irmao = this.filho;
            this.filho = no;
            no.pai = this;
        }
    }

    public NoArvore<T> pertence(T procurado) {
        NoArvore<T> noBuscado = null;

        if (this.info.equals(procurado)) {
            return this;
        } else {
            if (filho != null) 
                noBuscado = this.filho.pertence(procurado);

            if (irmao != null && noBuscado == null) {
                noBuscado = this.irmao.pertence(procurado);
            }
        }

        return noBuscado;
    }

	public int maiorAlturaArvore(int index) {
		if (filho != null) {
			getAndIncrementAlturaNo(filho, index);
		}
		
		if (irmao != null) {
			irmao.maiorAlturaArvore(index);
		}
		
		return setAltura(index);
	}

	public int alturaNoBuscado(T info, int index) {
		if (this.info.equals(info)) {
			buscadoAltura = index;
		};

		if (filho != null) {
			getAndIncrementAlturaNo(filho, index, info);
		}
		
		if (irmao != null) {
			irmao.alturaNoBuscado(info, index);
		}

		return buscadoAltura;
	}

	private void getAndIncrementAlturaNo(NoArvore<T> filho, int index) {
		index ++;
		filho.maiorAlturaArvore(index);
	}

    private void getAndIncrementAlturaNo(NoArvore<T> filho, int index, T info) {
		index ++;
		filho.alturaNoBuscado(info, index);
	}

    private int setAltura(int index) {
		if (altura < index)
			altura = index;
		return altura;
	}

    public boolean isBalanceadoNo() {
		maior = maiorAlturaArvore(0);

		if (maior - 1 == segundaAltura || maior == segundaAltura) {
			return true;
		}
		return false;
	}

    public NoArvore<T> getFilho() {
        return filho;
    }

    public void setFilho(NoArvore<T> filho) {
        this.filho = filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public void setIrmao(NoArvore<T> irmao) {
        this.irmao = irmao;
    }

    public NoArvore<T> getPai() {
        return pai;
    }

    public void setPai(NoArvore<T> pai) {
        this.pai = pai;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }
}
