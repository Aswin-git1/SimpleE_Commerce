package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceService;

import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities.AuthenticationEntity;

import java.util.List;

public interface AuthenticationServiceInterface {

    public List<AuthenticationEntity> findAll();

}
