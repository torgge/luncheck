package datapar.com.py.checkfood.model.vo;

public enum TipoEvento {

    ALMOCO(0, "Almuerzo"),
    CAFE_MANHA(1, "Desayuno"),
    OUTRO(2, "Otro");

    private final String nome;
    private final int codigo;

    TipoEvento(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
