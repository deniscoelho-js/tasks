package core.io.tasks.enums;

public enum Status {
    PENDENTE(0, "pendente"),
    EM_PROGRESSO(1, "em progresso"),
    CONCLUIDA(2, "concluida");

    private final Integer codigo;
    private final String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

//    public static Status toEnum(Integer codigo){
//        if(codigo == null){
//            return null;
//        }
//        for (Status s : Status.values()){
//            if(codigo.equals(s.getCodigo())){
//                return s;
//            }
//        }
//        throw new IllegalArgumentException("Status inválido");
//    }
}
