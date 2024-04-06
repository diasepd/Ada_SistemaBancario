package auxiliares;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarioArrayList = new ArrayList<>();

    public Usuario getUsuario(String idUsuario) {
        for (Usuario usuario : usuarioArrayList) {
            if (usuario.getId() == idUsuario)
                return usuario;
        }
        return null;
    }

    public void setUsuario(Usuario usuario) {
        usuarioArrayList.add(usuario);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "usuarioArrayList=" + usuarioArrayList +
                '}';
    }
}