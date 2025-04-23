package core.io.tasks.enums;

public enum Categoria {
    TRABALHO(0, "trabalho"),
    FACULDADE(1, "faculdade"),
    LAZER(2,"lazer");

    private final Integer codigo;
    private final String descricao;

    Categoria(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

//    public static Categoria toEnum(Integer codigo){
//        if (codigo == null){
//            return null;
//        }
//        for (Categoria c : Categoria.values()){
//            if(codigo.equals(c.getCodigo())){
//                return c;
//            }
//        }
//        throw new IllegalArgumentException("Categoria inválida");
//    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
