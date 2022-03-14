package chefchallenge.backend.challenges;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getListChallenge(){
        return challengeService.getAllChallenge();
    }

    @GetMapping("/{id_challenge}")
    public Challenge getChallengeById(@PathVariable int id_challenge){
        return challengeService.getChallenge(id_challenge);
    }

    @GetMapping("/search/{name_challenge}")
    public List<Challenge> getChallengeByName(@PathVariable String name_challenge){
        return challengeService.getChallengeByName(name_challenge);
    }

    @PutMapping
    public Challenge modifyChallenge(@RequestBody Challenge ingredient) {
        return challengeService.modifyChallenge(ingredient);
    }

    @PostMapping
    public Challenge addChallenge(@RequestBody Challenge ingredient) {
        return challengeService.addChallenge(ingredient);
    }

    @DeleteMapping("/{id_challenge}")
    public String deleteChallenge(@PathVariable int id_challenge) {
        return challengeService.deleteChallenge(id_challenge);
    }
}
