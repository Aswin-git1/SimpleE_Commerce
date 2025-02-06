package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceRepository;

import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities.AuthenticationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthenticationRepository implements AuthenticationRepositoryInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AuthenticationEntity> findAll() {
        try {
                List<AuthenticationEntity> authPeopleList = entityManager.createQuery("select a from AuthenticationEntity a ", AuthenticationEntity.class).getResultList();
                return authPeopleList;
            }
            catch(DataAccessException e){
                System.out.println("Error occured" + e.getMessage());
                throw e;
            }


        }
}
