package med.voll.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Classe do tip Servico, vai executar o Servico de autenticação
//UserDetailsService é a interface que faz o servico de autenticação
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repositoryUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUser.findByLogin(username);
    }
}
