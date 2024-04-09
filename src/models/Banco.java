package models;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> listaDeUsuario = new ArrayList<>();

    public List<Usuario> getListaDeUsuario() {
        return listaDeUsuario;
    }

    public Usuario getUsuario(String idUsuario) {
        for (Usuario usuario : listaDeUsuario) {
            if (usuario.getId() == idUsuario)
                return usuario;
        }
        return null;
    }

    public boolean setUsuario(Usuario usuarioNovo) {
        String idUsuario = usuarioNovo.getId();
        for (Usuario usuario : listaDeUsuario) {
            if (usuario.getId() == idUsuario)
                return false;
        }
        listaDeUsuario.add(usuarioNovo);
        return true;
    }
}