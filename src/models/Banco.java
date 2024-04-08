package models;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> listaDeUsuario = new ArrayList<>();

    public Usuario getUsuario(String idUsuario) {
        for (Usuario usuario : listaDeUsuario) {
            if (usuario.getId() == idUsuario) return usuario;
        }
        return null;
    }
    public void setUsuario(Usuario usuario) {
        listaDeUsuario.add(usuario);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "usuarioArrayList=" + listaDeUsuario +
                '}';
    }
}