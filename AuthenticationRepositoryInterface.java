package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceRepository;

import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities.AuthenticationEntity;

import java.util.List;

public interface AuthenticationRepositoryInterface {

    public List<AuthenticationEntity> findAll();

}
