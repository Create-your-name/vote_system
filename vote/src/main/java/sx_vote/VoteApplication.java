package sx_vote;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("sx_vote.dao.mapper")
public class VoteApplication {

    public static void main(String[] args) {

        SpringApplication.run(VoteApplication.class, args);
    }

}
