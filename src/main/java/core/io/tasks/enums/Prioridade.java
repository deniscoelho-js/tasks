package core.io.tasks.enums;

public enum Prioridade {
    URGENTE(0, "urgente"),
    NAO_URGENTE(1, "não urgente"),
    CRITICO(2,"crítico");

    private final Integer codigo;
    private final String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

//    public static Prioridade toEnum(Integer codigo){
//        if (codigo == null){
//            return null;
//        }
//        for (Prioridade p : Prioridade.values()){
//            if (codigo.equals(p.getCodigo())){
//                return p;
//            }
//        }
//        throw new IllegalArgumentException("Prioridade inválida");
//    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
