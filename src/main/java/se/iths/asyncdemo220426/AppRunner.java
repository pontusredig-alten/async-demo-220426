package se.iths.asyncdemo220426;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.iths.asyncdemo220426.model.GitHubUser;
import se.iths.asyncdemo220426.service.GitHubService;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private final GitHubService gitHubService;

    public AppRunner(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Override
    public void run(String... args) throws Exception {

        long start = System.currentTimeMillis();

        CompletableFuture<GitHubUser> gitHubUser1 = gitHubService.findUser("pontusredig-alten");
        CompletableFuture<GitHubUser> gitHubUser2 = gitHubService.findUser("docker");
        CompletableFuture<GitHubUser> gitHubUser3 = gitHubService.findUser("spring-projects");
        CompletableFuture<GitHubUser> gitHubUser4 = gitHubService.findUser("jakartaee");

        CompletableFuture.allOf(gitHubUser1, gitHubUser2, gitHubUser3, gitHubUser4).join();

        System.out.println("Det har gått: " + (System.currentTimeMillis() - start) + " millisekunder.");

        System.out.println("--->" + gitHubUser1.get());
        System.out.println("--->" + gitHubUser2.get());
        System.out.println("--->" + gitHubUser3.get());
        System.out.println("--->" + gitHubUser4.get());

    }
}
