package Spring.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;

  @RequestMapping("getOne")
  public UserEntity getOne() {
    System.out.println("into getOne function");
    return userService.getOne();
  }
}
