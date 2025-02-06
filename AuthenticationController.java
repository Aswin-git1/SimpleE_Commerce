package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceController;

import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities.AuthenticationEntity;
import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceService.AuthenticationService;
import Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceService.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

        @PostMapping("/authenticatePeople")
        public ResponseEntity<String> performAuth(@RequestBody AuthenticationEntity authenticationEntity) throws Exception {
            String userName = authenticationEntity.getUserName();
            String passWord = authenticationEntity.getPassWord();
            int phoneNumber = authenticationEntity.getPhoneNumber();
           String jwtToken = jwtService.generateToken(String.valueOf(phoneNumber));
            List<AuthenticationEntity> authForPeople = authenticationService.findAll();
            for (AuthenticationEntity people : authForPeople) {
                if (people.getUserName().equals(userName) && people.getPassWord().equals(passWord) && people.getPhoneNumber() == phoneNumber) {
                    return ResponseEntity.ok()
                            .header("authorization", jwtToken)
                            .body("Authentication Successful");
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication Denied");

        }
}



