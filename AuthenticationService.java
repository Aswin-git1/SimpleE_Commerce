package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceService;

import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities.AuthenticationEntity;
import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceRepository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService implements AuthenticationServiceInterface
{
    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public List<AuthenticationEntity> findAll() {
        return authenticationRepository.findAll();
    }
}
