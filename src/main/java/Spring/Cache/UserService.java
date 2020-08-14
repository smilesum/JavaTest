package Spring.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {
  @Autowired UserEntity userEntity;

  @Cacheable
  public UserEntity getOne() {
    System.out.println("access db@@@@@@@@@@@@@@@@@@");
    return userEntity;
  }
}
